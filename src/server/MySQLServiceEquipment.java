package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

import models.*;

public class MySQLServiceEquipment {

    private String url = "jdbc:mysql://localhost:3306/equipment?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";

    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public List<Equipment> getEquipment(){
        List<Equipment> list = new ArrayList<Equipment>();

        String query = "select * from equipment";
        sendSelectRequest(query);
        try {
            while (rs.next()) {
                int code = rs.getInt("code");
                String category = rs.getString("category");
                String name = rs.getString("name");
                int cost = rs.getInt("cost");
                String producer = rs.getString("producer");
                String receiptDate = rs.getString("receiptDate");

                list.add(new Equipment(code, category, name, cost, producer, receiptDate));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }
        return list;
    }

    public List<Cabinet> getCabinet(){
        List<Cabinet> list = new ArrayList<Cabinet>();

        String query = "select * from cabinet";
        sendSelectRequest(query);
        try {
            while (rs.next()) {
                int code = rs.getInt("code");
                String name = rs.getString("name");
                int codeResponsible = rs.getInt("codeResponsible");

                list.add(new Cabinet(code, name, codeResponsible));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public List<Responsible> getResponsible(){
        List<Responsible> list = new ArrayList<Responsible>();

        String query = "select * from responsible";
        sendSelectRequest(query);
        try {
            while (rs.next()) {
                int code = rs.getInt("code");
                String fio = rs.getString("fio");
                String phone = rs.getString("phone");

                list.add(new Responsible(code, fio, phone));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public java.util.List<Distribution> getDistribution(){
        List<Distribution> list = new ArrayList<Distribution>();

        String query = "select * from distribution";
        sendSelectRequest(query);
        try {
            while (rs.next()) {
                int code = rs.getInt("code");
                int codeCabinet = rs.getInt("codeCabinet");
                int codeEquipment = rs.getInt("codeEquipment");
                int number = rs.getInt("number");
                String date = rs.getString("date");

                list.add(new Distribution(code, codeCabinet, codeEquipment, number, date));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public java.util.List<Writeoff> getWriteoff(){
        List<Writeoff> list = new ArrayList<Writeoff>();

        String query = "select * from writeoff";
        sendSelectRequest(query);
        try {
            while (rs.next()) {
                int code = rs.getInt("code");
                int codeCabinet = rs.getInt("codeCabinet");
                int codeEquipment = rs.getInt("codeEquipment");
                int number = rs.getInt("number");
                String date = rs.getString("date");
                String cause = rs.getString("cause");

                list.add(new Writeoff(code, codeCabinet, codeEquipment, number, date, cause));
            }
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }

        return list;
    }

    public void addEquipment(Equipment equipment){
        String query = "INSERT INTO equipment (code, category, name, cost, producer, receiptDate)\n" +
                " VALUES (" + equipment.getCode() + ", '" +
                equipment.getCategory() + "', '" +
                equipment.getName() + "', " +
                equipment.getCost() + ", '" +
                equipment.getProducer() + "', '" +
                equipment.getReceiptDate() +
                "');";
        sendRequest(query);
    }

    public void addCabinet(Cabinet cabinet){
        String query = "INSERT INTO cabinet (code, name, codeResponsible)\n" +
                " VALUES (" + cabinet.getCode() + ", '" +
                cabinet.getName() + "', " +
                cabinet.getCodeResponsible() +
                ");";
        sendRequest(query);
    }

    public void addResponsible(Responsible responsible){
        String query = "INSERT INTO responsible (code, fio, phone)\n" +
                " VALUES (" + responsible.getCode() + ", '" +
                responsible.getFio() + "', '" +
                responsible.getPhone() +
                "');";
        sendRequest(query);
    }

    public void addDistribution(Distribution distribution){
        String query = "INSERT INTO distribution (code, codeCabinet, codeEquipment, number, date)\n" +
                " VALUES (" + distribution.getCode() + ", " +
                distribution.getCodeCabinet() + ", " +
                distribution.getCodeEquipment() + ", " +
                distribution.getNumber() + ", '" +
                distribution.getDate() +
                "');";
        sendRequest(query);
    }

    public void addWriteoff(Writeoff writeoff){
        String query = "INSERT INTO writeoff (code, codeCabinet, codeEquipment, number, date, cause)\n" +
                " VALUES (" + writeoff.getCode() + ", " +
                writeoff.getCodeCabinet() + ", " +
                writeoff.getCodeEquipment() + ", " +
                writeoff.getNumber() + ", '" +
                writeoff.getDate() + "', '" +
                writeoff.getCause() +
                "');";
        sendRequest(query);
    }

    public void delEquipment(int code){
        String query = "delete from equipment where code = " + code + ";";
        sendRequest(query);
    }

    public void delCabinet(int code){
        String query = "delete from cabinet where code = " + code + ";";
        sendRequest(query);
    }

    public void delResponsible(int code){
        String query = "delete from responsible where code = " + code + ";";
        sendRequest(query);
    }

    public void delDistribution(int code){
        String query = "delete from distribution where code = " + code + ";";
        sendRequest(query);
    }

    public void delWriteoff(int code){
        String query = "delete from writeoff where code = " + code + ";";
        sendRequest(query);
    }

    public void editEquipment(Equipment equipment){
        if (equipment.getCode() < 0)
            return;

        if (!equipment.getCategory().isEmpty()) {
            String query = "update equipment set category = '" +
                    equipment.getCategory() + "' where code = " +
                    equipment.getCode() + ";";
            sendRequest(query);
        }

        if (!equipment.getName().isEmpty()) {
            String query = "update equipment set name = '" +
                    equipment.getName() + "' where code = " +
                    equipment.getCode() + ";";
            sendRequest(query);
        }

        if (equipment.getCost() > 0) {
            String query = "update equipment set cost = '" +
                    equipment.getCost() + "' where code = " +
                    equipment.getCode() + ";";
            sendRequest(query);
        }

        if (!equipment.getProducer().isEmpty()) {
            String query = "update equipment set producer = '" +
                    equipment.getProducer() + "' where code = " +
                    equipment.getCode() + ";";
            sendRequest(query);
        }

        if (!equipment.getReceiptDate().isEmpty()) {
            String query = "update equipment set receiptDate = '" +
                    equipment.getReceiptDate() + "' where code = " +
                    equipment.getCode() + ";";
            sendRequest(query);
        }
    }

    public void editCabinet(Cabinet cabinet){
        if (cabinet.getCode() < 0)
            return;

        if (!cabinet.getName().isEmpty()) {
            String query = "update cabinet set name = '" +
                    cabinet.getName() + "' where code = " +
                    cabinet.getCode() + ";";
            sendRequest(query);
        }

        if (cabinet.getCodeResponsible() > 0) {
            String query = "update cabinet set codeResponsible = '" +
                    cabinet.getCodeResponsible() + "' where code = " +
                    cabinet.getCode() + ";";
            sendRequest(query);
        }
    }

    public void editResponsible(Responsible responsible){
        if (responsible.getCode() < 0)
            return;

        if (!responsible.getFio().isEmpty()) {
            String query = "update responsible set fio = '" +
                    responsible.getFio() + "' where code = " +
                    responsible.getCode() + ";";
            sendRequest(query);
        }

        if (!responsible.getPhone().isEmpty()) {
            String query = "update responsible set phone = '" +
                    responsible.getPhone() + "' where code = " +
                    responsible.getCode() + ";";
            sendRequest(query);
        }
    }

    public void editDistribution(Distribution distribution){
        if (distribution.getCode() < 0)
            return;

        if (distribution.getCodeCabinet() > 0) {
            String query = "update distribution set codeCabinet = '" +
                    distribution.getCodeCabinet() + "' where code = " +
                    distribution.getCode() + ";";
            sendRequest(query);
        }

        if (distribution.getCodeEquipment() > 0) {
            String query = "update distribution set codeEquipment = '" +
                    distribution.getCodeEquipment() + "' where code = " +
                    distribution.getCode() + ";";
            sendRequest(query);
        }

        if (distribution.getNumber() > 0) {
            String query = "update distribution set number = '" +
                    distribution.getNumber() + "' where code = " +
                    distribution.getCode() + ";";
            sendRequest(query);
        }

        if (!distribution.getDate().isEmpty()) {
            String query = "update distribution set date = '" +
                    distribution.getDate() + "' where code = " +
                    distribution.getCode() + ";";
            sendRequest(query);
        }
    }

    public void editWriteoff(Writeoff writeoff){
        if (writeoff.getCode() < 0)
            return;

        if (writeoff.getCodeCabinet() > 0) {
            String query = "update writeoff set codeCabinet = '" +
                    writeoff.getCodeCabinet() + "' where code = " +
                    writeoff.getCode() + ";";
            sendRequest(query);
        }

        if (writeoff.getCodeEquipment() > 0) {
            String query = "update writeoff set codeEquipment = '" +
                    writeoff.getCodeEquipment() + "' where code = " +
                    writeoff.getCode() + ";";
            sendRequest(query);
        }

        if (writeoff.getNumber() > 0) {
            String query = "update writeoff set number = '" +
                    writeoff.getNumber() + "' where code = " +
                    writeoff.getCode() + ";";
            sendRequest(query);
        }

        if (!writeoff.getDate().isEmpty()) {
            String query = "update writeoff set date = '" +
                    writeoff.getDate() + "' where code = " +
                    writeoff.getCode() + ";";
            sendRequest(query);
        }

        if (!writeoff.getCause().isEmpty()) {
            String query = "update writeoff set cause = '" +
                    writeoff.getCause() + "' where code = " +
                    writeoff.getCode() + ";";
            sendRequest(query);
        }
    }

    private void sendSelectRequest(String query) {

        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
    }

    private void sendRequest(String query) {
        try {
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    private void closeConnection() {
        try {
            con.close();
        } catch (SQLException se) { /*can't do anything */ }
        try {
            stmt.close();
        } catch (SQLException se) { /*can't do anything */ }
        try {
            rs.close();
        } catch (SQLException se) { /*can't do anything */ }
    }
}
