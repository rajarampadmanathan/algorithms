package random.programs;

public class Sync extends Object{//extends Thread{

	static String turn="";
	String msg;
	public Sync(String msg) {
		this.msg=msg;
	}
	//private   static int i=0;
	
	/*@Override
	public void run() {
		super.run();
		getValue();
	}*/
	
	public  int getValue() {
		//synchronized (Sync.class) {
		synchronized (Sync.class) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			turn=this.msg;
			System.out.println(turn);
			//Thread.;
		}
		
		/*
		for(;i<50;i++) {
	//		Thread.dumpStack();	
		System.out.println(i);	
	}//}
*/		return 1;
	} 

	public int getValue1() {
		//Thread.dumpStack();
		return 1;
	} 
	
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getId()+" -"+Thread.currentThread().getName());
		//System.out.print("Main thread---");
		//Thread.dumpStack();
		//System.out.println(Thread.activeCount());
		Runnable r=()->{Sync s1=new Sync("ping");while(true){s1.getValue();}};
		new Thread(r).start();
		Runnable r1=()->{Sync s1=new Sync("pong");while(true){s1.getValue();}};
		new Thread(r1).start();
	}
}
