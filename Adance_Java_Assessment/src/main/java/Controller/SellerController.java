package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.SellerDao;
import Model.Seller;

/**
 * Servlet implementation class SellerController
 */
@WebServlet("/SellerController")
public class SellerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SellerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("Log in")) {
			Seller s = new Seller();
			s.setEmail(request.getParameter("email"));
			String email = request.getParameter("email");
			s.setPassword(request.getParameter("password"));
			boolean flag = SellerDao.checkEmail(email);
			if (flag == true) {
				Seller s1 = SellerDao.loginSeller(s);
				if (s1 != null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", s1);
					request.getRequestDispatcher("home.jsp").forward(request, response);
				}
				else {
					request.setAttribute("incorrect", "password is incorrect.");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				}
			}
			else {
				request.setAttribute("msg1", "account is not registed");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		}
	}


