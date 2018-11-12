package cn.sxh.multiThread.ProCustom2;
/**
 * 产品
 * @author Sxh
 * 2018年11月9日 下午3:02:03
 */
public class ProductBean {
	private String fldid;
	private String fldname;
	public ProductBean() {
		super();
	}
	public ProductBean(String fldid, String fldname) {
		super();
		this.fldid = fldid;
		this.fldname = fldname;
	}
	public String getFldid() {
		return fldid;
	}
	public void setFldid(String fldid) {
		this.fldid = fldid;
	}
	public String getFldname() {
		return fldname;
	}
	public void setFldname(String fldname) {
		this.fldname = fldname;
	}
}
