package com.zbf.test;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zbf.config.RootConfig;
import com.zbf.entity.Spittle;
import com.zbf.repository.DataBaseConfig;
import com.zbf.repository.SpittleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={DataBaseConfig.class})
public class DataBaseTest {

	@Autowired
	private SpittleRepository spittleRep;
//	
	@Autowired
	private Spittle spittle;
	
	@Test
	public void dataSourceTest(){
		Spittle spittle = new Spittle();
		spittle.setName("zbf");
		spittle.setPassword("pass");
		int i = spittleRep.addSpittle(spittle);
		Assert.assertEquals(i, 1);
	}
	
	@Test
	public void dataSourceTest1(){
		Spittle spittle = spittleRep.findOne(1);
		Assert.assertEquals("zbf", spittle.getName());
	}
	
	@Test
	public void test(){
		Assert.assertEquals("dada", spittle.getName());
	}
}
