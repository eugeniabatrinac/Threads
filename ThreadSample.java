import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class ThreadSample extends Thread {
	private int duration;
	private CyclicBarrier barrier;

	public ThreadSample(CyclicBarrier barrier, String jname) {
		super(jname);
		this.barrier = barrier;	
	}

	@Override
	public void run() {

		String threadName = Thread.currentThread().getName();
		
		switch (threadName) {
			
			case "1":
				System.out.println("1");
				break;
			case "2":
				System.out.println("2");
				break;
			case "3":
				System.out.println("3");
				break;
			case "4":
				System.out.println("4");
				break;
			case "5":
				System.out.println("5");
				break;
			case "6":
				System.out.println("6");
				break;
			case "7":
				System.out.println("7");
				break;
			
		}
		try {
			this.barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	
	}
	
}