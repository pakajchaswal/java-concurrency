package cp.java.concurrency.basics;

public class ConcurrentAccessSolutionIntrinsicLock {
	public static void main(String args[]) {
		ConcurrentAccessSolutionIntrinsicLockCounterUsage c = new ConcurrentAccessSolutionIntrinsicLockCounterUsage();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}
}
class ConcurrentAccessSolutionIntrinsicLockCounter {
	static long count = 0;
}

class ConcurrentAccessSolutionIntrinsicLockCounterUsage implements Runnable {
	public void increment() {
		synchronized(this){
			ConcurrentAccessSolutionIntrinsicLockCounter.count++;
			System.out.print(ConcurrentAccessSolutionIntrinsicLockCounter.count + " ");
		}
	}

	public void run() {
		increment();
		increment();
		increment();
	}
}

