class StateManager
{ // Start of StateManager class

    enum STATE
    { // Start of enum State declarations
        MAINMENU, PLAYMENU, INSTRUCTIONSMENU, EASYGAME, MEDIUMGAME, HARDGAME, LOSESCREEN // All the states that I need in the game
    }; // End of enum state declarations

    static STATE State; // Declare a STATE variable for the different states currently running

    static STATE previousState; // Declare a STATE variable for the previous state running

} // End of StateManager class