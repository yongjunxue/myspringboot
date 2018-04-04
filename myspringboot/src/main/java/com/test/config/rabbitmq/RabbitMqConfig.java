package com.test.config.rabbitmq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

/**
 * 这个配置类可以不用写。用rabbitTemplate的时候直接使用如下的配置即可
 * @Autowired
   private AmqpTemplate amqpTemplate
 * 
 * 
 * @author xueyongjun
 *
 */
@Configuration
public class RabbitMqConfig {
	
	@Value("${rabbitmq.hostName}")
	private String hostName;  
	@Value("${rabbitmq.port}")
	private int port;  
	@Value("${rabbitmq.username}")
	private String username;  
	@Value("${rabbitmq.password}")
	private String password;
	
	private ConnectionFactory client;
	private CachingConnectionFactory cachingConnectionFactory;
	private RabbitTemplate rabbitTemplate;
	
	@Bean(name = "clientConnectionFactory")
	@Qualifier("clientConnectionFactory")
	public ConnectionFactory getConnectionFactory(){
		if(client==null){
			client=new ConnectionFactory();
			client.setHost(hostName);
			client.setPort(port);
			client.setUsername(username);
			client.setPassword(password);
		}
		return client;
	}
	
	@Bean(name = "connectionFactory")
	@Qualifier("connectionFactory")
	public CachingConnectionFactory getCachingConnectionFactory(){
		if(cachingConnectionFactory == null){
			cachingConnectionFactory =new CachingConnectionFactory(getConnectionFactory());
		}
		return cachingConnectionFactory;
	}
	
	@Bean(name = "rabbitTemplate")
	@Qualifier("rabbitTemplate")
	public RabbitTemplate getRabbitMqTemplate(){
		if(rabbitTemplate==null){
			rabbitTemplate=new RabbitTemplate(getCachingConnectionFactory());
		}
		return rabbitTemplate;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
