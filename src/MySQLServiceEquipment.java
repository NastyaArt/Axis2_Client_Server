import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import models.*;

public class MySQLServiceEquipment {

    private String url = "jdbc:mysql://127.0.0.1:3306/equipment?autoReconnect=true&useSSL=false";
    private String user = "root";
    private String password = "root";

    private Connection con=null;
    private Statement stmt;
    private ResultSet rs;

    public int getMySpechialCode(int b) {
        return 911+b;
    }

    public List<Equipment> getEquipment() {
        List<Equipment> list = new ArrayList<Equipment>();

        try {
            String query = "select * from equipment";
            sendSelectRequest(query);

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

    public List<Cabinet> getCabinet() {
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

    public List<Responsible> getResponsible() {
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

    public java.util.List<Distribution> getDistribution() {
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

    public java.util.List<Writeoff> getWriteoff() {
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

        public String addEquipment(Equipment equipment){
            StringBuilder query = new StringBuilder("INSERT INTO equipment (code, category, name, cost, producer, receiptDate)\n");
            query.append(" VALUES (");
            query.append(equipment.getCode());
            query.append(", '");
            query.append(equipment.getCategory());
            query.append("', '");
            query.append(equipment.getName());
            query.append("', ");
            query.append(equipment.getCost());
            query.append( ", '" );
            query.append(equipment.getProducer());
            query.append("', '");
            query.append(equipment.getReceiptDate());
            query.append("');");

            sendRequest(query.toString());
            return "Success";
        }

        public String addCabinet(Cabinet cabinet){
            StringBuilder query = new StringBuilder("INSERT INTO cabinet (code, name, codeResponsible)\n");
            query.append(" VALUES (");
            query.append(cabinet.getCode());
            query.append(", '");
            query.append(cabinet.getName());
            query.append("', ");
            query.append(cabinet.getCodeResponsible());
            query.append(");");
            sendRequest(query.toString());
            return "Success";
        }

        public String addResponsible(Responsible responsible){
            StringBuilder query = new StringBuilder("INSERT INTO responsible (code, fio, phone)\n");
            query.append(" VALUES (");
            query.append(responsible.getCode());
            query.append(", '");
            query.append(responsible.getFio());
            query.append("', '");
            query.append(responsible.getPhone());
            query.append("');");
            sendRequest(query.toString());
            return "Success";
        }

        public String addDistribution(Distribution distribution){
            StringBuilder query = new StringBuilder("INSERT INTO distribution (code, codeCabinet, codeEquipment, number, date)\n");
            query.append(" VALUES (");
            query.append(distribution.getCode());
            query.append(", ");
            query.append(distribution.getCodeCabinet());
            query.append(", ");
            query.append(distribution.getCodeEquipment());
            query.append(", ");
            query.append(distribution.getNumber());
            query.append(", '");
            query.append(distribution.getDate());
            query.append("');");
            sendRequest(query.toString());
            return "Success";
        }

        public String addWriteoff(Writeoff writeoff){
            StringBuilder query = new StringBuilder("INSERT INTO writeoff (code, codeCabinet, codeEquipment, number, date, cause)\n");
            query.append(" VALUES (");
            query.append(writeoff.getCode());
            query.append(", ");
            query.append(writeoff.getCodeCabinet());
            query.append(", ");
            query.append(writeoff.getCodeEquipment());
            query.append(", ");
            query.append(writeoff.getNumber());
            query.append(", '");
            query.append(writeoff.getDate());
            query.append("', '");
            query.append(writeoff.getCause());
            query.append("');");
            sendRequest(query.toString());
            return "Success";
        }

        public String delEquipment(int code){
            StringBuilder query = new StringBuilder("delete from equipment where code = ");
            query.append(code);
            query.append(";");
            sendRequest(query.toString());
            return "Success";
        }

        public String delCabinet(int code){
            StringBuilder query = new StringBuilder("delete from cabinet where code = ");
            query.append(code);
            query.append(";");
            sendRequest(query.toString());
            return "Success";
        }

        public String delResponsible(int code){
            StringBuilder query = new StringBuilder("delete from responsible where code = ");
            query.append(code);
            query.append(";");
            sendRequest(query.toString());
            return "Success";
        }

        public String delDistribution(int code){
            StringBuilder query = new StringBuilder("delete from distribution where code = ");
            query.append(code);
            query.append(";");
            sendRequest(query.toString());
            return "Success";
        }

        public String delWriteoff(int code){
            StringBuilder query = new StringBuilder("delete from writeoff where code = ");
            query.append(code);
            query.append(";");
            sendRequest(query.toString());
            return "Success";
        }

        public String editEquipment(Equipment equipment){
            if (equipment.getCode() < 0)
                return "Error";

            if (!equipment.getCategory().isEmpty()) {
                StringBuilder query = new StringBuilder("update equipment set category = '");
                query.append(equipment.getCategory());
                query.append("' where code = ");
                query.append(equipment.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!equipment.getName().isEmpty()) {
                StringBuilder query = new StringBuilder("update equipment set name = '");
                query.append(equipment.getName());
                query.append("' where code = ");
                query.append(equipment.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (equipment.getCost() > 0) {
                StringBuilder query = new StringBuilder("update equipment set cost = '");
                query.append(equipment.getCost());
                query.append("' where code = ");
                query.append(equipment.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!equipment.getProducer().isEmpty()) {
                StringBuilder query = new StringBuilder("update equipment set producer = '");
                query.append(equipment.getProducer());
                query.append("' where code = ");
                query.append(equipment.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!equipment.getReceiptDate().isEmpty()) {
                StringBuilder query = new StringBuilder("update equipment set receiptDate = '");
                query.append(equipment.getReceiptDate());
                query.append("' where code = ");
                query.append(equipment.getCode());
                query.append(";");
                sendRequest(query.toString());
            }
            return "Success";
        }

        public String editCabinet(Cabinet cabinet){
            if (cabinet.getCode() < 0)
                return "Error";

            if (!cabinet.getName().isEmpty()) {
                StringBuilder query = new StringBuilder("update cabinet set name = '");
                query.append(cabinet.getName());
                query.append("' where code = ");
                query.append(cabinet.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (cabinet.getCodeResponsible() > 0) {
                StringBuilder query = new StringBuilder("update cabinet set codeResponsible = '");
                query.append(cabinet.getCodeResponsible());
                query.append("' where code = ");
                query.append(cabinet.getCode());
                query.append(";");
                sendRequest(query.toString());
            }
            return "Success";
        }

        public String editResponsible(Responsible responsible){
            if (responsible.getCode() < 0)
                return "Error";

            if (!responsible.getFio().isEmpty()) {
                StringBuilder query = new StringBuilder("update responsible set fio = '");
                query.append(responsible.getFio());
                query.append("' where code = ");
                query.append(responsible.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!responsible.getPhone().isEmpty()) {
                StringBuilder query = new StringBuilder("update responsible set phone = '");
                query.append(responsible.getPhone());
                query.append("' where code = ");
                query.append(responsible.getCode());
                query.append(";");
                sendRequest(query.toString());
            }
            return "Success";
        }

        public String editDistribution(Distribution distribution){
            if (distribution.getCode() < 0)
                return "Error";

            if (distribution.getCodeCabinet() > 0) {
                StringBuilder query = new StringBuilder("update distribution set codeCabinet = '");
                query.append(distribution.getCodeCabinet());
                query.append("' where code = ");
                query.append(distribution.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (distribution.getCodeEquipment() > 0) {
                StringBuilder query = new StringBuilder("update distribution set codeEquipment = '");
                query.append(distribution.getCodeEquipment());
                query.append("' where code = ");
                query.append(distribution.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (distribution.getNumber() > 0) {
                StringBuilder query = new StringBuilder("update distribution set number = '");
                query.append(distribution.getNumber());
                query.append("' where code = ");
                query.append(distribution.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!distribution.getDate().isEmpty()) {
                StringBuilder query = new StringBuilder("update distribution set date = '");
                query.append(distribution.getDate());
                query.append("' where code = ");
                query.append(distribution.getCode());
                query.append(";");
                sendRequest(query.toString());
            }
            return "Success";
        }

        public String editWriteoff(Writeoff writeoff){
            if (writeoff.getCode() < 0)
                return "Error";

            if (writeoff.getCodeCabinet() > 0) {
                StringBuilder query = new StringBuilder("update writeoff set codeCabinet = '");
                query.append(writeoff.getCodeCabinet());
                query.append("' where code = ");
                query.append(writeoff.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (writeoff.getCodeEquipment() > 0) {
                StringBuilder query = new StringBuilder("update writeoff set codeEquipment = '");
                query.append(writeoff.getCodeEquipment());
                query.append("' where code = ");
                query.append(writeoff.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (writeoff.getNumber() > 0) {
                StringBuilder query = new StringBuilder("update writeoff set number = '");
                query.append(writeoff.getNumber());
                query.append("' where code = ");
                query.append(writeoff.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!writeoff.getDate().isEmpty()) {
                StringBuilder query = new StringBuilder("update writeoff set date = '");
                query.append(writeoff.getDate());
                query.append("' where code = ");
                query.append(writeoff.getCode());
                query.append(";");
                sendRequest(query.toString());
            }

            if (!writeoff.getCause().isEmpty()) {
                StringBuilder query = new StringBuilder("update writeoff set cause = '");
                query.append(writeoff.getCause());
                query.append("' where code = ");
                query.append(writeoff.getCode());
                query.append(";");
                sendRequest(query.toString());
            }
            return "Success";
        }

    private void sendSelectRequest(String query) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void sendRequest(String query){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection(url, user, password);
                stmt = con.createStatement();
                stmt.executeUpdate(query);

            } catch (SQLException sqlEx) {
                sqlEx.printStackTrace();
            }
            catch (ClassNotFoundException e) {
                e.printStackTrace();
            }finally {
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
