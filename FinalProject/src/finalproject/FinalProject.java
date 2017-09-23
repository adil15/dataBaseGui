/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Optional;
import java.util.StringTokenizer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author adilhassan
 */
public class FinalProject extends Application {

    private ArrayList<Car> carlist = new ArrayList();
    private Label lblID = new Label("CarID");
    private Label lblMan = new Label("Manufacturer");
    private Label lblTrim = new Label("Trim");
    private Label lblYear = new Label("Year");
    private Label lblPrice = new Label("Price");
    private Label lblQuan = new Label("Quantity");
    private Label lblIDm = new Label("CarID");
    private Label lblManm = new Label("Manufacturer");
    private Label lblTrimm = new Label("Trim");
    private Label lblYearm = new Label("Year");
    private Label lblPricem = new Label("Price");
    private Label lblQuanm = new Label("Quantity");
    private TextField txtId = new TextField();
    private TextField txtMan = new TextField();
    private TextField txtTrim = new TextField();
    private TextField txtYear = new TextField();
    private TextField txtPrice = new TextField();
    private TextField txtQuan = new TextField();
    private TextField txtIdm = new TextField();
    private TextField txtManm = new TextField();
    private TextField txtTrimm = new TextField();
    private TextField txtYearm = new TextField();
    private TextField txtPricem = new TextField();
    private TextField txtQuanm = new TextField();
    private TextField txtSearch = new TextField();
    private Button btnFirst = new Button("First");
    private Button btnNext = new Button("Next");
    private Button btnPrevious = new Button("Previous");
    private Button btnLast = new Button("Last");
    private Button btnAdd = new Button("Add Record");
    private Button btnDelete = new Button("Delete Record");
    private Button btnModify = new Button("Modify Record");
    private Button btnUpdatem = new Button("Update");
    private Button btnSearch = new Button("Search");
    private HBox hbox1 = new HBox(btnAdd, btnDelete, btnModify);
    private HBox hbox = new HBox(btnFirst, btnPrevious, btnNext, btnLast);
    private HBox hboxs = new HBox(btnSearch,txtSearch);
    
    private GridPane pane = new GridPane();
    private int index = 0;

    @Override
    public void start(Stage primaryStage) {

        pane.add(lblID, 0, 0);
        pane.add(txtId, 1, 0);
        pane.add(lblMan, 0, 1);
        pane.add(txtMan, 1, 1);
        pane.add(lblTrim, 0, 2);
        pane.add(txtTrim, 1, 2);
        pane.add(lblYear, 0, 3);
        pane.add(txtYear, 1, 3);
        pane.add(lblPrice, 0, 4);
        pane.add(txtPrice, 1, 4);
        pane.add(lblQuan, 0, 5);
        pane.add(txtQuan, 1, 5);
        pane.add(hbox, 1, 6);
        pane.add(hbox1, 1, 7);   
        pane.add(hboxs, 1, 8);
        
        
        

        String line = new String();
        StringTokenizer st1 = new StringTokenizer(line, ",");
        Iterator iterator = carlist.iterator();

        try {
            FileReader fr = new FileReader("Car.dat");
            BufferedReader br = new BufferedReader(fr);

            line = br.readLine();
            while (line != null) {

                StringTokenizer st = new StringTokenizer(line, ",");
                Car one = new Car(st.nextToken());
                one.setManu(st.nextToken());
                one.setTrim(st.nextToken());
                one.setYear(Integer.parseInt(st.nextToken()));
                one.setPrice(Double.parseDouble(st.nextToken()));
                one.setquan((Integer.parseInt(st.nextToken())));
                carlist.add(one);
                line = br.readLine();

            }

        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        }

        Car Fcar = carlist.get(0);
        txtId.setText(Fcar.getId());
        txtMan.setText(Fcar.getManu());
        txtTrim.setText(Fcar.getTrim());
        txtYear.setText(Integer.toString(Fcar.getYear()));
        txtPrice.setText(Double.toString(Fcar.getPrice()));
        txtQuan.setText(Integer.toString(Fcar.getquan()));

        btnFirst.setOnAction(e -> {
            Car carOne = carlist.get(0);
            txtId.setText(carOne.getId());
            txtMan.setText(carOne.getManu());
            txtTrim.setText(carOne.getTrim());
            txtYear.setText(Integer.toString(carOne.getYear()));
            txtPrice.setText(Double.toString(carOne.getPrice()));
            txtQuan.setText(Integer.toString(carOne.getquan()));

        });
        btnLast.setOnAction(e -> {
            Car carLast = carlist.get(carlist.size() - 1);
            txtId.setText(carLast.getId());
            txtMan.setText(carLast.getManu());
            txtTrim.setText(carLast.getTrim());
            txtYear.setText(Integer.toString(carLast.getYear()));
            txtPrice.setText(Double.toString(carLast.getPrice()));
            txtQuan.setText(Integer.toString(carLast.getquan()));
        });
        btnNext.setOnAction(e -> {
            Car carNext = carlist.get(index + 1);
            if (iterator.hasNext()) {

                txtId.setText(carNext.getId());
                txtMan.setText(carNext.getManu());
                txtTrim.setText(carNext.getTrim());
                txtYear.setText(Integer.toString(carNext.getYear()));
                txtPrice.setText(Double.toString(carNext.getPrice()));
                txtQuan.setText(Integer.toString(carNext.getquan()));
                index++;

                if (index == carlist.size() - 1) {
                    index = 0;
                }
            }

        });
        btnPrevious.setOnAction(e -> {
            if (index==0){
                    index=carlist.size()-1;
                }
            Car carPrevious = carlist.get(index - 1);
            if (iterator.hasNext()) {

                txtId.setText(carPrevious.getId());
                txtMan.setText(carPrevious.getManu());
                txtTrim.setText(carPrevious.getTrim());
                txtYear.setText(Integer.toString(carPrevious.getYear()));
                txtPrice.setText(Double.toString(carPrevious.getPrice()));
                txtQuan.setText(Integer.toString(carPrevious.getquan()));
                index--;

                
            }

        });
        btnModify.setOnAction(e -> {
            modStage mstage = new modStage();
            mstage.show();
        });

        btnDelete.setOnAction(e -> {
            Car carDelete = carlist.get(index);
            carlist.get(index);
            carlist.remove(index);
            txtId.setText(carDelete.getId());
            txtMan.setText(carDelete.getManu());
            txtTrim.setText(carDelete.getTrim());
            txtYear.setText(Integer.toString(carDelete.getYear()));
            txtPrice.setText((Double.toString(carDelete.getPrice())));
            txtQuan.setText(Integer.toString(carDelete.getquan()));
        });

        btnAdd.setOnAction(e -> {
            TextField IdCar = new TextField();
            IdCar.setEditable(false);
            int carIdinc = carlist.size() + 1;

            if (carlist.size() < 10) {
                IdCar.setText("C10" + carIdinc);
            }
            if (carlist.size() > 9) {
                IdCar.setText("C11" + carIdinc);
            }
            if (carlist.size() > 99) {
                IdCar.setText("C" + carIdinc);
            }
            Label addlblID = new Label("ID");
            Label addlblTrim = new Label("Trim");
            Label addlblManu = new Label("Manufacturer");
            Label addlblYear = new Label("Year");
            Label addlblPrice = new Label("Price");
            Label addlblQuan = new Label("Quantity");
            TextField addManu = new TextField();
            TextField addTrim = new TextField();
            TextField addYear = new TextField();
            TextField addPrice = new TextField();
            TextField addQuan = new TextField();
            Button btnupdate = new Button("Update");

            GridPane addPane = new GridPane();
            addPane.add(addlblID, 0, 0);
            addPane.add(IdCar, 1, 0);
            addPane.add(addlblManu, 0, 1);
            addPane.add(addManu, 1, 1);
            addPane.add(addlblTrim, 0, 2);
            addPane.add(addTrim, 1, 2);
            addPane.add(addlblYear, 0, 3);
            addPane.add(addYear, 1, 3);
            addPane.add(addlblPrice, 0, 4);
            addPane.add(addPrice, 1, 4);
            addPane.add(addlblQuan, 0, 5);
            addPane.add(addQuan, 1, 5);
            addPane.add(btnupdate, 1, 6);

            Stage addStage = new Stage();
            Scene scene = new Scene(addPane, 300, 300);
            addStage.setScene(scene);
            addStage.show();
            addYear.setOnKeyReleased(f -> {
                if (isNumeric(f.getCode()) == false) {
                    Alert yearerr = new Alert(AlertType.ERROR);
                    yearerr.setContentText("Numbers only");
                    yearerr.showAndWait();
                    addYear.selectBackward();
                    addYear.deletePreviousChar();
                }
            });
            addPrice.setOnKeyReleased(p -> {
                if (isNumeric(p.getCode()) == false) {
                    Alert priceerr = new Alert(AlertType.ERROR);
                    priceerr.setContentText("Numbers only");
                    priceerr.showAndWait();
                    addPrice.selectBackward();
                    addPrice.deletePreviousChar();
                }
            });
            addQuan.setOnKeyReleased(q -> {
                if (isNumeric(q.getCode()) == false) {
                    Alert quanerr = new Alert(AlertType.ERROR);
                    quanerr.setContentText("Numbers only");
                    quanerr.showAndWait();
                    addQuan.selectBackward();
                    addQuan.deletePreviousChar();
                }
            });

            btnupdate.setOnAction(up -> {
                try {
                    FileWriter fw = new FileWriter("Car.dat", true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    String theMessage = "";
                    Alert dlgConfirmation = new Alert(AlertType.CONFIRMATION);
                    Optional<ButtonType> confirm = dlgConfirmation.showAndWait();
                    dlgConfirmation.setContentText("Are you sure you want to update?");
                    if (confirm.get() == ButtonType.OK) {
                        theMessage = "Record has been added";
                        bw.newLine();
                        bw.write(IdCar.getText());
                        bw.write(",");
                        bw.write(addManu.getText());
                        bw.write(",");
                        bw.write(addTrim.getText());
                        bw.write(",");
                        bw.write(addYear.getText());
                        bw.write(",");
                        bw.write(addPrice.getText());
                        bw.write(",");
                        bw.write(addQuan.getText());
                        bw.flush();

                        addStage.close();
                    } else {
                        theMessage = "No record added";
                        addStage.close();
                    }
                    Alert dlgInfo = new Alert(AlertType.INFORMATION);
                    dlgInfo.setContentText(theMessage);
                    dlgInfo.showAndWait();
                } catch (Exception g) {
                    System.out.println(g);
                }
            });

        });
        btnSearch.setOnAction(e->{
                
             String srch = txtSearch.getText();
                
               for (int i = 0; i < carlist.size(); i++) {
                  
               if(srch.equalsIgnoreCase(carlist.get(i).getId())){
                   index=i;
                   
                   txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                   
                   
               } 
                if(srch.equalsIgnoreCase(carlist.get(i).getManu())){
                   index=i;
                    txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                }
                if(srch.equalsIgnoreCase(carlist.get(i).getTrim())){
                   index=i;
                    txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                }
                 if(srch.equalsIgnoreCase(Integer.toString(carlist.get(i).getYear()))){
                    index=i;
                    txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                }
               if(srch.equalsIgnoreCase(Double.toString(carlist.get(i).getPrice()))){
                   index=i;
                    txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                }
                if(srch.equalsIgnoreCase(Integer.toString(carlist.get(i).getquan()))){
                   index=i;
                    txtId.setText(carlist.get(index).getId());
                   txtMan.setText(carlist.get(index).getManu());
                   txtTrim.setText(carlist.get(index).getTrim());
                   txtYear.setText(Integer.toString(carlist.get(index).getYear()));
                   txtPrice.setText(Double.toString(carlist.get(index).getPrice()));
                   txtQuan.setText(Integer.toString(carlist.get(index).getquan()));
                }
                
            }
                
                
                
                
                
            });
        primaryStage.setOnCloseRequest(c -> {
            try {
                saveData();

            } catch (IOException o) {
                System.out.println(o);
            }
        });

        Scene scene = new Scene(pane, 500, 500);
        
        primaryStage.setScene(scene);
        scene.getStylesheets().add("css/style.css");
        primaryStage.show();
    }

    public class modStage extends Stage {

        GridPane paneM = new GridPane();
        Scene scene1 = new Scene(paneM, 300, 300);
        Car carMod = carlist.get(index);

        public modStage() {
            paneM.add(lblIDm, 0, 0);
            paneM.add(txtIdm, 1, 0);
            paneM.add(lblManm, 0, 1);
            paneM.add(txtManm, 1, 1);
            paneM.add(lblTrimm, 0, 2);
            paneM.add(txtTrimm, 1, 2);
            paneM.add(lblYearm, 0, 3);
            paneM.add(txtYearm, 1, 3);
            paneM.add(lblPricem, 0, 4);
            paneM.add(txtPricem, 1, 4);
            paneM.add(lblQuanm, 0, 5);
            paneM.add(txtQuanm, 1, 5);
            paneM.add(btnUpdatem, 1, 6);
            setScene(scene1);

            txtIdm.setText(carMod.getId());
            txtManm.setText(carMod.getManu());
            txtTrimm.setText(carMod.getTrim());
            txtYearm.setText(Integer.toString(carMod.getYear()));
            txtPricem.setText(Double.toString(carMod.getPrice()));
            txtQuanm.setText(Integer.toString(carMod.getquan()));

            txtIdm.setEditable(false);

            txtYearm.setOnKeyReleased(f -> {
                if (isNumeric(f.getCode()) == false) {
                    Alert yearerr = new Alert(AlertType.ERROR);
                    yearerr.setContentText("Numbers only");
                    yearerr.showAndWait();
                    txtYearm.selectBackward();
                    txtYearm.deletePreviousChar();
                }
            });
            txtPricem.setOnKeyReleased(p -> {
                if (isNumeric(p.getCode()) == false) {
                    Alert priceerr = new Alert(AlertType.ERROR);
                    priceerr.setContentText("Numbers only");
                    priceerr.showAndWait();
                    txtPricem.selectBackward();
                    txtPricem.deletePreviousChar();
                }
            });
            txtQuanm.setOnKeyReleased(q -> {
                if (isNumeric(q.getCode()) == false) {
                    Alert quanerr = new Alert(AlertType.ERROR);
                    quanerr.setContentText("Numbers only");
                    quanerr.showAndWait();
                    txtQuanm.selectBackward();
                    txtQuanm.deletePreviousChar();
                }
            });

            btnUpdatem.setOnAction(e -> {
                String message = "";
                Alert dlgcon = new Alert(AlertType.CONFIRMATION);
                Optional<ButtonType> confirm = dlgcon.showAndWait();
                dlgcon.setContentText("Are you sure you want to update?");
                if (confirm.get() == ButtonType.OK) {
                    message = "Record has been added";
                    Car Carup = new Car(txtIdm.getText());
                    Carup.setManu(txtManm.getText());
                    Carup.setTrim(txtTrimm.getText());
                    Carup.setYear(Integer.parseInt(txtYearm.getText()));
                    Carup.setPrice(Double.parseDouble(txtPricem.getText()));
                    Carup.setquan(Integer.parseInt(txtQuanm.getText()));
                    carlist.remove(index);
                    carlist.add(index, Carup);
                    close();
                } else {
                    message = "No record added";
                    close();
                }
                Alert dlgInfo = new Alert(AlertType.INFORMATION);
                dlgInfo.setContentText(message);
                dlgInfo.showAndWait();
            });
            
        }

    }

    private boolean isNumeric(KeyCode key) {
        switch (key) {
            case DIGIT0:
            case DIGIT1:
            case DIGIT2:
            case DIGIT3:
            case DIGIT4:
            case DIGIT5:
            case DIGIT6:
            case DIGIT7:
            case DIGIT8:
            case DIGIT9:
            case NUMPAD0:
            case NUMPAD1:
            case NUMPAD2:
            case NUMPAD3:
            case NUMPAD4:
            case NUMPAD5:
            case NUMPAD6:
            case NUMPAD7:
            case NUMPAD8:
            case NUMPAD9:
                return true;
        }
        return false;
    }

    public void saveData() throws IOException {
        File oldFile = new File("Car.dat");
        File tmp = new File("tmp.dat");
        BufferedWriter bw = new BufferedWriter(new FileWriter("tmp.dat", true));
        Iterator<Car> iterator = carlist.iterator();

        for (int i = 0; i < carlist.size(); i++) {
            String mod = carlist.get(i).getId() + "," + carlist.get(i).getManu() + "," + carlist.get(i).getTrim() + "," + carlist.get(i).getYear() + "," + carlist.get(i).getPrice() + "," + carlist.get(i).getquan();
            bw.write(mod);
            bw.newLine();

        }
        bw.flush();
        bw.close();
        oldFile.delete();
        tmp.renameTo(oldFile);

//        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
