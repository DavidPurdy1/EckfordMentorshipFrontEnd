package Eckford.services;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class PersonTableModel extends AbstractTableModel{

	private ArrayList<String> people; 
	private String[] columns = {}; 
	
	public PersonTableModel(ArrayList<String> people) {
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		String t = people.get(rowIndex); 
		
		return t;
	}

}
