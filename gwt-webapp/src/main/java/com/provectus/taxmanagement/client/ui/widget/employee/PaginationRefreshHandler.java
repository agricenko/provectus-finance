package com.provectus.taxmanagement.client.ui.widget.employee;

import com.provectus.taxmanagement.shared.model.PagingLoadRequest;

import java.io.Serializable;

/**
 * Created by Alex on 19.04.2017.
 */
public interface PaginationRefreshHandler<T extends Serializable> {

    void onDataChange(PagingLoadRequest pagingLoadRequest);
}
