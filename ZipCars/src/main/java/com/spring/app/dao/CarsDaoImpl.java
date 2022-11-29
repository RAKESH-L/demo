package com.spring.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.spring.app.model.Cars;

public class CarsDaoImpl implements CarsDao{
	
	private DataSource dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Cars getLastRow() {
		String sql = "SELECT * FROM CARS ORDER BY CARID DESC LIMIT 1";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		Cars c = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Cars.class));
		return c;
	}

	@Override
	public void save(Cars car) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CARS VALUES (?,?,?,?,?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		Cars c = getLastRow();
		
		int id = 101;
		if(c != null) {
			id = c.getCarId() + 1;
			
		}
		car.setCarId(id);
		
		Object[] args = {car.getCarId(), car.getCarName(),car.getBrand(), 
				car.getDescription(), car.getPrice()};
		
		int res = jdbcTemplate.update(sql, args);
		
		if(res>0) {
			System.out.println("Car Details Inserted");
		}else {
			System.out.println("Unable to insert. Try later");
		}
		
	}

	@Override
	public List<Cars> getAll() {
		String sql = "SELECT * FROM CARS";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		List<Cars> list = new ArrayList<Cars>();
		list = jdbcTemplate.query(sql, new RowMapper<Cars>() {

			@Override
			public Cars mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Cars c = new Cars();
				c.setCarId(rs.getInt("CARID"));
				c.setCarName(rs.getString("CARNAME"));
				c.setBrand(rs.getString("BRAND"));
				c.setDescription(rs.getString("DESCRIPTION"));
				c.setPrice(rs.getDouble("PRICE"));
				return c;
			}
			
		});
		
		return list;
	}

	@Override
	public Cars getByCarId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
