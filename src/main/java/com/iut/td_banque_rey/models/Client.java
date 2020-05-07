package com.iut.td_banque_rey.models;

import java.util.HashMap;
import java.util.Map;

public class Client {

	private String numClient;
	private String nom;
	private String adresse;
	private Map<String, Compte> listeComptes;
	
	public Client() {
		this.listeComptes = new HashMap<String, Compte>();
	}
	
	public Client(String numClient) throws Exception {
		if(verifieNum(numClient) == false) {
			throw new IllegalArgumentException("Le numéro du client ne peut pas être vide");
		}
		this.numClient = numClient;
		this.listeComptes = new HashMap<String, Compte>();
	}
	
	public Client(String numClient, String nom, String adresse) {
		this.numClient = numClient;
		this.nom = nom;
		this.adresse = adresse;
		if(verifieNum(numClient) == false) {
			throw new IllegalArgumentException("Le numéro du client ne peut pas être vide");
		}
		this.listeComptes = new HashMap<String, Compte>();
	}
	
	public Client(String numClient, String nom, String adresse, Map<String, Compte> listeComptes) {
		this.numClient = numClient;
		this.nom = nom;
		this.adresse = adresse;
		this.listeComptes = listeComptes;
		if(verifieNum(numClient) == false) {
			throw new IllegalArgumentException("Le numéro du client ne peut pas être vide");
		}
	}
	
	public Map<String, Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(Map<String, Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	public boolean verifieNum(String num) {
		if(num == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public void OuvertureCompte(String numeroCompte, int solde, String type, int decouvert)
	{
		Compte newCompte = null;
		
		switch (type) 
		{
		case "AvecDecouvert":
			newCompte = new CompteAvecDecouvert(solde, numeroCompte, decouvert);
			break;

		case "SansDecouvert":
			newCompte = new CompteSansDecouvert(solde, numeroCompte);
			break;
		default:
			break;
		}
		listeComptes.put(numeroCompte, newCompte);
	}
	
	
	public String getNumClient() {
		return numClient;
	}

	public void setNumClient(String numClient) {
		this.numClient = numClient;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
}
