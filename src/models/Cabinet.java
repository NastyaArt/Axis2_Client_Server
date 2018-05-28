package models;

public class Cabinet {

    private int code;
    private String name;
    private int codeResponsible;

    public Cabinet(){

    }
    public Cabinet(int code, String name, int codeResponsible) {
        this.code = code;
        this.name = name;
        this.codeResponsible = codeResponsible;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCodeResponsible() {
        return codeResponsible;
    }

    public void setCodeResponsible(int codeResponsible) {
        this.codeResponsible = codeResponsible;
    }
}
