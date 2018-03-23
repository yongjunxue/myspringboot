package com.test.config.elastic;

import java.net.InetAddress;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TransportClientConfig {
	
//	private String clusterName="my-application";//跟elasticsearch.yml中的cluster.name一样
//	private String nodeName="node-1";//跟elasticsearch.yml中的node.name一样
//	private String ip="127.0.0.1"; 
//	private int port=9300; //默认是这个端口
	
//	private String clusterName;
//	private String nodeName;
//	private String ip;
//	private int port;

//--------------获取properties属性----------------方法1
	@Value("${elastic.cluster.name}")
	private String clusterName;  
	@Value("${elastic.node.name}")
	private String nodeName;
	@Value("${elastic.http.ip}")
	private String ip;
	@Value("${elastic.http.port}")
	private int port;
	
//--------------获取properties属性----------------方法2.从Environment中读取
//	@Autowired
//    private Environment env;
	
	@Bean(name = "transportClient")
	@Qualifier("transportClient")
	public TransportClient primaryDataSource() {
//		clusterName=env.getProperty("elastic.cluster.name");
//		nodeName=env.getProperty("elastic.node.name");
//		ip=env.getProperty("elastic.http.ip");
//		port=Integer.parseInt(env.getProperty("elastic.http.port"));
		TransportClient client=null;
		Settings settings = Settings.builder() 
                .put("cluster.name", clusterName) 
                .put("node.name",nodeName)
                .build();
		try {
			client = new PreBuiltTransportClient(settings)
			.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ip), port));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return client;
	}

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	
	
}
