package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.CustomerClassListService;
import svc.manager.CustomerDetailService;
import svc.manager.CustomerParticipateListEndService;
import svc.manager.CustomerParticipateListService;
import vo.ActionForward;
import vo.Customer_bean;

public class CustomerDetailAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String customer_id = request.getParameter("customer_id");
		String page=request.getParameter("page");
		
		
		CustomerDetailService customerDetailService=new CustomerDetailService();
		Customer_bean cusInfo = customerDetailService.getCusInfo(customer_id);
		
		
		CustomerClassListService customerClassListService = new CustomerClassListService();
		int listCount = customerClassListService.getClassListCount(customer_id);
		
		CustomerParticipateListService cusParticipateListService = new CustomerParticipateListService();
		int partcipateCount = cusParticipateListService.getParticipateListCount(customer_id);
		
		
		CustomerParticipateListEndService customerParticipateEndListService = new CustomerParticipateListEndService();
		int partcipateEndCount = customerParticipateEndListService.getParticipateListCount(customer_id);
		
		
		request.setAttribute("cusInfo", cusInfo);
		request.setAttribute("myClass", listCount);
		request.setAttribute("partcipateCount", partcipateCount);
		request.setAttribute("partcipateEndCount", partcipateEndCount);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_CustomerDetail.jsp");
		return forward;

	}
}