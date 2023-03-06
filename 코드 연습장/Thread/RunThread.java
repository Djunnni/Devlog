public class RunThread {
	public static void main(String[] args) {
		RunThread threads = new RunThread();
		// threads.runBasic();
		threads.runMultiThread();
	}
	public void runBasic() {

		ThreadSample thread = new ThreadSample();
		thread.start();
		RunnableSample runnable = new RunnableSample();
		new Thread(runnable).start();

		System.out.println("RunThreads.runBasic method is ended");
	}

	public void runMultiThread() {
		RunnableSample[] runnable = new RunnableSample[5];
		ThreadSample[] thread = new ThreadSample[5];

		for(int i = 0; i < 5; i++) {
			runnable[i] = new RunnableSample();
			thread[i] = new ThreadSample();

			new Thread(runnable[i]).start();
			thread[i].start();
		}
		System.out.println("RunMultiThread.runMultiThread() method is ended");
	}
}
