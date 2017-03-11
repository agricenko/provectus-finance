package com.provectus.taxmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by alexey on 10.03.17.
 */
@Document(collection = "employees")
public class Employee implements Serializable {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String patronymic;
    private String comment;
    private String departnemt;
    private Integer taxPercentage = 5;//default current value
    private List<String> kved;
    private List<TaxRecord> taxRecords;

    private Date createdDate;
    private Date modifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDepartnemt() {
        return departnemt;
    }

    public void setDepartnemt(String departnemt) {
        this.departnemt = departnemt;
    }

    public Integer getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Integer taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public List<String> getKved() {
        return kved;
    }

    public void setKved(List<String> kved) {
        this.kved = kved;
    }

    public List<TaxRecord> getTaxRecords() {
        return taxRecords;
    }

    public void setTaxRecords(List<TaxRecord> taxRecords) {
        this.taxRecords = taxRecords;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (patronymic != null ? !patronymic.equals(employee.patronymic) : employee.patronymic != null) return false;
        if (comment != null ? !comment.equals(employee.comment) : employee.comment != null) return false;
        if (departnemt != null ? !departnemt.equals(employee.departnemt) : employee.departnemt != null) return false;
        return !(taxPercentage != null ? !taxPercentage.equals(employee.taxPercentage) : employee.taxPercentage != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (departnemt != null ? departnemt.hashCode() : 0);
        result = 31 * result + (taxPercentage != null ? taxPercentage.hashCode() : 0);
        return result;
    }
}
