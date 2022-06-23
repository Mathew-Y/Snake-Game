import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class PlayMenu extends JPanel implements Runnable
{ // Start of PlayMenu class, extends JPanel class, implements Runable class

    public Color background_colour = null; // Variable that will store the b ackground colour
    public int width = 0; // Variable that will store the width of the frame
    public int height = 0; // Variable that will store the height of the frame
    public java.awt.Rectangle easyButton = new java.awt.Rectangle(40, 750, 270, 50); // Rectangle that will draw the easy button
    public java.awt.Rectangle mediumButton = new java.awt.Rectangle(355, 750, 270, 50); // Rectangle that will draw the medium button
    public java.awt.Rectangle hardButton = new java.awt.Rectangle(670, 750, 270, 50); // Rectangle that will draw the hard button
    public java.awt.Rectangle backButton = new java.awt.Rectangle(20, 40, 150, 50); // Rectangle that will draw the back button

    public PlayMenu(JFrame parentFrame, int width, int height) // Takes in parentFrame, width, and height as constructor
    { // Start of PlayMenu constructor
        super(); // Inherit all JPanel classes
        this.width = width; // Set the width of the class to the width passed in to the parameters
        this.height = height; // Set the height of the class to the height passed in to the parameters
        this.background_colour = Color.black; // Set the background_colour variable to black
        this.setBackground(this.background_colour); // Set the background to the background_colour variable
        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the parentFrame when user presses the x at top right
        parentFrame.setSize(670, 670); // Set the parentFrame size to 670 px by 670 px

        parentFrame.addMouseListener(new MouseInput()); // Add a MouseListener to the parentFrame

        // Start of try statement

        // Start of try statement

        // Start of try statement
    } // End of PlayMenu constructor

    @Override
    protected void paintComponent(Graphics g) // Takes g as a parameter
    { // Start of paintComponent method
        super.paintComponent(g); // Inherit the paintComponent method, pass g as parameter
        Graphics2D g2d = (Graphics2D) g; // Create a new Graphics2D variable, will use to output the rectangles

        Font fnt0 = new Font("arial", Font.BOLD, 50); // Create a new font for the title at the top
        g.setFont(fnt0); // Set the font of Graphics g to fnt0
        g.setColor(Color.green); // Set the color of Graphics g to green
        g.drawString("Choose Difficulty", 295, 190); // Draw the title at the top of the frame

        Font fnt1 = new Font("arial", Font.BOLD, 30); // Make a new Font called fnt1, will use for button text
        g.setFont(fnt1); // Set the font of Graphics g to fnt1
        g.setColor(Color.white); // Set the color of Graphics g to white

        g.drawString("EASY", easyButton.x + 90, easyButton.y + 36); // Draws the String "EASY" on top of the easyButton
        g.drawString("MEDIUM", mediumButton.x + 72, mediumButton.y + 36); // Draws the String "MEDIUM" on top of the mediumButton
        g.drawString("HARD", hardButton.x + 89, hardButton.y + 36); // Draws the String "HARD" on top of the hardButton
        g.drawString("BACK", backButton.x + 30, backButton.y + 35); // Draw the String "BACK" on top of the backButton

        Font fnt2 = new Font("arial", Font.BOLD, 20); // Make a new Font called fnt1, will use for button text
        g.setFont(fnt2); // Set the font of Graphics g to fnt1
        g.setColor(Color.white); // Set the color of Graphics g to white

        g.drawString("Easy High Score: " + SnakeBoard.easy_high_score, 85, 700); // Draw the Easy High Score in the specified area
        g.drawString("Medium High Score: " + SnakeBoard.medium_high_score, 390, 700); // Draw the Medium High Score in the specified area
        g.drawString("Hard High Score: " + SnakeBoard.hard_high_score, 715, 700); // Draw the Hard High Score in the specified area


        g2d.draw(easyButton); // Drawing the easyButton
        g2d.draw(mediumButton); // Drawing the mediumButton
        g2d.draw(hardButton); // Drawing the hardButton
        g2d.draw(backButton); // Drawing the backButton
    } // End of paintComponent method

    @Override
    public void run()
    { // Start of run method
    } // End of run method
} // End of PlayMenu class