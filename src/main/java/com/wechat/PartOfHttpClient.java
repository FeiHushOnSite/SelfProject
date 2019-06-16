package com.wechat;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * describe:
 * HttpGet send request and acquire data   -----> 6 steps
 *  1.create HttpClients connection HttpClients.createDefault():
 *  2.create HttpGet request new HttpGet():
 *  3.configure response check ResponseHandler<JSONObject></>
 *  4.excuse request httpclient.excute(httpget.responseHandler):
 *  5.handle message body
 *  6.close connection httpclient.close().
 * @author Feiyu
 * @date 2019/06/16
 */
public class PartOfHttpClient {

    String corpid = "";
    String corpsecret = "";
    //create connection
    CloseableHttpClient httpClient = HttpClients.createDefault();
    //create httpGet
    HttpGet httpGet = new HttpGet("http://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid="+corpid+"&corpsecret="+corpsecret);
    ResponseHandler<JSONObject> responseHandler = new ResponseHandler<JSONObject>() {
        public JSONObject handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
            return null;
        }
    };
}
