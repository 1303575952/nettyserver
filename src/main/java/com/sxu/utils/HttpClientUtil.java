package com.huanxin.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * HttpClient 工具类
 */
public class HttpClientUtil {

    /**
     * 请求编码
     */
    private static final String DEFAULT_CHARSET = "UTF-8";

    /**
     * 执行HTTP POST请求
     *
     * @param url   url
     * @param param 参数
     * @return
     */
    public static String httpPostWithJSON(String url, Map<String, ?> param) {
        CloseableHttpClient client = null;

        try {
            if (url == null || url.trim().length() == 0) {
                throw new Exception("URL is null");
            }

            HttpPost httpPost = new HttpPost(url);

            client = HttpClients.createDefault();

            if (param != null) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(param.toString(), DEFAULT_CHARSET);

                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType("application/json");

                httpPost.setEntity(entity);
            }

            HttpResponse resp = client.execute(httpPost);

            if (resp.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client);
        }

        return null;
    }

    /**
     * 执行HTTP GET请求
     *
     * @param url   url
     * @param param 参数
     * @return
     */
    public static String httpGetWithJSON(String url, Map<String, ?> param) {
        CloseableHttpClient client = null;

        try {
            if (url == null || url.trim().length() == 0) {
                throw new Exception("URL is null");
            }

            client = HttpClients.createDefault();

            if (param != null) {
                StringBuffer sb = new StringBuffer("?");

                for (String key : param.keySet()) {
                    sb.append(key).append("=").append(param.get(key)).append("&");
                }

                url = url.concat(sb.toString());
                url = url.substring(0, url.length() - 1);
            }

            HttpGet httpGet = new HttpGet(url);
            HttpResponse resp = client.execute(httpGet);

            if (resp.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(resp.getEntity(), DEFAULT_CHARSET);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close(client);
        }

        return null;
    }

    /**
     * 关闭HTTP请求
     *
     * @param client
     */
    private static void close(CloseableHttpClient client) {
        if (client == null) {
            return;
        }

        try {
            client.close();
        } catch (Exception e) {

        }
    }

    /**
     * http://localhost:8081/renren-api/jnrdgk/tuoxiao_reaction?gasInVol=1&NOxInDen=2&O2InPer=3&gasInTemp=4&NH3InVol=5
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Map param = new HashMap();

        // 构造工况模型的参数
        param.put("gasInVol", "1");
        param.put("NOxInDen", "2");
        param.put("O2InPer", "3");
        param.put("gasInTemp", "4");
        param.put("NH3InVol", "5");

        // 工况模型接口的调用
        String result = httpGetWithJSON("http://localhost:8081/renren-api/jnrdgk/tuoxiao_reaction", param);

        System.out.println("result:" + result);

        // 对返回的 Json 进行解析
        Map<String,Object> parsemap = JSON.parseObject(result, new TypeReference<Map<String,Object>>(){});
        Iterator<Map.Entry<String,Object>> iterable =  parsemap.entrySet().iterator();

        while(iterable.hasNext()) {
            Map.Entry<String,Object> mapson = iterable.next();
            System.out.println(mapson.getKey()+"----"+mapson.getValue());
        }
    }
}
