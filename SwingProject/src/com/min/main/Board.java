package com.min.main;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Board {

	private JFrame frame;
	private JPanel editBoard;
	private JPanel boardList;
	private JTextField searchBar;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board window = new Board();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Board() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//읽어온 데이터 업데이트
		TableData td = new TableData();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1019, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		boardList = new JPanel();
		boardList.setBounds(0, 0, 1003, 583);
		frame.getContentPane().add(boardList);
		boardList.setLayout(null);
		
		JButton btnNewButton = new JButton("글쓰기");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//화면 show/display
				editBoard.setVisible(true);
				boardList.setVisible(false);
			}
		});
		btnNewButton.setBounds(831, 497, 130, 44);
		boardList.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("글 목록");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 18));
		lblNewLabel.setBounds(455, 35, 190, 32);
		boardList.add(lblNewLabel);
		
		searchBar = new JTextField();
		searchBar.setBounds(72, 43, 204, 21);
		boardList.add(searchBar);
		searchBar.setColumns(10);
		
		searchBar.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				String val = searchBar.getText();
				//테이블 값 필터
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(val));
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("검색");
		lblNewLabel_1.setBounds(38, 46, 57, 15);
		boardList.add(lblNewLabel_1);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(72, 77, 889, 394);
		boardList.add(panel);
		panel.setLayout(null);
		
		JButton backBtn = new JButton("<");
		backBtn.setBounds(12, 340, 130, 44);
		panel.add(backBtn);
		
		JButton nextBtn = new JButton(">");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		nextBtn.setBounds(747, 340, 130, 44);
		panel.add(nextBtn);
		
		table = new JTable(td);
		table.setBounds(12, 10, 865, 320);
		table.setRowHeight(30);
		panel.add(table);
		
		JButton btnNewButton_1 = new JButton("수정");
		btnNewButton_1.setBounds(689, 497, 130, 44);
		boardList.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("삭제");
		btnNewButton_2.setBounds(547, 497, 130, 44);
		boardList.add(btnNewButton_2);
		
		editBoard = new JPanel();
		editBoard.setBounds(0, 0, 1003, 583);
		frame.getContentPane().add(editBoard);
		editBoard.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(52, 128, 885, 351);
		editBoard.add(textArea);
		
		JTextArea titleBar = new JTextArea();
		titleBar.setBounds(52, 40, 669, 53);
		editBoard.add(titleBar);
		
		
		
		
		
		JButton btnBack = new JButton("뒤로가기");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//화면 show/display
				editBoard.setVisible(false);
				boardList.setVisible(true);
			}
		});
		btnBack.setBounds(783, 40, 154, 53);
		editBoard.add(btnBack);
		
		JButton btnGo = new JButton("글쓰기");
		btnGo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//글쓰기 버튼 클릭시 board.txt파일에 title,text저장
					FileWriter fw = new FileWriter("src/com/min/main/board.txt", true);
					String title = titleBar.getText();
					String text = textArea.getText();
					
					fw.append(title + "," + text + "\n");
					fw.close();
					
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null, "정보를 저장하지 못했습니다.");
				}
			}
		});
		btnGo.setBounds(812, 513, 125, 46);
		editBoard.add(btnGo);
		
		//화면감추기
		editBoard.setVisible(false);
	}
}
