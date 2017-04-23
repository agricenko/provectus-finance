package com.provectus.taxmanagement.client.ui.widget.payment;

import com.google.gwt.cell.client.DatePickerCell;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.dom.builder.shared.TableRowBuilder;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.cellview.client.AbstractCellTable;
import com.google.gwt.user.cellview.client.AbstractHeaderOrFooterBuilder;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.Composite;
import com.provectus.taxmanagement.shared.model.Quarter;
import com.provectus.taxmanagement.shared.model.TaxRecord;
import org.gwtbootstrap3.client.ui.gwt.CellTable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QuarterEditTable extends Composite {

    protected CellTable<TaxRecord> table;
    protected Quarter quarter = null;

    public QuarterEditTable() {
        table = new CellTable<>();
        table.setStriped(true);
        table.setBordered(true);
        table.setHover(true);
        table.setCondensed(true);

        initColumns();

        table.setHeaderBuilder(new CustomHeaderBuilder(table, false));
        table.setFooterBuilder(new CustomFooterBuilder(table, true));

        List<TaxRecord> taxRecords = new ArrayList<>();
        taxRecords.add(new TaxRecord());
        taxRecords.add(new TaxRecord());
        taxRecords.add(new TaxRecord());

        table.setRowData(taxRecords);

        initWidget(table);
    }

    private void initColumns() {
        Column<TaxRecord, String> companyColumn = new Column<TaxRecord, String>(new EditTextCell()) {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return taxRecord.getCounterpartyName();
            }
        };

        DateTimeFormat dateFormat = DateTimeFormat.getFormat(DateTimeFormat.PredefinedFormat.DATE_MEDIUM);
        Column<TaxRecord, Date> receivingDateColumn = new Column<TaxRecord, Date>(new DatePickerCell()) {
            @Override
            public Date getValue(TaxRecord taxRecord) {
                return new Date();
            }
        };
        receivingDateColumn.setFieldUpdater(new FieldUpdater<TaxRecord, Date>() {
            @Override
            public void update(int i, TaxRecord taxRecord, Date s) {
                taxRecord.setReceivingDate(s);
            }
        });

        Column<TaxRecord, String> usdRevenueColumn = new Column<TaxRecord, String>(new EditTextCell()) {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return String.valueOf(taxRecord.getUsdRevenue());
            }
        };

        TextColumn<TaxRecord> uahRevenueColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return String.valueOf(taxRecord.getUahRevenue());
            }
        };

        TextColumn<TaxRecord> exchangeRate = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return String.valueOf(taxRecord.getExchRateUsdUahNBUatReceivingDate());
            }
        };

        TextColumn<TaxRecord> uahVolumeColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return String.valueOf(taxRecord.getUahVolumeForTaxInspection());
            }
        };

        TextColumn<TaxRecord> taxValueColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return String.valueOf(taxRecord.getTaxValue());
            }
        };

        TextColumn<TaxRecord> quarterColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                if (quarter == null) return null;

                return quarter.getDescription();
            }
        };

        TextColumn<TaxRecord> amountColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return "";
            }
        };

        TextColumn<TaxRecord> payColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return "";
            }
        };

        TextColumn<TaxRecord> payDateColumn = new TextColumn<TaxRecord>() {
            @Override
            public String getValue(TaxRecord taxRecord) {
                return "";
            }
        };

        table.addColumn(companyColumn, "Наименование Контрагента");
        table.addColumn(receivingDateColumn, "Дата поступения денежных средств");
        table.addColumn(usdRevenueColumn, "Доллары");
        table.addColumn(uahRevenueColumn, "Гривна");
        table.addColumn(exchangeRate, "Курс НБУ на дату поступления");
        table.addColumn(uahVolumeColumn, "Эквивалент в гривне по курсу НБУ к налогообложению");
        table.addColumn(taxValueColumn, "Сумма к налогообложению");
        table.addColumn(quarterColumn, "Период");
        table.addColumn(amountColumn, "Начислено");
        table.addColumn(payColumn, "Оплачено");
        table.addColumn(payDateColumn, "Дата оплаты");
    }

    public void setQuarter(Quarter quarter) {
        this.quarter = quarter;
    }

    public class CustomHeaderBuilder extends AbstractHeaderOrFooterBuilder<TaxRecord> {

        public CustomHeaderBuilder(AbstractCellTable<TaxRecord> table, boolean isFooter) {
            super(table, isFooter);
        }

        @Override
        protected boolean buildHeaderOrFooterImpl() {
            buildRow1();
            buildRow2();

            return true;
        }

        private void buildRow1() {
            TableRowBuilder row = startRow();

            row.startTH().colSpan(2).endTH();
            row.startTH().colSpan(2).text("Валюта Поступления").endTH();
            row.startTH().colSpan(4).end();
            row.startTH().colSpan(3).text("Единый налог").endTH();

            row.end();
        }

        private void buildRow2() {
            TableRowBuilder row = startRow();

            row.startTH().text("Наименование Контрагента").endTH();
            row.startTH().text("Дата поступления денежных средств").endTH();
            row.startTH().text("Доллары").endTH();
            row.startTH().text("Гривна").endTH();
            row.startTH().text("Курс НБУ на дату поступления").endTH();
            row.startTH().text("Эквивалент в гривне по курсу НБУ к налогообложению").endTH();
            row.startTH().text("Сумма к налогооблажению").endTH();
            row.startTH().text("Период").endTH();
            row.startTH().text("Налислено").endTH();
            row.startTH().text("Оплачено").endTH();
            row.startTH().text("Дата оплаты").endTH();

            row.end();
        }
    }

    public class CustomFooterBuilder extends AbstractHeaderOrFooterBuilder<TaxRecord> {

        public CustomFooterBuilder(AbstractCellTable<TaxRecord> table, boolean isFooter) {
            super(table, isFooter);
        }

        @Override
        protected boolean buildHeaderOrFooterImpl() {
            buildRow1();

            return true;
        }

        private void buildRow1() {
            TableRowBuilder row = startRow();

            row.startTH().colSpan(6).text("Итого:").endTH();
            row.startTH().text("3797").endTH();
            row.startTH().endTH();
            row.startTH().text("189").endTH();
            row.startTH().endTH();
            row.startTH().endTH();

            row.end();
        }
    }
}
