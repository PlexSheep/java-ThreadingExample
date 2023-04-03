public class SimpleThread extends Thread {
    public static void main(String[] args){
        System.out.println("Starting Thread!");
        SimpleThread subThread = new SimpleThread();
        subThread.start();
        System.out.println("Thread was started, sleeping in main thread");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        subThread.interrupt();
        System.out.println("Ending SimpleThread.main()");
    }

    public void run() {
        boolean shouldExit = false;
        while (!shouldExit) {
            System.out.println("loo");
            try {
                Thread.sleep(500);  // 500 ms
            } catch (InterruptedException e) {
                // got some kind of interrupt, probably interrupted by the main thread running in SimpleThread.main()
                System.out.println("Got Interrupt in sub-thread.");
                return;
            }
        }
    }
}