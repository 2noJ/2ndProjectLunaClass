package action.manager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.MagNoticeDeleteService;
import vo.ActionForward;

public class MagNoticeDeleteAction implements Action {
	
private static final String FORM_VIEW = "MagNoticeList.do";
   private MagNoticeDeleteService magNoticeDeleteService = new MagNoticeDeleteService();
   ActionForward forward = new ActionForward();

   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
	   if (request.getMethod().equalsIgnoreCase("GET")) {
         return processSubmit(request, response);
      } else if (request.getMethod().equalsIgnoreCase("POST")) {
         return processSubmit(request, response);
      } else {
         response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
         return null;
      }
   }

   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
      int notice_id = Integer.parseInt(req.getParameter("notice_id"));

      try {
    	  magNoticeDeleteService.deleteNotice(notice_id);
         forward.setPath("MagNoticeList.do");
         
         return forward;
      } catch (Exception e) {
         
         forward.setPath(FORM_VIEW);
     	return forward;
      }
   }
   
}