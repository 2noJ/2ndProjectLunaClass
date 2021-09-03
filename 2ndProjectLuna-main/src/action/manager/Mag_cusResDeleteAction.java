package action.manager;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import svc.manager.Mag_cusResDeleteService;
import vo.ActionForward;

public class Mag_cusResDeleteAction implements Action {

	private static final String FORM_VIEW = "mag_cusRes_List.do";
	   private Mag_cusResDeleteService mag_cusResDeleteService = new Mag_cusResDeleteService();
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

	   private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
	    
		  String cusres_id = req.getParameter("cusres_id");
	      int cusres_num = Integer.parseInt(trim(req.getParameter("cusres_num")));

	     
	     
	    
	    
	      
	      Map<String, Boolean> errors = new HashMap<>();
	      req.setAttribute("errors", errors);
	    

	      
	      try {
	    	  mag_cusResDeleteService.cusResDelete(cusres_id, cusres_num);
	    	  if(req.getParameter("path")==null) {
		        	 
	    		  forward.setPath("mag_cusRes_List.do");
	    		  return forward;
	 	        	 }else {
	 	        		
	 	        		req.setAttribute("cusid", cusres_id);
	 	        		forward.setPath(req.getParameter("path")+"?cusid="+cusres_id);
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
