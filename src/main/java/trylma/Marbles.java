package trylma;

import javafx.scene.paint.Color;

public class Marbles extends javafx.scene.shape.Circle {

    void setColor(Color color) {
    this.setFill(color);
    }

    void setDefaultColor(){
        this.setFill(Color.GRAY);
    }

   
}

