package trylma;

import javafx.scene.paint.Color;

public class Marbles extends javafx.scene.shape.Circle {

    void setColor(Color color) {
    this.setFill(color);
    }

    void setDefaultColor(){
        this.setFill(Color.GRAY);
    }

    public void setDefaultColorWherePlayerStarted(){
        this.setFill(Color.DARKGRAY);
    }

    public void setPlayer1Color(){
        this.setFill(Color.GREEN);
    }

    public void setPlayer2Color(){
        this.setFill(Color.RED);
    }

    public void setPlayer3Color(){
        this.setFill(Color.YELLOW);
    }

    public void setPlayer4Color(){
        this.setFill(Color.BLUE);
    }

    public void setPlayer5Color(){
        this.setFill(Color.PINK);
    }

    public void setPlayer6Color(){
        this.setFill(Color.DARKMAGENTA);
    }

    /*
    public void getColor(Color color) {
        this.getColor(color);
    }
    I dont know why get Color should be null so i put it in comments couse it makes my life hard
    */
}

