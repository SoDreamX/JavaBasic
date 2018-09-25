package cn.sxh.designPattern.strategy;

public class TestStrategy {
	
	public static void main(String[] args) {
		//���о���ʹ�����ֲ���
		Strategy strategyA = new StrategyA();
        Strategy strategyB = new StrategyB();
        
		Context context = new Context(strategyA);
		context.strategyMethod();
		context = new Context(strategyB);
		context.strategyMethod();
	}
}
