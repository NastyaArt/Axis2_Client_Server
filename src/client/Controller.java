package client;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import models.*;

import java.util.List;

public class Controller {
    public TableView<Equipment> tableEquipment;
    public TableView<Cabinet> tableCabinet;
    public TableView<Responsible> tableResponsible;
    public TableView<Distribution> tableDistribution;
    public TableView<Writeoff> tableWriteoff;

    private Client client;

    @FXML
    public void initialize() {
        client = new Client();
        client.connect();

        updateEquipment();
        updateCabinet();
        updateResponsible();
        updateDistribution();
        updateWriteoff();
    }

    private void updateEquipment(){
        List<Equipment> listEquipment = client.getEquipment();
        ObservableList<Equipment> dataEquipment = FXCollections.observableArrayList(listEquipment);
        tableEquipment.setItems(dataEquipment);
    }

    private void updateCabinet(){
        List<Cabinet> listCabinet = client.getCabinet();
        ObservableList<Cabinet> dataCabinet = FXCollections.observableArrayList(listCabinet);
        tableCabinet.setItems(dataCabinet);
    }

    private void updateResponsible(){
        List<Responsible> listResponsible = client.getResponsible();
        ObservableList<Responsible> dataResponsible = FXCollections.observableArrayList(listResponsible);
        tableResponsible.setItems(dataResponsible);
    }

    private void updateDistribution(){
        List<Distribution> listDistribution = client.getDistribution();
        ObservableList<Distribution> dataDistribution = FXCollections.observableArrayList(listDistribution);
        tableDistribution.setItems(dataDistribution);
    }

    private void updateWriteoff(){
        List<Writeoff> listWriteoff = client.getWriteoff();
        ObservableList<Writeoff> dataWriteoff = FXCollections.observableArrayList(listWriteoff);
        tableWriteoff.setItems(dataWriteoff);
    }

    public void EditEquipment(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(EquipmentEdit.class.getResource("EquipmentEdit.fxml"));
        Parent root = loader.load();
        EquipmentEdit controller = loader.getController();
        controller.setClient(client);
        Stage stage = new Stage();
        stage.setOnHidden(e -> updateEquipment());
        stage.setScene(new Scene(root));
        stage.setTitle("Equipment Edit");
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void EditCabinet(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(CabinetEdit.class.getResource("CabinetEdit.fxml"));
        Parent root = loader.load();
        CabinetEdit controller = loader.getController();
        controller.setClient(client);
        Stage stage = new Stage();
        stage.setOnHidden(e -> updateCabinet());
        stage.setScene(new Scene(root));
        stage.setTitle("Cabinet Edit");
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void EditResponsible(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(ResponsibleEdit.class.getResource("ResponsibleEdit.fxml"));
        Parent root = loader.load();
        ResponsibleEdit controller = loader.getController();
        controller.setClient(client);
        Stage stage = new Stage();
        stage.setOnHidden(e -> updateResponsible());
        stage.setScene(new Scene(root));
        stage.setTitle("Responsible Edit");
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void EditDistribution(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(DistributionEdit.class.getResource("DistributionEdit.fxml"));
        Parent root = loader.load();
        DistributionEdit controller = loader.getController();
        controller.setClient(client);
        Stage stage = new Stage();
        stage.setOnHidden(e -> updateDistribution());
        stage.setScene(new Scene(root));
        stage.setTitle("Distribution Edit");
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void EditWriteoff(ActionEvent actionEvent) throws Exception {
        FXMLLoader loader = new FXMLLoader(WriteoffEdit.class.getResource("WriteoffEdit.fxml"));
        Parent root = loader.load();
        WriteoffEdit controller = loader.getController();
        controller.setClient(client);
        Stage stage = new Stage();
        stage.setOnHidden(e -> updateWriteoff());
        stage.setScene(new Scene(root));
        stage.setTitle("Writeoff Edit");
        stage.setResizable(false);
        stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
        stage.show();
    }

    public void exit() {
        client.close();
    }
}
