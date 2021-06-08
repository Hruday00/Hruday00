package org.project.jobportal;

import static org.junit.Assert.*;

import org.junit.Test;
public class TestCases {
@Test
	public void True() {
String mail="hruday02180@gmail.com";
String password="Hruday007";
boolean validin=SignIn.isValidMail(mail, password);
assertTrue(validin);
}
@Test
public void False() {
String mail="hruday@02180gmail.com";
String password="hruday007";
boolean validup=SignIn.isValidMail(mail, password);
assertFalse(validup);
}
}
