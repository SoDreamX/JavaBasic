package cn.sxh.designPattern.builder;
/**
 * 建造者模式
 * 工厂类模式提供的是创建单个类的模式，而建造者模式则是将各种产品集中起来进行管理，用来创建复合对象.
 * 假设有一个问题，我们需要创建一个学生对象，属性有name,number,className,age,school等属性，
 * 如果每一个属性都可以为空，也就是说我们可以只用一个name,也可以用一个school,name,或者一个class,number，
 * 或者其他任意的赋值来创建一个学生对象，这时该怎么构造？
 * @author Sxh
 * 2018年6月19日 下午1:34:43
 */
public class Builder {
	public static void main(String[] args) {
		Student s1 = new StudentBuilder().setName("A").setNumber("1").build();
		System.out.println(s1);
		Student s2 = new StudentBuilder().setName("B").setClassName("1-1").build();
		System.out.println(s2);
	}
}
