package models;

public class Distribution {

    private int code;
    private int codeCabinet;
    private int codeEquipment;
    private int number;
    private String date;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCodeCabinet() {
        return codeCabinet;
    }

    public void setCodeCabinet(int codeCabinet) {
        this.codeCabinet = codeCabinet;
    }

    public int getCodeEquipment() {
        return codeEquipment;
    }

    public void setCodeEquipment(int codeEquipment) {
        this.codeEquipment = codeEquipment;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
