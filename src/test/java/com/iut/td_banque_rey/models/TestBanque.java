package com.iut.td_banque_rey.models;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import com.iut.td_banque_rey.models.Client;

import junit.framework.Assert;

public class TestBanque {
	
	private Banque banque;
	Client client;
	
	@Before
	public void setUp() {
		client = new Client("1","louis", "Metz");
		HashMap<String, Client> listeClients = new HashMap<String, Client>();
		listeClients.put("1", client);
		banque = new Banque(listeClients);
	}
	
	@Test
	public void testConstructeurNotNull() {
		Assert.assertNotNull(banque.getListeClients());
	}
	
	
	@Test
	public void testConstructeur() {
		Assert.assertEquals(banque.getListeClients().get("1"), client);
	}
	
}
