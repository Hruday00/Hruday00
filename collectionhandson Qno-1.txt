import java.util.*;
class develop{
private ArrayList<Integer> l=new ArrayList();
	ArrayList storeEvenNumbers(int N) {
for(int i=2;i<=N;i+=2) {
	l.add(i);
}
System.out.println(l);
return l;
	}
	ArrayList printEvenNumbers() {
	ArrayList<Integer> c=new ArrayList();
for(int i:l) {
	c.add(i*2);
}
System.out.println(c);
return c;
	}
void retriveEvenNumber(int N) {
		if(l.contains(N)){
			System.err.println(N+" is present and it is returning "+N*2);
		}
		else
			System.err.println(N+" is not present and so it is returning "+0);
	}
public static void main(String[] args) {
	develop d=new develop();
	d.storeEvenNumbers(20);
	d.printEvenNumbers();
	d.retriveEvenNumber(4);
}
}
Output:[2, 4, 6, 8, 10, 12, 14, 16, 18, 20]
[4, 8, 12, 16, 20, 24, 28, 32, 36, 40]
4 is present and it is returning 8
