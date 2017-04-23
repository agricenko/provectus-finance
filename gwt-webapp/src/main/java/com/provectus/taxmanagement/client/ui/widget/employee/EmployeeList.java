package com.provectus.taxmanagement.client.ui.widget.employee;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.provectus.taxmanagement.shared.model.Employee;
import com.provectus.taxmanagement.shared.model.PagingLoadRequest;
import com.provectus.taxmanagement.shared.model.PagingLoadResult;
import org.gwtbootstrap3.client.ui.*;
import org.gwtbootstrap3.client.ui.constants.HeadingSize;
import org.gwtbootstrap3.client.ui.constants.Pull;
import org.gwtbootstrap3.client.ui.html.Paragraph;

import java.util.ArrayList;
import java.util.List;

public class EmployeeList extends Composite {

    @UiField
    LinkedGroup linkedGroup;
    @UiField
    Pagination pagination;

    private PaginationRefreshHandler<Employee> refreshHandler;
    private SingleSelectionModel<Employee> singleSelectionModel;

    private int pageSize = 25;

    public EmployeeList() {
        Binder uiBinder = GWT.create(Binder.class);
        initWidget(uiBinder.createAndBindUi(this));

        singleSelectionModel = new SingleSelectionModel<>();

        List<Employee> employees = new ArrayList<>();
        for (int i =0; i< 25; i++ ) {
            Employee employee = new Employee();
            employee.setId(String.valueOf(i));
            employee.setFirstName("User: " + i);
            employees.add(employee);
        }
        PagingLoadResult<Employee> pagingLoadResult = new PagingLoadResult<>(employees,6,15);
        setValues(pagingLoadResult);
    }


    public void setValues(PagingLoadResult<Employee> loadResult) {
        refreshPagination(loadResult.getPageNumber(), loadResult.getPageCount());
        refreshListItems(loadResult);
    }

    private void refreshListItems(PagingLoadResult<Employee> loadResult) {
        linkedGroup.clear();

        for (Employee employee: loadResult.getItems()) {
            LinkedGroupItem item = new LinkedGroupItem();
            Image image = new Image();
            image.setPull(Pull.LEFT);
            image.setUrl("http://fmfkemerovo.ru/files/staff/no-avatar.png");

            image.setPixelSize(50,50);

            item.add(image);

            item.setPaddingLeft(5);
            item.setPaddingRight(5);
            item.setPaddingTop(5);
            item.setPaddingBottom(5);
            item.add(new Heading(HeadingSize.H5, "Aleksander Matkovskiy"));
            item.add(new Paragraph(".com"));

            item.addClickHandler(clickEvent -> singleSelectionModel.setSelected(employee, true));

            linkedGroup.add(item);
        }
    }

    private void refreshPagination(int pageNumber, int pageCount) {
        pagination.clear();

        AnchorListItem anchorListItem = pagination.addPreviousLink();
        anchorListItem.setEnabled(pageNumber != 1);
        anchorListItem.addClickHandler(getClickHandler(pageNumber - 1));

        if (pageNumber > 2) {
            anchorListItem = new AnchorListItem("1");
            anchorListItem.addClickHandler(getClickHandler(1));
            pagination.add(anchorListItem);
        }

        if (pageNumber > 3) {
            anchorListItem = new AnchorListItem("...");
            anchorListItem.setEnabled(false);
            pagination.add(anchorListItem);
        }

        for (int i = pageNumber - 1; i < pageNumber + 2; i++) {
            if (i < 1 || i > pageCount) continue;

            anchorListItem = new AnchorListItem(String.valueOf(i));
            anchorListItem.addClickHandler(getClickHandler(i));
            pagination.add(anchorListItem);
        }

        if (pageCount - pageNumber > 2) {
            anchorListItem = new AnchorListItem("...");
            anchorListItem.setEnabled(false);
            pagination.add(anchorListItem);
        }

        if (pageCount - pageNumber > 1) {
            anchorListItem = new AnchorListItem(String.valueOf(pageCount));
            anchorListItem.addClickHandler(getClickHandler(pageCount));
            pagination.add(anchorListItem);
        }

        anchorListItem = pagination.addNextLink();
        anchorListItem.setEnabled(pageNumber < pageCount);
        anchorListItem.addClickHandler(getClickHandler(pageNumber + 1));
    }

    public void setRefreshHandler(PaginationRefreshHandler<Employee> refreshHandler) {
        this.refreshHandler = refreshHandler;
    }

    public void addSelectionHandler(SelectionChangeEvent.Handler handler){
        singleSelectionModel.addSelectionChangeHandler(handler);
    }

    private ClickHandler getClickHandler(int pageNumber) {
        return new ClickHandler() {
            @Override
            public void onClick(ClickEvent clickEvent) {
                if (refreshHandler != null) {
                    PagingLoadRequest pagingLoadRequest = new PagingLoadRequest(pageNumber, pageSize);
                    refreshHandler.onDataChange(pagingLoadRequest);
                }
            }
        };
    }

    public Employee getSelected() {
        return singleSelectionModel.getSelectedObject();
    }

    interface Binder extends UiBinder<Panel, EmployeeList> {
    }
}