package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)//uni directional- only car know about engine(engine not)
    @JoinColumn(name = "engine_id",referencedColumnName = "id")
    @JoinColumn(name = "engine_power",referencedColumnName = "power")
    private Engine engine;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "technical_passport_id",referencedColumnName = "id")
    private Technical_passport technical_passport;    ///bi directional
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)//u dircetional //bi directional it MANY TO ONE
    @JoinTable(name = "car_passenger",
                joinColumns = @JoinColumn(name = "car_id"),
    inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengers;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "car_drivers",
            joinColumns = @JoinColumn(name = "car_id"),
            inverseJoinColumns = @JoinColumn(name = "driver_id"))
    private List<Driver> drivers;

    public Technical_passport getTechnical_passport() {
        return technical_passport;
    }

    public void setTechnical_passport(Technical_passport technical_passport) {
        this.technical_passport = technical_passport;
    }
    public Car(String name, Engine engine, Technical_passport technical_passport) {
        this.name = name;
        this.engine = engine;
        this.technical_passport = technical_passport;
    }

    public Car(String name,Engine engine,List<Driver> drivers) {
        this.name = name;
        this.engine=engine;
        this.drivers=drivers;
    }

    public Car(String name, Engine engine, Technical_passport technical_passport, List<Passenger> passengers) {
        this.name = name;
        this.engine = engine;
        this.technical_passport = technical_passport;
        this.passengers = passengers;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", engine=" + engine +
                '}';
    }
}
