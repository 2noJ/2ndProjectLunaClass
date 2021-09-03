package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.PassUpdateService;
import vo.ActionForward;

public class PassUpdateAction implements Action {

	private static final String FORM_VIEW = "Customer_Detail.do";
	   private PassUpdateService passUpdateService = new PassUpdateService();
	   ActionForward forward = new ActionForward();

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

	   private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
			
			forward.setPath(FORM_VIEW);
			return forward;
		     
		   }
	   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		  String CUS_PWD = req.getParameter("newPass");
		  String CUS_ID = req.getParameter("customer_id");

	      try {
	    	  passUpdateService.passUpdate(CUS_PWD, CUS_ID);
	    	 
	         forward.setPath("Customer_Detail.do");
	         
	         return forward;
	      } catch (Exception e) {
	         
	         forward.setPath(FORM_VIEW);
	     	return forward;
	      }
	   }
	   
	}
