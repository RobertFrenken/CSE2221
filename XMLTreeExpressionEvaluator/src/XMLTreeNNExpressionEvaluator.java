import components.naturalnumber.NaturalNumber;
import components.naturalnumber.NaturalNumber2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;
import components.utilities.Reporter;
import components.xmltree.XMLTree;
import components.xmltree.XMLTree1;

/**
 * Program to evaluate XMLTree expressions of {@code int}.
 *
 * @author Robert Frenken
 *
 */
public final class XMLTreeNNExpressionEvaluator {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private XMLTreeNNExpressionEvaluator() {
    }

    /**
     * Evaluate the given expression.
     *
     * @param exp
     *            the {@code XMLTree} representing the expression
     * @return the value of the expression
     * @requires <pre>
     * [exp is a subtree of a well-formed XML arithmetic expression]  and
     *  [the label of the root of exp is not "expression"]
     * [There isn't a subtraction operation where the resultant is less than zero]
     * [There isn't a division operation where the divider is zero]
     * </pre>
     *
     * @ensures evaluate = [the value of the expression]
     */
    private static NaturalNumber evaluate(XMLTree exp) {
        NaturalNumber num = new NaturalNumber2(0);
        // base case
        if (exp.label().equals("number")) {
            String val = exp.attributeValue("value");
            num.setFromString(val);

        } else {
            NaturalNumber first = num.newInstance();
            NaturalNumber second = num.newInstance();
            if (exp.numberOfChildren() > 1) {
                first.copyFrom(evaluate(exp.child(0)));
                second.copyFrom(evaluate(exp.child(1)));

                // determine operation
                if (exp.label().equals("plus")) {
                    first.add(second);
                    num.transferFrom(first);
                } else if (exp.label().equals("minus")) {
                    if (first.compareTo(second) < 0) {
                        Reporter.fatalErrorToConsole(
                                "Subtraction evaluation cannot be less than zero");
                    }
                    first.subtract(second);
                    num.transferFrom(first);
                } else if (exp.label().equals("times")) {
                    first.multiply(second);
                    num.transferFrom(first);
                } else {
                    if (second.isZero()) {
                        Reporter.fatalErrorToConsole(
                                "Denominator cannot be zero");
                    }
                    first.divide(second);
                    num.transferFrom(first);
                }
            } else {
                first.copyFrom(evaluate(exp.child(0)));
                num.transferFrom(first);
            }

        }

        return num;

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

        out.print("Enter the name of an expression XML file: ");
        String file = in.nextLine();
        while (!file.equals("")) {
            XMLTree exp = new XMLTree1(file);
            out.println(evaluate(exp.child(0)));
            out.print("Enter the name of an expression XML file: ");
            file = in.nextLine();
        }

        in.close();
        out.close();
    }

}