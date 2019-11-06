import javafx.application.Application;
import javafx.stage.Stage;

//4787150

public class Main extends Application{

    public void start(Stage primaryStage) throws Exception {

        Controller controller = new Controller();
        controller.startStage(primaryStage);


    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        super.stop(); //To change body of generated methods, choose Tools | Templates.
        System.exit(0);
    }
}

