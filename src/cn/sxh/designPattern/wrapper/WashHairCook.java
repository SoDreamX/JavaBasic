package cn.sxh.designPattern.wrapper;

public class WashHairCook extends FilterCook {
	public WashHairCook(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void cookdinner() {
		System.out.println("做饭前先洗头。");
		cook.cookdinner();
	}

}
