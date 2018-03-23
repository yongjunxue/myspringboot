/*package com.ceshi;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.Start;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Start.class)
public class TestJdbc {
	@Autowired
	@Qualifier("primaryJdbcTemplate")
	protected JdbcTemplate jdbcTemplate1;

//	@Autowired
//	@Qualifier("secondaryJdbcTemplate")
//	protected JdbcTemplate jdbcTemplate2;

	@Before
	public void setUp() {
//		jdbcTemplate1.update("DELETE  FROM  USER ");
//		jdbcTemplate2.update("DELETE  FROM  USER ");
	}

	@Test
	public void test() throws Exception {
		List<Map<String, Object>> list=jdbcTemplate1.queryForList("select * from wms_qr_code limit 0,10");
		for(Map<String, Object> m : list){
			System.out.println(m.toString());
		}
//		
//		// 往第一个数据源中插入两条数据
//		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
//		jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);
//
//		// 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
//		jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);


	}
}
*/