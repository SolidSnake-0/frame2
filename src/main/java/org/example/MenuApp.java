package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MenuApp extends Application {

    private static final java.lang.String COLOR_FONDO = "#e3a663";
    private static final java.lang.String COLOR_ITEM_FONDO = "#f9e1c4";
    private static final java.lang.String COLOR_BOTON = "#d3d3d3";

    @Override
    public void start(Stage escenarioPrincipal) {
        VBox diseñoPrincipal = new VBox(10);
        diseñoPrincipal.setPadding(new Insets(20, 20, 20, 20));

        Text titulo = new Text("Frontera Market (UFMARK)");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setFill(Color.BROWN);

        Text saludo = new Text("Hola, Franco!\nBUENOS DÍAS");
        saludo.setFont(Font.font("Arial", FontWeight.BOLD, 22));
        saludo.setFill(Color.DARKGREEN);

        VBox cajaMenu = new VBox(10);
        cajaMenu.setPadding(new Insets(20));
        cajaMenu.setStyle("-fx-background-color: " + COLOR_FONDO + "; -fx-border-radius: 10; -fx-background-radius: 10;");

        List<String> itemsMenu = crearListaItemsMenu();

        for (String item : itemsMenu) {
            String[] detallesItem = item.split(" - ");
            cajaMenu.getChildren().add(crearItemMenu(detallesItem[0], detallesItem[1], detallesItem[2]));
        }

        Button botonPedido = new Button("Pedir");
        botonPedido.setStyle("-fx-background-color: " + COLOR_BOTON + "; -fx-text-fill: black;");
        botonPedido.setOnAction(e -> procesarPedido());

        VBox diseñoFinal = new VBox(20, titulo, saludo, new Label("Categorías de Menú"), cajaMenu, botonPedido);
        diseñoFinal.setPadding(new Insets(20));

        ScrollPane scrollPane = new ScrollPane(diseñoFinal);
        scrollPane.setFitToWidth(true);

        Scene escena = new Scene(scrollPane, 400, 600);
        escenarioPrincipal.setTitle("Frontera Market (UFMARK) - Menú");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    private HBox crearItemMenu(String nombre, String precio, String descripcion) {
        VBox cajaItem = new VBox(5);
        cajaItem.setPadding(new Insets(10));
        cajaItem.setStyle("-fx-background-color: " + COLOR_ITEM_FONDO + "; -fx-border-radius: 10; -fx-background-radius: 10;");

        Text tituloItem = new Text(nombre + " - " + precio);
        tituloItem.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        tituloItem.setFill(Color.BROWN);

        Label descripcionItem = new Label(descripcion);
        descripcionItem.setFont(Font.font("Arial", 12));
        descripcionItem.setTextFill(Color.BLACK);
        descripcionItem.setWrapText(true);

        cajaItem.getChildren().addAll(tituloItem, descripcionItem);

        return new HBox(cajaItem);
    }

    private List<String> crearListaItemsMenu() {
        List<String> itemsMenu = new ArrayList<>();
        itemsMenu.add("Menú Baes - 1850$ - Arvejas Partidas, Fruta, Jugo y/o Agua");
        itemsMenu.add("Menú Junaeb Baes - 2100$ - Ensalada o Sopa, Arvejas Partidas, Fruta, Jugo y/o Agua");
        itemsMenu.add("Menú Ejecutivo - 3500$ - Ensalada, Sopa, Arvejas Partidas, Fruta-postre, Jugo y/o Agua");
        itemsMenu.add("Menú Hipocalórico - 3500$ - Ensalada o Crema, Cornet de Jamón, Postre, Agua");
        itemsMenu.add("Menú Vegetariano - 3500$ - Ensalada o Sopa, Arvejas Partidas, Pan, Jugo y/o Fruta");
        itemsMenu.add("Menú Vegano - 3500$ - Ensalada o Sopa, Arvejas Partidas, Postre, Jugo y/o Fruta");
        return itemsMenu;
    }

    private void procesarPedido() {
        System.out.println("Pedido realizado!");
        // lógica para procesar el pedido
    }

    public static void main(String[] args) {
        launch(args);
    }
}
