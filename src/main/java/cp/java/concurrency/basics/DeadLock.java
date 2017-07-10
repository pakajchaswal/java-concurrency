package cp.java.concurrency.basics;

public class DeadLock {
	public static void main(String[] args) {
		TransferCounter c = new TransferCounter();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();
	}
}

class Jar {
	public static int count = 10;
}

class Beaker {
	public static int count = 0;
}

class TransferCounter implements Runnable {

	Object jar = new Object();
	Object beaker = new Object();

	private void incrementBeakerCount() {
		System.out.println(Thread.currentThread().getName() + " waiting for beaker resources");
		synchronized (beaker) {
			synchronized (jar) {
				Beaker.count++;
				Jar.count--;
				System.out.println("Beaker count :" + Beaker.count);
			}
		}
	}

	private void decrementJarCount() {
		System.out.println(Thread.currentThread().getName() + " waiting for jar resources");
		synchronized (beaker) {
			synchronized (jar) {
				Jar.count--;
				Beaker.count++;
				System.out.println("Jar count :" + Jar.count);
			}
		}
	}

	@Override
	public void run() {
		while (true) {
			incrementBeakerCount();
			decrementJarCount();
		}
	}

}