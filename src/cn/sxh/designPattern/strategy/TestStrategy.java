package cn.sxh.designPattern.strategy;

public class TestStrategy {
	
	public static void main(String[] args) {
		//自行决定使用哪种策略
		Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();
        
		Context context = new Context(strategyA);
		context.strategyMethod();
		context = new Context(strategyB);
		context.strategyMethod();
	}
}
