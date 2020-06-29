package com.min.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel{
	
	private List<Transaction> list;
	
	public TableData() {
		updateList();
	}
	
	
	public void updateList(){
		list = new ArrayList<Transaction>();
		try {
			Scanner sc = new Scanner(new File("src/com/min/main/board.txt"));
			
			for(int i = 0; sc.hasNextLine(); i++) {
				String[] data = sc.nextLine().split(",");
				Transaction t = new Transaction();
				TransactionBuilder tb = new TransactionBuilder(t);
				t = tb
						.title(data[0])
						.text(data[1])
						.transaction();
				list.add(t);
			}
			
			
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없습니다.");
			e.printStackTrace();
		}
		
		
		for(Transaction t : list) {
			System.out.println(t);
		}
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
//		return list.size();
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return list.get(rowIndex).getTitle();
		case 1:
			return list.get(rowIndex).getText();
		}
		return null;
	}

}
