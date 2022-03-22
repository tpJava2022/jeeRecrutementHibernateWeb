package ma.fstm.recrutement.model.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.SendResult;
import ma.fstm.recrutement.model.bo.Offre;
import ma.fstm.recrutement.model.bo.Recruteur;
import ma.fstm.recrutement.model.bo.TypeContrat;
import ma.fstm.recrutement.model.dao.DaoOffreImpl;
import ma.fstm.recrutement.model.dao.DaoRecruteurImpl;
import ma.fstm.recrutement.model.dao.DaoTypeContratImpl;
import ma.fstm.recrutement.model.dao.IDaoOffre;
import ma.fstm.recrutement.model.dao.IDaoRecruteur;
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
	private IDaoRecruteur daoRecruteur;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    @Override
    public void init() throws ServletException {
    	dao=new DaoOffreImpl();
    	daoType=new DaoTypeContratImpl();
    	daoRecruteur=new DaoRecruteurImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		HttpSession session=request.getSession(true);
		Long idRecruteur=(Long) session.getAttribute("idRecruteur");
		if(path.equals("/offres.php")) {
			if(idRecruteur!=null) {
				Collection<Offre> offres=daoRecruteur.retreive(idRecruteur).getOffres();
				request.setAttribute("offres", offres);
				request.getRequestDispatcher("offres.jsp").forward(request, response);
			}
			response.sendRedirect("login.php");
		}
		else if(path.equals("/supprimer.php")){
			Long id=Long.parseLong(request.getParameter("id"));
			dao.delete(id);
			request.getRequestDispatcher("offres.php").forward(request, response);
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
			
		}else if(path.equals("/login.php")) {
			if(idRecruteur==null)
			request.getRequestDispatcher("login.jsp").forward(request, response);
			else
				response.sendRedirect("offres.php");
		}else if(path.equals("/logout.php")) {
			session.setAttribute("idRecruteur", null);
			response.sendRedirect("offres.php");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String path=request.getServletPath();
		HttpSession session=request.getSession(true);
		Long idRecruteur=(Long) session.getAttribute("idRecruteur");
		if(path.equals("/ajouter.php") && request.getMethod().equalsIgnoreCase("post")) {
			if(idRecruteur!=null) {
				Offre offre= new Offre();
				TypeContrat type=new TypeContrat();
				type.setIdType(Long.parseLong(request.getParameter("type")));
				offre.setDescription(request.getParameter("description"));
				offre.setTitle(request.getParameter("titre"));
				offre.setProfil(request.getParameter("profil"));
				offre.setDate(new Date());
				offre.setTypeContrat(type);
				Recruteur recruteur=new Recruteur();
				recruteur.setId(idRecruteur);
				offre.setRecruteur(recruteur);
				dao.add(offre);
				response.sendRedirect("offres.php");
			}
			response.sendRedirect("login.php");
		}else if(path.equals("/modifier.php") && request.getMethod().equalsIgnoreCase("post")) {
			if(idRecruteur!=null) {
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
				Recruteur recruteur=new Recruteur();
				recruteur.setId(idRecruteur);
				offre.setRecruteur(recruteur);
				dao.update(offre);
				response.sendRedirect("offres.php");
			}
			response.sendRedirect("login.php");
		}else if(path.equals("/login.php") && request.getMethod().equalsIgnoreCase("post")) {
			String cin=request.getParameter("cin");
			Recruteur recruteur=daoRecruteur.retreive(cin);
			if(recruteur==null)
				response.sendRedirect("login.php");
			session.setAttribute("idRecruteur", recruteur.getId());
			response.sendRedirect("offres.php");
		}
	}

}
