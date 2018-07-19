package cn.sxh.designPattern.wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WashHandCook extends FilterCook {
	Logger logger = LoggerFactory.getLogger(WashHandCook.class);
	public WashHandCook(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void cookdinner() {
		logger.info("×ö·¹Ç°Ï´ÊÖ¡£");
		cook.cookdinner();
	}

}
