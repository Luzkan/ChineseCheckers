package trylma;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Board{
    Marbles board[][] = new Marbles[13][17]; //This array holds more marbles than there are in the game, but this way 2 marbles that are close on the board are also close in array.
    //Marbles that are not in game but in the array have thiere collors set to AQUA, that's why AQUA COLORED marbles are ignored when drawing

    public Board() {

        for (int x = 0; x < 13; x++) {
            for (int y = 0; y < 17; y++) {
                board[x][y] = new Marbles();
                board[x][y].setFill(Color.AQUA);
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
    }
}