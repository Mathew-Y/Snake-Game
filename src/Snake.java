import java.awt.*;
import java.util.ArrayList;

class Snake
{ // Start of Snake class

    public boolean canChangeDirection = false; // Create a new boolean called canChangeDirection and set it to false, will be used to indicate when it is possible to change direction

    public ArrayList<SnakeBox> snakeBodyArray = null; // Creates a new ArrayList of SnakeBoxes called snakeBodyArray, this will be the snake's body

    public String direction = "RIGHT"; // String that will be used to indicate which direction the snake is going, default it to right

    private boolean isMoving = false; // Boolean that will indicate when the snake is moving and when it is not

    public Snake(int x, int y, Color c, int width, int height) // Takes x, y, c, width and height as parameters
    { // Start of Snake constructor
        this.snakeBodyArray = new ArrayList<>(); // set the snakeBodyArray in this class to a new empty ArrayList
        this.snakeBodyArray.add(new SnakeBox(x, y, c, width, height)); // Add information to the snake ArrayList, this will be the head
        this.canChangeDirection = true; // Set our canChangeDirection variable to true
        this.isMoving = true; // Set our isMoving variable to true
    } // End of Snake constructor


    public void draw(Graphics g) // Takes g as parameter
    { // Start of draw method
        for(SnakeBox s : this.snakeBodyArray) // For the amount of Squares that make up the snake
            s.draw(g); // Draw each snake rectangle of the body
    } // End of draw method

    public void update()
    { // Start of update method
        if (!this.isMoving) // Check if the snake is not moving
            return; // Skips this method

        move(); // Calls the move method if the snake is currently moving
        this.canChangeDirection = true; // Set the canChangeDirection variable to true
    } // End of update method

    public void resetSnake()
    { // Start of resetSnake method
        SnakeBox head = this.snakeBodyArray.get(0); // Create a SnakeBox called head which will store the 1st index of the ArrayList
        head.setX(100); // Reset the X value of the head to 100 px on the x axis
        head.setY(300); // Reset the Y value of the head to 300 px on the y axis

        this.snakeBodyArray = new ArrayList<>(); // Create a new ArrayList for our new Snake
        this.snakeBodyArray.add(head); // Set our head variable as the first index of the ArrayList

        this.stopMoving(); // Make the snake stationary until user presses a button
    } // End of resetSnake method

    public boolean getIsMoving()
    { // Start of getIsMoving method
        return this.isMoving; // return true or false, whether the snake is moving or not
    } // End of getIsMoving method

    public void startMoving()
    { // Start of startMoving method
        this.isMoving = true; // Set the isMoving boolean to true, to indicate that the snake is now moving
    } // End of startMoving method

    public void stopMoving()
    { // Start of stopMoving method
        this.isMoving = false; // Set the isMoving boolean to false, to indicate that the snake is now stationary
    } // End of stopMoving method

    public void growSnake()
    { // Start of growSnake method
        int last_index = this.snakeBodyArray.size() - 1; // Variable that will store the value of the last index of the snake
        SnakeBox previous_snake_piece = this.snakeBodyArray.get(last_index); // SnakeBox variable that will store the lastIndex of the snake
        SnakeBox new_snake_piece = new SnakeBox(previous_snake_piece.getPreviousX(), previous_snake_piece.getPreviousY(), Color.green, 10, 10); // Creates a new SnakeBox which will be in the position of the previousSnakePiece
        this.snakeBodyArray.add(new_snake_piece); // Add the SnakeBox to the snakeBodyArray ArrayList
    } // End of growSnake method

    public void move()
    { // Start of move method
        switch (this.direction)
        { // Start of switch statement
            case "LEFT":  // Start of true branch
                this.snakeBodyArray.get(0).setX(this.snakeBodyArray.get(0).getX() - this.snakeBodyArray.get(0).getWidth()); // Subtract from the x value of the head
                this.snakeBodyArray.get(0).setY(this.snakeBodyArray.get(0).getY()); // Set the y to the y of the head (doesn't change)
                break; // Break out of switch
            case "RIGHT":  // Start of true branch
                this.snakeBodyArray.get(0).setX(this.snakeBodyArray.get(0).getX() + this.snakeBodyArray.get(0).getWidth()); // Add to the x value of the head
                this.snakeBodyArray.get(0).setY(this.snakeBodyArray.get(0).getY()); // Set the y to the y of the head (doesn't change)
                break; // Break out of switch
            case "UP":  // Start of true branch
                this.snakeBodyArray.get(0).setY(this.snakeBodyArray.get(0).getY() - this.snakeBodyArray.get(0).getHeight()); // Subtract from the y of the head
                this.snakeBodyArray.get(0).setX(this.snakeBodyArray.get(0).getX()); // Set the x to the x of the head (doesn't change)
                break; // Break out of switch
            case "DOWN":  // Start of true branch
                this.snakeBodyArray.get(0).setY(this.snakeBodyArray.get(0).getY() + this.snakeBodyArray.get(0).getHeight()); // Add to the y of the head
                this.snakeBodyArray.get(0).setX(this.snakeBodyArray.get(0).getX()); // Set the x to the x of the head (doesn't change)
                break; // Break out of switch
        } // End of switch statement

        if (this.snakeBodyArray.size() > 1) // Check if the Snake's body is greater than 1 rectangle
        { // Start ot true branch
            for (int i = 1; i < this.snakeBodyArray.size(); i++) // Loops as much as the size of the Snake ArrayList
            { // Start of for loop
                this.snakeBodyArray.get(i).setX(this.snakeBodyArray.get(i - 1).getPreviousX()); // Get the index equal to i and set it to the previousX of the index in front of it
                this.snakeBodyArray.get(i).setY(this.snakeBodyArray.get(i - 1).getPreviousY()); // Get the index equal to i and set it to the previousY of the index in front of it
            } // End of for loop
        } // End of true branch
    } // End of move method

    public void changeDirection(String next_direction) // Takes in String as parameter
    { // Start of changeDirection method
        if(!this.isMoving)
        { // Start of true branch
            this.direction = next_direction; // Set the direction variable from this class to the next_direction passed in the parameters
            this.canChangeDirection = false; // Set canChangeDirection to false to indicate that the snake cannot change directions
            return; // Break out method call
        } // End of true branch

        if(!this.canChangeDirection)
            return; // Break out method call

        if(this.direction == "LEFT" || this.direction == "RIGHT")
        { // Start of true branch
            if(next_direction == "UP" || next_direction == "DOWN")
            { // Start of true branch
                this.direction = next_direction; // Change direction to the direction passed in by user
                this.canChangeDirection = false; // Set canChangeDirection to false to stop user from moving
            } // End of true branch
        } // End of true branch

        else if(this.direction == "UP" || this.direction == "DOWN")
        { // Start of true branch
            if(next_direction == "LEFT" || next_direction == "RIGHT")
            { // Start of true branch
                this.direction = next_direction; // Change direction to teh direction passed in by user
                this.canChangeDirection = false; // Set canChangeDirection to false to stop user from moving
            } // End of true branch
        } // End of true branch
    } // End of changeDirection method
} // End of Snake class