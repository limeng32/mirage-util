package limeng32.mirage.util;

import java.io.Serializable;

import limeng32.mirage.util.pojo.PojoSupport;

public class LoginLogForTest extends PojoSupport<LoginLogForTest> implements
		Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private java.util.Date loginTime;
	private java.lang.String loginIP;

	private AccountForTest accountForTest;

	public Integer getId() {
		return id;
	}

	/**
	 * 为确保hashCode稳定性，仅在测试代码中保留setId方法，在产品代码无setId方法
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public java.util.Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(java.util.Date loginTime) {
		this.loginTime = loginTime;
	}

	public java.lang.String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(java.lang.String loginIP) {
		this.loginIP = loginIP;
	}

	public AccountForTest getAccountForTest() {
		return accountForTest;
	}

	public void setAccountForTest(AccountForTest newAccountForTest) {
		if (this.accountForTest == null
				|| this.accountForTest != newAccountForTest) {
			if (this.accountForTest != null) {
				AccountForTest oldAccountForTest = this.accountForTest;
				this.accountForTest = null;
				oldAccountForTest.removeLoginLogForTest(this);
			}
			if (newAccountForTest != null) {
				this.accountForTest = newAccountForTest;
				this.accountForTest.addLoginLogForTest(this);
			}
		}
	}

}