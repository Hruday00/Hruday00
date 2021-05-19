class ThreadRunnableEx implements Runnable{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("s.no "+i);
		}
	}
}
public class RunnableExMain {
public static void main(String[] args) {
	Thread t=new Thread(new ThreadRunnableEx());
	t.start();
}
}
