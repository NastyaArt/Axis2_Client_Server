package models;

public class Equipment {

    private int code;
    private String category;
    private String name;
    private int cost;
    private String producer;
    private String receiptDate;

    public Equipment() {
    }

    public Equipment(int code, String category, String name, int cost, String producer, String receiptDate) {
        this.code = code;
        this.category = category;
        this.name = name;
        this.cost = cost;
        this.producer = producer;
        this.receiptDate = receiptDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }
}
