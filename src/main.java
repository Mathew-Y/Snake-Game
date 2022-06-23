import java.awt.*; // Import all awt classes
import java.awt.event.*; // Import all event classes
import javax.imageio.ImageIO; // Import ImageIO class
import javax.swing.*; // Import all swing classes

import java.awt.Color; // Import Color class
import java.io.File; // Import File class
import java.io.IOException; // Import IOException class
import java.util.ArrayList; // Import ArrayList class

public class main
{ // Start of main class

    public static JFrame snake_frame = new JFrame("Snake"); // JFrame that will store the snake game frame
    public static JFrame main_menu = new JFrame("Main Menu"); // JFrame that will store the main menu frame
    public static JFrame play_menu = new JFrame("Play Menu"); // JFrame that will store the play menu frame
    public static JFrame instructions_menu = new JFrame("Instructions Menu"); // JFrame that will store the instructions menu frame
    public static JFrame lose_screen = new JFrame("You Lose!"); // JFrame that will store the lose screen frame

    public static void main(String[] args)
    { // Start of main method
        int square_width = 10; // Variable that will store the width of a square
        int height = 67 * square_width; // Variable that will store the height of the frame
        int width = 67 * square_width; // Variable that wills tore the width of the frame
        MainMenu m = new MainMenu(main_menu, width, height); // Creates a new instance of the MainMenu class called m, pass in the main_menu JFrame, the width and height
        InstructionsMenu i = new InstructionsMenu(instructions_menu, width, height); // Creates a new instance of the InstructionsMenu class called i, pass in the instructions_menu JFrame, the width and height
        PlayMenu p = new PlayMenu(play_menu, width, height); // Creates a new instance of the PlayMenu class called p, pass in the play_menu JFrame, the width and height
        LoseScene l = new LoseScene(lose_screen, width, height); // Creates a new instance of the LoseScene class called l, pass in the lose_screen JFrame, the width and height
        SnakeBoard s = new SnakeBoard(snake_frame, width, height, square_width); // Creates a new instance of the SnakeBoard class called s, pass in the snake_frame JFrame, the width and height
        Dimension frame_dimensions = new Dimension(width, height); // Creates a new instance of the Dimension class called frameDimensions, pass in the width and height
        Dimension d = new Dimension(width, height); // Creates a new instance of the Dimension class called d, pass in the width and height
        Dimension play_menu_size = new Dimension(1000, 900); // Creates a new instance of the Dimension class called play_menu_size, pass in the width of 1000 px and height of 900 px

        main_menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the main_menu close upon clicking the x button

        main_menu.getContentPane().setSize(frame_dimensions); // Set the size of the main_menu to the dimensions indicated by variable frameDimensions

        m.setSize(d); // Set the size of the MainMenu class instance to the dimensions indicated by variable d
        m.setPreferredSize(d); // Set the preferred size of the MainMenu class instance to the dimensions indicated by variable d
        m.setMaximumSize(d); // Set the maximum size of the MainMenu class instance to the dimensions indicated by variable d
        m.setMinimumSize(d); // Set the minimum size of the MainMenu class instance to the dimensions indicated by variable d

        main_menu.setResizable(false); // Make the main_menu frame not resizable

        main_menu.getContentPane().add(m); // Add the MainMenu instance to the main_menu frame
        main_menu.pack(); // Sizes the main_menu frame so that all its contents are at or above their preferred sizes

        i.setSize(d); // Set the size of the InstructionsMenu class instance to the dimensions indicated by variable d
        i.setPreferredSize(d); // Set the preferred size of the InstructionsMenu class instance to the dimensions indicated by variable d
        i.setMaximumSize(d); // Set the maximum size of the InstructionsMenu class instance to the dimensions indicated by variable d
        i.setMinimumSize(d); // Set the minimum size of the InstructionsMenu class instance to the dimensions indicated by variable d

        instructions_menu.setResizable(false); // Make the instructions_menu frame not resizable

        instructions_menu.getContentPane().add(i); // Add the InstructionsMenu instance to the instructions_menu frame
        instructions_menu.pack(); // Sizes the instructions_menu frame so that all its contents are at or above their preferred sizes

        p.setSize(play_menu_size); // Set the size of the PlayMenu class instance to the dimensions indicated by variable play_menu_size
        p.setPreferredSize(play_menu_size); // Set the preferred size of the PlayMenu class instance to the dimensions indicated by variable play_menu_size
        p.setMaximumSize(play_menu_size); // Set the maximum size of the PlayMenu class instance to the dimensions indicated by variable play_menu_size
        p.setMinimumSize(play_menu_size); // Set the minimum size of the PlayMenu class instance to the dimensions indicated by variable play_menu_size

        play_menu.setResizable(false); // Make the play_menu frame not resizable

        play_menu.getContentPane().add(p); // Add the PlayMenu instance to the play_menu frame
        play_menu.pack(); // Sizes the play_menu frame so that all its contents are at or above their preferred sizes

        snake_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // make the snake_frame close upon clicking the x button

        s.setSize(d); // Set the size of the SnakeBoard class instance to the dimensions indicated by variable d
        s.setPreferredSize(d); // Set the preferred size of the SnakeBoard class instance to the dimensions indicated by variable d
        s.setMaximumSize(d); // Set the maximum size of the SnakeBoard class instance to the dimensions indicated by variable d
        s.setMinimumSize(d); // Set the minimum size of the SnakeBoard class instance to the dimensions indicated by variable d

        snake_frame.setResizable(false); // Make the snake_frame frame not resizable

        snake_frame.getContentPane().add(s); // Add the SnakeBoard instance to the snake_frame frame
        snake_frame.pack(); // Sizes the snake_frame frame so that all its contents are at or above their preferred sizes

        l.setSize(d); // Set the size of the LoseScreen class instance to the dimensions indicated by variable d
        l.setPreferredSize(d); // Set the preferred size of the LoseScreen class instance to the dimensions indicated by variable d
        l.setMaximumSize(d); // Set the maximum size of the LoseScreen class instance to the dimensions indicated by variable d
        l.setMinimumSize(d); // Set the minimum size of the LoseScreen class instance to the dimensions indicated by variable d

        lose_screen.setResizable(false); // Make the lose_screen frame not resizable

        lose_screen.getContentPane().add(l); // Add the LoseScreen instance to the lose_screen frame
        lose_screen.pack(); // Sizes the lose_screen frame so that all its contents are at or above their preferred sizes

        StateManager.State = StateManager.STATE.MAINMENU; // Start the program in the MAINMENU state

        while(true)
        { // Start of while loop
            if(StateManager.State == StateManager.STATE.MAINMENU)
            { // Start of true branch
                lose_screen.setVisible(false); // Make the lose_screen frame not visible
                instructions_menu.setVisible(false); // Make the instructions_menu frame not visible
                play_menu.setVisible(false); // Make the play_menu frame not visible
                main_menu.setVisible(true); // Make the main_menu frame visible
                main_menu.setFocusable(true); // Make the main_menu frame focusable
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.INSTRUCTIONSMENU)
            { // Start of true branch
                main_menu.setVisible(false); // Make the main_menu frame not visible
                instructions_menu.setVisible(true); // Make the instructions_menu frame visible
                instructions_menu.setFocusable(true); // Make the instructions_menu frame focusable
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.PLAYMENU)
            { // Start of true branch
                snake_frame.setVisible(false); // Make the snake_frame frame not visible
                lose_screen.setVisible(false); // Make the lose_screen frame not visible
                main_menu.setVisible(false); // Make the main_menu frame not visible
                play_menu.setVisible(true); // Make the play_menu frame visible
                play_menu.setFocusable(true); // Make the play_menu frame setFocusable
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.EASYGAME)
            { // Start of true branch
                play_menu.setVisible(false); // Make the play_menu frame not visible
                s.generateEasyWalls(); // Generate the easy walls for the easy map
                snake_frame.repaint(); // repaint the snake_frame frame
                snake_frame.setVisible(true); // Make the snake_frame frame visible
                snake_frame.setFocusable(true); // Make the snake_frame frame focusable
                s.run(); // Call the run method in the EASYGAME state
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.MEDIUMGAME)
            { // Start of true branch
                play_menu.setVisible(false); // Make the play_menu frame not visible
                s.generateMediumWalls(); // Generate the medium walls for the medium map
                snake_frame.repaint(); // repaint the snake_frame frame
                snake_frame.setVisible(true); // Make the snake_frame frame visible
                snake_frame.setFocusable(true); // Make the snake_frame frame focusable
                s.run(); // Call the run method in the MEDIUMGAME state
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.HARDGAME)
            { // Start of true branch
                play_menu.setVisible(false); // Make the play_menu frame not visible
                s.generateHardWalls(); // Generate the hard walls for the hard map
                snake_frame.repaint(); // repaint the snake_frame frame
                snake_frame.setVisible(true); // Make the snake_frame frame visible
                snake_frame.setFocusable(true); // Make the snake_frame frame focusable
                s.run(); // Call the run method in the HARDGAME state
            } // End of true branch

            else if(StateManager.State == StateManager.STATE.LOSESCREEN)
            { // Start of true branch
                s.updateHighScore(); // Update the high score in the played mode
                s.snake.resetSnake(); // Reset the snake
                s.score = 1; // Reset the score
                s.apple.generateNewCoordinates(SnakeBoard.walls); // Generate new coordinates for the apple
                snake_frame.setVisible(false); // Make the snake_frame frame not visible
                lose_screen.setVisible(true); // Make the lose_screen frame visible
                lose_screen.setFocusable(true); // Make the lose_screen frame focusable
            } // End of true branch
        } // End of while loop

    } // End of main method
} // End of main class