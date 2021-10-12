package cn.edu.pzhu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.util.DruidUtil;

public class CarDAOImp implements CarDAO{

	public JdbcTemplate template = new JdbcTemplate(DruidUtil.getDs());
	
	@Override
	public boolean add(Car data) {
		String sql = "insert into car values(?,?,?,?)";
		int n = template.update(sql, data.getCar_id(),
				data.getCar_name(),data.getCar_type(),data.getCar_price());
		if (n>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean detele(Integer key) {
		String sql = "delete from car where car_id=?";
		int n = template.update(sql, key);
		if (n>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Car data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Car selectById(Integer key) {
		String sql="select * from car where car_id=?";
		try {
			return template.queryForObject(sql, new BeanPropertyRowMapper<>(Car.class), key);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public ArrayList<Car> selectAll() {
		String sql="select * from car";
		return (ArrayList<Car>) template.query(sql, new BeanPropertyRowMapper<>(Car.class));
	}

	@Override
	public List<Car> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
