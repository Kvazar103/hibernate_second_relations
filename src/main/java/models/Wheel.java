package models;

import javax.persistence.*;

@Entity
public class Wheel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Wheel_Type wheel_type;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER) //many to one uni directional
    @JoinColumn(name = "car_name",referencedColumnName = "name")
    private Car car;

    public Wheel(Wheel_Type wheel_type, Car car) {
        this.wheel_type = wheel_type;
        this.car = car;
    }

    public Wheel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Wheel_Type getWheel_type() {
        return wheel_type;
    }

    public void setWheel_type(Wheel_Type wheel_type) {
        this.wheel_type = wheel_type;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "id=" + id +
                ", wheel_type=" + wheel_type +
                ", car=" + car +
                '}';
    }
}
