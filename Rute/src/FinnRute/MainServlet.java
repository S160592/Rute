package FinnRute;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/index.html")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = this.getServletContext().getRealPath("/WEB-INF/routes.csv");

		request.setAttribute("nodes", PathFinder.hentLokasjonar(path));

		request.getRequestDispatcher("WEB-INF/jsp/route.jsp").forward(request, response);
		request.getSession().setAttribute("output", "");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String path = this.getServletContext().getRealPath("/WEB-INF/routes.csv");
		request.getSession().setAttribute("output",
				PathFinder.fromTo(request.getParameter("from"), request.getParameter("to"), path));
		;
		
		response.sendRedirect("index.html");
	//	doGet(request, response);
	}

}
