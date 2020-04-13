class OneSecondSleeper {
    private int sleepingUnit;

    OneSecondSleeper(int unitIn) {
        sleepingUnit = unitIn;
    }

    public void sleepCommand() {
        System.out.println("Put " + sleepingUnit + " to sleep");
        try {
            Thread.sleep(1000);
        }catch(Exception e){}
        System.out.println(sleepingUnit + "...finished");
    }
}

public class SleepCommand {
    public static void main(String[] args) {

        OneSecondSleeper first = new OneSecondSleeper(0);
        OneSecondSleeper second = new OneSecondSleeper(1);
        System.out.println("");

        long startExecuting = System.nanoTime();
        first.sleepCommand();
        second.sleepCommand();
        long finishExecuting = System.nanoTime();
        
        System.out.println("\nFunction execution time: " + (finishExecuting - startExecuting)/1000000 + " milliseconds");
        System.out.println("");
    }
}