package com.iut.td_banque_rey.models;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestCompte {

	private Compte compteAvec;
	private Compte compteSans;
	
	@Before
	public void setUp() {
		compteAvec = new CompteAvecDecouvert(100000, "2", 40);
		compteSans = new CompteSansDecouvert(5000, "3");
	}
	
	@Test
	public void testCreateNotNull() {
		Assert.assertNotNull(compteAvec);
		Assert.assertNotNull(compteSans);
	}
	
	@Test
	public void testCreate() {
		Assert.assertEquals(compteAvec.getSolde(), 100000.0);
		Assert.assertEquals(compteSans.getSolde(), 5000.0);
	}
	
	@Test
	public void testCredit() {
		compteAvec.crediter(15);
		Assert.assertEquals(100015.0, compteAvec.getSolde());
	}
	
	@Test
	public void testDebit() throws Exception {
		compteAvec.debiter(15);
		Assert.assertEquals(99985.0, compteAvec.getSolde());
	}
	
	@Test
	public void testDebitSansDecouvertErreur() throws Exception {
		compteSans.debiter(5001);
		Assert.assertEquals(5000.0, compteSans.getSolde());
	}
	
	@Test
	public void testDebitAvecDecouvertErreur() throws Exception{
		compteAvec.debiter(10000000.0);
		Assert.assertEquals(100000.0, compteAvec.getSolde());
	}
		
	
}
