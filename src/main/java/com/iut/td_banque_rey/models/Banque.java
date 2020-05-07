package com.iut.td_banque_rey.models;

import java.util.HashMap;
import java.util.Map;

public class Banque {
	
	private Map<String, Client> listeClients;
	
	public Banque() {
		this.listeClients = new HashMap<String, Client>();
	}
	
	public Banque(Map<String, Client> clients) {
		this.listeClients = clients;
	}
	
	public void retrait(String numCompte, String nomClient, double montant) throws Exception {
		Client client = listeClients.get(nomClient);
			Compte compte = client.getListeComptes().get(numCompte);
			compte.debiter(montant);
	}
	
	
	public void depot(String numCompte, String nomClient, double montant) throws Exception {
		Client client = listeClients.get(nomClient);
		Compte compte = client.getListeComptes().get(numCompte);
		compte.debiter(montant);
	}
	
	public void ouvertureCompte(String nomClient, String numCompte, String typeCompte) {
		Client client = listeClients.get(nomClient);
		client.OuvertureCompte(numCompte, 0, typeCompte, 0);
	}
	
	public void consultation(String numCompte) {
		
	}

	
	//from quelle unité ?
	public double conversionFromEuros(double montant) {
		return montant;
	}
	
	public double conversionToEuros(double montant) {
		return montant;
	}

	public Map<String, Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(Map<String, Client> listeClients) {
		this.listeClients = listeClients;
	}
}
