package cn.edu.pzhu.sw.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class RootFilter
 */
@WebFilter("/day06/show.jsp")
public class RootFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RootFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
		if(request2.getSession().getAttribute("hs")==null){
			//用户没有登录，请求转发或者重定向
			System.out.println("用户没有登录，过滤器已经自动为你跳转到登录界面");
			//response2.sendRedirect(request2.getContextPath()+"/day06/user.jsp");
			response2.getWriter().print("<script>alert('你没有登录，为你自动跳转');"
					+ "window.location.href='"+request2.getContextPath()+"/day06/user.jsp';"
							+ "</script>");
		}else{
			//用户已经登录，可以放行
			chain.doFilter(request, response);
		}
		
		
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
