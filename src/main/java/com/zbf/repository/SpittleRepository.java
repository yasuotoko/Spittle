package com.zbf.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zbf.entity.Spittle;

public class SpittleRepository{
	
//	@PersistenceUnit
//	private EntityManagerFactory emf;
//
//	private NamedParameterJdbcTemplate jdbcOperations;
//	
//	@Autowired
//	public SpittleRepository(NamedParameterJdbcTemplate jdbcOperations){
//		this.jdbcOperations = jdbcOperations;
//	}
//	
//	public void addSpitter(){
//	}
//	
//	private static final class SpitterRowMapper implements RowMapper<String> {
//
//		@Override
//		public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//			
//			return null;
//		}
//		
//	}
	private static final String INSERT_SPITTLE = "insert into Spittle (name,password)" + "values(?,?)";
	
	private static final String SELECT_BY_ID = "select * from Spittle where id=?";
	
	private JdbcTemplate jdbcTemplate;
	
	
//	@Autowired
	public SpittleRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int addSpittle(Spittle spittle){
		return jdbcTemplate.update(INSERT_SPITTLE,spittle.getName(),spittle.getPassword());
	}
	
	public Spittle findOne(int id){
		return jdbcTemplate.queryForObject(SELECT_BY_ID,this::mapSpittle,id);
	}
	
	private Spittle mapSpittle(ResultSet rs, int row) throws SQLException{
		Spittle spittle = new Spittle();
		spittle.setId(rs.getInt("id"));
		spittle.setName(rs.getString("name"));
		spittle.setPassword(rs.getString("password"));
		return spittle;
	}
}
