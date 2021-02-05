package Tables;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MatchTableModel extends AbstractTableModel {
	private Match m;
	private ArrayList<Match> matches;
	private String[] columns = {"FName", "LName", "PhoneNumber", "LGBT", "Email", "AddressID", "Race",
			"Nationality", "Sex", "Ethnicity, Position, Seniority, Field" };
	
	
	public MatchTableModel(ArrayList<Match> findMatches) {
		// TODO Auto-generated constructor stub
		this.matches = findMatches; 
	}

	@Override
	public int getRowCount() {
		return matches.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columns.length;
	}
	@Override
	public String getColumnName(int col) {
		return columns[col];
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		m = matches.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return m.Fname;
		case 1:
			return m.Lname;
		case 2:
			return m.PhoneNumber;
		case 3:
			return m.LGBT;
		case 4:
			return m.Email;
		case 5:
			return m.Race;
		case 6:
			return m.Nationality;
		case 7:
			return m.Sex;
		case 8:
			return m.Ethnicity;
		}
		return null;
	}

}
