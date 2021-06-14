package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * The Employee entity.\n@author The jfazliJ.
 */
@Entity
@Table(name = "employee")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "hire_date")
    private Instant hireDate;

    @Column(name = "ban")
    private Boolean ban;

    @Column(name = "parkingreserved_quantity")
    private Integer parkingreservedQuantity;

    @Column(name = "maxparkingreserve_quantity")
    private Integer maxparkingreserveQuantity;

    @OneToMany(mappedBy = "manager")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "cars", "manager" }, allowSetters = true)
    private Set<Guest> guests = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "guests", "manager", "cars", "parkedBlocks" }, allowSetters = true)
    private Employee manager;

    @OneToMany(mappedBy = "employee")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "employee", "parkedBlock", "guest" }, allowSetters = true)
    private Set<Car> cars = new HashSet<>();

    @OneToMany(mappedBy = "employee")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "parkedCar", "employee" }, allowSetters = true)
    private Set<Block> parkedBlocks = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee id(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Employee firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Employee lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Employee phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Instant getHireDate() {
        return this.hireDate;
    }

    public Employee hireDate(Instant hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public void setHireDate(Instant hireDate) {
        this.hireDate = hireDate;
    }

    public Boolean getBan() {
        return this.ban;
    }

    public Employee ban(Boolean ban) {
        this.ban = ban;
        return this;
    }

    public void setBan(Boolean ban) {
        this.ban = ban;
    }

    public Integer getParkingreservedQuantity() {
        return this.parkingreservedQuantity;
    }

    public Employee parkingreservedQuantity(Integer parkingreservedQuantity) {
        this.parkingreservedQuantity = parkingreservedQuantity;
        return this;
    }

    public void setParkingreservedQuantity(Integer parkingreservedQuantity) {
        this.parkingreservedQuantity = parkingreservedQuantity;
    }

    public Integer getMaxparkingreserveQuantity() {
        return this.maxparkingreserveQuantity;
    }

    public Employee maxparkingreserveQuantity(Integer maxparkingreserveQuantity) {
        this.maxparkingreserveQuantity = maxparkingreserveQuantity;
        return this;
    }

    public void setMaxparkingreserveQuantity(Integer maxparkingreserveQuantity) {
        this.maxparkingreserveQuantity = maxparkingreserveQuantity;
    }

    public Set<Guest> getGuests() {
        return this.guests;
    }

    public Employee guests(Set<Guest> guests) {
        this.setGuests(guests);
        return this;
    }

    public Employee addGuest(Guest guest) {
        this.guests.add(guest);
        guest.setManager(this);
        return this;
    }

    public Employee removeGuest(Guest guest) {
        this.guests.remove(guest);
        guest.setManager(null);
        return this;
    }

    public void setGuests(Set<Guest> guests) {
        if (this.guests != null) {
            this.guests.forEach(i -> i.setManager(null));
        }
        if (guests != null) {
            guests.forEach(i -> i.setManager(this));
        }
        this.guests = guests;
    }

    public Employee getManager() {
        return this.manager;
    }

    public Employee manager(Employee employee) {
        this.setManager(employee);
        return this;
    }

    public void setManager(Employee employee) {
        this.manager = employee;
    }

    public Set<Car> getCars() {
        return this.cars;
    }

    public Employee cars(Set<Car> cars) {
        this.setCars(cars);
        return this;
    }

    public Employee addCar(Car car) {
        this.cars.add(car);
        car.setEmployee(this);
        return this;
    }

    public Employee removeCar(Car car) {
        this.cars.remove(car);
        car.setEmployee(null);
        return this;
    }

    public void setCars(Set<Car> cars) {
        if (this.cars != null) {
            this.cars.forEach(i -> i.setEmployee(null));
        }
        if (cars != null) {
            cars.forEach(i -> i.setEmployee(this));
        }
        this.cars = cars;
    }

    public Set<Block> getParkedBlocks() {
        return this.parkedBlocks;
    }

    public Employee parkedBlocks(Set<Block> blocks) {
        this.setParkedBlocks(blocks);
        return this;
    }

    public Employee addParkedBlock(Block block) {
        this.parkedBlocks.add(block);
        block.setEmployee(this);
        return this;
    }

    public Employee removeParkedBlock(Block block) {
        this.parkedBlocks.remove(block);
        block.setEmployee(null);
        return this;
    }

    public void setParkedBlocks(Set<Block> blocks) {
        if (this.parkedBlocks != null) {
            this.parkedBlocks.forEach(i -> i.setEmployee(null));
        }
        if (blocks != null) {
            blocks.forEach(i -> i.setEmployee(this));
        }
        this.parkedBlocks = blocks;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        return id != null && id.equals(((Employee) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Employee{" +
            "id=" + getId() +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", hireDate='" + getHireDate() + "'" +
            ", ban='" + getBan() + "'" +
            ", parkingreservedQuantity=" + getParkingreservedQuantity() +
            ", maxparkingreserveQuantity=" + getMaxparkingreserveQuantity() +
            "}";
    }
}
