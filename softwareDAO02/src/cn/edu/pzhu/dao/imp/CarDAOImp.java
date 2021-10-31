package cn.edu.pzhu.dao.imp;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import cn.edu.pzhu.dao.CarDAO;
import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.util.DruidUtil;

public class CarDAOImp implements CarDAO {

	private JdbcTemplate template = new JdbcTemplate(DruidUtil.getDataSource());
	
	@Override
	public boolean add(Car data) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Car data) {
		String sql = "update car set car_name=?,car_type=?,car_price=? where car_id=?";
		int n = template.update(sql, data.getCar_name(),data.getCar_type(),data.getCar_price(),data.getCar_id());
		if (n>0) {
			return true;
		}
		return false;
	}

	@Override
	public Car select(Integer key) {
		String sql = "select * from car where car_id=?";
		try {
			return template.queryForObject(sql, new BeanPropertyRowMapper<Car>(Car.class), key);
		} catch (Exception e) {
			return null;
		}
		
	}

	@Override
	public List<Car> selectAll() {
		String sql="select * from car";
		try {
			return template.query(sql, new BeanPropertyRowMapper<Car>(Car.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Car> selectByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
