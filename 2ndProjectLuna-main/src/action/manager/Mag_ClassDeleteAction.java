package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import action.Action;
import svc.manager.MagClassDeleteService;
import vo.ActionForward;


public class Mag_ClassDeleteAction implements Action{
   
   private static final String FORM_VIEW = "mag_classList.do";
   private MagClassDeleteService magClassDeleteService = new MagClassDeleteService();
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
    
      int cl_id = Integer.parseInt(trim(req.getParameter("cl_id")));


    
      
      Map<String, Boolean> errors = new HashMap<>();
      req.setAttribute("errors", errors);
    
      
      try {
    	  magClassDeleteService.deleteClass(cl_id);
    	  if(req.getParameter("path")==null) {
    
    		  forward.setPath("mag_classList.do");
    		  return forward;
 	        	 }else {
 	        	
 	        		 String cusid=(String)req.getParameter("cusid");
 	        		req.setAttribute("cusid", cusid);
 	        		forward.setPath(req.getParameter("path"));
 	        		return forward;
 	        	 }

      } catch (Exception e) {
         
         forward.setPath(FORM_VIEW);
     	return forward;
      }
      
   }
   
   private String trim(String str) {
      return str == null ? null : str.trim();
   }
}