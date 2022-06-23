import java.awt.*;
import java.util.ArrayList;

class Apple extends Rectangle
{ // Start of Apple class, extends Rectangle (Inheritance)

    private int max_height = 0; // Variable that will store the max_height of the board
    private int max_width = 0; // Variable that will store the max_width of the board
    private int square_width = 0; // Variable that will store the width of the square

    public Apple(int width, int height, int max_height, int max_width, int square_width)
    { // Start of Apple constructor
        super(50, 50, Color.red, width, height); // Inherit x, y, c, width, and height from the Rectangle class
        this.max_height = max_height; // Set the max_height in this class to the max_height passed in the parameters
        this.max_width = max_width; // Set the max_width in this class to the max_width passed in the parameters
        this.square_width = square_width; // Set the square_width in this class to the square_width passed in the parameters
    } // End of Apple constructor

    public void generateNewCoordinates(ArrayList<Rectangle> walls) // Takes an ArrayList of Rectangles as a parameter to make sure it isn't generating a coordinate in which a rectangle is occupying
    { // Start of generateNewCoordinates method
        int newX = 0; // Variable that will store the new x coordinate of the Apple
        int newY = 0; // Variable that will store the new y coordinate of the Apple
        while(true)
        { // Start of while loop
            newX = (int) Math.ceil(Math.random() * (this.max_width - this.square_width)); // set newX to a random number from 0-1, multiplied by the max width subtracted by the width of the square, then this number will be casted to an int
            newY = (int) Math.ceil(Math.random() * (this.max_height - this.square_width)); // set newY to a random number from 0-1, multiplied by the max height subtracted by the width of the square, then this number will be casted to an int
            newX = Calculations.roundClosestPixel(newX, this.square_width); // Round our newX using our roundClosestPixel method from the Calculations class
            newY = Calculations.roundClosestPixel(newY, this.square_width); // Round our newY using our roundClosestPixel method from the Calculations class

            boolean found_collision = false; // Set foundCollision to false to indicate that there was no collision between the Apple and a rectangle

            for(Rectangle wall : walls) // For all the rectangles in the wall
            { // Start of for loop
                if(wall.getX() == newX && wall.getY() == newY) // Check if the apple is on a coordinate where there is a wall's rectangle
                    found_collision = true; // Set foundCollision to true to indicate that there was a collision between the Apple and a rectangle
            } // End of for loop

            if (!found_collision) // Check if there was no collision, if this evaluates to false, the while loop will run again and generate new coordinates
                break; // Break out of while loop, no need to generate new coordinates

        } // End of while loop

        this.setX(newX); // Generate a newX
        this.setY(newY); // Generate a newY
    } // End of generateNewCoordinates method
} // End of Apple class