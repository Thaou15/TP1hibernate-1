package com.inti.model;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVol;
    private LocalDate dateDepart;
    private LocalDate dateArrivee;
    private LocalTime heureDepart;
    private LocalTime heureArrivee;
    
    @ManyToMany
    @JoinTable(name="Vol_CA",
    joinColumns = @JoinColumn(name = "idV"), 
	inverseJoinColumns = @JoinColumn(name = "idCA"))
    private List<CompagnieAerienne> listeCompagnieAerienne;
    
    @OneToMany(mappedBy = "vol")
    private List<Reservation> listeReservation;
    
    @ManyToOne
    @JoinColumn(name="idvol")
    private Aeroport aeroport;

    public Vol() {
    }
    
	public Vol(LocalDate dateDepart, LocalDate dateArrivee, LocalTime heureDepart, LocalTime heureArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	
	
    public void ouvrirVol() {
        // TODO implement here
    }

    /**
     * 
     */
    public void fermerVol() {
        // TODO implement here
    }

	public int getIdVol() {
		return idVol;
	}

	public void setIdVol(int idVol) {
		this.idVol = idVol;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public LocalDate getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(LocalDate dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	public LocalTime getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(LocalTime heureDepart) {
		this.heureDepart = heureDepart;
	}

	public LocalTime getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(LocalTime heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@Override
	public String toString() {
		return "Vol [idVol=" + idVol + ", dateDepart=" + dateDepart + ", dateArrivee=" + dateArrivee + ", heureDepart="
				+ heureDepart + ", heureArrivee=" + heureArrivee + "]";
	}
}