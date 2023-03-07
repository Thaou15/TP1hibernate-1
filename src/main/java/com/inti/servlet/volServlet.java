package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Role;
import com.inti.model.Utilisateur;
import com.inti.model.Vol;
import com.inti.util.HibernateUtil;

/**
 * Servlet implementation class volServlet
 */
@WebServlet("/vol")
public class volServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private Logger log = LogManager.getLogger();
	private Session s;
	
    public volServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		s = HibernateUtil.getSessionFactory().openSession();
		log.debug("Connexion à la BDD et configuration d'hibernate depuis commande");
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/.jsp").forward(request, response);
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try 
		{
			s.beginTransaction();
			
			log.info("Début enregistrement vol");
			
			Vol v1 = new Vol(LocalDate.parse( request.getParameter("dateDepart")),LocalDate.parse( request.getParameter("dateArrivee")),LocalTime.parse(request.getParameter("heureDepart")),LocalTime.parse( request.getParameter("heureArrivee")));
					
			s.saveOrUpdate(v1);
					
			s.getTransaction().commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			
			log.error("Erreur enregistrement vol");
			
			s.getTransaction().rollback();
		}
		
		doGet(request, response);
	}

}
