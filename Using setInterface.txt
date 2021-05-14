import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.lang.StackOverflowError;
public class Test {
	public static void main(String[] args) {
		Test t=new Test();
	System.out.println(t.country());
		System.out.println(t.numlist());
		System.out.println(t.values());
	}
public Set country() {
Set l=new HashSet();
l.add("India");
l.add("australia");
l.add("NewZeland");
l.add("GreenLand");
l.add("Bangladesh");
return l;
}
public Set numlist() {
	Set s=new HashSet();
	for(int i=1;i<=10;i++) {
		s.add(i);
	}
	return s;
}
public Set values() {
	Set c=new HashSet();
	c.addAll(numlist());
	for(int i=11;i<=15;i++) {
	c.add(i);	
	}
	return c;
}
}