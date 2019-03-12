import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
  
	public static void main(String args[]) throws InterruptedException, BrokenBarrierException {
			
		Runnable barrierAction2 = new Runnable() {

			@Override
			public void run() {
				System.out.println("Barrier Action 2");
				
				CyclicBarrier barrier = new CyclicBarrier(1);	
				
				ThreadSample p1 = new ThreadSample(barrier, "1");
				ThreadSample p2 = new ThreadSample(barrier, "2");
				ThreadSample p3 = new ThreadSample(barrier, "3");
				
				p1.start();
				p2.start();
				p3.start();
			}
		};

		
		Runnable barrierAction1 = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Barrier Action 1");
				
				CyclicBarrier barrier = new CyclicBarrier(1, barrierAction2);		
				
				ThreadSample p4 = new ThreadSample(barrier, "4");
				p4.start();	
			}
		};
		
		
		CyclicBarrier barrier = new CyclicBarrier(3, barrierAction1);
		
		ThreadSample p5 = new ThreadSample(barrier, "5");
		ThreadSample p6 = new ThreadSample(barrier, "6");
		ThreadSample p7 = new ThreadSample(barrier, "7");		
		
		p5.start();
		p6.start();
		p7.start();			
	}
     
}