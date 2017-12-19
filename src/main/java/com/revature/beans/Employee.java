package com.revature.beans;

public class Employee {
	private int id;
	private String name;
	//private int age;
	//private int weight;
	
	
	public Employee() {
	}
	
	public Employee(int id, String name) {//int id, String name, int age, int weight) {
		super();
		this.id = id;
		this.name = name;
		//this.age = age;
		//this.weight = weight;
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
	/*
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
*/
}
