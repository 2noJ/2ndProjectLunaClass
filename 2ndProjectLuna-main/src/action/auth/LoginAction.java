package action.auth;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.auth.LoginService;
import vo.ActionForward;
import vo.User;

public class LoginAction implements Action {

	private static final String FORM_VIEW = "login.jsp";
	private LoginService loginService = new LoginService();
	ActionForward forward = new ActionForward();
	
	

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}

	}

	private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
		String path1=(String)req.getSession().getAttribute("path1");
		
		forward.setPath(FORM_VIEW);
		return forward;

	}

	private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = trim(req.getParameter("id"));
		String password = trim(req.getParameter("password"));
		String pic = trim(req.getParameter("pic"));
		String path1=(String)req.getSession().getAttribute("path1");
		
		
		
		
		String path=req.getParameter("path");
		if(path.equals("null")) {
			path=(String)req.getAttribute("path");
			
			
		}
		


		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			req.setAttribute("path", path);
			res.setContentType("text/html; charset=UTF-8");

			PrintWriter out = res.getWriter();

			out.println("<script>alert('아이디와 비밀번호를 확인해 주세요'); location.href='login.do';</script>");

			out.flush();

			return null;
		}

		try {
			User user = loginService.login(id, password, pic);

			req.getSession().setAttribute("authUser", user);
			 if(id.equals("admin")) {
res.setContentType("text/html; charset=UTF-8");
				 
				 PrintWriter out = res.getWriter();
				 
				 out.println("<script>alert('아이디와 비밀번호를 확인해 주세요'); location.href='login.do';</script>");
				 
				 out.flush();
				 
				 HttpSession session = req.getSession(false);
		         if (session != null) {
		            session.invalidate();
		         }
	        	 return null;
 
	         }else {
	        	
	        	 if(req.getParameter("path").equals("null")) {
	            res.sendRedirect(req.getContextPath() + "/"+path1);
	               }else {
	                  res.sendRedirect(req.getContextPath() + "/"+path);
	               }
	        	 return null;}
		} catch (Exception 
				e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			
		if(req.getParameter("path").equals("null")==false) {
			res.setContentType("text/html; charset=UTF-8");
		   	  
		   	  PrintWriter out = res.getWriter();
		   	   
		   	  out.println("<script>alert('아이디와 비밀번호를 확인해 주세요');</script>");
		   	   
		   	  out.flush();
			req.setAttribute("path", path);
			req.setAttribute("message", "mes");
			req.getRequestDispatcher("login.jsp").include(req, res);
			
			return null;
		}else {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			res.setContentType("text/html; charset=UTF-8");
		   	  
		   	  PrintWriter out = res.getWriter();
		   	   
		   	  out.println("<script>alert('아이디와 비밀번호를 확인해 주세요'); location.href='login.do';</script>");
		   	   
		   	  out.flush();
		     
		     	return null;
		      }
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}
}