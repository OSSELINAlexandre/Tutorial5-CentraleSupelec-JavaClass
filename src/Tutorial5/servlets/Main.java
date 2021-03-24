package Tutorial5.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Tutorial5.beans.Exercise2.Lauch;
import Tutorial5.beans.Exercise2.ThePath;

/**
 * Servlet implementation class Main
 */
@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Main() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, Integer> route =  new HashMap<>();
		Lauch lauch = new Lauch();
		route = lauch.loadingDB();
        HttpSession session = request.getSession();
        session.setAttribute("options", route);
        
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ThePath path =  new ThePath();
		Integer start = Integer.parseInt(request.getParameter("start"));
		Integer end = Integer.parseInt(request.getParameter("end"));	
		Lauch lauch = new Lauch();
		path = lauch.treatingRequest(start, end);
		request.setAttribute("route", path);
		this.getServletContext().getRequestDispatcher("/WEB-INF/Accueil.jsp").forward(request, response);
	}

}
