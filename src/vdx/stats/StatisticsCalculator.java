package vdx.stats;

import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 
 * @author sanjyoth
 * StatisticsCalculator: Main driver class to test the methods of StatisticsImpl
 *
 */

public class StatisticsCalculator {

	/*
	 * Increase this number if you want to check the output  for  longer time. 
	 * RUN_TIME 10 is going to run this program for 10 seconds
	 */
	static int RUN_TIME = 10;
	
	public static void main(String[] args) {
		Statistics sc = new StatisticsImpl();
		System.out.println("Starting at time:" + StatisticsImpl.START_TIME);

		/*
		 * The critical 4 tasks will be run in parallel  using executors
		 */
		ExecutorService eventExecutors = Executors.newFixedThreadPool(3);
		ExecutorService meanExecutors = Executors.newFixedThreadPool(2);
		ExecutorService meanNExecutors = Executors.newFixedThreadPool(2);
		ExecutorService varianceExecutors = Executors.newFixedThreadPool(2);

		int diff = 0;

		Runnable eventTask = () -> {
			
			while(true) {
				Random random = new Random();
				sc.event(random.nextInt(100));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(" CurrentTime: " + Calendar.getInstance().get(Calendar.SECOND) + " StartTime: "
						+ StatisticsImpl.START_TIME);
			}
			
		};

		Runnable meanTask = () -> {
			while(true) {
				System.out.println("Mean at " + Calendar.getInstance().get(Calendar.SECOND) + " is " + sc.mean());
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};

		Runnable meanNTask = () -> {
			while(true) {
				int randTime = new Random().nextInt(10);
				System.out.println("Mean at N " + randTime + " is " + sc.mean(randTime));
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};

		Runnable varianceTask = () -> {
			while(true) {
				System.out.println("Variance at " + Calendar.getInstance().get(Calendar.SECOND) + " is " + sc.variance());
				System.out.println("Minimum:" + sc.minimum() + " Maximum:" + sc.maximum());
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};

		while (diff < RUN_TIME) {
			eventExecutors.submit(eventTask);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			meanExecutors.submit(meanTask);
			meanNExecutors.submit(meanNTask);
			varianceExecutors.submit(varianceTask);
			System.out.println("Thread Counts: event:" + ((ThreadPoolExecutor)eventExecutors).getActiveCount() + " mean: " 
					+ ((ThreadPoolExecutor)meanExecutors).getActiveCount() + " meanN: " + ((ThreadPoolExecutor)meanNExecutors).getActiveCount() 
					+ " variance:" + ((ThreadPoolExecutor)varianceExecutors).getActiveCount());
			diff = Math.abs(Calendar.getInstance().get(Calendar.SECOND) - StatisticsImpl.START_TIME);
		}

		System.out.println("Shutting down threads");
		eventExecutors.shutdown();
		meanExecutors.shutdown();
		meanNExecutors.shutdown();
		varianceExecutors.shutdown();
		System.out.println("About to close the program..");
		System.exit(0);
	}
}
