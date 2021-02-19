package Tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class AddressTableModel extends AbstractTableModel {

	private Address a;
	private ArrayList<Address> address;
	private String[] columns = {"State", "City", "StreetAddress", "UnitNumber", "Zip"};

	public AddressTableModel(ArrayList<Address> address) {
		this.address = address;
	}

	@Override
	public int getRowCount() {
		return address.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public String getColumnName(int col) {
		return columns[col];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		a = address.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return a.State;
		case 1:
			return a.City;
		case 2:
			return a.Address;
		case 3:
			return a.UnitNumber;
		case 4:
			return a.Zip;
		}
		return null;
	}

}
