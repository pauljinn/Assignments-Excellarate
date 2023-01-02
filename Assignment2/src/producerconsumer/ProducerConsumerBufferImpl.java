package producerconsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ***** IMPLEMENTATION PRODUCER CONSUMER BUFFER********** 
 * This is our implementation class of a thread safe generic buffer 
 * for Producer-Consumer Problem.
 * 
 * @author amans
 *
 */
public class ProducerConsumerBufferImpl<E> {
	private Queue<E> buffer;
	final int MAX_SIZE = 10;
	/**
	 * Creating a Reentrant lock instance. They allows a thread to access a shared
	 * resource more than once. By acquiring a lock and blocking other thread from
	 * accessing that resource until the locking acquiring thread releases the lock.
	 */
	private ReentrantLock lock;
	
	/**
	 * Creating two condition for not empty and full buffer.
	 * Can also use simple plain Object here as well.
	 */
	private Condition notEmpty;
	private Condition notFull;

	public ProducerConsumerBufferImpl() {
		super();
		this.buffer = new LinkedList<>();
		// Fair attribute is set to true so that the threads are given access
		// to shared resource in order of which they send the lock request to
		// access the shared resource.
		lock = new ReentrantLock(true);
		notEmpty = lock.newCondition();
		notFull = lock.newCondition();
	}

	/**
	 * A method to add the produced item to the buffer.
	 * 
	 * @param e
	 */
	public void put(E e) {
		// Acquiring a lock so that only one producer could access this block.
		lock.lock();
		try {
			while (buffer.size() == MAX_SIZE) {
				System.out.println("Waiting for the queue to have space to accomodate the produced item");
				//It's used for the purpose of understanding the console output.
				Thread.sleep(1000);
				/**
				 * If simple plain object is used in place of condition then
				 * we have to use conventional wait() method here and
				 * notifyAll() in place of signalAll() below.
				 */
				notFull.await();
			}
			buffer.add(e);
			/**
			 * If an item is add to the buffer then it's sure that queue is not empty.
			 * Therefore, Signaling all the consumer threads waiting for the queue to be not
			 * empty to consume next item..
			 */
			notEmpty.signalAll();
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			//Releasing the lock.
			lock.unlock();
		}
	}

	/**
	 * A method to get the item from the buffer.
	 * 
	 * @return the item.
	 */
	public E get() {
		// Acquiring a lock so that only one consumer could access this block.
		lock.lock();
		E item = null;
		try {
			// If buffer is empty then waiting until it is not empty.
			while (buffer.size() == 0) {
				System.out.println("Waiting for the queue to have something to consume");
				Thread.sleep(1000);
				/**
				 * If simple plain object is used in place of condition then
				 * we have to use conventional wait() method here and
				 * notifyAll() in place of signalAll() below.
				 */
				notEmpty.await();
			}
			// If buffer is not empty then fetching the item.
			item = buffer.poll();
			/**
			 * If an item is fetched from the buffer then it's sure that queue is not full.
			 * Therefore, Signaling all the producer threads waiting for the queue to be not
			 * full to produce next item.
			 */
			notFull.signalAll();
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			//Releasing the lock.
			lock.unlock();
		}
		return item;
	}
	
	/**
	 * Returns the size of buffer.
	 * @return
	 */
	public int getSize() {
		return this.buffer.size();
	}

}
