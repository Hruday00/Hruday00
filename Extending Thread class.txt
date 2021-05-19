class Run extends Thread{
	public void run() {
		for(int i=0;i<=4;i++) {
			System.out.println(i);
			try {
				sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Deer{
	public static void main(String[] args) {
		Run r=new Run();
		r.start();
		System.out.println("Before setting name"+Thread.currentThread().getName());
	Thread.currentThread().setName("Run");
	System.out.println("After Setting name"+Thread.currentThread().getName());
System.out.println("Before setting priority"+Thread.currentThread().getPriority());
Thread.currentThread().setPriority(3);
System.out.println("After setting Priority"+Thread.currentThread().getPriority());

	}
}