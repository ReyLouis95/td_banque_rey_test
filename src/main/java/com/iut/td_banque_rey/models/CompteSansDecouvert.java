package com.iut.td_banque_rey.models;

public class CompteSansDecouvert extends Compte{

	public CompteSansDecouvert(double solde, String numCompte) {
		super(solde, numCompte);
	}

	@Override
	public void debiter(double montant) {
		if(this.solde - montant > 0) {
			this.solde = this.solde - montant;
		}
	}
}
