package domain;

public class Car {
    private Integer id;
    private String model;
    private String number;


    public Car(Integer id, String model, String number) {
        this.id = id;
        this.model = model;
        this.number = number;
    }

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
