import java.util.ArrayList;

class OneSecondRunnableSleeper implements Runnable {
    private int sleepingUnit;

    public void run() {
        sleepCommand();
    }

    OneSecondRunnableSleeper(int unitIn) {
        sleepingUnit = unitIn;
    }

    public void sleepCommand() {
        System.out.println("Put " + sleepingUnit + " to sleep");
        try {
            Thread.sleep(1000);
        } catch(Exception e) {}
        System.out.println(sleepingUnit + "...finished");
    }
}

public class SleepFastRunnableCommand {
    public static void main(String[] args) {

        OneSecondRunnableSleeper first = new OneSecondRunnableSleeper(0);
        OneSecondRunnableSleeper second = new OneSecondRunnableSleeper(1);

        System.out.println("\nNow executing non-threaded Sleep...");
        long startExecuting = System.nanoTime();
        first.sleepCommand();
        second.sleepCommand();
        long finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        System.out.println("\nThreaded Sleep");
        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        startExecuting = System.nanoTime();
        firstThread.start();
        secondThread.start();

        try {
            firstThread.join();
            secondThread.join();
        } catch(Exception e) {}
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        ArrayList<OneSecondRunnableSleeper> list = new ArrayList<OneSecondRunnableSleeper>();
        for (int i=0; i<10; i++) {
            list.add(new OneSecondRunnableSleeper(i));
        }

        System.out.println("\nNon-threaded ArrayList sleep:");
        startExecuting = System.nanoTime();
        for (OneSecondRunnableSleeper sleeper: list) {
            sleeper.sleepCommand();
        }
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        System.out.println("\nThreaded ArrayList sleep:");
        ArrayList<Thread> tList = new ArrayList<Thread>();
        for (OneSecondRunnableSleeper sleeper: list) {
            tList.add(new Thread(sleeper));
        }

        startExecuting = System.nanoTime();
        for (Thread thread: tList) {
            thread.start();
        }

        try {
            for (Thread thread: tList) {
                thread.join();
            }
        } catch (Exception e) {}
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

    }
}
