package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Distribution;

public class DistributionEdit {

    public TextField codeAdd;
    public TextField codeCabinetAdd;
    public TextField codeEquipmentAdd;
    public TextField numberAdd;
    public TextField dateAdd;

    public TextField codeDel;

    public TextField codeEdit;
    public TextField codeCabinetEdit;
    public TextField codeEquipmentEdit;
    public TextField numberEdit;
    public TextField dateEdit;

    private Client client;

    @FXML
    public void initialize() {

    }

    public void Add(ActionEvent actionEvent) {
        int code = Integer.parseInt(codeAdd.getText());
        int codeCabinet = Integer.parseInt(codeCabinetAdd.getText());
        int codeEquipment = Integer.parseInt(codeEquipmentAdd.getText());
        int number = Integer.parseInt(numberAdd.getText());
        String date = dateAdd.getText();

        Distribution dist = new Distribution(code, codeCabinet, codeEquipment, number, date);
        client.addDistribution(dist);
    }

    public void Delete(ActionEvent actionEvent) {
        client.delDistribution(Integer.parseInt(codeDel.getText()));
    }

    public void Edit(ActionEvent actionEvent) {
        int code = -1;
        if (!codeEdit.getText().isEmpty())
            code = Integer.parseInt(codeEdit.getText());
        int codeCabinet = -1;
        if (!codeCabinetEdit.getText().isEmpty())
            codeCabinet = Integer.parseInt(codeCabinetEdit.getText());
        int codeEquipment = -1;
        if (!codeEquipmentEdit.getText().isEmpty())
            codeEquipment = Integer.parseInt(codeEquipmentEdit.getText());
        int number = -1;
        if (!numberEdit.getText().isEmpty())
            number = Integer.parseInt(numberEdit.getText());
        String date = dateEdit.getText();

        Distribution dist = new Distribution(code, codeCabinet, codeEquipment, number, date);
        client.editDistribution(dist);
    }

    public void setClient(Client cl){
        client = cl;
    }
}
