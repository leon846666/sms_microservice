package com.youpinhui.sms;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

@Component
public class SmsListener {

	@Autowired
	private SmsUtil smsUtil;
	
	@JmsListener(destination="smstxt")
	public void send(Map<String, String> map) {
		System.out.println("asdasd");
		try {
			SendSmsResponse response = smsUtil.sendSms(map.get("phoneNum"), map.get("templateCode"), map.get("signName"), map.get("code"));
			System.out.println("code : "+response.getCode());
			System.out.println("message : "+response.getMessage());
			
		} catch (ClientException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
