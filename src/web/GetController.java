package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DaoDemandeur;
import model.Demandeur;

@WebServlet(name="GetController",urlPatterns = {"*.php"})
public class GetController extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DaoDemandeur daoDemandeur;
	@Override
	public void init() throws ServletException {
		this.daoDemandeur = new DaoDemandeur();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			if(req.getServletPath().equalsIgnoreCase("/cv.php")) {
				doPost(req, resp);		
			}else if(req.getServletPath().equalsIgnoreCase("/specialite.php")) {
				doPost(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/niveau.php")) {
				doPost(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/experience.php")) {
				doPost(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/realisation.php")) {
				doPost(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/deconnexion.php")) {
				doPost(req, resp);
			}
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		if(session.getAttribute("userId")!=null) {
			int userId = (int)session.getAttribute("userId");
			
			req.setAttribute("base", "http://localhost:8081/SEARCH_JOB_PLATFORM/");
			Demandeur demandeur = this.daoDemandeur.GetOneDemandeur(userId);
			
			if(req.getServletPath().equalsIgnoreCase("/cv.php")) {
				
				
				req.setAttribute("specialites", demandeur.getCv().getSpecialites());
				req.setAttribute("niveaux", demandeur.getCv().getNiveaux());
				req.setAttribute("realisations", demandeur.getCv().getRealisations());
				req.setAttribute("description_cv", demandeur.getCv().getOrder().getText());
				req.setAttribute("experiences", demandeur.getCv().getExperiences());
				req.setAttribute("personnal_info", 
						" Age : "+demandeur.getAge()+" ans - "
						+ " Email : "+demandeur.getUser().getEmail()
						+ " Date Naissance : "+demandeur.getDateNaissance()
						+ " Nationalite : "+demandeur.getNationalite()
						+ " Telephone : "+demandeur.getPhone()
						+ " Localisation : "+demandeur.getLocalisation()
						);
				
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/cv.jsp");		
				rd.forward(req, resp);
			}
			else if(req.getServletPath().equalsIgnoreCase("/specialite.php")) {
				req.setAttribute("specialites", demandeur.getCv().getSpecialites());
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/Specialite.jsp");		
				rd.forward(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/niveau.php")) {
				req.setAttribute("niveaux", demandeur.getCv().getNiveaux());
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/niveau.jsp");		
				rd.forward(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/experience.php")) {
				req.setAttribute("experiences", demandeur.getCv().getExperiences());
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/experience.jsp");		
				rd.forward(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/realisation.php")) {
				req.setAttribute("realisations", demandeur.getCv().getRealisations());
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/demandeur/realisation.jsp");		
				rd.forward(req, resp);
			}else if(req.getServletPath().equalsIgnoreCase("/deconnexion.php")) {
				session.invalidate();
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/index.jsp");		
				rd.forward(req, resp);
			}else {
				// Set response content type
			      resp.setContentType("text/html");

			      // New location to be redirected
			      String site = new String("http://localhost:8081/SEARCH_JOB_PLATFORM/");

			      resp.setStatus(resp.SC_MOVED_TEMPORARILY);
			      resp.setHeader("Location", site);
			}
		}
		
	}
}
