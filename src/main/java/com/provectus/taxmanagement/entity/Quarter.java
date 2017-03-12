package com.provectus.taxmanagement.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by alexey on 12.03.17.
 */
@Document(collection = "quarters")
public class Quarter {
    @Id
    private ObjectId id;
    private String quarterTitle;
    private Double uahVolumeForTaxes = 0d;
    private Double taxVolume = 0d;

    @DBRef
    private List<TaxRecord> taxRecords = new ArrayList<>();

    private Date createDate;
    private Date modifiedDate;

    public void addQarter(TaxRecord taxRecord) {
        taxRecords.add(taxRecord);
    }

    public void removeQarter(TaxRecord taxRecord) {
        taxRecords.remove(taxRecord);
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

    public ObjectId getId() {
        return id;
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

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getQuarterTitle() {
        return quarterTitle;
    }

    public void setQuarterTitle(String quarterTitle) {
        this.quarterTitle = quarterTitle;
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

        Quarter quarter = (Quarter) o;

        if (id != null ? !id.equals(quarter.id) : quarter.id != null) return false;
        if (quarterTitle != null ? !quarterTitle.equals(quarter.quarterTitle) : quarter.quarterTitle != null)
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
        result = 31 * result + (quarterTitle != null ? quarterTitle.hashCode() : 0);
        result = 31 * result + (uahVolumeForTaxes != null ? uahVolumeForTaxes.hashCode() : 0);
        result = 31 * result + (taxVolume != null ? taxVolume.hashCode() : 0);
        result = 31 * result + (taxRecords != null ? taxRecords.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
