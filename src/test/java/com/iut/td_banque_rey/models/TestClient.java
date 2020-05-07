package com.iut.td_banque_rey.models;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestClient {

	private Client client;
	private Compte compte;
	
	@Before
	public void setUp() {
		client = new Client("1", "rey", "metz");
	}
	
	@Test
	public void testConstructeurClientNotNull() {
		Assert.assertNotNull(client);
	}

	@Test
	public void testConstructeurIdEquals() {
		Assert.assertEquals("1", client.getNumClient());
	}
	
	@Test
	public void testConstructeurNomEquals() {
		Assert.assertEquals("rey", client.getNom());
	}
	
	@Test
	public void testConstructeurAdresseEquals(){
		Assert.assertEquals("metz", client.getAdresse());
	}
	
	//TODO: meilleure solution: surcharger la méthode equals pour faire une seule comparaison
	@Test
	public void testAjouterCompteSize() {
		compte = new CompteAvecDecouvert(5000,"1", 0);
		client.OuvertureCompte("1", 5000, "AvecDecouvert", 0);
		Assert.assertEquals(client.getListeComptes().size(), 1);
		Assert.assertEquals(client.getListeComptes().get("1").solde, compte.solde);
		Assert.assertEquals(client.getListeComptes().get("1").numCompte, compte.numCompte);
	}
	
}
