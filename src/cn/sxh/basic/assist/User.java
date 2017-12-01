package cn.sxh.basic.assist;

import java.io.Serializable;

/**
 * @author sxh
 * @version 创建时间：2017年11月30日 下午5:14:10
 * 类说明
 */
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String userName;
	//该变量不会被序列化
	private transient String password;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
