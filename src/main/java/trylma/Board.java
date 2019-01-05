package trylma;

import com.sun.org.apache.xpath.internal.functions.WrongNumberArgsException;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Board {
    private boolean marbleSelected = false;
    private int selectedMarbleX;
    private int selectedMarbleY;
    private Paint selectedMarbleColor;
    public static Paint whoseTurn;
    static Marbles board[][] = new Marbles[13][17];
    /* This array holds more marbles than there are in the game,
        but this way 2 marbles that are close on the board are also close in array.
        Marbles that are not in game but in the array have there colors set to AQUA,
        that's why AQUA COLORED marbles are ignored when drawing */

    public Board(int totalNumberOfPlayers) {
        try {
            if (totalNumberOfPlayers < 2 || totalNumberOfPlayers == 5 || totalNumberOfPlayers > 6)
                throw new WrongNumberArgsException("Invalid Number of players");

            // Create a 6-Star Board
            for (int x = 0; x < 13; x++) {
                for (int y = 0; y < 17; y++) {
                    board[x][y] = new Marbles();
                    board[x][y].setFill(Color.AQUA);

                    // For the lambda thing
                    int finalX = x;
                    int finalY = y;

                    // Mouse Controller
                    board[x][y].setOnMouseClicked(event -> {


                        if (true) {
                            // (J) Check if move was made this turn
                            boolean madeChoice = false;
                            boolean startedDeciding = false;
                            boolean jumpMade = false;
                            boolean moveMade = false;
                            boolean meMarbleJumped = false;

                            // ===    DEBUG OPTIONS    ===
                            // (J) Check ID on Click - just for debugging
                            System.out.println("Marble: [" + finalX + ", " + finalY + "]");

                            // (J) Quad click to change color to Red
                            if (event.getClickCount() > 3) {
                                System.out.println("[Dev Option] Changing Color to RED!");
                                board[finalX][finalY].setColor(Color.RED);
                            }
                            // ===  END OF DEBUG STUFF  ===

                            //if one mable is already selected then we are selecting target now
                            if (marbleSelected) {

                                if (!jumpMade || !moveMade) {
                                    move(finalX, finalY, selectedMarbleX, selectedMarbleY, selectedMarbleColor);

                                }

                                // (J) Adding jump logic. If a move is illegal, then instead of fail
                                // we can check if it was supposed to jump move instead
                                // if it was jump then we still allow to perform jumps
                                // and end turn, but user cant make regular moves anymore

                                if (!moveMade) {
                                    jump(finalX, finalY, selectedMarbleX, selectedMarbleY, selectedMarbleColor);
                                }

                                // (J) This is missing some kind of if statement or anything that checks
                                // If jump was performed - if yes, then boolean "jumpMade" should be true
                                // and move function isn't possible anymore.
                                // same logic to check if move was done

                                board[selectedMarbleX][selectedMarbleY].setRadius(15 * 1.33);
                                marbleSelected = false;

                            }
                            //if no marbles are selected we are selecting a marble to move, it must be non GRAY
                            else if (!Color.GRAY.equals(board[finalX][finalY].getFill())) {
                                marbleSelected = true;
                                selectedMarbleX = finalX;
                                selectedMarbleY = finalY;
                                selectedMarbleColor = board[finalX][finalY].getFill();
                                board[finalX][finalY].setRadius(30);
                            }
                        }
                    });
                }
            }
            if (totalNumberOfPlayers == 6) {
                setUpPlayer1(Color.GREEN);
                setUpPlayer2(Color.RED);
                setUpPlayer3(Color.YELLOW);
                setUpPlayer4(Color.BLUE);
                setUpPlayer5(Color.PINK);
                setUpPlayer6(Color.DARKMAGENTA);
            }
            if (totalNumberOfPlayers == 2) {
                setUpPlayer1(Color.GREEN);
                setUpPlayer2(Color.RED);
            }
            if (totalNumberOfPlayers == 3) {
                setUpPlayer1(Color.GREEN);
                setUpPlayer4(Color.BLUE);
                setUpPlayer6(Color.DARKMAGENTA);
            }
            if (totalNumberOfPlayers == 4) {
                setUpPlayer1(Color.GREEN);
                setUpPlayer2(Color.RED);
                setUpPlayer3(Color.YELLOW);
                setUpPlayer4(Color.BLUE);
            }
            setUpMiddle();
            deleteExtraMarbles();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    void setUpMiddle() {
        //sets the playable area to gray
        board[4][4].setDefaultColor();
        board[5][4].setDefaultColor();
        board[6][4].setDefaultColor();
        board[7][4].setDefaultColor();
        board[8][4].setDefaultColor();
        board[3][5].setDefaultColor();
        board[4][5].setDefaultColor();
        board[5][5].setDefaultColor();
        board[6][5].setDefaultColor();
        board[7][5].setDefaultColor();
        board[8][5].setDefaultColor();
        board[3][6].setDefaultColor();
        board[4][6].setDefaultColor();
        board[5][6].setDefaultColor();
        board[6][6].setDefaultColor();
        board[7][6].setDefaultColor();
        board[8][6].setDefaultColor();
        board[9][6].setDefaultColor();
        board[2][7].setDefaultColor();
        board[3][7].setDefaultColor();
        board[4][7].setDefaultColor();
        board[5][7].setDefaultColor();
        board[6][7].setDefaultColor();
        board[7][7].setDefaultColor();
        board[8][7].setDefaultColor();
        board[9][7].setDefaultColor();
        board[2][8].setDefaultColor();
        board[3][8].setDefaultColor();
        board[4][8].setDefaultColor();
        board[5][8].setDefaultColor();
        board[6][8].setDefaultColor();
        board[7][8].setDefaultColor();
        board[8][8].setDefaultColor();
        board[9][8].setDefaultColor();
        board[10][8].setDefaultColor();
        board[2][9].setDefaultColor();
        board[3][9].setDefaultColor();
        board[4][9].setDefaultColor();
        board[5][9].setDefaultColor();
        board[6][9].setDefaultColor();
        board[7][9].setDefaultColor();
        board[8][9].setColor(Color.GRAY);
        board[9][9].setColor(Color.GRAY);
        board[3][10].setColor(Color.GRAY);
        board[4][10].setColor(Color.GRAY);
        board[5][10].setColor(Color.GRAY);
        board[6][10].setColor(Color.GRAY);
        board[7][10].setColor(Color.GRAY);
        board[8][10].setColor(Color.GRAY);
        board[9][10].setColor(Color.GRAY);
        board[3][11].setColor(Color.GRAY);
        board[4][11].setColor(Color.GRAY);
        board[5][11].setColor(Color.GRAY);
        board[6][11].setColor(Color.GRAY);
        board[7][11].setColor(Color.GRAY);
        board[8][11].setColor(Color.GRAY);
        board[4][12].setColor(Color.GRAY);
        board[5][12].setColor(Color.GRAY);
        board[6][12].setColor(Color.GRAY);
        board[7][12].setColor(Color.GRAY);
        board[8][12].setColor(Color.GRAY);
        //now we check if players are set up, if not we change their color to gray and not AQUA so the areas are playable
        if (Color.AQUA.equals(board[6][0].getFill())) setUpPlayer1(Color.GRAY);
        if (Color.AQUA.equals(board[4][13].getFill())) setUpPlayer2(Color.GRAY);
        if (Color.AQUA.equals(board[0][4].getFill())) setUpPlayer3(Color.GRAY);
        if (Color.AQUA.equals(board[10][9].getFill())) setUpPlayer4(Color.GRAY);
        if (Color.AQUA.equals(board[10][7].getFill())) setUpPlayer5(Color.GRAY);
        if (Color.AQUA.equals(board[0][12].getFill())) setUpPlayer6(Color.GRAY);

    }

    void setUpPlayer1(Color color) {
        //sets player 1 as green
        board[6][0].setColor(color);
        board[5][1].setColor(color);
        board[6][1].setColor(color);
        board[5][2].setColor(color);
        board[6][2].setColor(color);
        board[7][2].setColor(color);
        board[4][3].setColor(color);
        board[5][3].setColor(color);
        board[6][3].setColor(color);
        board[7][3].setColor(color);
    }

    void setUpPlayer2(Color color) {
        //sets player 2 as red
        board[4][13].setColor(color);
        board[5][13].setColor(color);
        board[6][13].setColor(color);
        board[7][13].setColor(color);
        board[7][14].setColor(color);
        board[5][14].setColor(color);
        board[6][14].setColor(color);
        board[5][15].setColor(color);
        board[6][15].setColor(color);
        board[6][16].setColor(color);

    }

    void setUpPlayer3(Color color) {
        //sets player 3 as yellow
        board[0][4].setColor(color);
        board[1][4].setColor(color);
        board[2][4].setColor(color);
        board[3][4].setColor(color);
        board[0][5].setColor(color);
        board[1][5].setColor(color);
        board[2][5].setColor(color);
        board[1][6].setColor(color);
        board[2][6].setColor(color);
        board[1][7].setColor(color);
    }

    void setUpPlayer4(Color color) {
        //sets player 4 as blue
        board[10][9].setColor(color);
        board[10][10].setColor(color);
        board[11][10].setColor(color);
        board[9][11].setColor(color);
        board[10][11].setColor(color);
        board[11][11].setColor(color);
        board[9][12].setColor(color);
        board[10][12].setColor(color);
        board[11][12].setColor(color);
        board[12][12].setColor(color);

    }

    void setUpPlayer5(Color color) {
        //sets player 5 as color
        board[10][7].setColor(color);
        board[10][6].setColor(color);
        board[11][6].setColor(color);
        board[9][5].setColor(color);
        board[10][5].setColor(color);
        board[11][5].setColor(color);
        board[9][4].setColor(color);
        board[10][4].setColor(color);
        board[11][4].setColor(color);
        board[12][4].setColor(color);

    }

    void setUpPlayer6(Color color) {
        //sets payer 6 as DARKMAGENTA
        board[0][12].setColor(color);
        board[1][12].setColor(color);
        board[2][12].setColor(color);
        board[3][12].setColor(color);
        board[0][11].setColor(color);
        board[1][11].setColor(color);
        board[2][11].setColor(color);
        board[1][10].setColor(color);
        board[2][10].setColor(color);
        board[1][9].setColor(color);
    }


    void deleteExtraMarbles() {
        //setting all AQUA marbles to null, we dont care 'bout them
        // (J) Fixing problem for 0.54 update.
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 17; j++) {
                if (Color.AQUA.equals(board[i][j].getFill())) {
                    //board[i][j] = null;
                    board[i][j].setVisible(false);
                }
            }
        }
    }


    //self explanatory
    static void move(int hereGoX, int hereGoY, int goingFromX, int goingFromY, Paint player_color) {
        try {
            if (movePossible(hereGoX, hereGoY, goingFromX, goingFromY)) {
                board[hereGoX][hereGoY].setFill(board[goingFromX][goingFromY].getFill());
                board[goingFromX][goingFromY].setDefaultColor();
                System.out.println("MOVE");
                if(Client.out!= null) {
                    Client.out.println("MOVE "+ hereGoX + " " + hereGoY + " " + goingFromX+ " " + goingFromY + " " + player_color);
                }
            } else {
                System.out.println("Illegal Move");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    static void ServerForceMove(int hereGoX, int hereGoY, int goingFromX, int goingFromY) {
        //this is a method we use when server tells us to move something
        //it just moves and doesnt check anything
                board[hereGoX][hereGoY].setFill(board[goingFromX][goingFromY].getFill());
                board[goingFromX][goingFromY].setDefaultColor();
                System.out.println("SERVER FORCED MOVE MADE");
        }



     void jump(int hereGoX, int hereGoY, int goingFromX, int goingFromY, Paint player_color) {
        try {
           if (jumpPossible(hereGoX, hereGoY, goingFromX, goingFromY)) {
                board[hereGoX][hereGoY].setFill(player_color);
                board[goingFromX][goingFromY].setDefaultColor();
                System.out.println("JUMP");
               if(Client.out!= null) {
                   Client.out.println("MOVE "+ hereGoX + " " + hereGoY + " " + goingFromX+ " " + goingFromY + " " + player_color);
               }
            } else {
                System.out.println("Illegal Jump");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

     boolean jumpPossible(int hereGoX, int hereGoY, int goingFromX, int goingFromY) {

        /* (J) There are 8 direction from which a marble can jump over a marble
           Imagine that we have a clock and we jump from number to the other side
           Over the middle in the clock: like from 3 to 9 or from 12 to 6 etc.

           1 -> 7   [-1, +2]        3 -> 9  [-2, 0]         5 -> 11    [-1, -2]
           7 -> 1   [+1, -2]        9 -> 3  [+2, 0]         11 -> 5    [+1, +2]

           Problem arrises when we change the Board to a custom one cause we need to write logic
           from the beginning again. Hopefully the alghoritm for board will fix this problem and
           we can adjust accordingly.
        */
        if((Client.inMulitipalyerMode&&!Client.myTurn)||(Client.inMulitipalyerMode&&!Client.myColor.equals(board[goingFromX][goingFromY].getFill())))
             return false;

        if (goingFromX - hereGoX == 2)
            if (goingFromY - hereGoY == 0)
                if (!(Color.GRAY.equals(board[hereGoX + 1][hereGoY].getFill())))
                    return true;

        if (goingFromX - hereGoX == -2)
            if (goingFromY - hereGoY == 0)
                if (!(Color.GRAY.equals(board[hereGoX - 1][hereGoY].getFill())))
                    return true;

        // (J) curvature of the board forces to make two checks
        // cause could be placed on even or odd spot

        if (hereGoX - goingFromX == -1)
            if (hereGoY - goingFromY == 2)
                if (!(Color.GRAY.equals(board[hereGoX + 1][hereGoY - 1].getFill()))) {
                    return true;
                } else if (!(Color.GRAY.equals(board[hereGoX][hereGoY - 1].getFill())))
                    return true;

        if (hereGoX - goingFromX == -1)
            if (hereGoY - goingFromY == -2)
                if (!(Color.GRAY.equals(board[hereGoX + 1][hereGoY + 1].getFill()))) {
                    return true;
                } else if (!(Color.GRAY.equals(board[hereGoX][hereGoY + 1].getFill())))
                    return true;

        if (hereGoX - goingFromX == 1)
            if (hereGoY - goingFromY == 2) {
                if (!(Color.GRAY.equals(board[hereGoX][hereGoY - 1].getFill()))) {
                    return true;
                } else if (!(Color.GRAY.equals(board[hereGoX - 1][hereGoY - 1].getFill()))) {
                    return true;
                }
            }

        if (hereGoX - goingFromX == 1)
            if (hereGoY - goingFromY == -2)
                if (!(Color.GRAY.equals(board[hereGoX][hereGoY + 1].getFill()))) {
                    return true;
                } else if (!(Color.GRAY.equals(board[hereGoX - 1][hereGoY + 1].getFill())))
                    return true;

        return false;
    }

    static boolean movePossible(int hereGoX, int hereGoY, int goingFromX, int goingFromY) {
        if((Client.inMulitipalyerMode&&!Client.myTurn)||(Client.inMulitipalyerMode&&!Client.myColor.equals(board[goingFromX][goingFromY].getFill())))
            return false;
        if (goingFromX == hereGoX + 1 || goingFromX == hereGoX - 1 || goingFromX == hereGoX) //must be close
            if (goingFromY == hereGoY + 1 || goingFromY == hereGoY - 1 || goingFromY == hereGoY)
                if (Color.GRAY.equals(board[hereGoX][hereGoY].getFill())) // target must be gray
                    if (!Color.GRAY.equals(board[goingFromX][goingFromY].getFill())) // source must be non gray
                        if (!(goingFromX < hereGoX && goingFromY != hereGoY && goingFromY % 2 == 0))
                            if (!(goingFromX > hereGoX && goingFromY != hereGoY && goingFromY % 2 == 1))
                                    return true;
        return false;
    }

    // (J) Checkd with "End Turn" button.
    void winCondition(){
        if(
                Color.GREEN.equals(board[4][13].getFill()) &&
                        Color.GREEN.equals(board[5][13].getFill()) &&
                        Color.GREEN.equals(board[6][13].getFill()) &&
                        Color.GREEN.equals(board[7][13].getFill()) &&
                        Color.GREEN.equals(board[7][14].getFill()) &&
                        Color.GREEN.equals(board[5][14].getFill()) &&
                        Color.GREEN.equals(board[6][14].getFill()) &&
                        Color.GREEN.equals(board[5][15].getFill()) &&
                        Color.GREEN.equals(board[6][15].getFill()) &&
                        Color.GREEN.equals(board[6][16].getFill())
        )
            System.out.println("Player 1 Won.");
        if(
                Color.RED.equals(board[6][0].getFill()) &&
                        Color.RED.equals(board[5][1].getFill()) &&
                        Color.RED.equals(board[6][1].getFill()) &&
                        Color.RED.equals(board[5][2].getFill()) &&
                        Color.RED.equals(board[6][2].getFill()) &&
                        Color.RED.equals(board[7][2].getFill()) &&
                        Color.RED.equals(board[4][3].getFill()) &&
                        Color.RED.equals(board[5][3].getFill()) &&
                        Color.RED.equals(board[6][3].getFill()) &&
                        Color.RED.equals(board[7][3].getFill())
        )
            System.out.println("Player 2 Won.");

        if(
                Color.YELLOW.equals(board[10][9].getFill()) &&
                        Color.YELLOW.equals(board[10][10].getFill()) &&
                        Color.YELLOW.equals(board[11][10].getFill()) &&
                        Color.YELLOW.equals(board[9][11].getFill()) &&
                        Color.YELLOW.equals(board[10][11].getFill()) &&
                        Color.YELLOW.equals(board[11][11].getFill()) &&
                        Color.YELLOW.equals(board[9][12].getFill()) &&
                        Color.YELLOW.equals(board[10][12].getFill()) &&
                        Color.YELLOW.equals(board[11][12].getFill()) &&
                        Color.YELLOW.equals(board[12][12].getFill())
        )
            System.out.println("Player 3 Won.");

        if(
                Color.BLUE.equals(board[0][4].getFill()) &&
                        Color.BLUE.equals(board[1][4].getFill()) &&
                        Color.BLUE.equals(board[2][4].getFill()) &&
                        Color.BLUE.equals(board[3][4].getFill()) &&
                        Color.BLUE.equals(board[0][5].getFill()) &&
                        Color.BLUE.equals(board[1][5].getFill()) &&
                        Color.BLUE.equals(board[2][5].getFill()) &&
                        Color.BLUE.equals(board[1][6].getFill()) &&
                        Color.BLUE.equals(board[2][6].getFill()) &&
                        Color.BLUE.equals(board[1][7].getFill())
        )
            System.out.println("Player 4 Won.");

        if(
                Color.PINK.equals(board[0][12].getFill()) &&
                        Color.PINK.equals(board[1][12].getFill()) &&
                        Color.PINK.equals(board[2][12].getFill()) &&
                        Color.PINK.equals(board[3][12].getFill()) &&
                        Color.PINK.equals(board[0][11].getFill()) &&
                        Color.PINK.equals(board[1][11].getFill()) &&
                        Color.PINK.equals(board[2][11].getFill()) &&
                        Color.PINK.equals(board[1][10].getFill()) &&
                        Color.PINK.equals(board[2][10].getFill()) &&
                        Color.PINK.equals(board[1][9].getFill())
        )
            System.out.println("Player 5 Won.");

        if(
                Color.DARKMAGENTA.equals(board[10][7].getFill()) &&
                        Color.DARKMAGENTA.equals(board[10][6].getFill()) &&
                        Color.DARKMAGENTA.equals(board[11][6].getFill()) &&
                        Color.DARKMAGENTA.equals(board[9][5].getFill()) &&
                        Color.DARKMAGENTA.equals(board[10][5].getFill()) &&
                        Color.DARKMAGENTA.equals(board[11][5].getFill()) &&
                        Color.DARKMAGENTA.equals(board[9][4].getFill()) &&
                        Color.DARKMAGENTA.equals(board[10][4].getFill()) &&
                        Color.DARKMAGENTA.equals(board[11][4].getFill()) &&
                        Color.DARKMAGENTA.equals(board[12][4].getFill())
        )
            System.out.println("Player 6 Won.");
    }
}

