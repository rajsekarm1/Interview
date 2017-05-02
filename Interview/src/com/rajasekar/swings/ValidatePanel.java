package com.rajasekar.swings;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;
import java.time.LocalTime;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ValidatePanel extends JFrame{

	public static void main(String[] args) {
		ValidatePanel frame = new ValidatePanel();
		
		frame.setSize(500,500);
		frame.setResizable(true);
		frame.setPreferredSize(new Dimension(400, 400));
		//FlowLayout flaylout = new FlowLayout();
		//frame.setLayout(flaylout);
		
		JList list;
	    DefaultListModel listModel;
	    listModel = new DefaultListModel();
	    listModel.addElement("word1");
	    listModel.addElement("word2");
	    listModel.addElement("word3");
	   

	    //Create the list and put it in a scroll pane.
	    list = new JList(listModel);
	    JPanel rightSidePanel = new JPanel();
	    list.addListSelectionListener(e -> {
	    	System.out.println(list.getSelectedIndex());
	    	rightSidePanel.removeAll();
	    	rightSidePanel.revalidate();
	    	rightSidePanel.repaint();
	    	LocalTime currentTime = LocalTime.now();
	    	rightSidePanel.add(new JLabel("Rajasekar"+currentTime.toString()));
		});
	    list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    list.setSelectedIndex(0);
	    //list.addListSelectionListener(this);
	    list.setVisibleRowCount(5);

		JScrollPane leftScrollPane = new JScrollPane(list);
		leftScrollPane.setSize(new Dimension(200, 200));
		//leftScrollPane.add(list);
		
		
		JScrollPane rightScrollPane = new JScrollPane(new JLabel("Right Panel"));
		//rightScrollPane.add();
		rightScrollPane.setSize(new Dimension(200, 200));
		rightSidePanel.add(rightScrollPane);
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftScrollPane, rightSidePanel);
		splitPane.setSize(400, 400);
        frame.add(splitPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		

	}
	


}
