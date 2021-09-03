package action.customer.classes;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.ClassListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;

public class ClassListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		int page = 1;
		int limit = 6;
		int listCount = 0;
		String CL_LOCATION = null;
		String CL_CATEGORY = null;
		if(request.getParameter("CL_LOCATION") != null) {
			CL_LOCATION = (String) request.getParameter("CL_LOCATION");
		}
		if(request.getParameter("CL_CATEGORY") != null) {			
			CL_CATEGORY = (String) request.getParameter("CL_CATEGORY");
		}
		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ClassListService classListService = new ClassListService();
		
		ArrayList<Integer> headCount = new ArrayList<Integer>();
		
		if(CL_LOCATION != null && CL_CATEGORY != null) {
			headCount = classListService.getHeadCount(CL_LOCATION, CL_CATEGORY, page, limit);
		} else if (CL_LOCATION != null) {
			headCount = classListService.getHeadCount(CL_LOCATION, page, limit);	
		} else if (CL_CATEGORY != null) {
			headCount = classListService.getHeadCount(page, limit, CL_CATEGORY);			
		} else {
			headCount = classListService.getHeadCount(page, limit);			
		}
		request.setAttribute("headCount",headCount);
		
		if(CL_LOCATION != null && CL_CATEGORY != null) {
			listCount = classListService.getClassListCount(CL_CATEGORY, CL_LOCATION);		
		} else if (CL_LOCATION != null) {
			listCount = classListService.getLocClassListCount(CL_LOCATION);
		} else if (CL_CATEGORY != null) {
			listCount = classListService.getClassListCount(CL_CATEGORY);
		} else {
			listCount = classListService.getClassListCount();	
		}
		
		if(CL_LOCATION != null && CL_CATEGORY != null) {
			classList = classListService.getClassList(CL_LOCATION, CL_CATEGORY, page, limit);
		} else if (CL_LOCATION != null) {
			classList = classListService.getClassList(CL_LOCATION,page, limit);
		} else if (CL_CATEGORY != null) {
			classList = classListService.getClassList(page, limit, CL_CATEGORY);
		} else {
			classList = classListService.getClassList(page, limit);
		}
		
		int maxPage = (int) ((double) listCount/limit + 0.9);
		int startPage = (((int) ((double) page / 5 + 0.8)) - 1) * 5 + 1;
		int endPage = startPage + 5 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		PageInfo pageInfo = new PageInfo();
		pageInfo.setEndPage(endPage);
		pageInfo.setListCount(listCount);
		pageInfo.setMaxPage(maxPage);
		pageInfo.setPage(page);
		pageInfo.setStartPage(startPage);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("classList", classList);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/customer/class/classList.jsp");
		return forward;
	}
}
