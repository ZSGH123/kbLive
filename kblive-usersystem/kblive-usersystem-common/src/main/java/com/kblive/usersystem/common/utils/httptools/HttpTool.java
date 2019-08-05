package com.kblive.usersystem.common.utils.httptools;

import com.kblive.usersystem.common.utils.md5tools.MD5Util;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * title: HttpTool
 * projectName kbLive
 * description: 调用http请求的工具
 * author 2671242147@qq.com
 * date 2019-07-04 23:50
 ***/
public class HttpTool {


    /**
     * 封装请求参数
     */
    public static final String HANDURL = "https://s.zkong.xyz/outer/check";

    public static String doGet(String url, Map<String, String> parameters, int socketTimeout, int connectTimeout) throws IOException {
        return doGet(url, parameters, "UTF-8", socketTimeout, connectTimeout);
    }

    public static String doGetObj(String url, Map<String, Object> parameters, int socketTimeout, int connectTimeout) throws IOException {
        return doGet(url, convert(parameters), "UTF-8", socketTimeout, connectTimeout);
    }


    public static String doGet(String url, Map<String, String> parameters, String charset, int socketTimeout, int connectTimeout) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        String _url = url;
        if (!parameters.isEmpty()) {
            String _params = WebUtils.buildQuery(parameters, charset);
            _url = url + "?" + _params;
        }
        System.out.println("url:" + _url);
        HttpGet httpGet = new HttpGet(_url);
        RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(socketTimeout).setConnectTimeout(connectTimeout).build();//设置请求和传输超时时间
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = httpClient.execute(httpGet);//执行请求
        HttpEntity httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");
    }

    private static Map<String, String> convert(Map<String, Object> parameters) {
        Map<String, String> map = new HashMap<>();
        if (parameters == null) {
            return map;
        }
        for (String k : parameters.keySet()) {
            map.put(k, parameters.get(k) != null ? parameters.get(k).toString() : null);
        }
        return map;
    }

    public static String getSignByKey(Map<String, Object> paramMap, String key) {
        if (paramMap == null || StringUtils.isEmpty(key)) {
            return "";
        }
        TreeMap<String, Object> map = new TreeMap<>(new Comparator<String>() {
            public int compare(String obj1, String obj2) {
                return obj1.compareTo(obj2);
            }
        });
        for (String k : paramMap.keySet()) {
            map.put(k, paramMap.get(k));
        }
        StringBuilder str = new StringBuilder();
        for (String k : map.keySet()) {
            str.append(k).append(map.get(k));
        }
        str.append(key);
        System.out.println("参数：" + str + "，密文：" + MD5Util.getMD5(str.toString()).toUpperCase());
        return MD5Util.getMD5(str.toString()).toUpperCase();
    }

    /**
     * WebUtils.buildQuery(parameters, charset)
     * parameters.put("orderId", "");或者parameters.put("orderId", null)则都不会把此参数加到url后面
     *
     * @param args     
     */
    public static void main(String[] args) {
        Map<String, Object> param = new HashMap<>(2);
        param.put("appKey", 161966);
        param.put("orderId", "");
        param.put("tradeNo", "");
        param.put("pageNo", 1);
        param.put("pageSize", 20);
        param.put("token", getSignByKey(param, "zkong"));
        try {
            String res = doGetObj(HANDURL, param, 10000, 10000);
            System.out.println("响应内容：" + res);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

