package nl.inholland.javafx;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;
import java.text.DecimalFormat;

public class App extends Application {
    @Override
    public void start(Stage window) throws Exception {
        window.setHeight(400);
        window.setWidth(400);
        window.setTitle("Currency converter");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label userNameLabel = new Label("Amount €: ");
        gridPane.add(userNameLabel, 0,1);

        TextField userNameTextField = new TextField();
        gridPane.add(userNameTextField, 1, 1);

        Button Convert = new Button("Convert Euro to Dollar");
        gridPane.add(Convert, 1, 2);

        Label amountlbl = new Label("Amount $: ");
        gridPane.add(amountlbl, 0,5);

        StringProperty amountProp = userNameTextField.textProperty();
        Label Amount = new Label("0");
        gridPane.add(Amount, 1,5);

        Convert.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
            double convertAmount = Double.parseDouble(userNameTextField.getText());
            convertAmount = convertAmount * 1.17;
            String result = String.format("%.2f", convertAmount);
            Amount.setText(result);
            }
        });



        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.show();
    }
}
