import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * This program asks the user to enter a double value, enter calculates and
 * displays the sqrt of the entered value.
 *
 * @author Robert Frenken
 *
 */
public final class Newton4 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Computes estimate of square root of x to within relative error 0.01%.
     *
     * @param x
     *            positive number to compute square root of
     * @param relError
     *            relative error to determine the accuracy of the calculation
     * @return estimate of square root
     */
    private static double sqrt(double x, double relError) {
        double guess = x;

        // determine if the guess is zero
        if (x != 0) {
            guess = (guess + x / guess) / 2;
            // continue loop until the sqrt approx is within the stated error
            while (Math.abs(guess * guess - x) / x > relError) {
                guess = (guess + x / guess) / 2;
            }
        }
        return guess;
    }

    /**
     * Asks user to enter a double to find sqrt of.
     *
     * @param out
     *            allows program to display values and strings
     * @param in
     *            allows user to input values into program
     * @return number to find sqrt of
     */
    private static double enterGuess(SimpleWriter out, SimpleReader in) {
        out.print(
                "Please enter a double that you would like to find the sqrt to: ");
        double x = in.nextDouble();
        return x;
    }

    /**
     * Asks user if they want to play again.
     *
     * @param x
     *            number user entered
     * @return if user entered a positive or negative number
     */
    private static boolean playAgain(double x) {

        boolean playAgain;

        if (x >= 0) {
            playAgain = true;
        } else {
            playAgain = false;
        }
        return playAgain;
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        out.print("Please enter a relative error used to compute the sqrt: ");
        double relError = in.nextDouble();
        double x = enterGuess(out, in);
        double newX = sqrt(x, relError);

        if (playAgain(x)) {
            out.println("The sqrt of " + x + " is approximately: " + newX);

            while (playAgain(x)) {
                x = enterGuess(out, in);
                newX = sqrt(x, relError);
                if (playAgain(x)) {
                    out.println(
                            "The sqrt of " + x + " is approximately: " + newX);
                }
            }
        }
        out.print("Goodbye!");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
