package com.ceshi.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import net.minidev.json.JSONObject;

public class MySocket {
	public static void main(String[] args) throws UnknownHostException {
		
		InetAddress ia=InetAddress.getByName("time-A.timefreq.bldrdoc.gov");
		System.out.println(ia);
		System.out.println(InetAddress.getLocalHost());
		try {
			ServerSocket server=new ServerSocket(8090);
			Socket comming=server.accept();
			Scanner in=new Scanner(comming.getInputStream());
			PrintWriter out=new PrintWriter(comming.getOutputStream());
			out.print("Hi,Entry bye to exit");
			boolean done=false;
			if(!done && in.hasNext()){
				String msg=in.next();
				out.print("System:your msg is"+msg);
				if(msg.trim().equals("msg")){
					done=true;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
