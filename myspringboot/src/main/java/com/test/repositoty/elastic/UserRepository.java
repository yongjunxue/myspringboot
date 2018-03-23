package com.test.repositoty.elastic;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.test.pojo.elastic.User;

/**
 * UserRepository的使用需要用到ElasticsearchTemplate的实例，所以在ElasticSearchTemplateConfig对ElasticsearchTemplate进行了初始化
 * @author xueyongjun
 *
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
