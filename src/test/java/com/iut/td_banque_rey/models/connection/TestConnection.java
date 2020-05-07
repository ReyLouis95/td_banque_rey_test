package com.iut.td_banque_rey.models.connection;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.iut.td_banque_rey.connection.MySqlConnection;

import junit.framework.Assert;

public class TestConnection {

	private Connection instance;
	private Connection instance2;
	
	@Before
	public void setUp() {
		instance = MySqlConnection.getInstance();
		instance2 = MySqlConnection.getInstance();
	}
	
	@Test
	public void testConnectionNotNull() {
		Assert.assertNotNull(instance);
	}
	
	@Test
	public void TestSingleton() {
		Assert.assertEquals(instance, instance2);
	}
}
