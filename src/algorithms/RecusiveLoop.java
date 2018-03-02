/**
 * @author mc55262
 * */
package algorithms;

import java.util.concurrent.locks.Condition;

public class RecusiveLoop {

	
	public static void main(String[] args) {
		new RecusiveLoop().runLoop(20,12,"gt","--","test");
	}

public void runLoop(int i, int conditionValue, String condition, String incDec,String methodToBeCalled) {
	
	if("lt".equals(condition) && i <conditionValue) {
		System.out.println(i);
		if("--".equals(incDec)) {
		runLoop(--i,conditionValue,condition,incDec,methodToBeCalled);
		}else {
			runLoop(++i,conditionValue,condition,incDec,methodToBeCalled);
		}
	}else if("gt".equals(condition) && i > conditionValue){
		System.out.println(i);
		if("--".equals(incDec)) {
		runLoop(--i,conditionValue,condition,incDec,methodToBeCalled);
		}else {
			runLoop(++i,conditionValue,condition,incDec,methodToBeCalled);
		}
	}
}


}


