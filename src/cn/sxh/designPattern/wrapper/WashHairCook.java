package cn.sxh.designPattern.wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WashHairCook extends FilterCook {
	Logger logger = LoggerFactory.getLogger(WashHairCook.class);
	public WashHairCook(Cook cook) {
		this.cook = cook;
	}
	@Override
	public void cookdinner() {
		logger.info("做饭前先洗头。");
		cook.cookdinner();
	}

}
