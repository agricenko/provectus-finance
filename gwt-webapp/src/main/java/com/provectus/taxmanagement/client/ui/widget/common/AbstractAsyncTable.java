package com.provectus.taxmanagement.client.ui.widget.common;

import com.google.gwt.dom.client.Style;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.view.client.AsyncDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SelectionModel;
import com.google.gwt.view.client.SingleSelectionModel;
import com.provectus.taxmanagement.shared.model.PagingLoadRequest;
import com.provectus.taxmanagement.shared.model.PagingLoadResult;
import org.gwtbootstrap3.client.ui.gwt.DataGrid;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractAsyncTable<T extends Serializable> extends Composite{

    protected DataGrid<T> table;
    protected SelectionModel<T> selectionModel;
    protected SimplePager pager;
    protected AsyncDataProvider<T> dataProvider;
    protected ColumnSortEvent.ListHandler<T> sortHandler;

    private DockLayoutPanel dockLayoutPanel;

    public AbstractAsyncTable() {
        dockLayoutPanel = new DockLayoutPanel(Style.Unit.EM);

        table = new DataGrid<T>();
        table.setStriped(true);
        table.setBordered(true);
        table.setHover(true);
        table.setCondensed(true);

        initTableColumns();
        initSelectionModel();
        initPager();

        dockLayoutPanel.addSouth(pager, 3);
        dockLayoutPanel.add(table);

        initWidget(dockLayoutPanel);
    }

    protected abstract void initTableColumns();

    protected void initSelectionModel() {
        selectionModel = new SingleSelectionModel<T>();
        table.setSelectionModel(selectionModel);

        sortHandler = new ColumnSortEvent.ListHandler<T>(table.getVisibleItems()) {

            @Override
            public void onColumnSort(ColumnSortEvent columnSortEvent) {
                table.redraw();
            }
        };
        table.addColumnSortHandler(sortHandler);
    }

    private void initPager() {
        pager = new SimplePager();
        pager.setDisplay(table);
        pager.setRangeLimited(true);
        pager.setPageSize(25);
    }

    public void setValues(PagingLoadResult<T> loadResult) {
        pager.setPageStart(loadResult.getPageNumber());
        dataProvider.updateRowData(loadResult.getPageNumber(), loadResult.getItems());
        dataProvider.updateRowCount(loadResult.getPageCount(), true);
    }

    public void setValues(List<T> values) {
        dataProvider.updateRowData(0, values);
        dataProvider.updateRowCount(values.size(), true);
    }

    public T getSelected() {
        if (selectionModel instanceof SingleSelectionModel) {
            return ((SingleSelectionModel<T>) selectionModel).getSelectedObject();
        }

        return null;
    }

    public void setDataProvider(AsyncDataProvider<T> dataProvider) {
        this.dataProvider = dataProvider;
        dataProvider.addDataDisplay(table);
    }

    public PagingLoadRequest getPagingLoadConfig() {
        return new PagingLoadRequest(pager.getPage(), pager.getPageSize());
    }

    public void addSelectionHandler(SelectionChangeEvent.Handler handler){
        selectionModel.addSelectionChangeHandler(handler);
    }
}