
	import java.util.ArrayList;
import java.util.HashSet;
	import java.util.List;
	import java.util.Set;
	import java.lang.StackOverflowError;
	public class Genrics {
		public static void main(String[] args) {
			Test t=new Test();
		System.out.println(t.country());
			System.out.println(t.numlist());
		}
	public List country() {
	List <String> l=new ArrayList<String>();
	l.add("India");
	l.add("australia");
	l.add("NewZeland");
	l.add("GreenLand");
	l.add("Bangladesh");
	return l;
	}
	public Set numlist() {
		Set <Integer>s=new HashSet<Integer>();
		for(int i=1;i<=10;i++) {
			s.add(i);
		}
		return s;
	}

	}