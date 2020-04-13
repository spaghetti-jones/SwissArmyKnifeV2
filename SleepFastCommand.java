import java.util.ArrayList;

class OneSecondFastSleeper extends Thread {
    private int sleepingUnit;

    public void run() {
        sleepCommand();
    }

    OneSecondFastSleeper(int unitIn) {
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

public class SleepFastCommand {
    public static void main(String[] args) {

        OneSecondFastSleeper first = new OneSecondFastSleeper(0);
        OneSecondFastSleeper second = new OneSecondFastSleeper(1);

        System.out.println("\nNow executing Threaded Sleep...");
        long startExecuting = System.nanoTime();
        first.start();
        second.start();

        try {
            first.join();
            second.join();
        } catch(Exception e) {}
        long finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        System.out.println("\nNow executing non-threaded Sleep...");
        startExecuting = System.nanoTime();
        first.sleepCommand();;
        second.sleepCommand();
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        ArrayList<OneSecondFastSleeper> list = new ArrayList<OneSecondFastSleeper>();
        for (int i=0; i<10; i++) {
            list.add(new OneSecondFastSleeper(i));
        }

        System.out.println("\nNow Executing Threaded ArrayList sleep...");
        startExecuting = System.nanoTime();
        for (OneSecondFastSleeper sleeper: list) {
            sleeper.start();
        }

        try {
            for (OneSecondFastSleeper sleeper: list) {
                sleeper.join();
            }
        } catch (Exception e) {}
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");

        System.out.println("\nNow executing Non-threaded ArrayList sleep...");
        startExecuting = System.nanoTime();
        for (OneSecondFastSleeper sleeper: list) {
            sleeper.sleepCommand();
        }
        finishExecuting = System.nanoTime();
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");
    }
}
