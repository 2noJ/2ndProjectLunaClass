package action.customer.classes;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.SearchClassListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;

 public class SearchClassListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		
	
		 ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
			int page = 1;
			int limit = 6;
			String CL_NAME = null;
			String CL_LOCATION = null;
			if(request.getParameter("CL_NAME") != null) {
				CL_NAME = (String) request.getParameter("CL_NAME");				
			}
			if(request.getParameter("CL_LOCATION") != null) {
				CL_LOCATION = (String) request.getParameter("CL_LOCATION");				
			}
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			SearchClassListService searchClassListService = new SearchClassListService();
			
			
			
			ArrayList<Integer> headCount = new ArrayList<Integer>();
			if(CL_LOCATION != null) {
				headCount = searchClassListService.getHeadCount(CL_NAME, CL_LOCATION, page, limit);
			} else {
				headCount = searchClassListService.getHeadCount(CL_NAME, page, limit);
			}

			request.setAttribute("headCount",headCount);
			
			
			int listCount = 0;
			
			if(CL_LOCATION != null) {
				listCount = searchClassListService.getSearchClassListCount(CL_NAME,CL_LOCATION);
			} else {
				listCount = searchClassListService.getSearchClassListCount(CL_NAME);
			}
			
			if(CL_LOCATION != null) {
				classList = searchClassListService.getSearchClassList(CL_NAME, CL_LOCATION, page, limit);
			} else {
				classList = searchClassListService.getSearchClassList(CL_NAME, page, limit);
			}
			
			
			int maxPage = (int) ((double) listCount / limit + 0.9);
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
			request.setAttribute("CL_NAME", CL_NAME);
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("classList", classList);
			ActionForward forward = new ActionForward();
			
			forward.setPath("/view/customer/class/classList.jsp");
			return forward;
			

   	
	 }
	 
}