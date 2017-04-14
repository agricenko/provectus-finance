package com.provectus.taxmanagement.shared.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.*;

/**
 * Created by alexey on 10.03.17.
 */
public class Employee implements Serializable {
    public static final int TAX_PERCENTAGE_EMPLOYEE_3th_CATEGORY = 5;

    private String id;
    private Long version;
    @NotNull
    @Size(max = 40)
    private String firstName;
    @NotNull
    @Size(max = 40)
    private String lastName;
    @NotNull
    @Size(max = 40)
    private String secondName;
    @NotNull
    @Size(max = 200)
    private String comment;
    @NotNull
    @Size(max = 50)
    private String department;
    @NotNull
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,254})$")
    private String email;
    @NotNull
    @Max(100)
    private Integer taxPercentage = TAX_PERCENTAGE_EMPLOYEE_3th_CATEGORY;//default current value
    private List<String> kved;
    private List<Quarter> quartersSet = new ArrayList<>();

    private Date createdDate;
    private Date modifiedDate;

    public void addQuarter(Quarter quarter) {
        quartersSet.add(quarter);
    }

    public boolean removeQuarter(Quarter quarter) {
        return quartersSet.remove(quarter);
    }

    public Double getTotalUahVolumeForTaxesByYear(Integer year) {
        Double sum = 0d;
        Set<Quarter> allQuartersByYear = getAllQuartersByYear(year);
        for (Quarter quarter : allQuartersByYear) {
            List<TaxRecord> taxRecords = quarter.getTaxRecords();
            for (TaxRecord taxRecord : taxRecords) {
                sum += taxRecord.getUahVolumeForTaxInspection();
            }
        }
        return sum;
    }

    public Double getTotalTaxesVolumeByYear(Integer year) {
        Double sum = 0d;
        Set<Quarter> allQuartersByYear = getAllQuartersByYear(year);
        for (Quarter quarter : allQuartersByYear) {
            List<TaxRecord> taxRecords = quarter.getTaxRecords();
            for (TaxRecord taxRecord : taxRecords) {
                sum += taxRecord.getTaxValue();
            }
        }
        return sum;
    }

    public Set<Quarter> getAllQuartersByYear(Integer year) {
        Set<Quarter> quarters = new HashSet<>();
        for (Quarter quarter : quartersSet) {
            if (quarter.getQuarterDefinition().getYear().equals(year)) {
                quarters.add(quarter);
            }
        }
        return quarters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuartersSet(List<Quarter> quartersSet) {
        this.quartersSet = quartersSet;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (version != null ? !version.equals(employee.version) : employee.version != null) return false;
        if (firstName != null ? !firstName.equals(employee.firstName) : employee.firstName != null) return false;
        if (lastName != null ? !lastName.equals(employee.lastName) : employee.lastName != null) return false;
        if (secondName != null ? !secondName.equals(employee.secondName) : employee.secondName != null) return false;
        if (comment != null ? !comment.equals(employee.comment) : employee.comment != null) return false;
        if (department != null ? !department.equals(employee.department) : employee.department != null) return false;
        if (email != null ? !email.equals(employee.email) : employee.email != null) return false;
        if (taxPercentage != null ? !taxPercentage.equals(employee.taxPercentage) : employee.taxPercentage != null)
            return false;
        if (kved != null ? !kved.equals(employee.kved) : employee.kved != null) return false;
        if (quartersSet != null ? !quartersSet.equals(employee.quartersSet) : employee.quartersSet != null)
            return false;
        if (createdDate != null ? !createdDate.equals(employee.createdDate) : employee.createdDate != null)
            return false;
        return !(modifiedDate != null ? !modifiedDate.equals(employee.modifiedDate) : employee.modifiedDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (department != null ? department.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (taxPercentage != null ? taxPercentage.hashCode() : 0);
        result = 31 * result + (kved != null ? kved.hashCode() : 0);
        result = 31 * result + (quartersSet != null ? quartersSet.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
