package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.MagNoticeInsertService;
import vo.ActionForward;

public class MagNoticeInsertAction implements Action{
	 
	   private static final String FORM_VIEW = "MagNoticeList.do";
	   private MagNoticeInsertService magNoticeInsertService = new MagNoticeInsertService();
	   ActionForward forward = new ActionForward();
	  
	   
	   public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		   
		      if (req.getMethod().equalsIgnoreCase("GET")) {
			         return processForm(req, res);
			      } else if (req.getMethod().equalsIgnoreCase("POST")) {
			         return processSubmit(req, res);
			      } else { 
			         res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			      return null;
			   }

	}


	private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
		
		forward.setPath(FORM_VIEW);
		return forward;
	     
	   }
	   
	   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	      String notice_title= trim(req.getParameter("notice_title"));
	      String notice_content = trim(req.getParameter("notice_content"));
	     
	    
	    
	      
	      Map<String, Boolean> errors = new HashMap<>();
	      req.setAttribute("errors", errors);
	      
	      
	      try {
	    	  magNoticeInsertService.insertNotice(notice_title, notice_content);
	    	  forward = new ActionForward();
				forward.setRedirect(true);
	    	  forward.setPath("MagNoticeList.do");
	         
	         return forward;
	      } catch (Exception e) {
	         
	         forward.setPath(FORM_VIEW);
	     	return forward;
	      }
	   }
	   
	   private String trim(String str) {
	      return str == null ? null : str.trim();
	   }
	}