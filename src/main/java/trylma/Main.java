package trylma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane MainWindow;

    @Override
    public final void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chinese Checkers");
        showWholeWindow();
        showMainMenu();
    }

    // Main Window in which everything will happen.
    // Like all screens (mainmenu, the game and options are in this this dude right here)
    private void showWholeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainWindow.fxml"));
        MainWindow = loader.load();
        Scene scene = new Scene(MainWindow);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Main Menu
    public static void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainMenu.fxml"));
        BorderPane MainMenu = loader.load();
        MainWindow.setCenter(MainMenu);
    }

    // The Game
    public static void showPlayGame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/PlayGame.fxml"));
        BorderPane PlayGame = loader.load();

        /*
        ^ About this code
        I think we should keep it as main display for PlayGame
        That's why im changing the code to work like that:

        Canvas from below could be just the Center of that BorderPane

        This way we can easily add a menu to the right/left with additional stuff
        Check this image: https://i.imgur.com/EwAIbYK.png
        */

        Canvas theGame = new Canvas(600,600);
        Group root = new Group(theGame);

        // Getting the options from Options

        OptionsController options = new OptionsController();
        int totalPlayersNumber = options.getTotalPlayers();
        int numberOfPlayers = options.getNumberOfPlayers();
        int numberOfCPU = options.getNumberOfCPU();
        String typeOfBoard = options.getTypeOfBoard();
        String ruleSet = options.getRuleSet();
        String IPPort = options.getIPPort();

        // This thing returns 0 >:[
        System.out.println("Total Number of Players: " + totalPlayersNumber);

        Board board = new Board(6);
        for (int x = 0; x < 13; x++) {
            int posX=x*40+50;
            for (int y = 0; y < 17; y++) {
                if(board.board[x][y] != null) {

                    // Adding extrasize value to resize the board
                    // Might be helpfull later

                    double extraSize = 1.33;
                    int posY = y * 40 + 50;
                    board.board[x][y].setCenterY(posY * extraSize);
                    board.board[x][y].setCenterX(posX * extraSize);
                    if (y % 2 == 1) board.board[x][y].setCenterX((posX + 20) * extraSize);
                    board.board[x][y].setRadius(15 * extraSize);
                    root.getChildren().addAll(board.board[x][y]);
                }
            }
        }

        //primaryStage.setMaximized(true);
        MainWindow.setCenter(PlayGame);
        PlayGame.setCenter(root);
    }

    // Options Menu
    public static void showOptions() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/Options.fxml"));
        BorderPane Options = loader.load();
        MainWindow.setCenter(Options);
    }

    public static void main(String[] args) {
        launch(args);
    }
}