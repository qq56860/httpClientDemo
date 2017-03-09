package cn.com.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	public static String doPost(String url, String msg) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		RequestConfig config = RequestConfig.custom().setConnectTimeout(30000).setSocketTimeout(30000).build(); //设置超时时间
		
		
		StringEntity urlEntity = new StringEntity(msg);
		urlEntity.setContentEncoding("UTF-8");
		urlEntity.setContentType("application/json");
		
		post.setEntity(urlEntity);
		post.setConfig(config);
		
		
		CloseableHttpResponse response = httpclient.execute(post);
		
		HttpEntity entity = response.getEntity();
		if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
			System.out.println("--------------------------------------");  
            System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
            System.out.println("--------------------------------------"); 
		}
			
		
		return EntityUtils.toString(entity, "UTF-8");
		
	}
}
