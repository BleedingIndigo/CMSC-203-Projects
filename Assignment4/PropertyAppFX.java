
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyAppFX extends Application {
    private ManagementCompany company =
            new ManagementCompany("Sunrise Management", "12345");

    private TextField propertyNameField;
    private TextField cityField;
    private TextField rentAmountField;
    private TextField ownerField;
    private TextArea outputArea;

    @Override
    public void start(Stage primaryStage) {
        propertyNameField = new TextField();
        cityField = new TextField();
        rentAmountField = new TextField();
        ownerField = new TextField();

        Button addButton = new Button("Add Property");
        Button totalRentButton =
                new Button("Calculate Total Rent");

        outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setWrapText(true);
        outputArea.setPrefRowCount(12);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(new Label("Property Name:"), 0, 0);
        grid.add(propertyNameField, 1, 0);
        grid.add(new Label("City:"), 0, 1);
        grid.add(cityField, 1, 1);
        grid.add(new Label("Rent Amount:"), 0, 2);
        grid.add(rentAmountField, 1, 2);
        grid.add(new Label("Owner:"), 0, 3);
        grid.add(ownerField, 1, 3);

        HBox buttons = new HBox(10, addButton, totalRentButton);

        addButton.setOnAction(event -> {
            try {
                String propertyName = propertyNameField.getText().trim();
                String city = cityField.getText().trim();
                String owner = ownerField.getText().trim();
                double rentAmount = Double.parseDouble(
                        rentAmountField.getText().trim());

                if (propertyName.isEmpty() || city.isEmpty()
                        || owner.isEmpty() || !Double.isFinite(rentAmount)
                        || rentAmount < 0) {
                    outputArea.setText(
                            "Enter a name, city, owner, and valid rent.");
                    return;
                }

                Property property = new Property(
                        propertyName, city, rentAmount, owner);

                int index = company.addProperty(property);

                if (index >= 0) {
                    outputArea.setText(company.toString());
                    propertyNameField.clear();
                    cityField.clear();
                    rentAmountField.clear();
                    ownerField.clear();
                } else {
                    outputArea.setText(
                            "The property array is full. Maximum: "
                                    + ManagementCompany.MAX_PROPERTIES);
                }
            } catch (NumberFormatException ex) {
                outputArea.setText("Enter a valid number for rent.");
            }
        });

        totalRentButton.setOnAction(event ->
                outputArea.setText(company.toString()));

        VBox layout = new VBox(
                15,
                new Label("Property Management System"),
                grid,
                buttons,
                new Label("Property Information:"),
                outputArea
        );

        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 600, 550);
        primaryStage.setTitle("Property Management");
        primaryStage.setScene(scene);
        primaryStage.show();

        outputArea.setText(company.toString());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
