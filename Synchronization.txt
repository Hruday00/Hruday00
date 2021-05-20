import java.util.*;
class StringPrinter{
static synchronized void print(String a,String b){  
System.out.println(a + b);
	     }  
	     
}
class PrinterThread implements Runnable{
	Thread c;
	String a;
	String b;
	public PrinterThread( String a, String b) {
		this.a = a;
		this.b = b;
       Thread c=new Thread(this);
       c.start();
	}
	public void run() {
		StringPrinter.print(a, b);
	}
	
}
class Wall{
	public static void main(String[] args) {
new PrinterThread("Hello..","There");
new PrinterThread("How"," are you");
new PrinterThread("Thank You","very much");
	}
}