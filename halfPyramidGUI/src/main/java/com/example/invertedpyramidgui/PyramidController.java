package com.example.invertedpyramidgui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.stream.Stream;

public class PyramidController {
    @FXML
    private VBox containerVBox;
    @FXML
    private TextField inputTextField;
    Color cremeColor = Color.rgb(224, 218, 201);
    BackgroundFill cremeFill = new BackgroundFill(cremeColor, null, null);
    Background cremeBackground = new Background(cremeFill);
    Region lineBreakRegion = new Region();

    @FXML
    protected void onCriarButtonClick() {

        int[] list = Stream.of((inputTextField.getText()).split("\\s+")).mapToInt(Integer::parseInt).toArray();
        double calculoDasLinhas = (-1 + Math.sqrt(1 + 8 * list.length))/2;
        int numeroDeLinhas = (int)Math.ceil(calculoDasLinhas);

        for(int i = 0, k = 0; i < numeroDeLinhas; i++) {
            HBox newHBox = new HBox(5);
            for(int j = 0; j <= i; j++) {
                if(k > (list.length - 1)) {
                    break;
                }
                Label brickText = new Label(String.valueOf(list[k++]));
                brickText.setAlignment(javafx.geometry.Pos.CENTER);
                brickText.setPrefHeight(6);
                brickText.setPrefWidth(20);
                brickText.setBackground(cremeBackground);
                newHBox.getChildren().add(brickText);
            }
            containerVBox.getChildren().add(newHBox);
        }

        int[] tempArray = null;
        int[] menorNumero = new int[numeroDeLinhas];

        for(int i = 0, j = 0, k = 0; i < numeroDeLinhas; i++, j = k) {
            if(k >= 1) {
                k = k + tempArray.length + 1;
                if(k > list.length) {
                    k = list.length;
                }
            } else {
                k++;
            }
            tempArray = Arrays.copyOfRange(list, j, k);

            int menorNum = tempArray[0];
            for (int value : tempArray) {
                if (menorNum > value) {
                    menorNum = value;
                }
            }
            menorNumero[i] = menorNum;
        }

        int soma = 0;
        for (int j : menorNumero) {
            soma = soma + j;
        }

        lineBreakRegion.setPrefHeight(20);
        containerVBox.getChildren().add(lineBreakRegion);
        Label menoresNumeros = new Label("Menores de cada linha: " + Arrays.toString(menorNumero));
        Label somaMenores = new Label("Soma dos menores: " + soma);
        menoresNumeros.setTextFill(cremeColor);
        somaMenores.setTextFill(cremeColor);
        containerVBox.getChildren().add(menoresNumeros);
        containerVBox.getChildren().add(somaMenores);
    }
}