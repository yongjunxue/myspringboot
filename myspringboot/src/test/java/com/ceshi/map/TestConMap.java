package com.ceshi.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConMap {
	public static void main(String[] args) {
		Map<String,Object> m=new ConcurrentHashMap<String, Object>();
		System.out.println(m.putIfAbsent("aa", "aaa"));
		System.out.println(m);
		System.out.println(m.putIfAbsent("aa", "aaaa"));
		System.out.println(m);
		System.out.println(m.remove("bb"));
		System.out.println(m);
	}
}
