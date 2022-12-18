package models;

import javax.persistence.*;

@Entity
public class Technical_passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean presence;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "technical_passport")
    private Car car;  //bi directional

    public Technical_passport(boolean presence) {
        this.presence = presence;
    }

    public Technical_passport() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPresence() {
        return presence;
    }

    public void setPresence(boolean presence) {
        this.presence = presence;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Technical_passport{" +
                "id=" + id +
                ", presence=" + presence +
                ", car=" + car +
                '}';
    }
}
