package cn.sxh.designPattern.wrapper;

public class WashHandCook extends FilterCook {
	public WashHandCook(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void cookdinner() {
		System.out.println("×ö·¹Ç°Ï´ÊÖ¡£");
		cook.cookdinner();
	}

}
