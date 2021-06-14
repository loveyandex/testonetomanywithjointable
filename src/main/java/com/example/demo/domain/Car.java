package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Car.
 */
@Entity
@Table(name = "car")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "naem", nullable = false)
    private String naem;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne
    @JsonIgnoreProperties(value = { "guests", "manager", "cars", "parkedBlocks" }, allowSetters = true)
    private Employee employee;

    @JsonIgnoreProperties(value = { "parkedCar", "employee" }, allowSetters = true)
    @OneToOne(mappedBy = "parkedCar")
    private Block parkedBlock;

     @ManyToOne
     @JsonIgnoreProperties(value = { "cars", "manager" }, allowSetters = true)
     @Getter
     @Setter
     private Guest guest;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car id(Long id) {
        this.id = id;
        return this;
    }

    public String getNaem() {
        return this.naem;
    }

    public Car naem(String naem) {
        this.naem = naem;
        return this;
    }

    public void setNaem(String naem) {
        this.naem = naem;
    }

    public String getCode() {
        return this.code;
    }

    public Car code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Employee getEmployee() {
        return this.employee;
    }

    public Car employee(Employee employee) {
        this.setEmployee(employee);
        return this;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Block getParkedBlock() {
        return this.parkedBlock;
    }

    public Car parkedBlock(Block block) {
        this.setParkedBlock(block);
        return this;
    }

    public void setParkedBlock(Block block) {
        if (this.parkedBlock != null) {
            this.parkedBlock.setParkedCar(null);
        }
        if (parkedBlock != null) {
            parkedBlock.setParkedCar(this);
        }
        this.parkedBlock = block;
    }

 


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Car)) {
            return false;
        }
        return id != null && id.equals(((Car) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Car{" +
            "id=" + getId() +
            ", naem='" + getNaem() + "'" +
            ", code='" + getCode() + "'" +
            "}";
    }
}
