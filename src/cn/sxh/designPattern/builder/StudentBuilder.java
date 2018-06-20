package cn.sxh.designPattern.builder;

public class StudentBuilder {
	String name;
	int age;
	String number;
	String className;
	String school;
	
	public StudentBuilder setName(String name) {
		this.name = name;
		return this;
	}
	public StudentBuilder setAge(int age) {
		this.age = age;
		return this;
	}
	public StudentBuilder setNumber(String number) {
		this.number = number;
		return this;
	}
	public StudentBuilder setClassName(String className) {
		this.className = className;
		return this;
	}
	public StudentBuilder setSchool(String school) {
		this.school = school;
		return this;
	}
	public Student build() {
		return new Student(this);
	}
}
