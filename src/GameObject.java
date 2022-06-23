import java.awt.*;

class GameObject
{ // Start of GameObject class

    private int x = 0; // Variable that will store x value of object
    private int y = 0; // Variable that will store y value of object
    private Color c = null; // Variable that will store Color of object

    public GameObject(int x, int y, Color c) // Take x, y and c as parameters
    { // Start of GameObject constructor
        this.x = x; // Set our class variable x to the parameter passed in as x
        this.y = y; // Set our class variable y to the parameter passed in as y
        this.c = c; // Set our class variable c to the parameter passed in as c
    } // End of GameObject constructor

    public int getX()
    { // Start of getX method
        return x; // Return x to the Rectangle class
    } // End of getX method

    public void setX(int x) // Take x as parameter
    { // Start of setX method
        this.x = x; // Set the variable x to the x passed in the parameters
    } // end of setX method

    public int getY()
    { // Start of getY method
        return y; // Return y to the Rectangle class
    } // End of getY method

    public void setY(int y) // Take y as parameter
    { // Start of setY method
        this.y = y; // Set the variable y to the y passed in the paramters
    } // End of setY method

    public Color getColor()
    { // Start of getColor method
        return c; // Return c to the Rectangle class
    } // End of getColor method
} // End of GameObject class
