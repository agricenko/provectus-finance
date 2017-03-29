package com.provectus.taxmanagement.client.ui.widget.table;

import com.google.gwt.dom.builder.shared.TableRowBuilder;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.AbstractHeaderOrFooterBuilder;
import com.provectus.taxmanagement.client.ui.widget.common.AbstractAsyncTable;
import com.provectus.taxmanagement.shared.model.Quarter;

/**
 * Created by unconsionable on 28.03.2017.
 */
public class QuarterTable extends AbstractAsyncTable<Quarter> {

    @Override
    protected void initTableColumns() {

    }

    public class CustomHeaderBuilder extends AbstractHeaderOrFooterBuilder<Quarter> {

        public CustomHeaderBuilder(AbstractCellTable<Quarter> table, boolean isFooter) {
            super(table, isFooter);
        }

        @Override
        protected boolean buildHeaderOrFooterImpl() {
            TableRowBuilder row = startRow();


            return false;
        }
    }
}
