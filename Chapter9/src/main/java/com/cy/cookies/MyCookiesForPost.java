package com.cy.cookies;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        HttpGet get=new HttpGet(this.url+bundle.getString("getCookies.uri"));
//        HttpClient client= HttpClientBuilder.create().build();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();
        for (Cookie cookie : cookieList) {
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookie name="+name+",value="+value);
        }

    }
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {

        String uri = bundle.getString("test.post.with.cookies");
        String testurl = this.url + uri;

        //声明client对象，进行方法的执行
        DefaultHttpClient client=new DefaultHttpClient();
        //声明一个post方法
        HttpPost post=new HttpPost(testurl);
        //添加json参数
        JSONObject json=new JSONObject();
        json.put("name", "moushiqian");
        json.put("age", "18");
        //设置请求头信息
        post.setHeader("content-type","application/json");
        //将参数信息添加到方法中
        StringEntity entity=new StringEntity(json.toString(),"utf-8");
        post.setEntity(entity);
        //声明对象进行响应结果的存储
        String result;
        //设置cookies信息
        client.setCookieStore(this.store);
        //执行post方法
        HttpResponse response = client.execute(post);
        System.out.println(response);
        //获取响应结果
        result= EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        //处理结果，判断是否复合预期
        //将返回的响应结果字符串转化成json对象
        JSONObject resultJson=new JSONObject(result);
        //获取结果值
        String success = (String)resultJson.get("moushiqian");
        int status = (int)resultJson.get("status");

        //具体的判断返回结果的值
        Assert.assertEquals("success", success);
        Assert.assertEquals(1, status);


    }


}
