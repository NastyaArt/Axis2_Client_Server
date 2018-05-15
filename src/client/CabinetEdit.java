package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Cabinet;

public class CabinetEdit {

    public TextField codeAdd;
    public TextField nameAdd;
    public TextField codeResponsibleAdd;

    public TextField codeDel;

    public TextField codeEdit;
    public TextField nameEdit;
    public TextField codeResponsibleEdit;

    private Client client;

    @FXML
    public void initialize() {

    }

    public void Add(ActionEvent actionEvent) {
        int code = Integer.parseInt(codeAdd.getText());
        String name = nameAdd.getText();
        int codeResponsible = Integer.parseInt(codeResponsibleAdd.getText());
        Cabinet cab = new Cabinet(code, name, codeResponsible);
        client.addCabinet(cab);
    }

    public void Delete(ActionEvent actionEvent) {
        client.delCabinet(Integer.parseInt(codeDel.getText()));
    }

    public void Edit(ActionEvent actionEvent) {
        int code = -1;
        if (!codeEdit.getText().isEmpty())
            code = Integer.parseInt(codeEdit.getText());
        String name = nameEdit.getText();
        int codeResponsible = -1;
        if (!codeEdit.getText().isEmpty())
            codeResponsible = Integer.parseInt(codeResponsibleEdit.getText());

        Cabinet cab = new Cabinet(code, name, codeResponsible);
        client.editCabinet(cab);
    }

    public void setClient(Client cl){
        client = cl;
    }
}
