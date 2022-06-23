import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class MouseInput implements MouseListener
{ // Start of MouseInput class, implements MouseListener class

    // All empty methods are methods that must be in this class but methods that we don't need

    @Override
    public void mouseClicked(MouseEvent e) // Takes e as a parameter
    { // Start of mouseClicked method
    } // End of mouseClicked method

    @Override
    public void mousePressed(MouseEvent e) // Takes e as a parameter
    { // Start of mousePressed method
        int mx = e.getX(); // Get the x value of user's mouse click, save it under mx variable
        int my = e.getY(); // Get the y value of user's mouse click, save it under my variable

        if(StateManager.State == StateManager.STATE.MAINMENU)
        { // Start of true branch
            if(mx >= 220 && mx <= 425)
            { // Start of true branch
                if(my >= 230 && my <= 280)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.PLAYMENU; // Change the state to PLAYMENU
                } // End of true branch

                else if(my >= 380 && my <= 430)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.INSTRUCTIONSMENU; // Change the state to INSTRUCTIONSMENU
                } // End of true branch

                else if(my >= 530 && my <= 580)
                    System.exit(1); // Exits the program
            } // End of true branch
        } // End of true branch

        else if(StateManager.State == StateManager.STATE.INSTRUCTIONSMENU)
        { // Start of true branch
            if(mx >= 220 && mx <= 430)
            { // Start of true branch
                if(my >= 525 && my <= 575)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.MAINMENU; // Change the state to MAINMENU
                } // End of true branch
            } // End of true branch
        } // End of true branch

        else if(StateManager.State == StateManager.STATE.PLAYMENU)
        { // Start of true branch
            if(mx >= 40 && mx <= 320)
            { // Start of true branch
                if(my >= 780 && my <= 830)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.EASYGAME; // Change the current state to EASYGAME
                    StateManager.previousState = StateManager.STATE.EASYGAME; // Change the previous state to EASYGAME
                } // End of true branch
            } // End of true branch

            else if(mx >= 355 && mx <= 635)
            { // Start of true branch
                if(my >= 780 && my <= 830)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.MEDIUMGAME; // Change the current state to MEDIUMGAME
                    StateManager.previousState = StateManager.STATE.MEDIUMGAME; // Change the previous state to MEDIUMGAME
                } // End of true branch
            } // End of true branch

            else if(mx >= 670 && mx <= 950)
            { // Start of true branch
                if(my >= 780 && my <= 830)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.HARDGAME; // Change the current state to HARDGAME
                    StateManager.previousState = StateManager.STATE.HARDGAME; // Change the previous state to HARDGAME
                } // End of true branch
            } // End of true branch

            if(mx >= 28 && mx <= 179)
            { // Start of true branch
                if(my >= 70 && my <= 120)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.MAINMENU; // Change the state to HARDGAME
                } // End of true branch
            } // End of true branch

        } // End of true branch

        else if(StateManager.State == StateManager.STATE.LOSESCREEN)
        { // Start of true branch
            if(mx >= 220 && mx <= 425)
            { // Start of true branch
                if(my >= 280 && my <= 330)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.PLAYMENU; // Change the state to PLAYMENU
                } // End of true branch

                else if(my >= 430 && my <= 480)
                { // Start of true branch
                    StateManager.State = StateManager.STATE.MAINMENU; // Change the state to MAINMENU
                } // End of true branch

                else if(my >= 580 && my <= 630)
                { // Start of true branch
                    System.exit(1); // Exits the program
                } // End of true branch
            } // End of true branch
        } // End of true branch
    } // End of mousePressed method

    @Override
    public void mouseReleased(MouseEvent e) // Takes e as a parameter
    { // Start of mouseReleased method
    } // End of mouseReleased method

    @Override
    public void mouseEntered(MouseEvent e) // Takes e as a parameter
    { // Start of mouseEntered method
    } // End of mouseReleased method

    @Override
    public void mouseExited(MouseEvent e) // Takes e as a parameter
    { // Start of mouseExited method
    } // End of mouseExited method
} // End of MouseInput class