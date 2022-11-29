package com.spring.app.dao;

import java.util.List;

import com.spring.app.model.Cars;

public interface CarsDao {
	public void save(Cars car);
	public List<Cars> getAll();
	public Cars getByCarId(int id);
}
