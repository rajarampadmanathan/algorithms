package algorithms;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<String>{

	int prcNum;
	public TestCallable(int prcNum) {
		this.prcNum=prcNum;
		// TODO Auto-generated constructor stub
	}
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Schedule received..."+prcNum);
		//Thread.sleep(2000);
		return "Hello Santosh..."+prcNum;
	}
	
	

}
