import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.FormatChecker;

/**
 * Put a short phrase describing the program here.
 *
 * @author Put your name here
 *
 */
public final class ABCDGuesser2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private ABCDGuesser2() {
    }

    /**
     * Repeatedly asks the user for a positive real number until the user enters
     * one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number entered by the user
     */
    private static double getPositiveDouble(SimpleReader in, SimpleWriter out) {
        out.print("Please enter a significant number: ");
        String s = in.nextLine();

        while (!FormatChecker.canParseDouble(s)) {
            out.println("You must enter a double");
            out.print("Please enter a significant number: ");
            s = in.nextLine();
        }
        double number = Double.parseDouble(s);
        return number;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     * @return a positive real number not equal to 1.0 entered by the user
     */
    private static double getPositiveDoubleNotOne(SimpleReader in,
            SimpleWriter out) {
        out.print("Please enter a number not equal to 1: ");
        String s = in.nextLine();

        double number = 0;
        int counter = 0;
        while (counter == 0) {

            while (!FormatChecker.canParseDouble(s)) {
                out.println("You must enter a double not equal to 1!");
                out.print("Please enter a number not equal to 1: ");
                s = in.nextLine();
            }
            number = Double.parseDouble(s);
            if (number == 1) {
                out.println("You must enter a double not equal to 1!");
                out.print("Please enter a number not equal to 1: ");
                s = in.nextLine();
            } else {
                counter++;
            }
        }
        return number;
    }

    /**
     * Repeatedly asks the user for a positive real number not equal to 1.0
     * until the user enters one. Returns the positive real number.
     *
     * @param approxValue
     *            the calculated value
     * @param relError
     *            the relative error of the arroxValue to mew
     * @param a
     *            exponent for the first number
     * @param b
     *            exponent for the second number
     * @param c
     *            exponent for the third number
     * @param d
     *            exponent for the fourth number
     * @param in
     *            the input stream
     * @param out
     *            the output stream
     *
     */
    private static void returnAnswer(double approxValue, double relError,
            double a, double b, double c, double d, SimpleReader in,
            SimpleWriter out) {
        out.println("The approx number is: " + approxValue);
        out.print("The relative error is: ");
        out.print(relError * 100, 2, false);
        out.println("%");
        out.println("The exponents are: " + a + ", " + b + ", " + c + ", " + d);
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
        /*
         * Put your main program code here; it may call myMethod as shown
         */
        final int[] i = { -5, -4, -3, -2, -1, -1 / 2, -1 / 3, -1 / 4, 0, 1 / 4,
                1 / 3, 1 / 2, 1, 2, 3, 4, 5 };

        // ask the user for all 5 components
        double mew = getPositiveDouble(in, out);
        double w = getPositiveDoubleNotOne(in, out);
        double x = getPositiveDoubleNotOne(in, out);
        double y = getPositiveDoubleNotOne(in, out);
        double z = getPositiveDoubleNotOne(in, out);

        /*
         * initialize the first counter for the nested loop, the estimate, the
         * relError, the approxValue, and the exponents that will be printed at
         * the end
         */

        double estimate = 0;
        double relError = 100;
        double approxValue = 0;
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        /*
         * nested loop that will iterate through the array i 4 different times
         * for a total of 17^4 combinations
         */
        for (int counterW = 0; counterW < i.length; counterW++) {

            for (int counterX = 0; counterX < i.length; counterX++) {

                for (int counterY = 0; counterY < i.length; counterY++) {

                    for (int counterZ = 0; counterZ < i.length; counterZ++) {
                        estimate = Math.pow(w, i[counterW])
                                * Math.pow(x, i[counterX])
                                * Math.pow(y, i[counterY])
                                * Math.pow(z, i[counterZ]);
                        double relErrorTest = Math.abs(estimate - mew) / mew;
                        if (relErrorTest < relError) {
                            relError = relErrorTest;
                            approxValue = estimate;
                            a = i[counterW];
                            b = i[counterX];
                            c = i[counterY];
                            d = i[counterZ];
                        }

                    }

                }

            }

        }
        returnAnswer(approxValue, relError, a, b, c, d, in, out);

        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
