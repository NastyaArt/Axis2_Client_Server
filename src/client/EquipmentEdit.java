package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Equipment;

public class EquipmentEdit {

    public TextField codeAdd;
    public TextField categoryAdd;
    public TextField nameAdd;
    public TextField costAdd;
    public TextField producerAdd;
    public TextField receiptDateAdd;

    public TextField codeDel;

    public TextField codeEdit;
    public TextField categoryEdit;
    public TextField nameEdit;
    public TextField costEdit;
    public TextField producerEdit;
    public TextField receiptDateEdit;

    private Client client;

    @FXML
    public void initialize() {

    }

    public void Add(ActionEvent actionEvent) {
        int code = Integer.parseInt(codeAdd.getText());
        String category = categoryAdd.getText();
        String name = nameAdd.getText();
        int cost = Integer.parseInt(costAdd.getText());
        String producer = producerAdd.getText();
        String receiptDate = receiptDateAdd.getText();

        Equipment eq = new Equipment(code, category, name, cost, producer, receiptDate);
        client.addEquipment(eq);
    }

    public void Delete(ActionEvent actionEvent) {
        client.delEquipment(Integer.parseInt(codeDel.getText()));
    }

    public void Edit(ActionEvent actionEvent) {
        int code = -1;
        if (!codeEdit.getText().isEmpty()) {
            code = Integer.parseInt(codeEdit.getText());
        }
        String category = categoryEdit.getText();
        String name = nameEdit.getText();
        int cost = -1;
        if (!costEdit.getText().isEmpty()) {
             cost = Integer.parseInt(costEdit.getText());
        }
        String producer = producerEdit.getText();
        String receiptDate = receiptDateEdit.getText();

        Equipment eq = new Equipment(code, category, name, cost, producer, receiptDate);
        client.editEquipment(eq);
    }

    public void setClient(Client cl){
        client = cl;
    }
}
