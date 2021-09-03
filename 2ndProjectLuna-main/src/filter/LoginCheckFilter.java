package filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class LoginCheckFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
	HttpServletRequest request = (HttpServletRequest)req;
	HttpServletResponse response=(HttpServletResponse)res;
	HttpSession session = request.getSession(false);
	String path=(String)session.getAttribute("path");
	
	

	
	if(session == null || session.getAttribute("authUser") == null) {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter script = response.getWriter();
        script.println("<script>");
        script.println("alert('로그인을 해주세요.')");
        script.println("</script>");
		request.setAttribute("path", path);
		request.getRequestDispatcher("login.jsp").include(request, response);

		
		
		
	}else {
		chain.doFilter(req, res);
	}
	
	}
	
	
	@Override
	public void destroy() {
	}

	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
