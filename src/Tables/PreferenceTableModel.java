package Tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PreferenceTableModel extends AbstractTableModel {

	private Preference p;
	private ArrayList<Preference> preferences;
	private String[] columns = {"State", "City", "Field", "Seniority", "Sex", "LGBT"};

	public PreferenceTableModel(ArrayList<Preference> preferences) {
		this.preferences = preferences;
	}

	@Override
	public int getRowCount() {
		return preferences.size();
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
		p = preferences.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.State;
		case 1:
			return p.City;
		case 2:
			return p.Field;
		case 3:
			return p.Seniority;
		case 4:
			return p.Sex;
		case 5:
			return p.LGBT;
		}
		return null;
	}

}
