package cn.sxh.designPattern.builder;

public class Student {
	String name;
	int age;
	String number;
	String className;
	String school;
	
	public Student(StudentBuilder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.number = builder.number;
		this.className = builder.className;
		this.school = builder.school;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", number=" + number + ", className=" + className
				+ ", school=" + school + "]";
	}
}
