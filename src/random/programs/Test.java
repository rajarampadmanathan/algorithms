package random.programs;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

public class Test extends Object{
	
	int state=0;
    final int a=0;
	final public synchronized void testMethod() {
		System.gc();
		ReentrantLock rl=new ReentrantLock();
			if(state==0) {
        	System.out.println("1");
        	state=1;
        	try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	}
        	else if(state==1){
        		System.out.println("0000000");
            	state=0;
            	this.notify();
        	}try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
       
    }
    public static void main(String[] args) throws InterruptedException {
    	ArrayList<Integer> al=new ArrayList<>();
    	al.add(1);
    	al.add(2);
    	al.add(1);
    	al.add(3);
    	al.add(2);
    	al.add(1);
    	al.stream().map(i-> i).collect(Collectors.groupingBy(p->p,Collectors.counting())).forEach((x,y)->System.out.println(x+":"+y));
    	System.out.println(Thread.currentThread().isDaemon());
    	final Test test1 = new Test();
        Thread t1 = new Thread() { public void run() { while(true) {test1.testMethod(); }} };
        Thread t2 = new Thread() { public void run() { while(true) {test1.testMethod(); } }};
        Thread t3 = new Thread() { public void run() { while(true) {test1.testMethod(); } }};
        //Thread t4 = new Thread() { public void run() { while(true) {test1.testMethod(); } }};
        t1.start();
        t2.start();
        t3.start();
        //t4.start();
        //Thread.sleep(5000);
        System.out.println(t2.getState());
    }
}
