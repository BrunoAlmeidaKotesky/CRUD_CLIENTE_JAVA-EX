package crud_cliente;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Tabela {

    private JTable _tabela;
    public Tabela(JTable tabela) {
        _tabela = tabela;
    }

    private DefaultTableModel getTableModel() {
        return (DefaultTableModel) _tabela.getModel();
    }

    public void insertRow(Object[] rowData) {
        getTableModel().addRow(rowData);
    }

    public void deleteRow(String code) {
        int rowIndex = -1;
        for (int i = 0; i < getTableModel().getRowCount(); i++) {
            if (getTableModel().getValueAt(i, 0).equals(code)) {
                rowIndex = i;
                break;
            }
        }
        getTableModel().removeRow(rowIndex);
    }

    public void clearTable() {
        int rowCount = _tabela.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            getTableModel().removeRow(i);
        }
    }

    public Vector<String> getSelectedRow() {
        int rowIndex = _tabela.getSelectedRow();
        if (rowIndex == -1) {
            return null;
        }
        return (Vector<String>) getTableModel().getDataVector().elementAt(rowIndex);
    }

    public void filterRows(String nome) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(getTableModel()); 
        sorter.setRowFilter(RowFilter.regexFilter(nome));
        _tabela.setRowSorter(sorter);
    }

    public void editRow(String code, Object[] rowData) {
        int rowIndex = -1;
        for (int i = 0; i < getTableModel().getRowCount(); i++) {
            if (getTableModel().getValueAt(i, 0).equals(code)) {
                rowIndex = i;
                break;
            }
        }
        getTableModel().removeRow(rowIndex);
        getTableModel().insertRow(rowIndex, rowData);
    }
}
