

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterServ")
public class RegisterServ extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get all the parameters
		String uname = request.getParameter("uname");
		String uemail = request.getParameter("uemail");
		String upassword = request.getParameter("upassword");
		String ucity = request.getParameter("ucity");
		
		//go to Model.java.
		Model model = new Model();
		//set the objects.
		model.setUname(uname);
		model.setUemail(uemail);
		model.setUpassword(upassword);
		model.setUcity(ucity);
		int row = model.registerInfo();
		
		//use session for attribute passing to  jsp.
		HttpSession session = request.getSession();
		//set attribute
		session.setAttribute("uname", uname);
		//if success or fail then send redirect.
		if(row > 0) {
			response.sendRedirect("Success.jsp");
		} else {
			response.sendRedirect("Failed.jsp");
		}
	}
}
