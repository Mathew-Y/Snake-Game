class Calculations
{ // Start of Calculations class

    /**
     * This method will take a number and factor and round the number to the
     *  closest multiple of that factor. For example, if number=351 and factor=5,
     *  the returned value must be 350. If number=63 and factor=2, choose either 62
     *  or 64.43
     */

    public static int roundClosestPixel(int number, int factor)
    { // Start of roundClosestPixel method
        int r = number % factor; // r will represent the remainder after calculating the number modulo the factor

        /*
        For example, If you have a number of 652 and a factor of 5, the floor will be 350 and 355 will be the cieling
         */
        int difFromCiel = factor - r; // Set the difference from the cieling to the factor minus the remainder
        int difFromFloor = r; // Set the difference from the floor to the remainder

        if (difFromCiel > difFromFloor) // Will return if the number is closer to the floor
        { // Start of true branch
            return number - r; // Return the number minus the remainder (new number after rounding down)
        } // End of true branch

        return number + difFromCiel; // Will return if the number is closer to the cieling
    } // End of roundClosestPixel method
} // End of Calculations class