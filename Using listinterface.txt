
	import java.util.*;
	public class Lists {
		public static void main(String[] args) {
			Test t=new Test();
		System.out.println(t.country());
			System.out.println(t.numlist());
			System.out.println(t.values());
		}
	public List country() {
	List l=new ArrayList();
	l.add("India");
	l.add("australia");
	l.add("NewZeland");
	l.add("GreenLand");
	l.add("Bangladesh");
	return l;
	}
	public List numlist() {
		List s=new ArrayList();
		for(int i=1;i<=10;i++) {
			s.add(i);
		}
		return s;
	}
	public List values() {
		List c=new ArrayList();
		c.addAll(numlist());
		for(int i=11;i<=15;i++) {
		c.add(i);	
		}
		return c;
	}
	}
