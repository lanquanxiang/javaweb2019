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
			//�û�û�е�¼������ת�������ض���
			System.out.println("�û�û�е�¼���������Ѿ��Զ�Ϊ����ת����¼����");
			//response2.sendRedirect(request2.getContextPath()+"/day06/user.jsp");
			response2.getWriter().print("<script>alert('��û�е�¼��Ϊ���Զ���ת');"
					+ "window.location.href='"+request2.getContextPath()+"/day06/user.jsp';"
							+ "</script>");
		}else{
			//�û��Ѿ���¼�����Է���
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
