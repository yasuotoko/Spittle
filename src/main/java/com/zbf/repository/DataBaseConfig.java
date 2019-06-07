package com.zbf.repository;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate3.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Component;

import com.zbf.entity.Spittle;

@Configuration
public class DataBaseConfig {

//	@Profile("production")
//	@Bean
//	public JndiObjectFactoryBean jndiDataSource(){
//		JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//		
//		return jndiObjectFactoryBean;
//		
//	}
//	
//
//	
////	@Bean
//	public DataSource managerDataSource(){
//		DriverManagerDataSource dSource = new DriverManagerDataSource();
//		
//		return dSource;
//	}
//	
////	@Profile("development")
////	@Bean
//	public DataSource embedDataSource() {
//		return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
//				.addScript("classpath:schema.sql")
//				.addScript("classpath:test-data.sql")
//				.build();
//	}
	
//	@Profile("qa")
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springT?serverTimezone=UTC");
		ds.setUsername("root");
		ds.setPassword("password");
		return ds;
	}
//	
	@Bean
	public JdbcTemplate jdbcTemplate(BasicDataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
//	
	@Bean
	public Spittle spittle(){
		Spittle spittle = new Spittle();
		spittle.setName("dada");
		return spittle;
	}
	
	
	@Bean
	public SpittleRepository spittleRepository(JdbcTemplate jdbcTemplate){
		return new SpittleRepository(jdbcTemplate);
	}
	
//	@Bean
//	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource){
//		return new NamedParameterJdbcTemplate(dataSource);
//	}
	

//	@Bean
//	public LocalSessionFactoryBean sessionFactoryBean(DataSource dataSource){
//		LocalSessionFactoryBean sfb = new LocalSessionFactoryBean();
//		sfb.setDataSource(dataSource);
//		sfb.setMappingResources(new String[]{});
//		Properties pros = new Properties();
//		//TODO
//		sfb.setHibernateProperties(pros);
//		return sfb;
//	}
//	
//	@Bean
//	public BeanPostProcessor persitenceTraslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}
//	
//	@Bean
//	public LocalEntityManagerFactoryBean entityManagerFactoryBean(){
//		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
//		emfb.setPersistenceUnitName("spitterPu");
//		//TODO
//		return emfb;
//	}
//	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(DataSource dataSource,JpaVendorAdapter jpaVendorAdapter){
//		LocalContainerEntityManagerFactoryBean ecfb = new LocalContainerEntityManagerFactoryBean();
//		ecfb.setDataSource(dataSource);
//		ecfb.setJpaVendorAdapter(jpaVendorAdapter);
//		//TODO
//		return ecfb;
//	}
}
