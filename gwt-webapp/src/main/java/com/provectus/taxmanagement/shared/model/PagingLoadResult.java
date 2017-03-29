package com.provectus.taxmanagement.shared.model;

import java.io.Serializable;
import java.util.List;

public class PagingLoadResult<T extends Serializable> implements Serializable {

    private List<T> items;
    private int pageNumber;
    private int pageCount;

    public PagingLoadResult(List<T> items, int pageNumber, int pageCount) {
        this.items = items;
        this.pageNumber = pageNumber;
        this.pageCount = pageCount;
    }

    /**
     * For serialization only
     */
    @SuppressWarnings("unused")
    public PagingLoadResult() {
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getItems() {
        return items;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageCount() {
        return pageCount;
    }
}