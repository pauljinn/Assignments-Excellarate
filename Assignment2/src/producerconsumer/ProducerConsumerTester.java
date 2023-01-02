package producerconsumer;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A test class to produce and consume numbers.
 * @author amans
 *
 */
public class ProducerConsumerTester {
	private static int jobId = 1;
	
	public static void main(String[] args) throws InterruptedException {
		//Creating a thread safe buffer for producing and consuming number.
		ProducerConsumerBufferImpl<Job> queue = new ProducerConsumerBufferImpl<>();
		
		//Creating a producer which producer random integer.
		Runnable producer = ()->{
			while(true) {
				//Calling our utility to produce a Job.
				Job job = produceJob();
				System.out.println("Job" + job.getJobId() + " in progress...");
				queue.put(job);
			}
		};
		
		//Starting one producer threads.
		new Thread(producer).start();
		
		//Creating a consumer which consumer numbers.
		Runnable consumer = ()->{
			while(true) {
				Job job = queue.get();
				System.out.println("Job" + job.getJobId() + " completed");
			}
		};
		
		//Starting one consumer threads.
		new Thread(consumer).start();
		
		Thread.sleep(5000);

	}
	
	/**
	 * A utility function to create Job with job ID.
	 * @return
	 */
	public static Job produceJob() {
		Job job = new Job(jobId++);
		return job;
	}

}
