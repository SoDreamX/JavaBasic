package cn.sxh.designPattern.proxy.demo2;

public class MTNrmsServer implements MTServer {
	@Override
	public String getServerName(String url) {
		String name = "未知页面";
		if("http://10.228.228.7/NRMS".equals(url)) {
			name = "天津移动综合资管";
		}
		return name;
	}

}
