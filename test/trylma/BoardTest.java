package trylma;

import javafx.scene.paint.Color;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class BoardTest {
    @Test
    public void Boardtests(){
        Board board6=new Board(6);
        Assert.assertFalse(board6.movePossible(0,0,0,0));
    }
    @Test
    public void Boardtest(){
        Board board=new Board(6);
        board.board[4][13].setFill(Color.GREEN);
        board.board[6][16].setFill(Color.GREEN);
        Board.turnManager();
        Assert.assertFalse(board.winCondition());
        
    }
}
