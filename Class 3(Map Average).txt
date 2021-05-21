import java.util.*;
import java.util.Map.Entry;
public class Average {
public static int Marks(Map<Integer,Integer> m1) {
int n=0,c=0;
Iterator<Integer> i=m1.keySet().iterator();
while(i.hasNext()){
	Integer b=i.next();
	if(b%2!=0) {
	c++;
	n=n+m1.get(b);
	}
	}
return (n/c);
}
public static void main(String[] args) {
	Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
	m1.put(12,90);
	m1.put(35, 90);
	m1.put(33, 90);
	m1.put(56, 88);
	System.out.println(Marks(m1));
	}
}
