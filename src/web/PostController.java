package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CvImpl;
import dao.DaoDemandeur;
import dao.DaoSpecialite;
import dao.DaoUser;
import helper.HibernateConfig;
import model.Cv;
import model.Demandeur;
import model.Specialite;
import model.User;

@WebServlet(name="PostController",urlPatterns = {"*.save"})
public class PostController extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DaoUser daoUser;
	private DaoDemandeur daoDemandeur;
	private DaoSpecialite daoSpecialite;
	private CvImpl daoCv;
	
	@Override
	public void init() throws ServletException {
		this.daoUser = new DaoUser();
		this.daoSpecialite = new DaoSpecialite();
		this.daoDemandeur = new DaoDemandeur();
		this.daoCv = new CvImpl();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		if(req.getServletPath().equalsIgnoreCase("/login.save")) {
			rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setAttribute("base", "http://localhost:8081/SEARCH_JOB_PLATFORM/");
		RequestDispatcher rd = null;
		
		
		if(req.getServletPath().equalsIgnoreCase("/login.save")) {
			String email = req.getParameter("uname");
			String password = req.getParameter("psw");
			String user = req.getParameter("personne");
			
			
			switch(user) {
			case "demandeur":
				User u = this.daoUser.getOneUser(email, password);
				if(u!=null) {
					PrintWriter pr = resp.getWriter();
					Demandeur demandeur = this.daoDemandeur.GetOneDemandeur(u.getId());
					//PrintWriter pri = resp.getWriter();
					
					// set the session 
					
					session.setAttribute("userId",demandeur.getUser().getId());
					session.setAttribute("nameUser", demandeur.getName()+" "+demandeur.getSurname());
					session.setAttribute("demandeurId", demandeur.getId());
					session.setAttribute("cvId", demandeur.getCv().getId());
					rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/home.jsp");
					rd.forward(req, resp);
				}else {
					rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");
					rd.forward(req, resp);
				}
				
				break;
			case "entreprise":
				break;
		}
			
			
			
						
		}else if(req.getServletPath().equalsIgnoreCase("/specialite.save")) {
			String libelle = req.getParameter("technologie");
			int niveau = Integer.parseInt(req.getParameter("niveau"));
			int cvId = (int) session.getAttribute("cvId");
			Cv cv = this.daoCv.getOneCvById(cvId);
			
//			// saves the specialite 
			Specialite spe = new Specialite();
			spe.setLevel(niveau);
			spe.setLibelle(libelle);
			spe.addCv(cv);
			this.daoSpecialite.insertOneSpecialite(spe);
			
			 //add the specialite to the CV id 
			//this.daoCv.addSpecialiteToCv(cvId, 3);
			
//			PrintWriter pr = resp.getWriter();
//			pr.print(this.daoCv.getOneCvById(cvId));
		}
		
		
	}

}
