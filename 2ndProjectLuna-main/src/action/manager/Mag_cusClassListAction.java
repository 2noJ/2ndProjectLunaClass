package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.Mag_cusClassListService;
import vo.ActionForward;
import vo.ClassBean;
import vo.PageInfo;

public class Mag_cusClassListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String cusid = (String) request.getParameter("cusid");
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		int page = 1;
		int limit = 6;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}

		Mag_cusClassListService mag_cusclassListService = new Mag_cusClassListService();
		
		int listCount = mag_cusclassListService.getClassListCount(cusid);
		classList = mag_cusclassListService.getClassList(page, limit,cusid);
		
		
		
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
		request.setAttribute("cusid", cusid);
		ActionForward forward = new ActionForward();
		forward.setPath("/view/manager/Mag_cusClassList.jsp");
		return forward;
	}
}
