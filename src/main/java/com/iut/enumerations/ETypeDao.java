package com.iut.enumerations;

public enum ETypeDao {
	MYSQL(1), MEMORY(2), XML(3);

	private int id;

	public int getId() {
		return id;
	}

	ETypeDao(int id) {
		this.id = id;
	}
}
