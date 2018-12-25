package trylma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.InetAddress;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane MainWindow;

    @Override
    public final void start(Stage primaryStage) throws IOException {
        Main.primaryStage = primaryStage;
        Main.primaryStage.setTitle("Chinese Checkers");
        showWholeWindow();
        showMainMenu();
    }


    // (J) Main Window in which everything will happen.
    // Like all screens (mainmenu, the game and options are in this this dude right here)
    private void showWholeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainWindow.fxml"));
        MainWindow = loader.load();
        Scene scene = new Scene(MainWindow);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    // (J) Main Menu
    public static void showMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/MainMenu.fxml"));
        BorderPane MainMenu = loader.load();
        MainWindow.setCenter(MainMenu);
    }

    // (J) Connection
    public static void showConnection() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/Connection.fxml"));
        BorderPane Connection = loader.load();
        MainWindow.setCenter(Connection);
    }

    // (J) The Game
    public static void showPlayGame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/PlayGame.fxml"));
        BorderPane PlayGame = loader.load();

        /* (J)
        ^ About this code
        I think we should keep it as main display for PlayGame
        That's why im changing the code to work like that:

        Canvas from below could be just the Center of that BorderPane

        This way we can easily add a menu to the right/left with additional stuff
        Check this image: https://i.imgur.com/EwAIbYK.png
        */

        // (J) ??? Why this canvas is 600/600? xD
        Canvas theGame = new Canvas(600,600);
        Group root = new Group(theGame);

        // (J) Getting Options from Options and check
        OptionsComputing options = new OptionsComputing();
        System.out.println("[Game Started]\n===");
        System.out.printf("%-15s %-15s %-15s %-17s %-17s\n", "Total Players", "Human Players", "CPU Players", "Type of Board", "Rule Set");
        System.out.printf("%-15s %-15s %-15s %-17s %-17s\n", options.getTotalPlayers(), options.getNumberOfPlayers(), options.getNumberOfCPU(), options.getTypeOfBoard(), options.getRuleSet());
        System.out.println("===");


        CreateBoard(options.getTotalPlayers(), root);

        //primaryStage.setMaximized(true);
        MainWindow.setCenter(PlayGame);
        PlayGame.setCenter(root);
    }


    // (J) The Game
    public static void showJoinedGame() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/PlayGame.fxml"));
        BorderPane PlayGame = loader.load();
        startClient(); // starts clientThread

        // (J) ??? Why this canvas is 600/600? xD
        Canvas theGame = new Canvas(600,600);
        Group root = new Group(theGame);

        // (J) Getting Options from Options and check
        OptionsComputing options = new OptionsComputing();
        System.out.println("[Joining Game] IP and Port: " + options.getIPPort());

        while(Client.Number_of_players==0){
            //just waiting for it to get inicialized
        }

        // (J) Saw that you are linking #players from client so I'm putting that in
        CreateBoard(Client.Number_of_players, root);

        //primaryStage.setMaximized(true);
        MainWindow.setCenter(PlayGame);
        PlayGame.setCenter(root);
    }


    // (J) Options Menu
    public static void showOptions() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/fxml/Options.fxml"));
        BorderPane Options = loader.load();
        MainWindow.setCenter(Options);
    }


    private static void startClient() {
        // create new thread to handle network communication
        new Thread(() -> {
            System.out.println("Client started.");

            try {
                String serverAddress = InetAddress.getLocalHost().getHostAddress();
                Client client = new Client(serverAddress);
                client.play();
            } catch (Exception ex) {
                System.out.println("Connection Error: " + ex);
            }
        }).start();
    }

    static void CreateBoard(int TotalAmountOfPlayers, Group group){
        Board board = new Board(TotalAmountOfPlayers);
        for (int x = 0; x < 13; x++) {
            int posX=x*40+50;
            for (int y = 0; y < 17; y++) {
                if(board.board[x][y] != null) {
                    // (J) Adding extrasize value to resize the board
                    // Might be helpfull later
                    double extraSize = 1.33;
                    int posY = y * 40 + 50;
                    board.board[x][y].setCenterY(posY * extraSize);
                    board.board[x][y].setCenterX(posX * extraSize);
                    if (y % 2 == 1) board.board[x][y].setCenterX((posX + 20) * extraSize);
                    board.board[x][y].setRadius(15 * extraSize);
                    group.getChildren().addAll(board.board[x][y]);
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}