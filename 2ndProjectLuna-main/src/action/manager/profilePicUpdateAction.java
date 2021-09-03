package action.manager;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import action.Action;
import svc.manager.ProfilePicUpdateService;
import vo.ActionForward;

public class profilePicUpdateAction implements Action {
	private ProfilePicUpdateService profilePicUpdateService = new ProfilePicUpdateService();

	ActionForward forward = new ActionForward();

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			return processForm(request, response);
		} else if (request.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(request, response);
		} else {
			response.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private ActionForward processForm(HttpServletRequest req, HttpServletResponse res) {
		forward.setPath("myPage.jsp");
		return forward;
	}

	private ActionForward processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String userId = req.getParameter("CUS_ID");
		boolean isProfileChanged = false;
		String realFolder = null;
		String saveFolder = null;
		MultipartRequest multi = null;
		int fileSize = 0;
		
		String filename = profilePicUpdateService.deleteProfilePic(userId);		

		if(filename !=null) {
		String uploadFileName = req.getRealPath("upload/profile")+"/"+ filename;
		
		File uploadfile = new File (uploadFileName);
        if ( uploadfile.exists()&& uploadfile.isFile() )
        {
             uploadfile.delete();      
        }}
		realFolder = req.getSession().getServletContext().getRealPath("upload/profile");
		saveFolder = "/upload/profile";
		fileSize = 5 * 1024 * 1024;
		ServletContext context = req.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		multi = new MultipartRequest(req, realFolder, fileSize, "UTF-8", new MyFileRenamePolicy( (String)req.getParameter("CUS_ID")));
		isProfileChanged = profilePicUpdateService.changeProfilePic(userId, multi);
		if (!isProfileChanged) {
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('사진 업로드 실패');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("Customer_Detail.do?customer_id="+userId+"&page="+req.getParameter("page"));
		}
		
		

		return forward;
	}
}

class MyFileRenamePolicy implements FileRenamePolicy {
	private String cusID;
	
	
	public MyFileRenamePolicy(String cusID) {
		this.cusID =cusID;
	}
	
	public File rename(File f) {
		String uniqueFileName = cusID;

		String name = f.getName();
		String body = null;
		String ext = null;

		int dot = name.lastIndexOf(".");
		if (dot != -1) {
			body = name.substring(0, dot);
			ext = name.substring(dot);
		} else {
			body = name;
			ext = "";
		}

		String tempName = uniqueFileName + ext;
		f = new File(f.getParent(), tempName);
		if (createNewFile(f)) {
			return f;
		}
		
			String newName = uniqueFileName + ext;
			f = new File(f.getParent(), newName);
		

		return f;
	}

	private boolean createNewFile(File f) {
		try {
			return f.createNewFile();
		} catch (IOException ignored) {
		}
		return false;
	}

}