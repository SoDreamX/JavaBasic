package cn.sxh.designPattern.strategy;

public class Context {
	//持有策略的引用
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	public void strategyMethod() {
		strategy.useStrategy();
	}
}
