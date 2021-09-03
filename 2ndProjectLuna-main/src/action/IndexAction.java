package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.IndexService;
import vo.ActionForward;
import vo.ClassBean;
import vo.Notice_bean;

public class IndexAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ArrayList<Notice_bean> noticeList = new ArrayList<Notice_bean>();
		ArrayList<ClassBean> classList = new ArrayList<ClassBean>();
		IndexService idexService = new IndexService();
		
		int classN = idexService.countClass();
		int customerN = idexService.countCustomer();
		int classINGN = idexService.countClassING();
		noticeList = idexService.getNotice();
		classList = idexService.getclassList();
		
		request.setAttribute("classN", classN);
		request.setAttribute("customerN", customerN);
		request.setAttribute("classINGN", classINGN);
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("classList", classList);
		
		
		ActionForward forward = new ActionForward();
		
		
		forward.setPath("/index.jsp");
		return forward;

	}
}
