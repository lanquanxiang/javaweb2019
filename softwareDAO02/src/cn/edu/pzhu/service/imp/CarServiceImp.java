package cn.edu.pzhu.service.imp;

import java.util.List;

import cn.edu.pzhu.dao.CarDAO;
import cn.edu.pzhu.dao.imp.CarDAOImp;
import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.service.CarService;

public class CarServiceImp implements CarService{

	CarDAO dao = new CarDAOImp();
	
	@Override
	public List<Car> show() {
		return dao.selectAll();
	}

}
