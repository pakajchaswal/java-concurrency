package cp.java.concurrency.basics;

public class ConcurrentAccessProblem {
	public static void main(String args[]) {
		ConcurrentAccessProblemCounterUsage c = new ConcurrentAccessProblemCounterUsage();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		Thread t3 = new Thread(c);
		t1.start();
		t2.start();
		t3.start();
	}
}

class ConcurrentAccessProblemCounter {
	static long count = 0;
}

class ConcurrentAccessProblemCounterUsage implements Runnable {
	public void increment() {
		ConcurrentAccessProblemCounter.count++;
		System.out.print(ConcurrentAccessProblemCounter.count + " ");
	}

	public void run() {
		increment();
		increment();
		increment();
	}
}
