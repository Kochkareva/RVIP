package com.exam.consumer.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Entity
@Table(name = "t_number")
@Data
@Accessors(chain = true)
public class MainModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Boolean is_Even;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Boolean getIs_Even() {
        return is_Even;
    }

    public void setIs_Even(Boolean is_Even) {
        this.is_Even = is_Even;
    }
}
