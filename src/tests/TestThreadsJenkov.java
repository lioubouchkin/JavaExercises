package tests;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class TestThreadsJenkov {
	public static void main(String[] args) {
		/***************************************************************************/
		/* threads are created and started sequentially, but executed in a different order	*/
		/***************************************************************************/
//		System.out.println(Thread.currentThread().getName());
//		for (int i=0; i< 10; i++) {
//			new Thread("Thread "+i){
//				public void run() {
//					System.out.println(this.getName() + " running");
//				}
//			}.start();	// threads are created and started sequentially, but executed in a different order
//		}
		/***************************************************************************/
		/* critical section example	*/
		/***************************************************************************/
		TestThreadsJenkov.Counter c = new Counter();
		for (int i=0; i< 2; i++) {
			new Thread("Thread "+i){
				public void run() {
					for (int j=0;j<100000;j++) {
						c.increment();
					}
				}
			}.start();	// threads are created and started sequentially, but executed in a different order
		}
		Scanner sc = new Scanner(System.in);
		sc.next();
		System.out.println(c.count);
	}
	
	static class Counter {
//		protected AtomicLong count = new AtomicLong(0);
		protected long count = 0;
	    public void increment(){
//	    	count.incrementAndGet();
	    	++count;
	    }
	}
}
