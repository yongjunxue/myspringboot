package com.ceshi.io;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestIo {
	public static void main(String[] args) throws FileNotFoundException {
//		InputStream f=new FileInputStream("");
//		FileOutputStream out=new FileOutputStream("");
		try 
		(AutoClose autoClose=new AutoClose())
		{
			autoClose.print();
		} catch (Exception e) {
			
		}
	}
}
class AutoClose implements Closeable{

	@Override
	public void close() throws IOException {
		System.out.println("关闭了");
	}
	public void print(){
		System.out.println("打印");
	}
}