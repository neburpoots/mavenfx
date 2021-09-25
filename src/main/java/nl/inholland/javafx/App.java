package nl.inholland.javafx;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
        window.setTitle("Car rental");

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        Label numDaysRented = new Label("Number of days rented: ");
        gridPane.add(numDaysRented, 0,0);

        TextField numDaysRentedTxt = new TextField();
        gridPane.add(numDaysRentedTxt, 1, 0);

        Label numOfKilometers = new Label("Number of kilometers driven: ");
        gridPane.add(numOfKilometers, 0,1);

        TextField numOfKilometersTxt = new TextField();
        gridPane.add(numOfKilometersTxt, 1, 1);

        CheckBox cb1 = new CheckBox("Fuel tank not full when returned");
        gridPane.add(cb1, 0, 2);

        Label numLiters = new Label("Number of liters: ");
        gridPane.add(numLiters, 0,3);

        TextField numLitersTxt = new TextField();
        gridPane.add(numLitersTxt, 1, 3);

        Button calculatePayment = new Button("Calculate payment");
        gridPane.add(calculatePayment, 1, 4);

        Label amountlbl = new Label("Amount due: ");
        gridPane.add(amountlbl, 0,5);

        Label amountLblInput = new Label("");
        gridPane.add(amountLblInput, 1,5);

        calculatePayment.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double price = 0;
                int numDays = Integer.getInteger(numDaysRentedTxt.getText());
                int numKilometers = Integer.getInteger(numOfKilometersTxt.getText());
                int numLiters = 0;

                price = numDays * 45;
                if(numKilometers > 100) {
                    price += (numKilometers - 100) * 0.25;
                }

                if(cb1.isSelected()) {
                    numLiters = Integer.getInteger(numLitersTxt.getText());
                    price += numLiters * 2;
                }

                //amountLblInput.setText();
            }
        });


        gridPane.setHgap(20);
        gridPane.setVgap(20);
        Scene scene = new Scene(gridPane);
        window.setScene(scene);
        window.show();
    }
}
