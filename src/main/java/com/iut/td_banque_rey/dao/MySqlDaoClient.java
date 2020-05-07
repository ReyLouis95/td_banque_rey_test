package com.iut.td_banque_rey.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.iut.td_banque_rey.connection.MySqlConnection;
import com.iut.td_banque_rey.interfaces.IClientDao;
import com.iut.td_banque_rey.models.Client;
import com.mysql.cj.exceptions.RSAException;

public class MySqlDaoClient implements IClientDao{

	private static MySqlDaoClient instance;
	private static Connection connection = MySqlConnection.getInstance();
	
	public MySqlDaoClient() {
		this.connection = MySqlConnection.getInstance();
	}
	
	public static MySqlDaoClient getInstance() {
		if(instance == null) {
			instance = new MySqlDaoClient();
		}
		return instance;
	}
	
	@Override
	public boolean create(Client objet) {
		String requete = "insert into client (nom, adresse) values (?, ?) ";
		boolean reponse = false;
		try {
			PreparedStatement preparedStatement =connection.prepareStatement(requete);
			preparedStatement.setString(1, objet.getNom());
			preparedStatement.setString(2, objet.getAdresse());
		   	reponse = preparedStatement.execute();
		   	preparedStatement.close();
		} catch (SQLException e) {
		   e.printStackTrace();
		}
		return reponse;
	}

	@Override
	public boolean update(Client objet) {
		String requete = "update client set nom = ?, adresse = ? where id = ?";
		boolean reponse = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, objet.getNom());
			preparedStatement.setString(2, objet.getAdresse());
			preparedStatement.setString(3, objet.getNumClient());
			reponse = preparedStatement.execute();
			preparedStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return reponse;
	}

	@Override
	public boolean delete(Client objet) {
		String requete = "delete from client where id = ?";
		boolean reponse = false;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, objet.getNom());
			reponse = preparedStatement.execute();
			preparedStatement.close();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return reponse;
	}

	/**
	 * Read by Id 
	 * */
	@Override
	public Client read(Client objet) {
		String requete = "select * from client where id = ?";
		Client reponse = new Client();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			preparedStatement.setString(1, objet.getNumClient());
			ResultSet rs = preparedStatement.executeQuery();
			if(rs.next()) {
			reponse.setNom(rs.getString(2));
			reponse.setAdresse(rs.getString(3)); 
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return reponse;
	}
	
	@Override
	public List<Client> getList() {
		String requete = "select * from client";
		ArrayList<Client> reponse= new ArrayList<Client>();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(requete);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String num = Integer.toString(rs.getInt(1));
				String adresse = rs.getString(3);
				String nom = rs.getString(2);
				reponse.add(new Client(num, nom, adresse));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return reponse;
	}

}
