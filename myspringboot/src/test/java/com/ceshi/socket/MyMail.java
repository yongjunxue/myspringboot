package com.ceshi.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class MyMail {
	public static void send() throws UnknownHostException, IOException{
		Socket so=new Socket("smtp.163.com",25);
		PrintWriter out=new PrintWriter(so.getOutputStream(),true);
		String hostName=InetAddress.getLocalHost().getHostName();
		out.println("HELO "+hostName);
		out.flush();
		
		out.println("MAIL FROM:<"+"1925213936@qq.com");
		
		out.println("RCPT TO:<"+"1925213936@qq.com");
		
		out.println("RCPT TO:<"+"1925213936@qq.com");
		
		out.println("DATA");
		
		out.println("Content-Type:text/html");
		
		out.println("Subject:" + "<h1>你好，测试了</h1>");
		
		out.println("From:" + "1925213936@qq.com");
		out.println("To:"+"1925213936@qq.com");
		out.println(".");
		out.println("QUIT");
		so.close();
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		send();
	}
}
