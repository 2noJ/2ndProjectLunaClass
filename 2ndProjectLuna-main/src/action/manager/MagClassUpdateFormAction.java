package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.myClass.ClassUpdateFormService;
import vo.ActionForward;
import vo.ClassBean;

public class MagClassUpdateFormAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String CL_IDS = request.getParameter("CL_ID");
		String page=request.getParameter("page");
		int CL_ID = Integer.parseInt(CL_IDS);	
		ClassUpdateFormService classUpdateFormService = new ClassUpdateFormService();		
		ClassBean updateClass = classUpdateFormService.getClass(CL_ID);
		request.setAttribute("updateClass", updateClass);
		request.setAttribute("page", page);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_cusClassUpdate.jsp");
		return forward;

	}
}