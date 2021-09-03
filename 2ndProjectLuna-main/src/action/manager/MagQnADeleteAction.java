package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.MagQnADeleteService;
import vo.ActionForward;


public class MagQnADeleteAction implements Action{
   
   private static final String FORM_VIEW = "MagQnAlist.do";
   private MagQnADeleteService magQnADeleteService = new MagQnADeleteService();
   ActionForward forward = new ActionForward();
  
   
   
   

   @Override
public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
	   
	  
	      if (req.getMethod().equalsIgnoreCase("GET")) {
		         return processSubmit(req, res);
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
    
      int qa_id = Integer.parseInt(trim(req.getParameter("qa_id")));
     
      String nowPage = req.getParameter("page");
    
     
    
    
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
      
      
      try {
    	  magQnADeleteService.deleteA(qa_id);
         forward.setPath("MagQnAlist.do?page=" + nowPage);
         
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