import java.awt.*;

class SnakeBox extends Rectangle
{ // Start of SnakeBox class, extends Rectangle class (Inheritance)

    private int previousX = 0; // Variable that will store the X value of any part of the snake in the last frame
    private int previousY = 0; // Variable that will store the y value of any part of the snake in the last frame

    public SnakeBox(int x, int y, Color c, int width, int height)
    { // Start of SnakeBox constructor
        super(x, y, c, width, height); // Inherit the x, y, c, width, and height from the Rectangle class
        this.previousX = x; // Set our previousX variable to the x passed in the parameters
        this.previousY = y; // Set our previousY variable to the y passed in the parameters
    } // End of SnakeBox constructor

    public void setX(int x) // Takes in x as parameter
    { // Start of setX method
        this.previousX = this.getX(); // Set the previousX in this class to the x value of the SnakeBox
        super.setX(x); // Inherently set the x to the x passed in the parameters
    } // End of setX method

    public void setY(int y) // Takes in y as parameter
    { // Start of setY method
        this.previousY = this.getY(); // Set the previousY in this class to the y value of the SnakeBox
        super.setY(y); // Inherently set the y to the y passed in the parameters
    } // End of setY method


    public int getPreviousX()
    { // Start of getPreviousX method
        return this.previousX; // Return the previousX in this class to all classes using the SnakeBox
    } // End of getPreviousX method

    public int getPreviousY()
    { // Start of getPreviousY method
        return this.previousY; // Return the previousY in this class to all classes using the SnakeBox
    } // End of getPreviousY method
} // End of SnakeBox class