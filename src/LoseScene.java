import javax.swing.*;
import java.awt.*;

class LoseScene extends JPanel implements Runnable
{ // Start of LoseScene class, extends JPanel class, implements Runnable class
    public Color background_colour = null; // Variable that will store the background colour
    public int width = 0; // Variable that will store the width of the frame
    public int height = 0; // Variable that will store the height of the frame
    public java.awt.Rectangle playAgainButton = new java.awt.Rectangle(220, 250, 200 , 50); // Rectangle that will draw the playAgainButton
    public java.awt.Rectangle mainMenuButton = new java.awt.Rectangle(220, 400, 200 , 50); // Rectangle that will draw the mainMenuButton
    public java.awt.Rectangle exitButton = new java.awt.Rectangle(220, 550, 200 , 50); // Rectangle that will draw the exitButton

    public LoseScene(JFrame parentFrame, int width, int height) // Takes in parentFrame, width, and height as parameters
    { // Start of LoseScene constructor
        super(); // Inherits all JPanel classes
        this.width = width; // Sets the width variable in the class to the width passed in the parameters
        this.height = height; // Sets the height variable in the class to the height passed in the parameters
        this.background_colour = Color.black; // Sets the background colour to black
        this.setBackground(this.background_colour); // Set the background to the background_colour variable

        parentFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the program when the user presses the x at the top right
        parentFrame.setSize(670, 670); // Sets the parentFrame size to 670 px by 670 px

        parentFrame.addMouseListener(new MouseInput()); // Add a Mouse Listener to the parentFrame
    } // End of LoseScene constructor

    @Override
    protected void paintComponent(Graphics g) // Takes in g as a parameter
    { // Start of paintComponent method
        super.paintComponent(g); // Inherit the paintComponent method, pass g as parameter
        Graphics2D g2d = (Graphics2D) g; // Create a new Graphics2D variable, will use to output the rectangles

        Font fnt0 = new Font("arial", Font.BOLD, 50); // Create a new font for the title at the top
        g.setFont(fnt0); // Set the font of Graphics g to fnt0
        g.setColor(Color.green); // Set the color of Graphics g to green
        g.drawString("You Lose!", 200, 115); // Draw the title at the top of the frame

        Font fnt1 = new Font("arial", Font.BOLD, 30); // Make a new Font called fnt1, will use for button text
        g.setFont(fnt1); // Set the font of Graphics g to fnt1
        g.setColor(Color.white); // Set the color of Graphics g to white
        g.drawString("Play Again", playAgainButton.x + 25, playAgainButton.y + 34); // Draws "Play Again" on top of the play again button
        g.drawString("Main Menu", mainMenuButton.x + 25, mainMenuButton.y + 34); // Draws "Main Menu" on top of the main menu button
        g.drawString("Exit", exitButton.x + 72, exitButton.y + 35); // Draws "Exit" on top of the exit button

        Font fnt2 = new Font("arial", Font.BOLD, 20);
        g.setFont(fnt2);
        g.setColor(Color.white);

        if(StateManager.previousState == StateManager.STATE.EASYGAME)
        { // Start of true branch
            g.drawString("Easy High Score: " + SnakeBoard.easy_high_score, 230, 200); // Draw the Easy High Score in the specified area
        } // End of true branch
        else if(StateManager.previousState == StateManager.STATE.MEDIUMGAME)
        { // Start of true branch
            g.drawString("Medium High Score: " + SnakeBoard.medium_high_score, 215, 200); // Draw the Medium High Score in the specified area
        } // End of true branch
        else if(StateManager.previousState == StateManager.STATE.HARDGAME)
        { // Start of true branch
            g.drawString("Hard High Score: " + SnakeBoard.hard_high_score, 230, 200); // Draw the Hard High Score in the specified area
        } // End of true branch

        g2d.draw(playAgainButton); // Draws the play again button
        g2d.draw(mainMenuButton); // Draws the main menu button
        g2d.draw(exitButton); // Draws the exit button
    } // End of paintComponent method

    @Override
    public void run()
    { // Start of run method
    } // End of run method
} // End of LoseScene class