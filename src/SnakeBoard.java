import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

class SnakeBoard extends JPanel implements Runnable
{ // Start of SnakeBoard class, extends JPanel class, implements Runnable class
    public Color background_colour = null; // Variable that will store the background colour
    public Apple apple = null; // Variable that will store an Apple object
    public Snake snake = null; // Variable that will store a Snake object
    public static ArrayList<Rectangle> walls = new ArrayList<>(); // ArrayList of Rectangles that will create a wall
    public int width = 0; // Variable that will store the width of the parentFrame
    public int height = 0; // Variable that will store the height of the parentFrame
    public static int square_width = 0; // Variable that will store the width of the square
    public int score = 1; // Variable that will store the user's score
    public static int easy_high_score = 0; // Variable that will store the user's easy high score
    public static int medium_high_score = 0; // Variable that will store the user's medium high score
    public static int hard_high_score = 0; // Variable that will store the user's hard high score
    private boolean isRunning = false; // Boolean that will indicate when the game loop is running, set it to false

    public SnakeBoard(JFrame parentFrame, int width, int height, int square_width)
    { // Start of SnakeBoard constructor
        super(); // Inherit all JPanel classes
        this.width = width; // Set the width in this class to the width passed in the parameters
        this.height = height; // Set the height in this class to the height passed in the parameters
        SnakeBoard.square_width = square_width; // Set the square_width in this class to the square_width passed in the parameters
        this.background_colour = Color.BLACK; // Set the background_colour variable to black
        this.setBackground(this.background_colour); // Set the background to the background_colour variable
        this.snake = new Snake(0, 0, Color.green, square_width, square_width); // Create a new Snake and save it under the snake variable
        this.apple = new Apple(square_width, square_width, height, width, square_width); // Create a new Apple and save it under the apple variable

        if(StateManager.State == StateManager.STATE.EASYGAME)
        { // Start of true branch
            generateEasyWalls(); // Generate easy walls if the state is EASYGAME
        } // End of true branch
        else if(StateManager.State == StateManager.STATE.MEDIUMGAME)
        { // Start of true branch
            generateMediumWalls(); // Generate medium walls if the state is MEDIUMGAME
        } // End of true branch
        else if(StateManager.State == StateManager.STATE.HARDGAME)
        { // Start of true branch
            generateHardWalls(); // Generate hard walls if the state is HARDGAME
        } // End of true branch

        this.apple.generateNewCoordinates(walls); // Generate new coordinates for the apple to be in, pass in the location of all rectangles in the wall ArrayList

        this.snake.resetSnake(); // Call the resetSnake method from the Snake class

        this.isRunning = false; // Set the isRunning variable to false since the game loop is not running

        parentFrame.addKeyListener(new KeyListener()
        { // Start of addKeyListener method list
            @Override
            public void keyTyped(KeyEvent keyEvent) // Takes in keyEvent as a parameter
            { // Start of keyTyped method
            } // End of keyTyped method

            @Override
            public void keyPressed(KeyEvent keyEvent) // Takes in keyEvent as a parameter
            { // Start of keyPressed method
                int key = keyEvent.getKeyCode(); // Save the user's keyboard inputs under key variable
                switch(key)
                { // Start of switch statement
                    case KeyEvent.VK_UP: // If the user pressed the up key
                        snake.changeDirection("UP"); // Change the snake's direction to up
                        break; // Break out of switch statement
                    case KeyEvent.VK_DOWN: // If the user pressed the down key
                        snake.changeDirection("DOWN"); // Change the snake's direction to down
                        break; // Break out of the switch statement
                    case KeyEvent.VK_LEFT: // If the user pressed the left key
                        snake.changeDirection("LEFT"); // Change the snake's direction to left
                        break; // Break out of the switch statement
                    case KeyEvent.VK_RIGHT: // If the user pressed the right key
                        snake.changeDirection("RIGHT"); // Change the snake's direction to right
                } // End of switch statement

                if(!snake.getIsMoving()) // If the snake is not moving
                    snake.startMoving(); // Make the snake start moving
            } // End of keyPressed method

            @Override
            public void keyReleased(KeyEvent keyEvent) // Takes in keyEvent as a parameter
            { // Start of keyReleased method
            } // End of keyReleased method
        }); // End of addKeyListener method list
    } // End of SnakeBoard constructor

    @Override
    protected void paintComponent(Graphics g) // Takes g as a parameter
    { // Start of paintComponent method
        g.setColor(Color.black); // Set the colour of Graphics g to black
        g.fillRect(0, 0, this.width, this.height); // Fill in the whole frame with the colour we just set
        this.apple.draw(g); // Draw the apple
        this.snake.draw(g); // Draw the snake
        g.drawString("Score: " + score, 10, 660); // Draw the score at the bottom left

        // For all of the rectangles in the walls ArrayList
        for (int i = 0; i <= walls.size() - 1; i++)
        { // Start of for loop
            walls.get(i).draw(g); // Draw each rectangle at every index
        } // End of for loop
    } // End of paintComponent method

    public void checkCollisions()
    { // Start of checkCollisions method
        int snakeHeadX = snake.snakeBodyArray.get(0).getX(); // Get the X of the 1st index of the snake ArrayList and save that under snakeHeadX
        int snakeHeadY = snake.snakeBodyArray.get(0).getY(); // Get the Y of the 1st index of the snake ArrayList and save that under snakeHeadY

        if(snakeHeadX == this.apple.getX() && snakeHeadY == this.apple.getY())
        { // Start of true branch
            this.snake.growSnake(); // Call the growSnake method on the snake
            this.score++; // Add 1 to the score of the user
            this.apple.generateNewCoordinates(walls); // Generate new coordinates for the apple, pass in walls ArrayList as a parameter to avoid collision
            return; // Break out of method
        } // End of true branch

        if (snakeHeadX < 0 || snakeHeadY < 0 || snakeHeadX >= this.width || snakeHeadY >= this.height)
        { // Start of true branch
            StateManager.State = StateManager.STATE.LOSESCREEN; // Change the state to the LOSESCREEN
            isRunning = false; // Set isRunning to false to break the game loop
        } // End of true branch

        if (snake.snakeBodyArray.size() > 1)
        { // Start of true branch
            for(int i = 1; i < snake.snakeBodyArray.size(); i++) // Runs as many times as there are SnakeBoxes in the snakeBody ArrayList
            { // Start of for loop
                if(snake.snakeBodyArray.get(i).getX() == snakeHeadX && snake.snakeBodyArray.get(i).getY() == snakeHeadY)
                {
                    StateManager.State = StateManager.STATE.LOSESCREEN; // Changes the state of the game to LOSESCREEN
                    isRunning = false;
                    break;
                }
            } // End of for loop
        } // End of true branch

        for(int i = 0; i <= walls.size() - 1; i++) // Runs as many times as there are Rectangles in the wall
        { // Start of for loop
            Rectangle rectangle = walls.get(i);

            if (snakeHeadX == rectangle.getX() && snakeHeadY == rectangle.getY()) {
                StateManager.State = StateManager.STATE.LOSESCREEN; // Change the state of the game to LOSESCREEN
                isRunning = false;
                break;
            }
        } // End of for loop
    } // End of checkCollisions method

    public void updateHighScore()
    { // Start of updateHighScore method
        if(StateManager.previousState == StateManager.STATE.EASYGAME)
        { // Start of true branch
            if(score >= easy_high_score)
                easy_high_score = score; // Update the high score if the score is higher than the current high score
        } // End of true branch
        else if(StateManager.previousState == StateManager.STATE.MEDIUMGAME)
        { // Start of true branch
            if(score >= medium_high_score)
                medium_high_score = score; // Update the high score if the score is higher than the current high score
        } // End of true branch
        else if(StateManager.previousState == StateManager.STATE.HARDGAME)
        { // Start of true branch
            if(score >= hard_high_score)
                hard_high_score = score; // Update the high score if the score is higher than the current high score
        } // End of true branch
    } // End of updateHighScore method

    public void generateEasyWalls()
    { // Start of generateEasyWalls method
        walls.clear(); // Clear the walls ArrayList

        walls.add(new Rectangle(100, 190, Color.white, square_width, square_width)); // Add the guiding Rectangle (first one)

        for(int i = 0; i <= 6; i++) // Runs 7 times, used to add 7 Rectangles to ArrayList
            walls.add(new Rectangle(100, walls.get(walls.size() - 1).getY() - 10, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a y value of the last one - 10

        for(int i = 6; i <= 13; i++) // Runs 7 times, used to add 7 Rectangles to ArrayList
            walls.add(new Rectangle(walls.get(walls.size() - 1).getX() + 10, 120, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a x value of the last one + 10

        walls.add(new Rectangle(560, 480, Color.white, square_width, square_width)); // Add a new Rectangle to the wall ArrayList near the bottom right as a guidance Rectangle

        for(int i = 0; i <= 6; i++) // Runs 7 times, used to add 7 Rectangles to ArrayList
            walls.add(new Rectangle(560, walls.get(walls.size() - 1).getY() + 10, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a y value of the last one + 10


        for(int i = 6; i <= 13; i++) // Runs 7 times, used to add 7 Rectangles to ArrayList
            walls.add(new Rectangle(walls.get(walls.size() - 1).getX() - 10, 550, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a y value of the last one - 10
    } // End of generateEasyWalls method

    public void generateMediumWalls()
    { // Start of generateMediumWalls method
        walls.clear(); // Clear the walls ArrayList

        walls.add(new Rectangle(330, 170, Color.white, square_width, square_width)); // Add the guiding Rectangle (first one)

        for (int i = 0; i <= 24; i++) // Runs 25 times, used to add 25 Rectangles to ArrayList
            walls.add(new Rectangle(330, walls.get(walls.size() - 1).getY() + 10, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a y value of the last one + 10

        walls.add(new Rectangle(210, 290, Color.white, square_width, square_width)); // Add a new Rectangle to the wall ArrayList near the bottom right as a guidance Rectangle

        for (int i = 0; i <= 24; i++) // Runs 25 times, used to add 25 Rectangles to ArrayList
            walls.add(new Rectangle(walls.get(walls.size() - 1).getX() + 10, 290, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a x value of the last one + 10
    } // End of generateMediumWalls method

    public void generateHardWalls()
    { // Start of generateHardWalls method
        walls.clear(); // Clear the walls ArrayList

        walls.add(new Rectangle(70, 590, Color.white, square_width, square_width)); // Add a new Rectangle to the wall ArrayList near the bottom right as a guidance Rectangle

        for(int i = 0; i <= 50; i++) // Runs 51 times, used to add 51 Rectangles to ArrayList
            walls.add(new Rectangle(walls.get(walls.size() - 1).getX() + 10, walls.get(walls.size() - 1).getY() - 10, Color.white, square_width, square_width)); // Adds a new wall every time but each wall addition has a x value of the last one + 10 and has a y value of the last one - 10
    } // End of generateHardWalls method

    @Override
    public void run()
    { // Start of run method
        if (!this.isRunning)
        { // Start of true branch
            this.isRunning = true; // Set isRunning to true to indicate that the game loop is running
            StateManager.State = StateManager.STATE.MAINMENU;

            while (this.isRunning)
            { // Start of while loop
                this.snake.update(); // Call the update method on the snake
                this.checkCollisions(); // Check if the snake collided with anything

                this.repaint(); // repaint the whole frame after the game loop refreshes

                try
                { // Start of try statement
                    // Variable that will store the desired amount of frames the game should have per second
                    int frames = 50;
                    Thread.sleep(1000 / frames); // Delay the game loop by 1000 ms / 50 (frames) to get 50 fps on the game
                } // End of try statement
                catch (InterruptedException e) // Catch an InterruptedException error
                { // Start of catch statement
                    e.printStackTrace(); // Handles IOException error
                } // End of catch statement
            } // End of while loop
        } // End of true branch
    } // End of run method
} // End of SnakeBoard class