import java.util.Scanner;

public class Stopwatch {
    private long startTime;
    private int seconds;
    private boolean isRunning;

    // initialized
    public Stopwatch() {
        this.seconds = 0;
        this.isRunning = false;
    }

    public void start() { // strat when it's not running
        if (!isRunning) {
            startTime = System.currentTimeMillis();
            isRunning = true;
        } else {
            System.out.println("Error : Stopwatch is already running.");
        }
    }

    public void stop() { // stop when it's running
        if (isRunning) {
            seconds += (int) ((System.currentTimeMillis() - startTime) / 1000);
            isRunning = false;
        } else {
            System.out.println("Error: Stopwatch is not running.");
        }
    }

    public void reset() {
        if (!isRunning) { // initialize when it's not running
            seconds = 0;
        } else {
            System.out.println("Error : No while stopwatch is running.");
        }
    }

    public int getTime() {
        if (isRunning) { // if it's running, display current time
            return seconds + (int) ((System.currentTimeMillis() - startTime) / 1000);
        }
        return seconds;
    }

    // user's input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stopwatch sw = new Stopwatch();
        String command;

        while (true) {
            System.out.print("Command: ");
            command = sc.nextLine().trim();

            switch (command) {
                case "start":
                    sw.start();
                    break;
                case "stop":
                    sw.stop();
                    break;
                case "reset":
                    sw.reset();
                    break;
                case "time":
                    System.out.println("Elapsed time: " + sw.getTime() + "seconds");
                    break;
                case "exit":
                    sc.close();
                    return;
                default:
                    System.out.println("Error: Invalid command.");
            }
        }

    }
}
