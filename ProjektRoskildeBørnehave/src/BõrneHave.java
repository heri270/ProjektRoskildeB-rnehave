import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.security.*;

/**
 *
 * Created by andreas on 14-03-2016.
 */
public class BõrneHave extends Application {
    private TableView<Person> table = new TableView<Person>();
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(
                    new Person("Jacob", "22002222", "Jane smith","23/43/56-421"),
                    new Person("Isabella", "22222222", "Rune Johnson","22/22/22-4433"),
                    new Person("Ethan", "22220022", "Rene.williams","33/44/55-1122"),
                    new Person("Emma", "22000022", "Siguard.jones","43/43/99-2233"),
                    new Person("Michael", "22002200", "Hans.brown","55/66/88-4343"),
                    new Person("Hans", "22102222", "Torben Janesen","28/43/56-421"),
                    new Person("Joachim", "22422222", "Thor Storbjørn","28/22/22-4433"),
                    new Person("Christopher", "22520022", "Nr 47","38/44/55-1122"),
                    new Person("Simon", "22600022", "Rigwald Wolfman","48/43/99-2233"),
                    new Person("Lene", "22702200", "Slade Wilson","58/66/88-4343"));
    final HBox hb = new HBox();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        final Label Text = new Label();
        final Label info = new Label();
        final TextArea navn = new TextArea();
        navn.setPromptText("Navn her");
        navn.setMinSize(230,40);
        navn.setMaxSize(240,50);
        final TextArea Kodeord = new TextArea();
        Kodeord.setPromptText("Kodeord her");
        Kodeord.setMaxSize(240,50);
        Kodeord.setMinSize(230,40);
        Button buttonLogin = new Button("Log in");
        Button buttonLogud = new Button("Log ud");
        Button buttonVisAlle = new Button("Vis Alle");
        Button buttonIndskrivning = new Button("Indskrivning");
        Button buttonTilbage = new Button("Tilbage");
        Button buttonVælg = new Button("Vælg");
        VBox vBox = new VBox();
        VBox vBoxLogin = new VBox();
        VBox vboxIndskrivning = new VBox();
        BorderPane borderPane = new BorderPane(vBox);
        BorderPane borderPaneLogIn = new BorderPane(vBoxLogin);
        BorderPane borderPaneInd = new BorderPane(vboxIndskrivning);
        vBox.getChildren().addAll(buttonLogud,buttonIndskrivning,buttonVisAlle);
        vBoxLogin.getChildren().addAll(navn,Kodeord,buttonLogin,Text);
       // vboxIndskrivning.getChildren().addAll(table, hb,info,buttonVælg);
        Scene sceneLogIn = new Scene(borderPaneLogIn);
        Scene scene2 = new Scene(borderPane);
        Scene scene = new Scene(new Group());
        Scene sceneIndsrivning = new Scene(borderPaneInd);
        buttonLogin.setOnAction(event ->{if(Kodeord.getText().equals("Start")&&(navn.getText().equals("Andreas"))){

            stage.setScene(scene2);
        }else {Text.setText("Kodeord eller navn passer ikke sammen");}});
        buttonVisAlle.setOnAction(event -> stage.setScene(scene));
        buttonVælg.setOnAction(event ->{ try{

        } finally {
            info.setText("");
        }
        }
        );
        buttonLogud.setOnAction(event -> stage.close());
        buttonIndskrivning.setOnAction(event -> stage.setScene(sceneIndsrivning));
        buttonTilbage.setOnAction(event -> stage.setScene(scene2));
        stage.setTitle("Oversigt");
        stage.setWidth(450);
        stage.setHeight(550);

        final Label label = new Label("Oplysninger");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);

        TableColumn NavnCol = new TableColumn("Navn");
        NavnCol.setMinWidth(100);
        NavnCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Navn"));

        TableColumn TLFCol = new TableColumn("TLF");
        TLFCol.setMinWidth(100);
        TLFCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("TLF"));

        TableColumn ForældreCol = new TableColumn("Forældre");
        ForældreCol.setMinWidth(200);
        ForældreCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("Forældre"));

        TableColumn CPRCol = new TableColumn("CPR");
        CPRCol.setMinWidth(200);
        CPRCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("CPR"));

        table.setItems(data);
        table.getColumns().addAll(NavnCol, TLFCol, ForældreCol,CPRCol);

        final TextField addNavn = new TextField();
        addNavn.setPromptText("Navn");
        addNavn.setMaxWidth(NavnCol.getPrefWidth());
        final TextField addTLF = new TextField();
        addTLF.setMaxWidth(TLFCol.getPrefWidth());
        addTLF.setPromptText("TLF");
        final TextField addForældre = new TextField();
        addForældre.setMaxWidth(ForældreCol.getPrefWidth());
        addForældre.setPromptText("Forældre");
        final TextField addCPR = new TextField();
        addCPR.setMaxWidth(CPRCol.getPrefWidth());
        addCPR.setPromptText("CPR");
        final Button addButton = new Button("Add");
        addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                data.add(new Person(
                        addNavn.getText(),
                        addTLF.getText(),
                        addForældre.getText(),
                        addCPR.getText()));
                addNavn.clear();
                addTLF.clear();
                addForældre.clear();
                addCPR.clear();
            }
        });

        hb.getChildren().addAll(addNavn, addTLF, addForældre,addCPR, addButton,buttonTilbage);
        hb.setSpacing(3);
        vboxIndskrivning.setSpacing(5);
        vboxIndskrivning.setPadding(new Insets(10, 0, 0, 10));
        vboxIndskrivning.getChildren().addAll(label, table, hb);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(sceneLogIn);
        stage.show();
    }

    public static class Person {

        private final SimpleStringProperty Navn;
        private final SimpleStringProperty TLF;
        private final SimpleStringProperty Forældre;
        private final SimpleStringProperty CPR;
        private Person(String fName, String lName, String Forældre, String Cnr) {
            this.Navn = new SimpleStringProperty(fName);
            this.TLF = new SimpleStringProperty(lName);
            this.Forældre = new SimpleStringProperty(Forældre);
            this.CPR = new SimpleStringProperty(Cnr);
        }
        public String getNavn() {
            return Navn.get();
        }

        public void setNavn(String fName) {
            Navn.set(fName);
        }

        public String getTLF() {
            return TLF.get();
        }

        public void setTLF(String fName) {
            TLF.set(fName);
        }

        public String getForældre() {
            return Forældre.get();
        }

        public void setForældre(String fName) {
            Forældre.set(fName);
        }

        public String getCPR() {

            return CPR.get();
        }
        public void setCPR(String Cnr) {
                CPR.set(Cnr);
            }
    }
}