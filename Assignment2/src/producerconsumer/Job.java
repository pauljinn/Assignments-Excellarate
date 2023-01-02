package producerconsumer;
/**
 * A POJO class to store the info regarding job.
 * @author amans
 *
 */
public class Job {
	private int jobId;

	public Job(int jobId) {
		super();
		this.jobId = jobId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}	
}
