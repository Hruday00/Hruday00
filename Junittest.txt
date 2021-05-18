package Programming;

	public class MyJUnitClass {
public int add(int a,int b) {
	return a+b;
	}
public String concat(String a,String b) {
	return a+b;
}
}
------------------------------------------
package Programming;

import static org.junit.Assert.*;

import org.junit.Test;

public class AddTest {

	@Test
	public void Addtest() {
MyJUnitClass junit=new MyJUnitClass();
int result=junit.add(12,21);
assertEquals(33,result);
String red=junit.concat("hru", "day");
assertEquals("hruday",red);
	}

}
------------------------------------------------
