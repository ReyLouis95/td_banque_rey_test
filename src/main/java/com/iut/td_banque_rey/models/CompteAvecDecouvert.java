package com.iut.td_banque_rey.models;

public class CompteAvecDecouvert extends Compte{

	private double decouvertAutorise;
	
	public CompteAvecDecouvert(double solde, String numCompte, double decouvertAutorise) {
		super(solde, numCompte);
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public void debiter(double montant) {
		if (this.solde - montant >= decouvertAutorise) {
			this.solde = this.solde - montant;
		}
	}
}
