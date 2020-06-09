package com.amar.SpringRestApp.bean.helloworld;

public class HelloWorldBeanJ {
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

public HelloWorldBeanJ(String massage) {
	super();
	this.massage = massage;
}
}
