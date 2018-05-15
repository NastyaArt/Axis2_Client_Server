package client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import models.Responsible;

public class ResponsibleEdit {

    public TextField codeAdd;
    public TextField fioAdd;
    public TextField phoneAdd;

    public TextField codeDel;

    public TextField codeEdit;
    public TextField fioEdit;
    public TextField phoneEdit;

    private Client client;

    @FXML
    public void initialize() {

    }

    public void Add(ActionEvent actionEvent) {
        int code = Integer.parseInt(codeAdd.getText());
        String fio = fioAdd.getText();
        String phone = phoneAdd.getText();

        Responsible resp = new Responsible(code, fio, phone);
        client.addResponsible(resp);
    }

    public void Delete(ActionEvent actionEvent) {
        client.delResponsible(Integer.parseInt(codeDel.getText()));
    }

    public void Edit(ActionEvent actionEvent) {
        int code = -1;
        if (!codeEdit.getText().isEmpty())
            code = Integer.parseInt(codeEdit.getText());
        String fio = fioEdit.getText();
        String phone = phoneEdit.getText();

        Responsible resp = new Responsible(code, fio, phone);
        client.editResponsible(resp);
    }

    public void setClient(Client cl){
        client = cl;
    }
}
