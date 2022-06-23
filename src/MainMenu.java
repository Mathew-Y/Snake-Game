import javax.swing.*;
import java.awt.*;

class MainMenu extends JPanel implements Runnable
{ // Start of MainMenu class, extends JPanel class, implements Runnable class
    public Color background_colour = null; // Variable that will store the background color
    public int width = 0; // Variable that will store the width of main menu frame
    public int height = 0; // Variable that will store the height of main menu frame
    public java.awt.Rectangle playButton = new java.awt.Rectangle(220, 200, 200 , 50); // Rectangle that will display the play button
    public java.awt.Rectangle instructionsButton = new java.awt.Rectangle(220, 350, 200 , 50); // Rectangle that will display the Instructions button
    public java.awt.Rectangle exitButton = new java.awt.Rectangle(220, 500, 200 , 50); // Rectangle that will display the exit button

    public MainMenu(JFrame parentFrame, int width, int height) // Takes in the parentFrame, width, and height as parameters
    { // Start of MainMenu constructor
        super(); // Inherit from JPanel class
        this.width = width; // Set the width in this class to the width given through the parameters
        this.height = height; // Set the height in this class to the height given through the parameters
        this.background_colour = Color.BLACK; // Set the background color to black
        this.setBackground(this.background_colour); // set the background of the parentFrame to the background color
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the parentFrame close upon clicking the x button
        parentFrame.setSize(670, 670); // Set the size of the parentFrame to 670 px by 670 px

        parentFrame.addMouseListener(new MouseInput()); // Add a MouseListener to the parentFrame
    } // End of MainMenu constructor

    @Override
    protected void paintComponent(Graphics g) // Takes in g as a parameter
    { // Start of paintComponent method
        super.paintComponent(g); // Inherit the paintComponent method, pass g as parameter
        Graphics2D g2d = (Graphics2D) g; // Create a new Graphics2D variable, will use to output the rectangles

        Font fnt0 = new Font("arial", Font.BOLD, 50); // Create a new font for the title at the top
        g.setFont(fnt0); // Set the font of Graphics g to fnt0
        g.setColor(Color.green); // Set the color of Graphics g to green
        g.drawString("Snake Game", 180, 115); // Draw the title at the top of the frame

        Font fnt1 = new Font("arial", Font.BOLD, 30); // Make a new Font called fnt1, will use for button text
        g.setFont(fnt1); // Set the font of Graphics g to fnt1
        g.setColor(Color.white); // Set the color of Graphics g to white
        g.drawString("Play", playButton.x + 70, playButton.y + 34); // Draw play on top of the play button
        g.drawString("Instructions", instructionsButton.x + 15, instructionsButton.y + 34); // Draw instructions on top of the instructions button
        g.drawString("Exit", exitButton.x + 70, exitButton.y + 35); // Draw Exit on top of the exit button

        g2d.draw(playButton); // draw the play button
        g2d.draw(instructionsButton); // draw the instructions button
        g2d.draw(exitButton); // draw the exit button
    } // End of paintComponent method

    @Override
    public void run()
    { // Start of run method
    } // End of run method
} // End of MainMenu class