package cn.sxh.collection.bean;

public class Student {
	private Integer age;
	private String name;
	private Integer score;
	public Student(Integer age, String name, Integer score) {
		super();
		this.age = age;
		this.name = name;
		this.score = score;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.age;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
