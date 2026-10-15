import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FXMainPane extends VBox {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;

    private Label label;
    private TextField textField;

    private HBox buttonBox;
    private HBox feedbackBox;

    private DataManager dataManager;

    public FXMainPane() {
        button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");

        label = new Label("Feedback:");
        textField = new TextField();
        textField.setEditable(false);

        buttonBox = new HBox(10);
        feedbackBox = new HBox(10);

        dataManager = new DataManager();

        setPadding(new Insets(20));
        setSpacing(20);
        setAlignment(Pos.CENTER);

        buttonBox.setAlignment(Pos.CENTER);
        feedbackBox.setAlignment(Pos.CENTER);

        buttonBox.getChildren().addAll(
            button1, button2, button3, button4, button5
        );

        feedbackBox.getChildren().addAll(label, textField);

        getChildren().addAll(buttonBox, feedbackBox);

        button1.setOnAction(e ->
            textField.setText(dataManager.getHello())
        );

        button2.setOnAction(e ->
            textField.setText(dataManager.getHowdy())
        );

        button3.setOnAction(e ->
            textField.setText(dataManager.getChinese())
        );

        button4.setOnAction(e ->
            textField.clear()
        );

        button5.setOnAction(e ->
            Platform.exit()
        );
    }
}