package Eckford.services;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel {

	private Person p;
	private ArrayList<Person> people;
	private String[] columns = { "ID", "FName", "LName", "PhoneNumber", "LGBT", "Email", "AddressID", "Race",
			"Nationality", "Sex", "Ethnicity" };

	public PersonTableModel(ArrayList<Person> people) {
		this.people = people;
	}

	@Override
	public int getRowCount() {
		return people.size();
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
		p = people.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.ID;
		case 1:
			return p.Fname;
		case 2:
			return p.Lname;
		case 3:
			return p.PhoneNumber;
		case 4:
			return p.LGBT;
		case 5:
			return p.Email;
		case 6:
			return p.AddressID;
		case 7:
			return p.Race;
		case 8:
			return p.Nationality;
		case 9:
			return p.Sex;
		case 10:
			return p.Ethnicity;
		}
		return null;
	}

}
