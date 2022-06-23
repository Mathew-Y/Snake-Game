import java.awt.*;

class Rectangle extends GameObject
{ // Start of Rectangle class, extends GameObject class (Inheritance)

    private int width = 0; // Variable that will store the width of the Rectangle
    private int height = 0; // Variable that will store the height of the Rectangle

    public Rectangle(int x, int y, Color c, int width, int height) // Takes in x, y, c, width, and height as parameters
    { // Start of Rectangle constructor
        super(x, y, c); // Inherit the x, y, and c variables from GameObject
        this.width = width; // Set our class variable width to the parameter passed in as width
        this.height = height; // Set our class variable height to the parameter passed in as height
    }

    public int getWidth()
    { // Start of getWidth method
        return width; // Return width to all classes using Rectangle class
    } // End of getWidth method

    public int getHeight()
    { // Start of getHeight method
        return height; // Return height to all classes using Rectangle class
    } // End of getHeight method

    public void draw(Graphics g) // Take in g as parameter
    { // Start of draw method
        g.setColor(this.getColor()); // set the color of g to the colour used in this class
        g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight()); // fill the Rectangle of the specified parameters
    } // End of draw method
} // End of Rectangle class