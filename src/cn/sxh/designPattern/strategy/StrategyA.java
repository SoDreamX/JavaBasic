package cn.sxh.designPattern.strategy;
//具体策略角色
public class StrategyA implements Strategy {

	@Override
	public void useStrategy() {
		System.out.println("StrategyA.useStrategy()");
	}

}
