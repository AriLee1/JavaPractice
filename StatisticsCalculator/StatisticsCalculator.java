import java.util.Scanner;

public class StatisticsCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        boolean done = false;
        int[] numbers = new int[100];
        int count = 0;

        System.out.println("Enter positive integers, one per line. Press enter to finish.");

        do {
            System.out.print(">");
            input = sc.nextLine().trim();

            if (input.isEmpty()) {
                done = true;
            } else {
                try {
                    // 숫자 입력
                    int num = Integer.parseInt(input);
                    if (num > 0) {
                        // positive integers store
                        numbers[count++] = num;
                    } else {
                        System.out.println("Invalid input. Please enter a positive integer.");
                    }
                } catch (NumberFormatException err) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                }
            }
        } while (!done);

        sc.close();

        if (count == 0) {
            System.out.println("No valid numbers entered. No statistics to display.");
            return;
        }

        // valid entreies
        if (count > 0) {

            // calculate
            int min = numbers[0];
            int max = numbers[0];
            int sum = 0;

            for (int i = 0; i < count; i++) {
                if (numbers[i] < min)
                    min = numbers[i];
                if (numbers[i] > max)
                    max = numbers[i];
                sum += numbers[i];
            }

            double average = (double) sum / count;

            System.out.printf("Minimum value: %d\nMaximum value: %d\nAverage value: %.2f ", min, max, average);
            System.out.printf("\nFor valid entries:");
            for (int i = 0; i < count; i++) {
                System.out.print(numbers[i]);
                if (i < count - 1) {
                    System.out.print(", ");
                }
            }
        }
    }

}
