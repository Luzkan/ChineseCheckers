package trylma;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;


public class Board{
    boolean marbleSelected=false;
    int selectedMarbleX;
    int selectedMarbleY;
    Paint selectedMarbleColor;
    Marbles board[][] = new Marbles[13][17];
    /* This array holds more marbles than there are in the game,
        but this way 2 marbles that are close on the board are also close in array.
        Marbles that are not in game but in the array have there colors set to AQUA,
        that's why AQUA COLORED marbles are ignored when drawing */




    public Board() {

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                board[x][y] = new Marbles();
                board[x][y].setFill(Color.AQUA);

                // For the lambda thing
                int finalX = x;
                int finalY = y;

                board[x][y].setOnMouseClicked(event -> {

                    // Check if move was made this turn
                    boolean madeChoice = false;
                    boolean startedDeciding = false;
                    boolean jumpMade = false;
                    boolean moveMade = false;


                    // Check ID on Click - just for debugging
                    System.out.println("Marble: [" + finalX + ", " + finalY + "]");
                    // Double click to select maybe? Idk, maybe could be useful somehow.
                    if (event.getClickCount() > 1) {
                        System.out.println("Clickd Twice!");
                    }


                    //if one mable is already selected then we are selecting target now
                    if(marbleSelected){

                        if(!jumpMade || !moveMade) {
                            move(finalX, finalY, selectedMarbleX, selectedMarbleY, selectedMarbleColor);
                        }

                        // Adding jump logic. If a move is illegal, then instead of fail
                        // we can check if it was supposed to jump move instead
                        // if it was jump then we still allow to perform jumps
                        // and end turn, but user cant make regular moves anymore

                        if(!moveMade) {
                            jump(finalX, finalY, selectedMarbleX, selectedMarbleY, selectedMarbleColor);
                        }

                        // This is missing some kind of if statement or anything that checks
                        // If jump was performed - if yes, then boolean "jumpMade" should be true
                        // and move function isn't possible anymore.
                        // same logic to check if move was done

                        board[selectedMarbleX][selectedMarbleY].setRadius(15 * 1.33);
                        marbleSelected=false;

                    }
                    //if no marbles are selected we are selecting a marble to move, it must be non GRAY
                    else if(!Color.GRAY.equals(board[finalX][finalY].getFill())){
                        marbleSelected=true;
                        selectedMarbleX=finalX;
                        selectedMarbleY=finalY;
                        selectedMarbleColor = board[finalX][finalY].getFill();
                        board[finalX][finalY].setRadius(30);
                    }


                    /*
                    if(board[x][y].getColor == //ActualPlayer.color){
                        if(//= space from where we are moving marble is starting positions for a player) {
                            board[finalX][finalY].setDefaultPlayerColor();
                            int movingThisX = finalX;
                            int movingThisY = finalY;
                            startedDeciding = true;
                        }else{
                            board[finalX][finalY].setDefaultGrayColor();
                            int movingThisX = finalX;
                            int movingThisY = finalY;
                            startedDeciding = true;
                        }
                    }

                    if(startedDeciding == true //&& movePossible(finalX, finalY, movingThisX, movingThisY) == true) {
                        board[finalX][finalY].setFill(//ActualPlayer.color);
                        madeChoice = true;
                    }
                    */

                });
            }
        }


        //sets player 1 as green
        board[6][0].setColor(Color.GREEN);
        board[5][1].setColor(Color.GREEN);
        board[6][1].setColor(Color.GREEN);
        board[5][2].setColor(Color.GREEN);
        board[6][2].setColor(Color.GREEN);
        board[7][2].setColor(Color.GREEN);
        board[4][3].setColor(Color.GREEN);
        board[5][3].setColor(Color.GREEN);
        board[6][3].setColor(Color.GREEN);
        board[7][3].setColor(Color.GREEN);

        //sets player 3 as yellow
        board[0][4].setColor(Color.YELLOW);
        board[1][4].setColor(Color.YELLOW);
        board[2][4].setColor(Color.YELLOW);
        board[3][4].setColor(Color.YELLOW);
        board[0][5].setColor(Color.YELLOW);
        board[1][5].setColor(Color.YELLOW);
        board[2][5].setColor(Color.YELLOW);
        board[1][6].setColor(Color.YELLOW);
        board[2][6].setColor(Color.YELLOW);
        board[1][7].setColor(Color.YELLOW);

        //sets player 5 as pink
        board[10][7].setColor(Color.PINK);
        board[10][6].setColor(Color.PINK);
        board[11][6].setColor(Color.PINK);
        board[9][5].setColor(Color.PINK);
        board[10][5].setColor(Color.PINK);
        board[11][5].setColor(Color.PINK);
        board[9][4].setColor(Color.PINK);
        board[10][4].setColor(Color.PINK);
        board[11][4].setColor(Color.PINK);
        board[12][4].setColor(Color.PINK);

        //sets payer 6 as DARKMAGENTA
        board[0][12].setColor(Color.DARKMAGENTA);
        board[1][12].setColor(Color.DARKMAGENTA);
        board[2][12].setColor(Color.DARKMAGENTA);
        board[3][12].setColor(Color.DARKMAGENTA);
        board[0][11].setColor(Color.DARKMAGENTA);
        board[1][11].setColor(Color.DARKMAGENTA);
        board[2][11].setColor(Color.DARKMAGENTA);
        board[1][10].setColor(Color.DARKMAGENTA);
        board[2][10].setColor(Color.DARKMAGENTA);
        board[1][9].setColor(Color.DARKMAGENTA);

        //sets player 4 as blue
        board[10][9].setColor(Color.BLUE);
        board[10][10].setColor(Color.BLUE);
        board[11][10].setColor(Color.BLUE);
        board[9][11].setColor(Color.BLUE);
        board[10][11].setColor(Color.BLUE);
        board[11][11].setColor(Color.BLUE);
        board[9][12].setColor(Color.BLUE);
        board[10][12].setColor(Color.BLUE);
        board[11][12].setColor(Color.BLUE);
        board[12][12].setColor(Color.BLUE);

        //sets player 2 as red
        board[4][13].setColor(Color.RED);
        board[5][13].setColor(Color.RED);
        board[6][13].setColor(Color.RED);
        board[7][13].setColor(Color.RED);
        board[7][14].setColor(Color.RED);
        board[5][14].setColor(Color.RED);
        board[6][14].setColor(Color.RED);
        board[5][15].setColor(Color.RED);
        board[6][15].setColor(Color.RED);
        board[6][16].setColor(Color.RED);

        //sets the playable area to gray
        board[4][4].setColor(Color.GRAY);
        board[5][4].setColor(Color.GRAY);
        board[6][4].setColor(Color.GRAY);
        board[7][4].setColor(Color.GRAY);
        board[8][4].setColor(Color.GRAY);
        board[3][5].setColor(Color.GRAY);
        board[4][5].setColor(Color.GRAY);
        board[5][5].setColor(Color.GRAY);
        board[6][5].setColor(Color.GRAY);
        board[7][5].setColor(Color.GRAY);
        board[8][5].setColor(Color.GRAY);
        board[3][6].setColor(Color.GRAY);
        board[4][6].setColor(Color.GRAY);
        board[5][6].setColor(Color.GRAY);
        board[6][6].setColor(Color.GRAY);
        board[7][6].setColor(Color.GRAY);
        board[8][6].setColor(Color.GRAY);
        board[9][6].setColor(Color.GRAY);
        board[2][7].setColor(Color.GRAY);
        board[3][7].setColor(Color.GRAY);
        board[4][7].setColor(Color.GRAY);
        board[5][7].setColor(Color.GRAY);
        board[6][7].setColor(Color.GRAY);
        board[7][7].setColor(Color.GRAY);
        board[8][7].setColor(Color.GRAY);
        board[9][7].setColor(Color.GRAY);
        board[2][8].setColor(Color.GRAY);
        board[3][8].setColor(Color.GRAY);
        board[4][8].setColor(Color.GRAY);
        board[5][8].setColor(Color.GRAY);
        board[6][8].setColor(Color.GRAY);
        board[7][8].setColor(Color.GRAY);
        board[8][8].setColor(Color.GRAY);
        board[9][8].setColor(Color.GRAY);
        board[10][8].setColor(Color.GRAY);
        board[2][9].setColor(Color.GRAY);
        board[3][9].setColor(Color.GRAY);
        board[4][9].setColor(Color.GRAY);
        board[5][9].setColor(Color.GRAY);
        board[6][9].setColor(Color.GRAY);
        board[7][9].setColor(Color.GRAY);
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
        //setting all AQUA marbles to null, we dont care 'bout them
        for(int i=0;i<13;i++){
            for(int j=0;j<17;j++){
                if( Color.AQUA.equals(board[i][j].getFill())){
                    board[i][j]=null;
                }
            }
        }
    }
    //self explanatory 
     void move(int hereGoX, int hereGoY, int goingFromX, int goingFromY, Paint player_color){
        try{
            if(movePossible(hereGoX, hereGoY, goingFromX, goingFromY)){
                board[hereGoX][hereGoY].setFill(player_color);
                board[goingFromX][goingFromY].setColor(Color.GRAY);
                System.out.println("MOVE");
            }
            else{
                System.out.println("Illegal Move, Trying Jump"); //debażer

            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    void jump(int hereGoX, int hereGoY, int goingFromX, int goingFromY, Paint player_color){
        try{
            if(jumpPossible(hereGoX, hereGoY, goingFromX, goingFromY)){
                board[hereGoX][hereGoY].setFill(player_color);
                board[goingFromX][goingFromY].setColor(Color.GRAY);
                System.out.println("JUMP");

            }else{
                System.out.println("Illegal Jump"); //debugger

            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    boolean jumpPossible(int hereGoX, int hereGoY, int goingFromX, int goingFromY){

        /* There are 8 direction from which a marble can jump over a marble
           Imagine that we have a clock and we jump from number to the other side
           Over the middle in the clock: like from 3 to 9 or from 12 to 6 etc.

           1 -> 7   [-1, +2]        3 -> 9  [-2, 0]         5 -> 11    [-1, -2]
           7 -> 1   [+1, -2]        9 -> 3  [+2, 0]         11 -> 5    [+1, +2]

           Problem arrises when we change the Board to a custom one cause we need to write logic
           from the beginning again. Hopefully the alghoritm for board will fix this problem and
           we can adjust accordingly.
        */

        if(goingFromX - hereGoX  == 2)
            if(goingFromY - hereGoY == 0)
                if(!(Color.GRAY.equals(board[hereGoX+1][hereGoY].getFill())))
                    return true;

        if(goingFromX - hereGoX == -2)
            if(goingFromY - hereGoY == 0)
                if(!(Color.GRAY.equals(board[hereGoX-1][hereGoY].getFill())))
                    return true;

        // curvature of the board forces to make two checks
        // cause could be placed on even or odd spot

        if(hereGoX - goingFromX == -1)
            if(hereGoY - goingFromY == 2)
                if(!(Color.GRAY.equals(board[hereGoX+1][hereGoY-1].getFill()))){
                    return true;
                }else if (!(Color.GRAY.equals(board[hereGoX][hereGoY-1].getFill())))
                    return true;

        if(hereGoX - goingFromX == -1)
            if(hereGoY - goingFromY == -2)
                if(!(Color.GRAY.equals(board[hereGoX+1][hereGoY+1].getFill()))){
                    return true;
                }else if (!(Color.GRAY.equals(board[hereGoX][hereGoY+1].getFill())))
                    return true;

        if(hereGoX - goingFromX  == 1)
            if(hereGoY - goingFromY == 2)
                if(!(Color.GRAY.equals(board[hereGoX][hereGoY-1].getFill()))) {
                    return true;
                }else if (!(Color.GRAY.equals(board[hereGoX-1][hereGoY-1].getFill())))
                    return true;

        if(hereGoX - goingFromX  == 1)
            if(hereGoY - goingFromY == -2)
                if(!(Color.GRAY.equals(board[hereGoX][hereGoY+1].getFill()))) {
                    return true;
                }else if (!(Color.GRAY.equals(board[hereGoX-1][hereGoY+1].getFill())))
                    return true;



        return false;
    }

    boolean movePossible(int hereGoX, int hereGoY, int goingFromX, int goingFromY){
        if(goingFromX == hereGoX+1 || goingFromX == hereGoX-1 || goingFromX==hereGoX) //must be close
            if(goingFromY == hereGoY+1 || goingFromY == hereGoY-1 || goingFromY == hereGoY)
                if(Color.GRAY.equals(board[hereGoX][hereGoY].getFill())) // target must be gray
                    if(!(goingFromX+1 == hereGoX && goingFromY%2 == 0 && goingFromY-1 == hereGoY) && !(goingFromX-1 == hereGoX && goingFromX%2 == 1 && goingFromY+1 == hereGoY))
                        return true;

        return false;
    }


}