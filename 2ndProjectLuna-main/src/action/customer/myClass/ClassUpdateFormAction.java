package action.customer.myClass;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myClass.ClassUpdateFormService;
import vo.ActionForward;
import vo.ClassBean;

public class ClassUpdateFormAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String CL_IDS = request.getParameter("CL_ID");
		int CL_ID = Integer.parseInt(CL_IDS);	
		ClassUpdateFormService classUpdateFormService = new ClassUpdateFormService();		
		ClassBean updateClass = classUpdateFormService.getClass(CL_ID);
		request.setAttribute("updateClass", updateClass);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/myClass/myClassUpdate.jsp");
		return forward;

	}
}