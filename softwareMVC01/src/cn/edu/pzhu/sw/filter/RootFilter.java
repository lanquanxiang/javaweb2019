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
			System.out.println("过滤器发现你未登录，已经自动帮你跳转到登录页面！");
			//response2.sendRedirect(request2.getContextPath()+"/day06/user.jsp");
			response2.setCharacterEncoding("UTF-8");
			response2.setContentType("text/html; charset=UTF-8");
			response2.getWriter().print("<script>alert('你没有登录，为你跳转到登录页面');window.location.href='"+request2.getContextPath()+"/day06/user.jsp"+"'</script>");
		}else{
			//如果不为null，表示能够取到hs，也就是说用户已经登录成功
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
