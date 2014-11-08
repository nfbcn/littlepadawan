/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifpe.littlepadawan.basics;



/**
 *
 * @author Nikolas
 */

public class Student {
	
	private int id;
	private String name;
	private String registration;
	private String password;
	private int levelAcess;

	public Student(String name) {
		this.name = name;
	}

	public Student(String name, String registration, String password) {
		this.name = name;
		this.registration = registration;
		this.password = password;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the registration
	 */
	public String getRegistration() {
		return registration;
	}

	/**
	 * @param registration
	 *            the registration to set
	 */
	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public int getLevelAcess() {
		return levelAcess;
	}

	public void setLevelAcess(int levelAcess) {
		this.levelAcess = levelAcess;
	}
}
