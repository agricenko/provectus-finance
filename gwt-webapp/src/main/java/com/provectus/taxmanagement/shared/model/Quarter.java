package com.provectus.taxmanagement.shared.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexey on 12.03.17.
 */
public class Quarter implements Serializable {

    private String id;
    private String description;
    private QuarterDefinition quarterDefinition;
    private Double uahVolumeForTaxes = 0d;
    private Double taxVolume = 0d;
    private List<TaxRecord> taxRecords = new ArrayList<>();

    private Date createDate;
    private Date modifiedDate;

    public static class QuarterDefinition implements Serializable{
        private QuarterName quarterName;
        private Integer year;

        public QuarterDefinition() {
        }

        public QuarterDefinition(QuarterName quarterName, Integer year) {
            this.quarterName = quarterName;
            this.year = year;
        }

        public QuarterName getQuarterName() {
            return quarterName;
        }

        public void setQuarterName(QuarterName quarterName) {
            this.quarterName = quarterName;
        }

        public Integer getYear() {
            return year;
        }

        public void setYear(Integer year) {
            this.year = year;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            QuarterDefinition that = (QuarterDefinition) o;

            if (quarterName != that.quarterName) return false;
            return !(year != null ? !year.equals(that.year) : that.year != null);

        }

        @Override
        public int hashCode() {
            int result = quarterName != null ? quarterName.hashCode() : 0;
            result = 31 * result + (year != null ? year.hashCode() : 0);
            return result;
        }
    }

    public Quarter() {
    }

    public Quarter(QuarterDefinition quarterDefinition) {
        this.quarterDefinition = quarterDefinition;
    }

    public void addTaxRecord(TaxRecord taxRecord) {
        taxRecords.add(taxRecord);
    }

    public boolean removeTaxRecord(TaxRecord taxRecord) {
        return taxRecords.remove(taxRecord);
    }

    public void calculateUahVolumeForTaxes() {
        for (TaxRecord taxRecord : taxRecords) {
            uahVolumeForTaxes += taxRecord.getUahVolumeForTaxInspection();
        }
    }

    public void calculateTaxVolume() {
        for (TaxRecord taxRecord : taxRecords) {
            taxVolume += taxRecord.getTaxValue();
        }
    }

    public Double getUahVolumeForTaxes() {
        return uahVolumeForTaxes;
    }

    public void setUahVolumeForTaxes(Double uahVolumeForTaxes) {
        this.uahVolumeForTaxes = uahVolumeForTaxes;
    }

    public Double getTaxVolume() {
        return taxVolume;
    }

    public void setTaxVolume(Double taxVolume) {
        this.taxVolume = taxVolume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public QuarterDefinition getQuarterDefinition() {
        return quarterDefinition;
    }

    public void setQuarterDefinition(QuarterDefinition quarterDefinition) {
        this.quarterDefinition = quarterDefinition;
    }

    public List<TaxRecord> getTaxRecords() {
        return taxRecords;
    }

    public void setTaxRecords(List<TaxRecord> taxRecords) {
        this.taxRecords = taxRecords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quarter quarter = (Quarter) o;

        if (id != null ? !id.equals(quarter.id) : quarter.id != null) return false;
        if (quarterDefinition != null ? !quarterDefinition.equals(quarter.quarterDefinition) : quarter.quarterDefinition != null)
            return false;
        if (uahVolumeForTaxes != null ? !uahVolumeForTaxes.equals(quarter.uahVolumeForTaxes) : quarter.uahVolumeForTaxes != null)
            return false;
        if (taxVolume != null ? !taxVolume.equals(quarter.taxVolume) : quarter.taxVolume != null) return false;
        if (taxRecords != null ? !taxRecords.equals(quarter.taxRecords) : quarter.taxRecords != null) return false;
        if (createDate != null ? !createDate.equals(quarter.createDate) : quarter.createDate != null) return false;
        return !(modifiedDate != null ? !modifiedDate.equals(quarter.modifiedDate) : quarter.modifiedDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quarterDefinition != null ? quarterDefinition.hashCode() : 0);
        result = 31 * result + (uahVolumeForTaxes != null ? uahVolumeForTaxes.hashCode() : 0);
        result = 31 * result + (taxVolume != null ? taxVolume.hashCode() : 0);
        result = 31 * result + (taxRecords != null ? taxRecords.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
