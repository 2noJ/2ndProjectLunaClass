package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.IndexAction;
import action.auth.IdCheckAction;
import action.auth.JoinAction;
import action.auth.LoginAction;
import action.auth.LogoutAction;
import action.auth.Mag_LoginAction;
import action.customer.classes.ClassDetailAction;
import action.customer.classes.ClassListAction;
import action.customer.classes.Cus_commentAction;
import action.customer.classes.Cus_deletecommentAction;
import action.customer.classes.Cus_deleterecommentAction;
import action.customer.classes.Cus_recommentAction;
import action.customer.classes.Cus_updateRecommentAction;
import action.customer.classes.Cus_updatecommentAction;
import action.customer.classes.JjimCancelDetailAction;
import action.customer.classes.JjimDetailAction;
import action.customer.classes.ReservationCompletedAction;
import action.customer.classes.SearchClassListAction;
import action.customer.cusService.FnQViewAction;
import action.customer.cusService.NoticeListAction;
import action.customer.cusService.QnAInsertAction;
import action.customer.cusService.QnAListAction;
import action.customer.myClass.ClassUpdateAction;
import action.customer.myClass.ClassUpdateFormAction;
import action.customer.myClass.ClassWriteProAction;
import action.customer.myClass.MyClassListAction;
import action.customer.myClass.MyClassListEndAction;
import action.customer.myClass.MyClassListINGAction;
import action.customer.myPage.ChangeInfoAction;
import action.customer.myPage.ChangePasswordAction;
import action.customer.myPage.ChangeProfileAction;
import action.customer.myPage.DeleteUserAction;
import action.customer.myPage.JJIMAction;
import action.customer.myPage.LeaveAction;
import action.customer.myPage.MyPageAction;
import action.customer.myPage.MyParticipateListAction;
import action.customer.myPage.MyParticipateListEndAction;
import action.customer.myPage.RecentlyViewedAction;
import action.customer.myPage.ReservCancelAction;
import action.manager.AddrUpdateAction;
import action.manager.CommentListAction;
import action.manager.CustomerDetailAction;
import action.manager.CustomerListAction2;
import action.manager.FnQDeleteAction;
import action.manager.FnQInsertAction;
import action.manager.FnQListAction;
import action.manager.FnQModifyAction;
import action.manager.MQnADeleteAction;
import action.manager.MagClassUpdateAction;
import action.manager.MagClassUpdateFormAction;
import action.manager.MagNoticeContentAction;
import action.manager.MagNoticeDeleteAction;
import action.manager.MagNoticeInsertAction;
import action.manager.MagNoticeListAction;
import action.manager.MagNoticeUpdateAction;
import action.manager.MagQnADeleteAction;
import action.manager.MagQnAInsertAction;
import action.manager.MagQnAListAction;
import action.manager.Mag_ClassDeleteAction;
import action.manager.Mag_ClassDetailAction;
import action.manager.Mag_ClassListAction;
import action.manager.Mag_CusresListAction;
import action.manager.Mag_cusClassListAction;
import action.manager.Mag_cusResDeleteAction;
import action.manager.Mag_cusReservationListAction;
import action.manager.NameUpdateAction;
import action.manager.NoticeContentAction;
import action.manager.PassUpdateAction;
import action.manager.SearchCustomerListAction;
import action.manager.TelUpdateAction;
import action.manager.deletecommentAction;
import action.manager.deleterecommentAction;
import action.manager.getOutAction;
import action.manager.profilePicUpdateAction;
import vo.ActionForward;

@WebServlet("*.do")
public class LunaFrontController extends HttpServlet {
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		ActionForward forward = null;
		Action action = null;

		if (command.equals("/index.do")) {
			action = new IndexAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/classWriteForm.do")) {
			forward = new ActionForward();
			forward.setPath("/view/customer/myClass/myClassWrite.jsp");
		} else if (command.equals("/MagLogin.do")) {
			forward = new ActionForward();
			forward.setPath("/MagLogin.jsp");
		}else if (command.equals("/Cus_QnAForm.do")) {
			forward = new ActionForward();
			forward.setPath("/view/customer/cusService/Cus_QnAForm.jsp");
		} else if (command.equals("/Cus_Guide.do")) {
			forward = new ActionForward();
			forward.setPath("/view/customer/cusService/Cus_Guide.jsp");
		} else if (command.equals("/Mag_Notice_Writer.do")) {
			forward = new ActionForward();
			forward.setPath("/view/manager/Mag_Notice_Writer.jsp");
		} else if (command.equals("/Mag_FnQForm.do")) {
			forward = new ActionForward();
			forward.setPath("/view/manager/Mag_FnQForm.jsp");
		} else if (command.equals("/Cus_Location.do")) {
			forward = new ActionForward();
			forward.setPath("/view/customer/cusService/Cus_Map.jsp");
		} else if (command.equals("/classList.do")) {
			action = new ClassListAction();
			 if(request.getParameter("CL_NAME") != null) {
		            action = new SearchClassListAction();
		         }
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/leave.do")) {
			action = new LeaveAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/classWritePro.do")) {
			action = new ClassWriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myClassList.do")) {
			action = new MyClassListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myClassListING.do")) {
			action = new MyClassListINGAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myClassListEnd.do")) {
			action = new MyClassListEndAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/login.do")) {
			action = new LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/logout.do")) {
			action = new LogoutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myPage.do")) {
			action = new MyPageAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/passChange.do")) {
			action = new ChangePasswordAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/userDelete.do")) {
			action = new DeleteUserAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/addrChange.do")) {
			action = new ChangeInfoAction();
			try {
				request.setAttribute("col", "CUS_ADDR");
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/telChange.do")) {
			action = new ChangeInfoAction();
			try {
				request.setAttribute("col", "CUS_TEL");
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/nameChange.do")) {
			action = new ChangeInfoAction();
			try {
				request.setAttribute("col", "CUS_NAME");
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/profilePicChange.do")) {
			action = new ChangeProfileAction();
			try {
				request.setAttribute("col", "CUS_PROFILE_PATH");
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myParticipateList.do")) {
			action = new MyParticipateListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/myParticipateListEnd.do")) {
			action = new MyParticipateListEndAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/recentlyViewed.do")) {
			action = new RecentlyViewedAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/JJIMList.do")) {
			action = new JJIMAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/reservCancel.do")) {
			action = new ReservCancelAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/classDetail.do")) {
			action = new ClassDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/reservationCompleted.do")) {
			action = new ReservationCompletedAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/jjimDetail.do")) {
			action = new JjimDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/jjimCancelDetail.do")) {
			action = new JjimCancelDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Join.do")) {
			action = new JoinAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/QnAlist.do")) {
			action = new QnAListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/MagQnAlist.do")) {
			action = new MagQnAListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/mag_QA_Insert.do")) {
			action = new MagQnAInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/QnAInsert.do")) {
			action = new QnAInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/FnQList.do")) {
			action = new FnQListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/FnQInsert.do")) {
			action = new FnQInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/FnQModify.do")) {
			action = new FnQModifyAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/FnQDelete.do")) {
			action = new FnQDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/mag_QA_delete.do")) {
			action = new MagQnADeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/m_QA_delete.do")) {
			action = new MQnADeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/FnQShow.do")) {
			action = new FnQViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/MagNoticeList.do")) {
			action = new MagNoticeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/MagNoticeContent.do")) {
			action = new MagNoticeContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/MagNoticeInsert.do")) {
			action = new MagNoticeInsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/Notice_List.do")) {
			action = new NoticeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/Customer_Detail.do")) {
			action = new CustomerDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/Customer_List.do")) {
			action = new CustomerListAction2();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/searchCustomerList.do")) {
			action = new SearchCustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/IdCustomerList.do")) {
			action = new SearchCustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/NameCustomerList.do")) {
			action = new SearchCustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/TelCustomerList.do")) {
			action = new SearchCustomerListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/Notice_Content.do")) {
			action = new NoticeContentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/passUpdate.do")) {
			action = new PassUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/nameUpdate.do")) {
			action = new NameUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/addrUpdate.do")) {
			action = new AddrUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/telUpdate.do")) {
			action = new TelUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/profilePicUpdate.do")) {
			action = new profilePicUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else if (command.equals("/delte.do")) {
			action = new Cus_deletecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updatecomment.do")) {
			action = new Cus_updatecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/recomment.do")) {
			action = new Cus_recommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/deleterecomment.do")) {
			action = new Cus_deleterecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/updateRecomment.do")) {
			action = new Cus_updateRecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/commentList.do")) {
			action = new CommentListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/mag_classList.do")) {
			action = new Mag_ClassListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mag_classDetail.do")) {
			action = new Mag_ClassDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/mag_class_delete.do")) {
			action = new Mag_ClassDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/mag_cusRes_List.do")) {
			action = new Mag_CusresListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (command.equals("/mag_CusResDelete.do")) {
			action = new Mag_cusResDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MagNoticeUpdate.do")) {
			action = new MagNoticeUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/MagNoticeDelete.do")) {
			action = new MagNoticeDeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/getout.do")) {
			action = new getOutAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mag_cusClassList.do")) {
			action = new Mag_cusClassListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mag_cusReservationList.do")) {
			action = new Mag_cusReservationListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/classUpdateForm.do")) {
			action = new ClassUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/classUpdate.do")) {
			action = new ClassUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/mag_deletecomment.do")) {
			action = new deletecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/mag_deleterecomment.do")) {
			action = new deleterecommentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mag_Login.do")) {
			action = new Mag_LoginAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Mag_classUpdateForm.do")) {
			action = new MagClassUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("/Mag_classUpdate.do")) {
			action = new MagClassUpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/Cus_comment.do")) {
			action = new Cus_commentAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/IdCheckAction.do")) {
			action = new IdCheckAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
		
		
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
