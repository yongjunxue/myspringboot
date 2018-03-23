package com.test.config.elastic;

import org.elasticsearch.client.transport.TransportClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;


/**
 * 操作elasticsearch可以使用ElasticsearchTemplate，也可以使用PagingAndSortingRepository的实现类
 * @author xueyongjun
 *
 */
@Configuration
public class ElasticSearchTemplateConfig {
	
	@Bean(name = "elasticsearchTemplate")
	@Qualifier("elasticsearchTemplate")
	public ElasticsearchTemplate primaryDataSource(@Qualifier("transportClient") TransportClient client) {
		return new ElasticsearchTemplate(client);
	}
}
