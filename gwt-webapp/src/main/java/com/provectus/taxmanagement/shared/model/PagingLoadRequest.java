package com.provectus.taxmanagement.shared.model;

import java.io.Serializable;

public class PagingLoadRequest implements Serializable {

    private int pageNumber;
    private int pageSize;

    public PagingLoadRequest(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    public PagingLoadRequest() {
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    @Override
    public String toString() {
        return "PageNumber: " + pageNumber +", PageSize: " + pageSize;
    }
}