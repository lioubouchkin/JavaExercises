package tests;

import org.w3c.dom.css.Counter;

public class TestThreads {

	static class MyThread extends Thread {
		private 
		String name;
		
		public MyThread(String n) {
			this.name = n;
		}
		
		@Override
		public void run() {
			for (int i=0; i<10; i++) {
				System.out.println(i);
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	
	static class MyThread2 extends Thread {
		private String name;
		
		public MyThread2(String n) {
			this.name = n;
		}
		
		@Override
		public void run() {
			for (int i=100; i<110; i++) {
				System.out.println(""+i);
//				try {
//					TimeUnit.SECONDS.sleep(2);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}
		}
	}
	
	public static void main(String[] args) {
//		MyThread t = new TestThreads.MyThread("numbers");
//		MyThread2 t2 = new TestThreads.MyThread2("letters");
//		t2.start();
//		t.start();
		Counter c = new TestThreads.Counter();
		Thread t1 = new TestThreads.Sequencer("T1", c);
		Thread t2 = new TestThreads.Sequencer("T2", c);
		t1.run();
		t2.run();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(c.getLv());
	}
	
	static class Sequencer extends Thread {
		private String name;
		private Counter counter;
		
		public Sequencer(String n, Counter c) {
			this.name = n;
			this.counter = c;
		}
		 @Override
		public void run() {
			 for (int i=0; i<1000000; i++) {
				 counter.inc();
			 }
		}
	}
	static class Counter {
		private int lv = 0;
		public Counter() {
		}
		private void inc() {
			this.lv++;
		}
		public int getLv(){
			return this.lv;
		}
	}
}





