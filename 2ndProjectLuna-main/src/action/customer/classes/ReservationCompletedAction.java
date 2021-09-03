package action.customer.classes;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import svc.customer.classes.ReservationCompletedService;
import vo.ActionForward;
import vo.ClassBean;
import vo.ReservationBean;
import vo.User;

public class ReservationCompletedAction implements Action {

	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception{ 

		HttpSession session = request.getSession(false);
		
		response.setContentType("text/html;charset=UTF-8");
		ReservationCompletedService reservationCompletedService = new ReservationCompletedService();
		User user = (User)session.getAttribute("authUser");

		String userId = null;

		if(user.getId()==null) {
			
		}else {
			 userId = user.getId();
		}

		int CL_ID=Integer.parseInt(request.getParameter("CL_ID"));
		ClassBean classInfoBean = reservationCompletedService.selectClassInfo(CL_ID);
		
		String CL_NAME=(String)(classInfoBean.getCL_NAME());
		String CL_WRITER_ID=(String)(classInfoBean.getCL_WRITER_ID());
		
		
		if (userId.equals(CL_WRITER_ID)) {
			PrintWriter script = response.getWriter();

			script.println("<script>alert('재능 생성자는 예약할 수 없습니다.'); location.href='classDetail.do?CL_ID="+CL_ID+"';</script>");

			script.flush();
			
		
			return null;
		}
		
		
		
		ArrayList<ReservationBean> RevCheckNumList = reservationCompletedService.resvCheckNum(userId);
		
		for(int i=0; i<RevCheckNumList.size(); i++) {
if(RevCheckNumList.get(i).getRESV_CL_NUM() == CL_ID) {
				
				PrintWriter script = response.getWriter();
				script.println("<script>alert('예약 이력이 존재합니다.'); location.href='classDetail.do?CL_ID="+CL_ID+"';</script>");

				script.flush();
			
			return null;
		}
	}
		
		
		ClassBean article = reservationCompletedService.getArticle(userId, CL_ID, CL_NAME, CL_WRITER_ID);
		ReservationBean reservationBean = reservationCompletedService.getArticle2(userId, CL_ID);
		ActionForward forward = new ActionForward();
		request.setAttribute("classInfoBean", classInfoBean);
		request.setAttribute("reservation", reservationBean);

		
		forward.setPath("view/customer/class/reservationCompleted.jsp");
		return forward;
		
	}

}