package com.ceshi.elastic;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;
import com.test.pojo.elastic.BasePojo;
import com.test.pojo.elastic.Car;
import com.test.pojo.elastic.Goods;
import com.test.pojo.elastic.User;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class MyElasticsearchTemplate{
	
	@Autowired
	private TransportClient client;
	@Autowired
	private ElasticsearchTemplate template;
	
	@Before
	public void setUp() {
		
	}
	
	/**
	 * 用client添加数据
	 * @throws IOException
	 */
//	@Test
	@Deprecated
	public void addIndex1() throws IOException{
		IndexResponse response =client.prepareIndex("pl5", "user", "13")
            .setSource(XContentFactory.jsonBuilder()
                    .startObject()
                    .field("name", "十三")
                    .field("money", 1300)
                    .field("postDate", new Date())
                .endObject()
                    )
            .get();
        System.out.println("索引名称："+response.getIndex());
        System.out.println("类型："+response.getType());
        System.out.println("文档ID："+response.getId()); // ��һ��ʹ����1
        System.out.println("当前实例状态："+"---");
	}
	
	/**
	 * 用template添加
	 */
//	@Test
	public void addIndex(){
		System.out.println("----------开始添加索引----------------");
		User u=new User();
		u.setId(8L);
		u.setName("王八");
		u.setPassword("888");
		u.setTel("18234243");
		u.setAge(23);
		u.setMoney(2700);
//		userRep.save(u);
		createIndex(u);
		IndexQuery indexQuery=getIndexQuery(u);
		String id=template.index(indexQuery);
		System.out.println(id);
	}
	
	/**
	 * 用这个方法可以创建自定义数量的shards
	 * @param pojo
	 */
	public void createIndex(BasePojo pojo){
		if(!template.indexExists(pojo.getClass())){
			template.createIndex(pojo.getClass());
		}
	}
	
	/**
	 * 用template添加
	 * 问题：如果index、type相同，不设置id，那么elasticsearch会自动生成id值。但是，会覆盖掉已经存在的数据。
	 */
//	@Test
	public void addIndex2(){
		System.out.println("----------开始添加索引----------------");
		Car u=new Car();
//		u.setId(14L);
		u.setName("大黄蜂");
		u.setBrand("跑车");
		u.setPrice(2);
		u.setProduct("MX");
//		
		createIndex(u);
//		
//		IndexQuery indexQuery=getIndexQuery(u);
//		String id=template.index(indexQuery);
//		System.out.println("id:"+id);
		template.putMapping(u.getClass());
//		template.createIndex(indexName, settings);
//		template.createIndex(Goods.class);
	}
	
//	@Test
	public void getIndexInfo(){
		String index="user";
		Map<String, Object> map = template.getSetting(index);
		for (String key : map.keySet()) {
			System.out.println("key:" + key + ",value:" + map.get(key));
		}
	}
	
	/**
	 * 查询---排序---分页
	 */
//	@Test
	public void getUserOrder(){
		Map<String, Object> query=new HashMap<String, Object>();
		query.put("name", "老");
		query.put("minAge", 10);
//		query.put("password", "33");
		Criteria criteria=convertCriteria(query);
		if (criteria != null) {
			CriteriaQuery singleCriteriaQuery = new CriteriaQuery(criteria);
			singleCriteriaQuery.addSort(new Sort(Direction.DESC,"money")).addSort(new Sort(Direction.ASC,"age"));
			singleCriteriaQuery.addTypes("user");
			singleCriteriaQuery.setPageable(PageRequest.of(0,10));
			List<User> list=template.queryForList(singleCriteriaQuery, User.class);
			for(User user:list){
				System.out.println(user);
			}
		}
	}
	
	/**
	 * 模糊查询---排序---分页
	 */
	@Test
	public void getUserOrder2(){
		Map<String, Object> query=new HashMap<String, Object>();
//		query.put("name", "老大");
//		query.put("tel", "23");
		query.put("password", "33");
		SearchQuery searchQuery=convertSearchQuery(query);
		if (searchQuery != null) {
			searchQuery.addSort(new Sort(Direction.DESC,"money"));//.addSort(new Sort(Direction.ASC,"brandId"));
			searchQuery.addTypes("user");
			searchQuery.setPageable(PageRequest.of(0,10));
			List<User> list=template.queryForList(searchQuery, User.class);
			for(User user:list){
				System.out.println(user);
			}
		}
	}
	
	/**
	 * 删除所有索引和数据
	 */
//	@Test
	public void deleteAllIndex(){
		template.deleteIndex(Goods.class);
	}
	
	/**
	 * 删除所有索引和数据
	 */
//	@Test
	public void deleteIndex(){
		User u=new User();
		u.setId(1L);
//		template.delete(u,u.getId());//不能用
//		template.delete(indexName, type, id)；
	}
	
	
	private SearchQuery convertSearchQuery(Map<String, Object> query) {
		NativeSearchQueryBuilder nsb = new NativeSearchQueryBuilder();//高亮字段  
    	BoolQueryBuilder qb=QueryBuilders.boolQuery();  
		Iterator<String> ite = query.keySet().iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			Object value = query.get(key);
			if (key.equals("id")) {
				qb.must(QueryBuilders.termQuery("id", value));//完全匹配
				continue;
			}
			if (key.equals("password")) {
				qb.must(QueryBuilders.matchQuery("password", value));//模糊匹配
				continue;
			}
			String[] searchList = { "\\", "+", "-", "!", "(", ")", "（", "）", ":", "^", "[", "]", "\"", "{", "}", "~",
					"*", "?", "|", "&", ";", "/", " " };
			String[] replacementList = { "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
					"", "", "" };
			String _value = StringUtils.replaceEach(String.valueOf(value), searchList, replacementList);
			if (key.equals("name")) {
				qb.must(QueryBuilders.matchPhrasePrefixQuery("name", _value));//模糊匹配
				continue;
			}
			if (key.equals("tel")) {
//				qb.must(QueryBuilders.matchQuery("tel", _value));//模糊匹配
				qb.must(QueryBuilders.matchPhrasePrefixQuery("tel", _value));//模糊匹配
				continue;
			}
//			if (key.equals("carModelId")) {//v2b商品车型筛选，有车型必有车系，绑定了精确的车型id 或 车系在小v商品适配车型
//				qb.must(QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("carModelId", "-1")).should(QueryBuilders.matchQuery("carModelId",_value)));
//				continue;
//			}
//			if (key.equals("status")) {
//				qb.must(QueryBuilders.termQuery("status", value));
//				continue;
//			}
		}
		if (qb.hasClauses()) {
			nsb.withQuery(qb);  
			SearchQuery searchQuery = nsb.build();//查询建立 
			return searchQuery;
		} else {
			return null;
		}
	}

	private Criteria convertCriteria(Map<String, Object> query) {
		Criteria criteria = null;
		Iterator<String> ite = query.keySet().iterator();
		while (ite.hasNext()) {
			String key = ite.next();
			Object value = query.get(key);
			if (key.equals("id")) {
				if (criteria != null) {
					criteria = criteria.and("id").is(value);
				} else {
					criteria = Criteria.where("id").is(value);
				}
			}else if(key.equals("name")){
				if (criteria != null) {
					criteria = criteria.and("name").is(value);
				} else {
					criteria = Criteria.where("name").is(value);
				}
			}
			else if(key.equals("password")){
				if (criteria != null) {
					criteria = criteria.and("password").contains(value.toString());//模糊查询
				} else {
					criteria = Criteria.where("password").contains(value.toString());
				}
			}
			else if(key.equals("age")){
				if (criteria != null) {
					criteria = criteria.and("age").is(value);
				} else {
					criteria = Criteria.where("age").is(value);
				}
			}
			else if(key.equals("minAge")){
				if (criteria != null) {
					criteria = criteria.and("age").greaterThan(value);
				} else {
					criteria = Criteria.where("age").greaterThan(value);
				}
			}
		}
		return criteria;
	}
	
	
	private IndexQuery getIndexQuery(BasePojo  pojo) {
		Class<? extends Object> clazz=pojo.getClass();
		Document doc=clazz.getAnnotation(Document.class);
		if(doc != null){
			String indexName=doc.indexName();
			String type=doc.type();
			short shards=doc.shards();
			short replicas=doc.replicas();
			return new IndexQueryBuilder().withId(pojo.getId() + "")
					.withObject(pojo).withIndexName(indexName).withType(type).build();
		}else{
			return null;
		}
		
	}
	
}
