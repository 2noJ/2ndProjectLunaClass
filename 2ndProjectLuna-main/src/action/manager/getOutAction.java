package action.manager;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.CustomerDetailService;
import svc.manager.getOutService;
import vo.ActionForward;
import vo.Customer_bean;


public class getOutAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cusid= (String) request.getParameter("cusid");
		getOutService getoutService = new getOutService();
		boolean isClassING = getoutService.checkClassING(cusid);
		boolean isParticlpateING = getoutService.checkParticlpateING(cusid);
		CustomerDetailService customerDetailService=new CustomerDetailService();
		Customer_bean cusInfo = customerDetailService.getCusInfo(cusid);
		request.setAttribute("myInfo", cusInfo);
		request.setAttribute("isClassING", isClassING);
		request.setAttribute("isParticlpateING", isParticlpateING);

		
		if(isClassING==true||isParticlpateING==true) {
			response.setContentType("text/html; charset=UTF-8");
	         
	         PrintWriter out = response.getWriter();
	          
	         out.println("<script>alert('진행 중인 재능 나눔이 존재하거나 참여 중인 재능 수업이 있다면 탈퇴가 불가능 합니다!'); location.href='Customer_Detail.do?customer_id="+cusid+"';</script>");
	          
	         out.flush();
		}
		else {
			 boolean isDeleteSuccess = false;
		      isDeleteSuccess=getoutService.deletemember(cusid);
		      if (!isDeleteSuccess) {
		         response.setContentType("text/html;charset=UTF-8");
		         PrintWriter out = response.getWriter();
		         out.println("<script>");
		         out.println("alert('삭제 실패');");
		         out.println("history.back()");
		         out.println("</script>");
		      } else {
		    	  response.setContentType("text/html;charset=UTF-8");
			         PrintWriter out = response.getWriter();
			         out.println("<script>");
			         out.println("alert('삭제되었습니다!');");
			         out.println("history.back()");
			         out.println("</script>");
			         ActionForward forward = new ActionForward();
			 		forward.setPath("Customer_List.do");
			 		return forward;
		}
		
		

	}
		return null;
}
}
