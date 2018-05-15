package models;

public class Responsible {

    private int code;
    private String fio;
    private String phone;

    public Responsible(int code, String fio, String phone) {
        this.code = code;
        this.fio = fio;
        this.phone = phone;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
