package com.ttn.rabbitmq.consumer.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;


public class Employee {

    public Employee() {
    }

    public Employee(Long empId, String name, Date doj) {
        this.empId = empId;
        this.name = name;
        this.doj = doj;
    }

    @JsonProperty("emp_id")
    private Long empId;
    private String name;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date doj;
    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", doj=" + doj +
                '}';
    }
}
