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

	@Override
	public ArrayList<Car> showCar(int page, int num) {
		if(page<=0){
			page=1;
		}
		if (num<=0) {
			num=10;
		}
		int start = (page-1)*num;
		return dao.selectAll(start, num);
	}

}
