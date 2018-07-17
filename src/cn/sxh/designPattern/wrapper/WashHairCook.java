package cn.sxh.designPattern.wrapper;

public class WashHairCook extends FilterCook {
	public WashHairCook(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void cookdinner() {
		System.out.println("����ǰ��ϴͷ��");
		cook.cookdinner();
	}

}
