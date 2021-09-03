package action.manager;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.SearchCustomerListService;
import vo.ActionForward;
import vo.Customer_bean;
import vo.PageInfo;

 public class SearchCustomerListAction implements Action {
	 
	 public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 
		
	
		 ArrayList<Customer_bean> customerList = new ArrayList<Customer_bean>();
			int page = 1;
			int limit = 5;
			String search= (String)request.getParameter("search");
			
			String content = (String) request.getParameter("content");
		
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
			}

			SearchCustomerListService searchCustomerListService = new SearchCustomerListService();
			
			
			int listCount = searchCustomerListService.getSearchCustomerListCount(content,search);
	
			
			customerList = searchCustomerListService.getSearchCustomerList(content,search, page, limit);
			
			
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
			request.setAttribute("pageInfo", pageInfo);
			request.setAttribute("customerList", customerList);
			request.setAttribute("search", search);
			request.setAttribute("content", content);
			
			ActionForward forward = new ActionForward();
			if(search.equals("전체")) {
				forward.setPath("/Customer_List.do");
			}else if(search.equals("아이디")){
				forward.setPath("/IdCustomer_List.jsp");
			}else if(search.equals("이름")){
				forward.setPath("NameCustomer_List.jsp");
			}else if(search.equals("전화번호")){
				forward.setPath("/TelCustomer_List.jsp");
			}
			return forward;
			

   	
	 }
	 
}