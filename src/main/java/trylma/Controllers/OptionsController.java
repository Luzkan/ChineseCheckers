package trylma.Controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import trylma.Main;
import trylma.OptionsComputing;

import java.io.IOException;

public class OptionsController extends OptionsComputing {

    // (J) Game Options
    @FXML
    private ComboBox<String> numberOfPlayers;
    private ObservableList<String> numberOfPlayersList = FXCollections.observableArrayList("1", "2", "3", "4", "6");

    @FXML
    private ComboBox<String> typeOfBoard;
    private ObservableList<String> typeOfBoardList = FXCollections.observableArrayList("6-Shaped Start");

    @FXML
    private ComboBox<String> ruleSet;
    private ObservableList<String> ruleSetList = FXCollections.observableArrayList("Blocked Switch", "Blocked Loses");


    // (J) CPU Options
    @FXML
    private ComboBox<String> numberOfCPU;
    private ObservableList<String> numberOfCPUList = FXCollections.observableArrayList("0", "1", "2", "3", "5");


    // (J) Initialize
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


    // (J) Confirmation Button
    public final void confirmOptions (ActionEvent actionEvent) throws IOException {

        // (J) Getting number from String
        String NumberOfPlayersString = numberOfPlayers.getValue();
        int numberOfPlayers1 = Integer.parseInt(NumberOfPlayersString);

        // (J) Getting number from String
        String NumberOfCPUString = numberOfCPU.getValue();
        int numberOfCPU1 = Integer.parseInt(NumberOfCPUString);

        // (J) Calculating Total Players and Creating Port/IP
        int totalPlayers = numberOfPlayers1 + numberOfCPU1;


        // (J) Checks if amount of players is correct
        if(totalPlayers == 2 || totalPlayers == 3 || totalPlayers == 4 || totalPlayers == 6){

            // (J) Game Options
            setTotalPlayers(totalPlayers);
            setNumberOfPlayers(numberOfPlayers1);
            setNumberOfCPU(numberOfCPU1);
            setTypeOfBoard(typeOfBoard.getValue());
            setRuleSet(ruleSet.getValue());

            Main.showMainMenu();
        }
    }

    @FXML
    private void goMainMenu() throws IOException {
        Main.showMainMenu();
    }
}