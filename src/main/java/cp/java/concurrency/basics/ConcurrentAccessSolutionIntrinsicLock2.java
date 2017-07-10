package cp.java.concurrency.basics;

public class ConcurrentAccessSolutionIntrinsicLock2 {
	public static void main(String args[]) {
		ConcurrentAccessSolutionIntrinsicLockCounterUsage2 c = new ConcurrentAccessSolutionIntrinsicLockCounterUsage2();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}
}
class ConcurrentAccessSolutionIntrinsicLockCounter2 {
	static long count = 0;
}

class ConcurrentAccessSolutionIntrinsicLockCounterUsage2 implements Runnable {
	Object object = new Object();
	public void increment() {
		synchronized(object){
			ConcurrentAccessSolutionIntrinsicLockCounter2.count++;
			System.out.print(ConcurrentAccessSolutionIntrinsicLockCounter2.count + " ");
		}
	}

	public void run() {
		increment();
		increment();
		increment();
	}
}

