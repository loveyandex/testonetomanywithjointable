package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * The Guest entity.\n@author A true hipster
 */
@Entity
@Table(name = "guest")
public class Guest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * name
     */
    @Column(name = "name")
    private String name;

    @OneToMany
    @JsonIgnoreProperties(value = { "employee", "parkedBlock"}, allowSetters = true)
    @JoinTable(name="GuestCars",
    joinColumns = @JoinColumn( name="guest_id"),
    inverseJoinColumns = @JoinColumn( name="car_id"))
    private Set<Car> cars = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "guests", "manager", "cars", "parkedBlocks" }, allowSetters = true)
    private Employee manager;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Guest name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public Guest cars(Set<Car> cars) {
        this.setCars(cars);
        return this;
    }

    public Guest addCar(Car car) {
        this.cars.add(car);
        return this;
    }

    public Guest removeCar(Car car) {
        this.cars.remove(car);
        return this;
    }

    public void setCars(Set<Car> cars) {
    
        this.cars = cars;
    }

    public Employee getManager() {
        return this.manager;
    }

    public Guest manager(Employee employee) {
        this.setManager(employee);
        return this;
    }

    public void setManager(Employee employee) {
        this.manager = employee;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Guest)) {
            return false;
        }
        return id != null && id.equals(((Guest) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Guest{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
