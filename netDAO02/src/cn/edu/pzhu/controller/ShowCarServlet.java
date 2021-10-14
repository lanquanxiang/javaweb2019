package cn.edu.pzhu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.pzhu.entity.Car;
import cn.edu.pzhu.service.imp.CarServiceImp;
import cn.edu.pzhu.service.inf.CarService;
import cn.edu.pzhu.util.PagesUtil;

/**
 * Servlet implementation class ShowCarServlet
 */
@WebServlet("/show")
public class ShowCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarService service = new CarServiceImp();
		//物理分页
		//ArrayList<Car> list = service.showCar(1,10);
		//逻辑分页
		//1.得到完整的所有数据
		ArrayList<Car> list = service.showCar();
		//3.生产导航栏，并保存
		String spage = request.getParameter("page");
		String snum = request.getParameter("num");
		int page = 1;
		int num = 10;
		try {
			page = Integer.parseInt(spage);
		} catch (Exception e) {
			page = 1;
		}
		try {
			num = Integer.parseInt(snum);
		} catch (Exception e) {
			num = 10;
		}
		String path = request.getContextPath()+"/show";
		StringBuffer bar = PagesUtil.createBar(list,page,num,path);
		request.getSession().setAttribute("bar", bar);
		//2.根据需求分割list
		list = PagesUtil.splitList(list,page,num);
		request.getSession().setAttribute("list", list);
		response.sendRedirect(request.getContextPath()+ "/day17/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
