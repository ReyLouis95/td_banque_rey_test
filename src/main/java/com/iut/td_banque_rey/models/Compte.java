package com.iut.td_banque_rey.models;

public abstract class Compte {
	
	protected double solde;
	protected String numCompte;
	//TODO: rajouter enum pour le type de compte
	public Compte(double solde, String numCompte) {
		if(verifieNum(numCompte) == false) {
			throw new IllegalArgumentException("Le numéro de compte ne peut pas être null");
		}
		this.solde = solde;
		this.numCompte = numCompte;
	}
	
	public boolean verifieNum(String num) {
		if(num == null) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public abstract void debiter(double montant) throws Exception;
	
	public void crediter(double montant) {
		this.solde = solde + montant;
	}
	
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getNumCompteString() {
		return numCompte;
	}
	public void setNumCompteString(String numCompteString) {
		this.numCompte = numCompteString;
	}
	

}
