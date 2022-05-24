package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EXECUTOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(10);

	    executorService.execute(new Runnable() {
	        public void run() {
	            System.out.println("Asynchronous task");
	        }
	    });

	    executorService.shutdown();
	}

}
