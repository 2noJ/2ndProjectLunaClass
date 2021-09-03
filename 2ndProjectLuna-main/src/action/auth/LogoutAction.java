package action.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import vo.ActionForward;


public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		 HttpSession session = req.getSession(false);
         if (session != null) {
            session.invalidate();
         }
         res.sendRedirect(req.getContextPath() + "/index.do");
         return null;
	}
 
	   }