package login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import login.model.User;
import login.service.UserService;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet("/EditProfileAction")
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String)request.getSession().getAttribute("username");
		RequestDispatcher rd = null;
		if(username == null) {
			rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("error", "Unauthoriced User");
		}else {
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setName(request.getParameter("name"));
			user.setAge(Integer.parseInt(request.getParameter("age")));
			user.setPassword(request.getParameter("password"));
			user.setSalary(Integer.parseInt(request.getParameter("salary")));
			UserService userService = new UserService();
			userService.editUser(user);
			rd = request.getRequestDispatcher("profile.jsp");
			request.getSession().setAttribute("user", user);
			request.setAttribute("message", "Recored updated");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
