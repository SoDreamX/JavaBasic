package cn.sxh.designPattern.proxy.demo2;

public class MTNrmsServer implements MTServer {
	@Override
	public String getServerName(String url) {
		String name = "δ֪ҳ��";
		if("http://10.228.228.7/NRMS".equals(url)) {
			name = "����ƶ��ۺ��ʹ�";
		}
		return name;
	}

}
