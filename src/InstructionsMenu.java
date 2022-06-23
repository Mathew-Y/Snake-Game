import javax.swing.*;
import java.awt.*;

class InstructionsMenu extends JPanel implements Runnable
{ // Start of InstructionsMenu class, extends JPanel class, implements Runnable class
    public Color background_colour = null; // Variable that will store the background color
    public int width = 0; // Variable that will store the width of the parentFrame
    public int height = 0; // Variable that will store the height of the parentFrame
    public java.awt.Rectangle backButton = new java.awt.Rectangle(220, 500, 200, 50); // Rectangle that will be the backButton

    public InstructionsMenu(JFrame parentFrame, int width, int height) // Takes in parentFrame, width, and height as parameters
    { // Start of InstructionsMenu constructor
        super(); // Inherit classes from JPanel
        this.width = width; // Set the width from the class to the width passed in the parameters
        this.height = height; // Set the height from the class to the height passed in the parameters
        this.background_colour = Color.black; // Set the background_colour variable to black
        this.setBackground(this.background_colour); // Set the background to the background_colour colour
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the parentFrame close upon clicking the x button
        parentFrame.setSize(670, 670); // Set the size of the parentFrame to 670 px by 670 px

        parentFrame.addMouseListener(new MouseInput()); // Add a MouseListener to the parentFrame
    } // End of InstructionsMenu constructor

    @Override
    protected void paintComponent(Graphics g) // Takes in g as parameter
    { // Start of paintComponent method
        super.paintComponent(g); // Inherit the paintComponent method, pass g as parameter
        Graphics2D g2d = (Graphics2D) g; // Create a new Graphics2D variable, will use to output the rectangles

        Font fnt0 = new Font("arial", Font.BOLD, 50); // Create a new font for the title at the top
        g.setFont(fnt0); // Set the font of Graphics g to fnt0
        g.setColor(Color.green); // Set the color of Graphics g to green
        g.drawString("Instructions", 180, 115); // Draw the title at the top of the frame

        Font fnt1 = new Font("arial", Font.BOLD, 30); // Make a new Font called fnt1, will use for button text
        g.setFont(fnt1); // Set the font of Graphics g to fnt1
        g.setColor(Color.white); // Set the color of Graphics g to white
        g.drawString("Back", backButton.x + 65, backButton.y + 34); // Draw Back on top of the back button
        Font fnt2 = new Font("arial", Font.PLAIN, 20);
        g.setFont(fnt2);
        g.drawString("Welcome to the Snake Game! In order to play, you must click the play", 25, 200);
        g.drawString("button in the main menu and select your desired difficulty. To control", 35, 250);
        g.drawString("the snake, you must use the arrow keys located on the bottom right", 35, 300);
        g.drawString("hand of your keyboard. You must collect the red apples to grow your", 35, 350);
        g.drawString("snake and reach the highest score possible. If you run into a wall,", 50, 400);
        g.drawString("your own body or the outer boundaries, you lose the game. Good luck!", 30, 450);

        g2d.draw(backButton); // Draw the backButton
    } // End of paintComponent method

    @Override
    public void run()
    { // Start of run method
    } // End of run method
} // End of InstructionsMenu class