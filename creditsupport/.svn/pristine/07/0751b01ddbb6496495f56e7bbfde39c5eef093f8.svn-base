package com.yodata.creditsupport.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

public class HttpClientUtil {

    public static String post(String url, List<NameValuePair> params) throws IOException{
        String result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);

        try {
            post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
            HttpResponse response = client.execute(post);
            result = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            result = "error";
            throw e;
        }finally {  
            try {  
                //关闭流并释放资源  
                client.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }
        }
        
        return result;
    }
    
    
    public static void main(String...strings) {
//        举例：{content: {"operation":"predict", "model_code":"110000"}}
//        定义：
//            operation   <string>: 模型预测或训练操作，predict 或 train 可选；默认为predict；
//            model_code <string>: 行业模型的代码，默认110000； 依次编码为 110001,110002... 以此类推；
        String url = "http://172.17.128.17:19800/para/";
//        JSONObject json = new JSONObject();
//        json.put("operation", "predict");
//        json.put("model_code", "110000");
//        List<NameValuePair> params = new ArrayList<>();
//        params.add(new BasicNameValuePair("content", json.toJSONString()));
        JSONObject json = new JSONObject();
        json.put("model_code", "110000");
        json.put("reg_id", "320303000060648");
        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("content_one", json.toJSONString()));
        try {
            String rs = HttpClientUtil.post(url, params);
            JSONObject rsObject = JSONObject.parseObject(rs);
            int i = rsObject.getIntValue("state_code");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
