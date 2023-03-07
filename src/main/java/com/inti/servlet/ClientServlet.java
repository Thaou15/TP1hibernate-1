package com.inti.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

import com.inti.model.Client;
import com.inti.util.HibernateUtil;


@WebServlet("/ReserverServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger log = LogManager.getLogger();
	private Session session;
    
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	session = HibernateUtil.getSessionFactory().openSession();

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/client.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try {
			
			

			session.beginTransaction();
			log.info("Début enregistrement commande");
			
			Client c1 = new Client(request.getParameter("nomC"), request.getParameter("prenomC"), request.getParameter("adresseC"),Integer.parseInt(request.getParameter("telephoneC")), request.getParameter("mail"));
			
           
			session.save(c1);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			log.error("Erreur enregistement utilisateur");

			session.getTransaction().rollback();
		}
	}

}
