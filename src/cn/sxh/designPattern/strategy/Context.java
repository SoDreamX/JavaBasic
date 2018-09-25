package cn.sxh.designPattern.strategy;

public class Context {
	//���в��Ե�����
	private Strategy strategy;
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}
	public void strategyMethod() {
		strategy.useStrategy();
	}
}
