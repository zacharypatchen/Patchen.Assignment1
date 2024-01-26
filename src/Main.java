
/**
 * The Main class contains implementations for several problems.
 */
public class Main {

    /**
     * Problem #1:
     * Given two strings, this method finds the count of matching characters at the same positions.
     *
     * @param text1 The first input string.
     * @param text2 The second input string.
     * @return The count of matching characters at the same positions.
     */
    public int problem1(String text1, String text2) {
        String longWord;
        String shortWord;

        // Determine the longer and shorter words
        if (text1.length() < text2.length()) {
            longWord = text2;
            shortWord = text1;
        } else {
            longWord = text1;
            shortWord = text2;
        }

        // Convert strings to char arrays for easy access
        char[] longWordCharArray = longWord.toCharArray();
        char[] shortWordCharArray = shortWord.toCharArray();

        int count = 0;

        // Iterate through the characters and count matches at the same positions
        for (int i = 0; i < shortWordCharArray.length; i++) {
            if (longWordCharArray[i] == shortWordCharArray[i]) {
                count++;
            }
        }

        return count;
    }

    /**
     * Problem #3:
     * Given an integer input, this method generates a sequence based on a specific rule and prints the values.
     *
     * @param input The input integer.
     */
    public void problem3(int input) {
        long[] output = new long[input];

        // Handle special cases
        if (input == 2 || input == 1) {
            System.out.println(input - 1);
        } else {
            // Initialize the sequence and print values
            output[0] = 0;
            System.out.println(0);
            output[1] = 1;
            System.out.println(1);
            for (int i = 2; i < input; i++) {
                output[i] = (3 * output[i - 2]) + (2 * output[i - 1]);
                System.out.println(output[i]);
            }
        }
    }

    /**
     * Problem #4:
     * Given an integer input, this method calculates the position of the input in a specific sequence.
     *
     * @param input The input integer.
     * @return The position of the input in the sequence.
     */
    public int problem4(int input) {
        long first = 0;
        long second = 1;
        long current = 0;
        int position = 3;

        // Handle special case
        if (input == 0) {
            System.out.println(1);
        }

        // Find the position of the input in the sequence
        while (current < input) {
            current = (3 * first) + (2 * second);

            if (current == input) {
                return position;
            } else if (current > input) {
                return position - 1;
            }

            position++;
            first = second;
            second = current;
        }

        return position;
    }

    /**
     * Problem #5:
     * Given an array of integers and a target value, this method removes occurrences of the target value in the array.
     *
     * @param nums The input array of integers.
     * @param val  The target value to be removed.
     * @return The new length of the array after removal.
     */
    public int problem5(int[] nums, int val) {
        int output = 0;

        // Iterate through the array and remove occurrences of the target value
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[output++] = nums[i];
            }
        }

        return output;
    }
    /**
     * Main method for testing the implemented problems.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        Main m = new Main();
        System.out.println("***************************************************************");
        String p1t1Input = "zzxzzi";
        String p1t2Input = "zxxxsi";
        System.out.println("Promblem #1 input: " + p1t1Input + " and "+p1t2Input);
        System.out.println("Promblem #1 output: " + m.problem1("zzxzzi", "zxxxsi"));
        System.out.println("***************************************************************");
        int p3Input = 10;
        System.out.println("Promblem #3 input: " + p3Input);
        System.out.println("Promblem #3 output: ");
        m.problem3(p3Input);
        System.out.println("***************************************************************");
        int p4Input = 8;
        System.out.println("Promblem #4 input: " + p4Input);
        System.out.println("Promblem #4 output: " + m.problem4(p4Input));
        System.out.println("***************************************************************");
        int p5Input = 2;
        int[] p5InputArray = {0,1,2,2,3,0,4,2};
        System.out.println("Promblem #5 input: " + p4Input);
        System.out.println("Promblem #5 output: " + m.problem5(p5InputArray, p5Input));
        System.out.println("***************************************************************");
    }
}