package cn.edu.pzhu.service;

import java.util.List;

import cn.edu.pzhu.dao.CarDAO;
import cn.edu.pzhu.dao.CarDAOImp;
import cn.edu.pzhu.entity.Car;

public class CarServiceImp implements CarService{

	private CarDAO dao = new CarDAOImp();
	
	@Override
	public List<Car> show() {
		return dao.select();
	}

}
