package tes;


import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;

public class Javatest {
 private JFrame frame;
 private JTable table;
 private JTextField lname;
 private JTextField email;
 private JTextField adress;
 private JTextField city;
 private JTextField zocde;
 private JTextField state;
 private JTextField phone;
 private JTextField fname;
 private JTextField denty;

 /**
 * Launch the application.
 */
 public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Javatest window = new Javatest();
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
 public Javatest() {
 initialize();
 Connect();
 }
 Connection con;
 PreparedStatement pst;
 public void Connect() {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection("jdbc:mysql://localhost/customertest", "root", "");
 } catch (ClassNotFoundException ex) {
 ex.printStackTrace();
 } catch (SQLException ex) {
 ex.printStackTrace();
 }
 }
 
 /**
 * Initialize the contents of the frame.
 */
 private void initialize() {
 frame = new JFrame();
 frame.setBounds(100, 100, 785, 459);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.getContentPane().setLayout(null);
 JLabel lblNewLabel = new JLabel("PIZZACO");
 lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 52));
 lblNewLabel.setBounds(25, 11, 293, 80);
 frame.getContentPane().add(lblNewLabel);
 JPanel panel = new JPanel();
 panel.setBorder(new TitledBorder(null, "Input", TitledBorder.LEADING, TitledBorder.TOP, null, null));
 panel.setBounds(10, 102, 388, 265);
 frame.getContentPane().add(panel);
 panel.setLayout(null);
 JLabel lblNewLabel_1 = new JLabel("Customer first name");
 lblNewLabel_1.setBounds(23, 25, 130, 14);
 panel.add(lblNewLabel_1);
 JLabel lblNewLabel_1_1 = new JLabel("Customer last name");
 lblNewLabel_1_1.setBounds(23, 50, 130, 14);
 panel.add(lblNewLabel_1_1);
 JLabel lblNewLabel_1_2 = new JLabel("Phone");
 lblNewLabel_1_2.setBounds(23, 79, 130, 14);
 panel.add(lblNewLabel_1_2);
 JLabel lblNewLabel_1_3 = new JLabel("Email");
 lblNewLabel_1_3.setBounds(23, 104, 130, 14);
 panel.add(lblNewLabel_1_3);

JLabel lblNewLabel_1_3_2 = new JLabel("Adress");
 lblNewLabel_1_3_2.setBounds(23, 154, 130, 14);
 panel.add(lblNewLabel_1_3_2);
 JLabel lblNewLabel_1_3_3 = new JLabel("State");
 lblNewLabel_1_3_3.setBounds(23, 181, 130, 14);
 panel.add(lblNewLabel_1_3_3);
 JLabel lblNewLabel_1_3_3_1 = new JLabel("City");
 lblNewLabel_1_3_3_1.setBounds(23, 206, 130, 14);
 panel.add(lblNewLabel_1_3_3_1);
 JLabel lblNewLabel_1_3_3_1_1 = new JLabel("Zip code");
 lblNewLabel_1_3_3_1_1.setBounds(23, 231, 130, 14);
 panel.add(lblNewLabel_1_3_3_1_1);
 lname = new JTextField();
 lname.setColumns(10);
 lname.setBounds(187, 47, 170, 20);
 panel.add(lname);
 email = new JTextField();
 email.setColumns(10);
 email.setBounds(187, 101, 170, 20);
 panel.add(email);
 adress = new JTextField();
 adress.setColumns(10);
 adress.setBounds(187, 151, 170, 20);
 panel.add(adress);
 city = new JTextField();
 city.setColumns(10);
 city.setBounds(187, 203, 170, 20);
 panel.add(city);

 zocde = new JTextField();
 zocde.setBackground(Color.LIGHT_GRAY);
 zocde.setColumns(10);
 zocde.setBounds(187, 228, 170, 20);
 panel.add(zocde);
 state = new JTextField();
 state.setColumns(10);
 state.setBackground(Color.LIGHT_GRAY);
 state.setBounds(187, 178, 170, 20);
 panel.add(state);
 phone = new JTextField();
 phone.setColumns(10);
 phone.setBackground(Color.LIGHT_GRAY);
 phone.setBounds(187, 76, 170, 20);
 panel.add(phone);
 fname = new JTextField();
 fname.setColumns(10);
 fname.setBackground(Color.LIGHT_GRAY);
 fname.setBounds(187, 22, 170, 20);
 panel.add(fname);
 
 
 JButton btnNewButton = new JButton("Save");
 btnNewButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 try {
 String query = "insert into customerinfo (firstname,lastname,phone,email,address,state,city,zipcode,dentystname) values (?,?,?,?,?,?,?,?,?)";
 pst = con.prepareStatement(query);
 pst.setString(1, fname.getText());
 pst.setString(2, lname.getText());
 pst.setString(3, phone.getText());
 pst.setString(4, email.getText());
 pst.setString(5, adress.getText());
 pst.setString(6, state.getText());
 pst.setString(7, city.getText());
 pst.setString(8, zocde.getText());
 pst.setString(9, denty.getText());
 pst.executeUpdate();
 JOptionPane.showMessageDialog(null, "Record Added!!!!");

 
 fname.setText("");
 lname.setText("");
 phone.setText("");
 email.setText("");
 adress.setText("");
 state.setText("");
 city.setText("");
 zocde.setText("");
 denty.setText("");
 } catch (SQLException ex) {
 ex.printStackTrace();
 }
 }
 });


 btnNewButton.setBounds(10, 378, 89, 23);
 frame.getContentPane().add(btnNewButton);
 JButton btnClear = new JButton("Clear");
 btnClear.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 }
 });
 btnClear.setBounds(116, 378, 89, 23);
 frame.getContentPane().add(btnClear);
 JScrollPane scrollPane = new JScrollPane();
 scrollPane.setBounds(408, 102, 319, 265);
 frame.getContentPane().add(scrollPane);
 table = new JTable();
 scrollPane.setViewportView(table);
 JButton btnUpdate = new JButton("Update");
 btnUpdate.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 }
 });
 btnUpdate.setBounds(409, 378, 89, 23);
 frame.getContentPane().add(btnUpdate);
 JButton btnClear_2 = new JButton("Clear");
 btnClear_2.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e) {
 }
 });

 btnClear_2.setBounds(519, 378, 89, 23);
 frame.getContentPane().add(btnClear_2);
 JPanel panel_1 = new JPanel();
 panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
 panel_1.setBounds(409, 26, 317, 65);
 frame.getContentPane().add(panel_1);
 panel_1.setLayout(null);
 JLabel lblNewLabel_2 = new JLabel("Customer ID");
 lblNewLabel_2.setBounds(10, 28, 81, 14);
 panel_1.add(lblNewLabel_2);
 denty = new JTextField();
 denty.setColumns(10);
 denty.setBounds(119, 25, 170, 20);
 panel_1.add(denty);
 }
}