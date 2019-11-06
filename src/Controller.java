import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.Scene;


import java.io.File;
import java.io.FileNotFoundException;

public class Controller {

    @FXML
    private AnchorPane configPanel;
    @FXML
    private Label infoLabel1;
    @FXML
    private Label infoLabel2;
    @FXML
    private Label infoLabel3;
    @FXML
    private TextField accountTxt;
    @FXML
    private TextField delayTxt;
    @FXML
    private RadioButton radioRegional;
    @FXML
    private RadioButton radioGlobal;
    @FXML
    private Button btn_start;
    @FXML
    private Button btn_stop;
    @FXML
    private Button btn_configure;

    private Loop loop;


    public void startStage(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("UpdatePP");
        primaryStage.setScene(new Scene(root, 350, 200));
        primaryStage.show();
        primaryStage.getIcons().add(
                new Image(
                        Controller.class.getResourceAsStream( "osulogo.png" ))); ;

    }

    @FXML
    void onMouseEnter(){
        File file = new File("login.peppy");
        if (!file.isFile()) {
            infoLabel1.setText("     Looks like you don't");
            infoLabel2.setText("    have a settings file yet,");
            infoLabel3.setText("       please set your id.");
        }


    }

    @FXML
    void onSaveConfig(){
        this.configPanel.setVisible(false);
        this.btn_start.setDisable(false);
        TxtMan.saveFile(accountTxt.getText(), radioRegional.isSelected(), Integer.parseInt(delayTxt.getText()));
        infoLabel1.setText("                 Saved");
        infoLabel2.setText("");
        infoLabel3.setText("");
    }

    @FXML
    void onPressStart(ActionEvent event) throws Exception {
        TxtMan parsedJson = TxtMan.retrieveInfo();
        String id = parsedJson.getId();
        String url = "https://osu.ppy.sh/api/get_user?k=c78156f8a36708af0ac5f6d4d9b5f75ba0b2c2d9&u=" + id + "&m=0&type=id";
        String json = UrlMan.readUrl(url);
        loop = new Loop(parsedJson.getMs(), url);
        this.btn_stop.setDisable(false);
        this.btn_start.setDisable(true);
        this.btn_configure.setDisable(true);
        infoLabel1.setText("Running...");
        infoLabel2.setText("Username: " + TxtMan.parseJson(json)[0].getUsername());
        infoLabel3.setText("Initial Position: " + TxtMan.getPosition(json));

    }

    @FXML
    void onPressStop(ActionEvent event){
        loop.stopLoop();
        this.btn_start.setDisable(false);
        this.btn_stop.setDisable(true);
        this.btn_configure.setDisable(false);
        infoLabel1.setText("Stopped");
        infoLabel2.setText("");
        infoLabel3.setText("");
    }

    @FXML
    void onDisplayConfig() throws FileNotFoundException {
        if (this.configPanel.isVisible()) {
            this.configPanel.setVisible(false);
            this.btn_start.setDisable(false);
        } else {
            File file = new File("login.peppy");
            if (file.isFile()) {
                accountTxt.setText(TxtMan.retrieveInfo().getId());
                delayTxt.setText(String.valueOf(TxtMan.retrieveInfo().getMs()));
                if (!TxtMan.retrieveInfo().isCountry()){
                    radioRegional.setSelected(false);
                    radioGlobal.setSelected(true);
                }
            }
            this.configPanel.setVisible(true);
            this.btn_start.setDisable(true);
        }

    }

    @FXML
    void onMouseStop(){

    }
}
