package com.provectus.taxmanagement.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by alexey on 10.03.17.
 */
@Document(collection = "taxRecords")
public class TaxRecord implements Serializable {
    @Id
    private String id;
    @Version
    private Long version;
    private String counterpartyName;
    @Indexed
    private Date receivingDate;
    private Double uahRevenue = 0d;
    private Double usdRevenue = 0d;
    private Double exchRateUsdUahNBUatReceivingDate = 0d;
    private Double uahAmountForTaxInspection;//usdRevenue * exchRateUsdUahNBUatReceivingDate + uahRevenue
    private String taxQuoter;//like Q1 2017, Q4 2016
    private Double taxValue;//uahAmountForTaxInspection * Employee.taxPercentage or uahAmountForTaxInspection * this.taxPercentage
    private Integer taxPercentage = Employee.TAX_PERCENTAGE_EMPLOYEE_3th_CATEGORY;//default current value

    private Date createdDate;
    private Date modifiedDate;

    public Double calculateAmountForTaxInspection() {
        uahAmountForTaxInspection = usdRevenue * exchRateUsdUahNBUatReceivingDate + uahRevenue;
        return uahAmountForTaxInspection;
    }

    public Double calculateTaxValue() {
        taxValue = uahAmountForTaxInspection * taxPercentage / 100;
        return taxValue;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCounterpartyName() {
        return counterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        this.counterpartyName = counterpartyName;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Double getUahRevenue() {
        return uahRevenue;
    }

    public void setUahRevenue(Double uahRevenue) {
        this.uahRevenue = uahRevenue;
    }

    public Double getUsdRevenue() {
        return usdRevenue;
    }

    public void setUsdRevenue(Double usdRevenue) {
        this.usdRevenue = usdRevenue;
    }

    public Double getExchRateUsdUahNBUatReceivingDate() {
        return exchRateUsdUahNBUatReceivingDate;
    }

    public void setExchRateUsdUahNBUatReceivingDate(Double exchRateUsdUahNBUatReceivingDate) {
        this.exchRateUsdUahNBUatReceivingDate = exchRateUsdUahNBUatReceivingDate;
    }

    public Double getUahAmountForTaxInspection() {
        return uahAmountForTaxInspection;
    }

    public void setUahAmountForTaxInspection(Double uahAmountForTaxInspection) {
        this.uahAmountForTaxInspection = uahAmountForTaxInspection;
    }

    public String getTaxQuoter() {
        return taxQuoter;
    }

    public void setTaxQuoter(String taxQuoter) {
        this.taxQuoter = taxQuoter;
    }


    public Double getTaxValue() {
        return taxValue;
    }

    public void setTaxValue(Double taxValue) {
        this.taxValue = taxValue;
    }

    public Integer getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(Integer taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxRecord taxRecord = (TaxRecord) o;

        if (id != null ? !id.equals(taxRecord.id) : taxRecord.id != null) return false;
        if (version != null ? !version.equals(taxRecord.version) : taxRecord.version != null) return false;
        if (counterpartyName != null ? !counterpartyName.equals(taxRecord.counterpartyName) : taxRecord.counterpartyName != null)
            return false;
        if (receivingDate != null ? !receivingDate.equals(taxRecord.receivingDate) : taxRecord.receivingDate != null)
            return false;
        if (uahRevenue != null ? !uahRevenue.equals(taxRecord.uahRevenue) : taxRecord.uahRevenue != null) return false;
        if (usdRevenue != null ? !usdRevenue.equals(taxRecord.usdRevenue) : taxRecord.usdRevenue != null) return false;
        if (exchRateUsdUahNBUatReceivingDate != null ? !exchRateUsdUahNBUatReceivingDate.equals(taxRecord.exchRateUsdUahNBUatReceivingDate) : taxRecord.exchRateUsdUahNBUatReceivingDate != null)
            return false;
        if (uahAmountForTaxInspection != null ? !uahAmountForTaxInspection.equals(taxRecord.uahAmountForTaxInspection) : taxRecord.uahAmountForTaxInspection != null)
            return false;
        if (taxQuoter != null ? !taxQuoter.equals(taxRecord.taxQuoter) : taxRecord.taxQuoter != null) return false;
        if (taxValue != null ? !taxValue.equals(taxRecord.taxValue) : taxRecord.taxValue != null) return false;
        if (taxPercentage != null ? !taxPercentage.equals(taxRecord.taxPercentage) : taxRecord.taxPercentage != null)
            return false;
        if (createdDate != null ? !createdDate.equals(taxRecord.createdDate) : taxRecord.createdDate != null)
            return false;
        return !(modifiedDate != null ? !modifiedDate.equals(taxRecord.modifiedDate) : taxRecord.modifiedDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (counterpartyName != null ? counterpartyName.hashCode() : 0);
        result = 31 * result + (receivingDate != null ? receivingDate.hashCode() : 0);
        result = 31 * result + (uahRevenue != null ? uahRevenue.hashCode() : 0);
        result = 31 * result + (usdRevenue != null ? usdRevenue.hashCode() : 0);
        result = 31 * result + (exchRateUsdUahNBUatReceivingDate != null ? exchRateUsdUahNBUatReceivingDate.hashCode() : 0);
        result = 31 * result + (uahAmountForTaxInspection != null ? uahAmountForTaxInspection.hashCode() : 0);
        result = 31 * result + (taxQuoter != null ? taxQuoter.hashCode() : 0);
        result = 31 * result + (taxValue != null ? taxValue.hashCode() : 0);
        result = 31 * result + (taxPercentage != null ? taxPercentage.hashCode() : 0);
        result = 31 * result + (createdDate != null ? createdDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
