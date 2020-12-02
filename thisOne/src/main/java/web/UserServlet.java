package web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.SalePost;
import dao.UserDAO;
import dao.SalePostDAO;



@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private SalePostDAO salePostDAO;
	private HttpSession session = null;
	
	public void init() {
		userDAO = new UserDAO();
		salePostDAO = new SalePostDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/register":
				showRegisterForm(request, response);
				break;
			case "/userLogin":
				userLogin(request, response);
				break;
			case "/postSale":
				postArtSale(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateUser(request, response);
				break;
			case "/profile":
				showProfile(request, response);
				break;
			case "/listUsers":
				listUsers(request, response);
				break;
			case "/listSales":
				listSales(request, response);
					break;
			default:
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> listUser = userDAO.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
		dispatcher.forward(request, response);
	}

	private void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		session = request.getSession();
		session.setAttribute("currentUser", name);
		session.setAttribute("currentPassword", password);

		try {
			userDAO.userExists(name, password);
			//if(blackListDAO.isBanned(name))) {
			//    throw new ErrorException("You have been banned");
			//}
		}
		catch(SQLException e) {
			if(e.getErrorCode() == 1045) {
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("listSales");
		dispatcher.forward(request, response);
		System.out.println(session.getAttribute("currentUser"));
		System.out.println(session.getAttribute("currentPassword"));
	}

	private void listSales(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<SalePost> listSalePost = salePostDAO.selectAllSales();
		request.setAttribute("listSalePost", listSalePost);
		RequestDispatcher dispatcher = request.getRequestDispatcher("sales.jsp");
		dispatcher.forward(request, response);
	}

	private void showRegisterForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerForm.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		User existingUser = userDAO.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerForm.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}

	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		User newUser = new User(name, email, country, password);
		userDAO.insertUser(newUser);
		response.sendRedirect("listUsers");
	}

	private void postArtSale(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String user = request.getParameter("user");
		SalePost newSale = new SalePost(name, description, user);
		salePostDAO.insertSale(newSale);
		response.sendRedirect("listSales");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");

		User book = new User(id, name, email, country, password);
		userDAO.updateUser(book);
		response.sendRedirect("listUsers");
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("listUsers");
	}

	private void showProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");

		User book = new User(id, name, email, country, password);
		userDAO.updateUser(book);
		response.sendRedirect("listUsers");
	}
}
