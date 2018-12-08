package trylma;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.io.IOException;

public class OptionsController {

    // Game Options
    @FXML
    private ComboBox numberOfPlayers;
    private ObservableList<String> numberOfPlayersList = FXCollections.observableArrayList("1", "2", "3", "4", "6");

    @FXML
    private ComboBox typeOfBoard;
    private ObservableList<String> typeOfBoardList = FXCollections.observableArrayList("6-Shaped Start");

    @FXML
    private ComboBox ruleSet;
    private ObservableList<String> ruleSetList = FXCollections.observableArrayList("Blocked Switch", "Blocked Loses");


    // CPU Options
    @FXML
    private ComboBox numberOfCPU;
    private ObservableList<String> numberOfCPUList = FXCollections.observableArrayList("0", "1", "2", "3", "5");


    // Connection
    @FXML
    private TextField givenIP;
    @FXML
    private TextField givenPort;


    // Graphic
    @FXML
    private Slider sliderSizeOfBoard;


    // Initialize
    @FXML
    private void initialize(){
        numberOfPlayers.setValue("6");
        numberOfPlayers.setItems(numberOfPlayersList);

        typeOfBoard.setValue("6-Shaped Star");
        typeOfBoard.setItems(typeOfBoardList);

        ruleSet.setValue("Blocked Switch");
        ruleSet.setItems(ruleSetList);

        numberOfCPU.setValue("0");
        numberOfCPU.setItems(numberOfCPUList);
    }


    // Return Variables from options with getters
    private int TotalPlayers;
    private int NumberOfPlayers;
    private int NumberOfCPU;
    private String TypeOfBoard;
    private String RuleSet;
    private String IPPort;

    public int getTotalPlayers() {
        return TotalPlayers;
    }

    public int getNumberOfPlayers() {
        return this.NumberOfPlayers;
    }

    public int getNumberOfCPU() {
        return this.NumberOfCPU;
    }

    public String getTypeOfBoard() {
        return this.TypeOfBoard;
    }

    public String getRuleSet() {
        return this.RuleSet;
    }

    public String getIPPort() {
        return this.IPPort;
    }


    // Confirmation Button
    public final void confirmOptions (ActionEvent actionEvent) throws IOException {

        // Getting number from String
        String NumberOfPlayersString = numberOfPlayers.getValue().toString();
        NumberOfPlayers = Integer.parseInt(NumberOfPlayersString);

        // Getting number from String
        String NumberOfCPUString = numberOfCPU.getValue().toString();
        NumberOfCPU = Integer.parseInt(NumberOfCPUString);

        TotalPlayers = NumberOfPlayers + NumberOfCPU;
        TypeOfBoard = typeOfBoard.getValue().toString();
        RuleSet = ruleSet.getValue().toString();
        IPPort = givenIP.getText() + ":" + givenPort.getText();

        if(TotalPlayers == 2 || TotalPlayers == 3 || TotalPlayers == 4 || TotalPlayers == 6){

            // Game Options
            System.out.println("Total Players: " + TotalPlayers);
            System.out.println("Real/CPU: [" + NumberOfPlayers + "/" + NumberOfCPU + "]");
            System.out.println("Type of Board: " + TypeOfBoard);
            System.out.println("Ruleset: " + RuleSet);

            // Connection
            System.out.println("IP/port: " + IPPort);

            // Graphic Size Change - my god, it doesn't work, idk why.
            //System.out.println("Size of Board: " + sliderSizeOfBoard.getValue());

            main.showMainMenu();
        }
    }



    // Stuff to accept / cancel the options
    private Main main;

    @FXML
    private void goMainMenu() throws IOException {
        main.showMainMenu();
    }
}
