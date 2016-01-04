package limeng32.mirage.util;

import java.io.Serializable;

import limeng32.mirage.util.pojo.PojoSupport;

public class AccountForTest extends PojoSupport<AccountForTest> implements
		Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;

	private java.lang.String name;

	private java.lang.String email;

	private java.lang.String password;

	/**
	 * 是否已激活
	 * */
	private boolean activated;

	private java.util.Collection<LoginLogForTest> loginLogForTest;

	public Integer getId() {
		return id;
	}

	/**
	 * 为确保hashCode稳定性，仅在测试代码中保留setId方法，在产品代码无setId方法
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	public java.lang.String getPassword() {
		return password;
	}

	public void setPassword(java.lang.String password) {
		this.password = password;
	}

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public java.util.Collection<LoginLogForTest> getLoginLogForTest() {
		if (loginLogForTest == null)
			loginLogForTest = new java.util.LinkedHashSet<LoginLogForTest>();
		return loginLogForTest;
	}

	public java.util.Iterator<LoginLogForTest> getIteratorLoginLogForTest() {
		if (loginLogForTest == null)
			loginLogForTest = new java.util.LinkedHashSet<LoginLogForTest>();
		return loginLogForTest.iterator();
	}

	public void setLoginLogForTest(
			java.util.Collection<LoginLogForTest> newLoginLogForTest) {
		removeAllLoginLog();
		for (java.util.Iterator<LoginLogForTest> iter = newLoginLogForTest
				.iterator(); iter.hasNext();)
			addLoginLogForTest((LoginLogForTest) iter.next());
	}

	public void addLoginLogForTest(LoginLogForTest newLoginLogForTest) {
		if (newLoginLogForTest == null)
			return;
		if (this.loginLogForTest == null)
			this.loginLogForTest = new java.util.LinkedHashSet<LoginLogForTest>();
		if (!this.loginLogForTest.contains(newLoginLogForTest)) {
			this.loginLogForTest.add(newLoginLogForTest);
			newLoginLogForTest.setAccountForTest(this);
		}
	}

	public void removeLoginLogForTest(LoginLogForTest oldLoginLogForTest) {
		if (oldLoginLogForTest == null)
			return;
		if (this.loginLogForTest != null)
			if (this.loginLogForTest.contains(oldLoginLogForTest)) {
				this.loginLogForTest.remove(oldLoginLogForTest);
				oldLoginLogForTest.setAccountForTest((AccountForTest) null);
			}
	}

	public void removeAllLoginLog() {
		if (loginLogForTest != null) {
			LoginLogForTest oldLoginLogForTest;
			for (java.util.Iterator<LoginLogForTest> iter = getIteratorLoginLogForTest(); iter
					.hasNext();) {
				oldLoginLogForTest = (LoginLogForTest) iter.next();
				iter.remove();
				oldLoginLogForTest.setAccountForTest((AccountForTest) null);
			}
		}
	}

	public boolean equalsExactly(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountForTest other = (AccountForTest) obj;
		if (activated != other.activated)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (loginLogForTest == null) {
			if (other.loginLogForTest != null)
				return false;
		} else if (!loginLogForTest.equals(other.loginLogForTest))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

}
