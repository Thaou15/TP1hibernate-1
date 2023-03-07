package com.inti.model;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Ville {

 
    public Ville() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVille;
    private String nomVille;
    
    @OneToOne(mappedBy = "ville")
    private Aeroport aeroport;

	public Ville(String nomVille, Aeroport aeroport) {
		super();
		this.nomVille = nomVille;
		this.aeroport = aeroport;
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	@Override
	public String toString() {
		return "Ville [idVille=" + idVille + ", nomVille=" + nomVille + ", aeroport=" + aeroport + "]";
	}
    

}