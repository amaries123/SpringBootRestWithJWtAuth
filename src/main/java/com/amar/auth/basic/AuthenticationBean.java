package com.amar.auth.basic;

public class AuthenticationBean {
private String massage;

@Override
public String toString() {
	return "HelloWorldBeanJ [massage=" + massage + "]";
}

public String getMassage() {
	return massage;
}

public void setMassage(String massage) {
	this.massage = massage;
}

public AuthenticationBean(String massage) {
	super();
	this.massage = massage;
}
}
