package br.ifpe.littlepadawan.basics;






public class Discipline  {

	private int id;
	private String name;
	private String acronym;

	public Discipline() {

	}

	public Discipline(String name) {
		this.name = name;
	}

	public Discipline(String name, String acronym) {
		this.name = name;
		this.acronym = acronym;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}
}
