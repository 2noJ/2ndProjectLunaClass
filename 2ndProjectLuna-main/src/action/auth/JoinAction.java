package action.auth;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.auth.JoinService;
import vo.ActionForward;
import vo.Join_bean;

public class JoinAction implements Action {
		
		private static final String FORM_VIEW = "Join.jsp";
		private JoinService joinService = new JoinService();
		ActionForward forward = new ActionForward();
			@Override
			public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
				if (request.getMethod().equalsIgnoreCase("GET")) {
					return processForm(request, response);
				} else if (request.getMethod().equalsIgnoreCase("POST")) {
					return processSubmit(request, response);
				} else { 
					response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
					return null;
				}
			}
		
			

		private ActionForward processForm(HttpServletRequest request, HttpServletResponse response) {
			String path=request.getParameter("path");
			request.setAttribute("path", path);
			forward.setPath(FORM_VIEW);
			return forward;
		}
		
		private ActionForward processSubmit(HttpServletRequest request, HttpServletResponse response) throws Exception{
			
			Join_bean jobean = new Join_bean();
			jobean.setCUS_ID(request.getParameter("id"));
			jobean.setCUS_PWD(request.getParameter("password"));
			jobean.setCUS_NAME(request.getParameter("name"));
			jobean.setCUS_ADDR(request.getParameter("addr1")+"("+request.getParameter("addr2")+")|"+request.getParameter("addr4")+"("+request.getParameter("addr5")+")");
			jobean.setCUS_TEL(request.getParameter("tel"));
			jobean.setCUS_CONFIRMPASSWORD(request.getParameter("confirmPassword"));
			
			Map<String, Boolean> errors = new HashMap<>();
			request.setAttribute("errors", errors);
			
			jobean.validate(errors);
			
			if (!errors.isEmpty()) {
				response.setContentType("text/html; charset=UTF-8");
		         
		         PrintWriter out = response.getWriter();
		          
		         out.println("<script>alert('비밀번호가 일치하지 않습니다. 확인 후 다시 입력해주세요.'); location.href='Join.do';</script>");
		          
		         out.flush();
		         return null;
				
			}
			
			try { 
				
				if(!request.getParameter("path").equals("null")) {
					request.setAttribute("path", request.getParameter("path"));
				}
				joinService.join(jobean);
				forward.setPath("/joinSuccess.jsp");
				return forward;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}