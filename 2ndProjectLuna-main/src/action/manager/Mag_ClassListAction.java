package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.customer.classes.ClassListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;

public class Mag_ClassListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//User authUser = (User) request.getSession().getAttribute("authUser");
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		int page = 1;
		int limit = 6;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		ClassListService classListService = new ClassListService();
		
		int listCount = classListService.getClassListCount();
		classList = classListService.getClassList(page, limit);
		
		
		
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
		forward.setPath("/view/manager/Mag_ClassList.jsp");
		return forward;
	}
}
