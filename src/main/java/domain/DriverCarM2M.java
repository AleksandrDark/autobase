package domain;

public class DriverCarM2M {
    private Integer id;
    private Integer id_driver;
    private Integer id_car;

    public DriverCarM2M(Integer id_driver, Integer id_car) {
        this.id_driver = id_driver;
        this.id_car = id_car;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_driver() {
        return id_driver;
    }

    public void setId_driver(Integer id_driver) {
        this.id_driver = id_driver;
    }

    public Integer getId_car() {
        return id_car;
    }

    public void setId_car(Integer id_car) {
        this.id_car = id_car;
    }
}
