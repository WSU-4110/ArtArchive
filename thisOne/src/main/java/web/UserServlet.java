package web;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import dao.DirectoryDAO;
import dao.QuestionboardDAO;
import model.Directory;
import model.Questionboard;
import model.User;
import model.SalePost;
import dao.UserDAO;
import dao.SalePostDAO;



@WebServlet("/")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO;
	private SalePostDAO salePostDAO;
	private DirectoryDAO directoryDAO;
	private HttpSession session = null;
	private QuestionboardDAO questionDAO;
	
	public void init() {
		userDAO = new UserDAO();
		salePostDAO = new SalePostDAO();
		directoryDAO = new DirectoryDAO();
		questionDAO = new QuestionboardDAO();
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
			case "/postDirectory":
				postDirectory(request, response);
				break;
			case "/insert":
				insertUser(request, response);
				break;
			case "/delete":
				deleteUser(request, response);
				break;
		//	case "/edit":
				//showEditForm(request, response);
		//		break;
			case "/update":
				updateUser(request, response);
				break;
			case "/tutor":
				showTutors(request, response);
				break;
			case "/listUsers":
				listUsers(request, response);
				break;
			case "/listSales":
				listSales(request, response);
				break;
			case "/listDirectories":
				listDirectories(request, response);
				break;
			case "/questionboard":
				showQuestionForm(request, response);
				break;

			case "/profile":
				showProfile(request, response);
				break;
			case "/aaDirectories":
				showAADirectory(request, response);
				break;
			case "/ttDirectory":
				showTTDirectory(request, response);
				break;
			case "/refDirectory":
				showRefDirectory(request, response);
				break;
			case "/contact":
				showContact(request, response);
				break;

				case "/insertquestion":
					insertquestion(request,response);
					break;
				case "/listquestions":
					listquestions(request, response);
					break;
				case "/deletequestion":
					deletequestion(request,response);
					break;
				case "/editquestion":
					editQuestion(request,response);

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
	private void listquestions(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Questionboard> listquestions = questionDAO.selectAllData();
		request.setAttribute("listquestions", listquestions);
		RequestDispatcher dispatcher = request.getRequestDispatcher("questionboard.jsp");
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

	private void listDirectories(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Directory> listDirectory = directoryDAO.selectAllDirectories();
		request.setAttribute("listDirectory", listDirectory);
		RequestDispatcher dispatcher = request.getRequestDispatcher("directory.jsp");
		dispatcher.forward(request, response);
	}

	private void showTutors(HttpServletRequest request, HttpServletResponse response)
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

	private void showQuestionForm (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("questionBoard.jsp");
		dispatcher.forward(request,response);
	}

/*	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//User existingUser = userDAO.selectUser((String)session.getAttribute("currentUser"));
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerForm.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);
	}
*/
	private void insertUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String description = request.getParameter("description");
		String favoriteColor = request.getParameter("favoriteColor");
		User newUser = new User(name, email, country, password, firstName, lastName, description, favoriteColor);
		userDAO.insertUser(newUser);
		response.sendRedirect("listUsers");
	}
	private void insertquestion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String name = request.getParameter("topic_author");
		String topic_title = request.getParameter("topic_title");
		String topicquestion = request.getParameter("topicquestion");
		Questionboard question = new Questionboard(name, topic_title,topicquestion);
		questionDAO.insertQuestions(question);
		response.sendRedirect("questionboard");
	}

	private void postArtSale(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String user = (String)session.getAttribute("currentUser");
		String file = request.getParameter("file");
		SalePost newSale = new SalePost(name, description, user, file);
		salePostDAO.insertSale(newSale);
		response.sendRedirect("listSales");
	}

	private void postDirectory(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String user = (String)session.getAttribute("currentUser");
		String link = request.getParameter("link");
		Directory directory = new Directory(title, description, user, link);
		directoryDAO.insertDirectory(directory);
		response.sendRedirect("listDirectories");
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String description = request.getParameter("description");
		String favoriteColor = request.getParameter("favoriteColor");
		User book = new User(id, name, email, country, password, firstName, lastName, description, favoriteColor);
		userDAO.updateUser(book);
		response.sendRedirect("listUsers");
	}
	private void editQuestion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int topic_id = Integer.parseInt(request.getParameter("topic_id"));
		String topic_author = request.getParameter("topic_author");
		String topic_title = request.getParameter("topic_title");
		String topicquestion = request.getParameter("topicquestion");
		Questionboard question2 = new Questionboard(topic_id,topic_author,topic_title,topicquestion);
		questionDAO.editquestion(question2);
		response.sendRedirect("listquestions");
	}
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) 
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		userDAO.deleteUser(id);
		response.sendRedirect("listUsers");
	}
	private void deletequestion(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		questionDAO.deletequestion(id);
		response.sendRedirect("listquestions");
	}

	private void showProfile(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = (String)session.getAttribute("currentUser");
		List<User> listProfileUser = userDAO.selectUser(name);
		request.setAttribute("listProfileUser", listProfileUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profilepage.jsp");

		dispatcher.forward(request, response);
	}

	private void listProfileUser(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		String name = (String)session.getAttribute("currentUser");
		List<User> listProfileUser = userDAO.selectUser(name);
		request.setAttribute("listProfileUser", listProfileUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("profilepage.jsp");
		dispatcher.forward(request, response);
	}

	private void showAADirectory (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("directories.jsp");
		dispatcher.forward(request,response);
	}

	private void showTTDirectory (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("ttDirectory.jsp");
		dispatcher.forward(request,response);
	}

	private void showRefDirectory (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("refDirectory.jsp");
		dispatcher.forward(request,response);
	}

	private void showContact (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		RequestDispatcher dispatcher = request.getRequestDispatcher("contact.jsp");
		dispatcher.forward(request,response);
	}
}
