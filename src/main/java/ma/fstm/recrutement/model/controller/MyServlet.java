package ma.fstm.recrutement.model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.TypeContrat;
import ma.fstm.recrutement.model.dao.DaoOffreImpl;
import ma.fstm.recrutement.model.dao.DaoTypeContratImpl;
import ma.fstm.recrutement.model.dao.IDaoOffre;
import ma.fstm.recrutement.model.dao.IDaoTypeContrat;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet(name = "serv",urlPatterns = {"*.php"})
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDaoOffre dao;
	private IDaoTypeContrat daoType;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	dao=new DaoOffreImpl();
    	daoType=new DaoTypeContratImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if(path.equals("/index.php")) {
			Collection<Offre> offres=dao.getAll();
			request.setAttribute("offres", offres);
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else if(path.equals("/supprimer.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			dao.delete(id);
			request.getRequestDispatcher("index.php").forward(request, response);
		}
		else if(path.equals("/ajouter.php")){
			Collection<TypeContrat> types=daoType.getAll();
			request.setAttribute("types", types);
			request.getRequestDispatcher("ajouter.jsp").forward(request, response);
		}else if(path.equals("/modifier.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			Offre offre=dao.findById(id);
			Collection<TypeContrat> types=daoType.getAll();
			request.setAttribute("types", types);
			request.setAttribute("offre", offre);
			request.getRequestDispatcher("modifier.jsp").forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		if(path.equals("/ajouter.php") && request.getMethod().equalsIgnoreCase("post")) {
			Offre offre= new Offre();
			TypeContrat type=new TypeContrat();
			type.setIdType(Long.parseLong(request.getParameter("type")));
			offre.setDescription(request.getParameter("description"));
			offre.setTitle(request.getParameter("titre"));
			offre.setProfil(request.getParameter("profil"));
			offre.setDate(new Date());
			offre.setTypeContrat(type);
			dao.add(offre);
			response.sendRedirect("index.php");
		}else if(path.equals("/modifier.php") && request.getMethod().equalsIgnoreCase("post")) {
			Offre offre= new Offre();
			offre.setId(Long.parseLong(request.getParameter("id")));
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			offre.setDescription(request.getParameter("description"));
			offre.setTitle(request.getParameter("titre"));
			offre.setProfil(request.getParameter("profil"));
			try {
				offre.setDate(formatter.parse(request.getParameter("date")));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			TypeContrat type=new TypeContrat();
			type.setIdType(Long.parseLong(request.getParameter("type")));
			offre.setTypeContrat(type);
			dao.update(offre);
			response.sendRedirect("index.php");
		}
	}

}
