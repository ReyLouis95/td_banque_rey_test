package com.iut.td_banque_rey.interfaces;

import java.util.List;

public interface IDao<T> {

	boolean create(T objet);

	boolean update(T objet);

	boolean delete(T objet);

	/**
	 * get by id
	 * @param objet
	 * @return l'objet en fonction de son id
	 */
	T read(T objet);
	
	/**
	 * readAll
	 * @return 
	 */
	List<T> getList();
}


