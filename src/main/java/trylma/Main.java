package trylma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private static Stage primaryStage;
    private static BorderPane MainWindow;

    // Starting parameters
    @Override
    public final void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chinese Checkers");
        showWholeWindow();
        showMainMenu();
    }

    // Main Window in which everything will happen.
    // Like all screens (mainmenu, the game and options are children of this dude right here
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
        MainWindow.setCenter(PlayGame);
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



/* General rules:
    1. We try to not make the code look like crap
        (at the beginning)
    2. JaxaFX
    3. English in the project

    TODO:
        = Core =
        (setting up the game):
            1. Create simple menu
                - Selectable number of players
                - Play button
                = Later on:
                    - Selectable amount of checkers
                    - Selectable type of board
                    - Selectable set of rules
                    - Selectable amount of CPU opponents of the players
            2. Create the board (6-star shape)
            3. Create options for # of players
                - 2, 3, 4 or 6 players options
                * DECIDE:
                    [ ] Switch statement for listed above
                    [ ] Some kind of dynamic fill
            4. Create checkers fill depending on #3.
                - Checkers should have ID's

        = Basic =
        (playing the game)
            5. Who's first
                * DECIDE:
                    [X] From starting player and then clockwise left
                    [ ] Based on value from RNG "coinflip"
                    nvm, checked the rules, its the upper option.
            6. Checkers movement
                * DECIDE:
                    [ ] Press checker and press spot
                    [ ] Dragable
            7. Limit movement to given rules
                & Checker can move in all directions that are "forward"
            8. Game win condition

            From this point the game should be usable and ready to play
            with two players sitting next to the "gaming station" lol


        Later on:

        = Multiplayer =
        (client-server)
            - Stay positive

        = Singleplayer =
        (basic algorithms opponent)
            My proposition:
            - CPU gets "DistanceToWin" value
            - CPU wants to decrease that value to 0 on every of his checkers
            - CPU checks if a move will make his value of DistanceToWin lower
            - CPU will check if a move if possible - if yes, then he is doing it
            - If not, then he looks for another movement
            & This way CPU will always make the same movements that are trying to lead him to win
                But that sucks. To make it more random, lets just make him more random.
            - CPU will get random number to decide which checker will be moved and
                another random number to which direction will he move
                that meets the conditions.


        For a good start I created the project using Maven
        Added folders, redirected windows to use fxml folder so make it more clear
        And added the graphical skeleton of all possible windows that we need

        So we got all the JavaFX thing set-up and ready to go
        Options are usable and detectable
        Just run the program and take a look

        Running on: - Java 1.8
                    - Use Maven (import it with Maven)

        Package is called Trylma cause that's what pop-ups from google if u type in
        "Chińskie Warcaby xD"

        Marcel Jerzyk @ 05.12.2018 03:04
 */