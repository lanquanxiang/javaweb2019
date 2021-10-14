package cn.edu.pzhu.service.imp;

import java.util.ArrayList;

import cn.edu.pzhu.dao.imp.CarDAOImp;
import cn.edu.pzhu.dao.inf.CarDAO;
import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.service.inf.CarService;

public class CarServiceImp implements CarService{
	
	CarDAO dao = new CarDAOImp();
	
	@Override
	public ArrayList<Car> showCar() {
		return dao.selectAll();
	}

}
