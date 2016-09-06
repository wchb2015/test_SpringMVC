package com.springmvc.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient {

    public static void main(String[] args) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet("http://hq.sinajs.cn/list=SR1609");

        CloseableHttpResponse response = httpClient.execute(httpGet);

        HttpEntity entity = response.getEntity();

        System.out.println("--------------------------------------");
        System.out.println(response.getStatusLine());
        if (entity != null) {
            System.out.println("Response Content length: " + entity.getContentLength());
            System.out.println("Response Content: " + EntityUtils.toString(entity));
        }
        System.out.println("--------------------------------------");
    }
}