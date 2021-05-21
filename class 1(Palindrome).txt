import java.util.*;
import java.util.Scanner;

public class sum {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	List<Integer> e=new ArrayList();
	int n=sc.nextInt();
	int m=sc.nextInt();
for(int i=n;i<=m;i++) {
	if(palindrome(i))
		e.add(i);
}
int sum=0;
for(Integer i:e) {
	sum=sum+i;
	}

System.out.println(sum);

}
static boolean palindrome(int n) {
	int t=n;
	int sum=0;
	while(n!=0) {
		int r=n%10;
		sum=sum*10+r;
		n=n/10;
}
	if(sum==t)
		return true;
	else 
		return false;


}
}