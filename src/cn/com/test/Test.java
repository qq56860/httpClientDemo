package cn.com.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import cn.com.util.HttpUtil;

public class Test {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String url = "http://localhost:8080/MRAuthorizationServer/mtu/loginV17x";
		String msg = "{\"mtuCode\":\"123qwe\"}";
		;
		System.out.println(HttpUtil.doPost(url, msg));
	}
}
