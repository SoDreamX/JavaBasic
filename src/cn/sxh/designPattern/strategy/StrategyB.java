package cn.sxh.designPattern.strategy;
//具体策略角色
public class StrategyB implements Strategy {

	@Override
	public void useStrategy() {
		System.out.println("StrategyB.useStrategy()");
	}

}
