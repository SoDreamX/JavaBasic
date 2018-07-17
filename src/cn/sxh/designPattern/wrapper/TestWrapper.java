package cn.sxh.designPattern.wrapper;

public class TestWrapper {
	public static void main(String[] args) {
		Cook cook1 = new WashHandCook(new ChinessCook());
		Cook cook2 = new WashHairCook(new ChinessCook());
		cook1.cookdinner();
		cook2.cookdinner();
	}
}
