package com.gft.model;

public class User {
private int Id;
private String Name;
private String Prefix;
private String Number;
public String getPrefix() {
	return Prefix;
}
public void setPrefix(String prefix) {
	Prefix = prefix;
}
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getNumber() {
	return Number;
}
public void setNumber(String number) {
	Number = number;
}
public User(int id, String name, String prefix, String number) {
	super();
	Id = id;
	Name = name;
	Prefix = prefix;
	Number = number;
}

}
