package com.demo;

/**
 * <p>
 * <b> TODO : Insert description of the class's responsibility/role. </b>
 * </p>
 */
public class ExceptionDemo {

    public static void main(final String[] args) {// can call only static
                                                  // methods

        if (args.length == 2) {

            System.out.println("arg0=" + args[0]);
            System.out.println("arg1=" + args[1]);// space acting as delimiter

            try {

                int num = Integer.parseInt(args[0]);
                int den = Integer.parseInt(args[1]);

                int result = divide(num, den);

                System.out.println(result);

            } catch (NumberFormatException e) {
                // TODO: handle exception
                System.out.println("Invalid input args");
            } catch (DivideException e) { // TODO: handle exception
                System.out.println("Division exception=" + e.getMessage());
            } finally {
                System.out.println("Finally");
            }
            System.out.println("Try catch finally over");


        }

        System.out.println("App over");


    }

    private static int divide(final int x, final int y) throws DivideException {// this
                                                                                // is
                                                                                // necessary
        if (y != 0) {
            return x / y;
        } else {
            throw new DivideException("The denominator is 0");
        }

    }

}
