package trylma;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class Marbles extends javafx.scene.shape.Circle {

        public void setDefaultGrayColor(Color color) {
            this.setFill(Color.GRAY);
        }

        public void setDefaultPlayerColor(Color color) {
            this.setFill(Color.DARKGRAY);
        }

        public void setColor(Color color) {
            this.setFill(color);
        }

       /* public void getColor(Color color) {
            this.getColor(color);
        }
        I dont know why get Color should be null so i put it in comments couse it makes my life hard
        */
    //Check ID on Click - just for debugging

}

