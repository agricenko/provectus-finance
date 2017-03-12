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

    public ObjectId getId() {
        return id;
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

        Quarter quarter1 = (Quarter) o;

        if (id != null ? !id.equals(quarter1.id) : quarter1.id != null) return false;
        if (quarterTitle != null ? !quarterTitle.equals(quarter1.quarterTitle) : quarter1.quarterTitle != null) return false;
        if (taxRecords != null ? !taxRecords.equals(quarter1.taxRecords) : quarter1.taxRecords != null) return false;
        if (createDate != null ? !createDate.equals(quarter1.createDate) : quarter1.createDate != null) return false;
        return !(modifiedDate != null ? !modifiedDate.equals(quarter1.modifiedDate) : quarter1.modifiedDate != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (quarterTitle != null ? quarterTitle.hashCode() : 0);
        result = 31 * result + (taxRecords != null ? taxRecords.hashCode() : 0);
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (modifiedDate != null ? modifiedDate.hashCode() : 0);
        return result;
    }
}
