package trylma;

import java.io.FileOutputStream;
import java.util.prefs.Preferences;

public class OptionsComputing {

    private int TotalPlayers;
    private int NumberOfPlayers;
    private int NumberOfCPU;
    private String TypeOfBoard;
    private String RuleSet;
    private String IPPort;

    private Preferences chinesePrefs;

    // (J) Saves settings to a file
    private void setPreference(String type, String value) {

        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        chinesePrefs.put(type, value);

        try {
            chinesePrefs.exportNode(new FileOutputStream("checkersPrefs.xml"));
            System.out.println("[Options] Saved '" + type + "' with value '" + chinesePrefs.get(type, value) + "'");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // (J) Getters & Setters
    int getTotalPlayers() {
        int defaultValue = 6;
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        TotalPlayers = chinesePrefs.getInt("totalPlayers", defaultValue);
        return TotalPlayers;
    }

    protected void setTotalPlayers(int totalPlayers) {
        TotalPlayers = totalPlayers;
        String TotalPlayersString = Integer.toString(TotalPlayers);
        setPreference("totalPlayers", TotalPlayersString);
    }

    public int getNumberOfPlayers() {
        int defaultValue = 6;
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        NumberOfPlayers = chinesePrefs.getInt("numberOfPlayers", defaultValue);
        return NumberOfPlayers;
    }

    protected void setNumberOfPlayers(int numberOfPlayers) {
        NumberOfPlayers = numberOfPlayers;
        String NumberOfPlayersString = Integer.toString(NumberOfPlayers);
        setPreference("numberOfPlayers", NumberOfPlayersString);
    }

    public int getNumberOfCPU() {
        int defaultValue = 0;
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        NumberOfCPU = chinesePrefs.getInt("numberOfCPU", defaultValue);
        return NumberOfCPU;
    }

    protected void setNumberOfCPU(int numberOfCPU) {
        NumberOfCPU = numberOfCPU;
        String NumberOfCPUString = Integer.toString(NumberOfCPU);
        setPreference("numberOfCPU", NumberOfCPUString);
    }

    public String getTypeOfBoard() {
        String defaultValue = "6-Shaped Start";
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        TypeOfBoard = chinesePrefs.get("numberOfCPU", defaultValue);
        return TypeOfBoard;
    }

    protected void setTypeOfBoard(String typeOfBoard) {
        TypeOfBoard = typeOfBoard;
        setPreference("typeOfBoard", TypeOfBoard);
    }

    public String getRuleSet() {
        String defaultValue = "Blocked Switch";
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        RuleSet = chinesePrefs.get("ruleSet", defaultValue);
        return RuleSet;
    }

    protected void setRuleSet(String ruleSet) {
        RuleSet = ruleSet;
        setPreference("ruleSet", RuleSet);
    }

    public String getIPPort() {
        String defaultValue = "127.0.0.1:3306";
        chinesePrefs = Preferences.userRoot().node(this.getClass().getName());
        IPPort = chinesePrefs.get("ipPort", defaultValue);
        return IPPort;
    }

    protected void setIPPort(String IPPort) {
        this.IPPort = IPPort;
        setPreference("ipPort", IPPort);
    }
}
