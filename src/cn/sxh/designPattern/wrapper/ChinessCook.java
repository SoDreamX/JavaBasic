package cn.sxh.designPattern.wrapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChinessCook implements Cook {
	Logger logger = LoggerFactory.getLogger(ChinessCook.class);
	@Override
	public void cookdinner() {
		// TODO Auto-generated method stub
		logger.info("中国人做晚餐。。。");
	}

}
