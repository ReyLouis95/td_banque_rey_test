package com.iut.td_banque_rey.factory;

import com.iut.enumerations.ETypeDao;
import com.iut.td_banque_rey.interfaces.IClientDao;
import com.iut.td_banque_rey.interfaces.ICompteDao;

public abstract class DaoFactory 
{
	public static DaoFactory getDaoFactory(ETypeDao cible) throws Exception {

		DaoFactory daoF = null;

		switch (cible) {
		case MEMORY:
			throw new Exception("Not yet implemented");
		case MYSQL:
			daoF = new MySqlDaoFactory();
			break;
		case XML:
			throw new Exception("Not yet implemented");
		default:
			throw new Exception("Not yet implemented");

		}
		return daoF;
	}
	
	public abstract IClientDao getClientDao();
	public abstract ICompteDao getCompteDao();
}
