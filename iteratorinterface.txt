import java.util.*;
public class iterator {
public static void main(String[] args) {
	iterator c=new iterator();
Iterator i=c.getcountries().iterator();
while(i.hasNext()) {
System.out.println(i.next());	
}
}
public Set getcountries() {
	Set s=new HashSet();
	s.add("India");
	s.add("Bangladesh");
	s.add("Afghanistan");
	s.add("Iran");
	s.add("iraq");
	return s;
}
}