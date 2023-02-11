package dispAwt;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AwtJdbc implements ActionListener  {
		JFrame fmEmp;
		JPanel pEmp1,pEmp2;
		JScrollPane sp;
		JTable empTab;

		JButton btnDisp;
		Connection con;
		ResultSet rs;
		ResultSetMetaData rsmd;
		
		JButton btnShowAll;
		public AwtJdbc()
		{
				fmEmp=new JFrame();
				//
				empTab=new JTable();
				btnDisp= new JButton("Display");
				
				sp=new JScrollPane(empTab);
				fmEmp.add(btnDisp);
				
				btnDisp= new JButton("Display");
				btnDisp.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent objAE)
					{
						try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						
						Connection con = null;
						try {
							con = DriverManager.getConnection(  
									"jdbc:mysql://sql12.freesqldatabase.com/sql12597176","sql12597176","ftV1rDuW74");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Statement stmt = null;
						try {
							stmt = con.createStatement();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  

						try {
							ResultSet rs=stmt.executeQuery("select * from employee");
							ResultSetMetaData rsmd=rs.getMetaData();
							 DefaultTableModel model=(DefaultTableModel) empTab.getModel();
							 int cols=rsmd.getColumnCount();
							 String []colNames=new String[cols];
							 
							 for(int i=0;i<cols;i++)
							 {
								 colNames[i]=rsmd.getColumnName(i+1);
							 }
							 model.setColumnIdentifiers(colNames);
									 String efname,elname,ePanNum;
									 int empid,eAge;
								while(rs.next())
								{
									System.out.println(rs.getInt(1)+" "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+" "+rs.getInt(5));
									empid=rs.getInt(1);
									efname=rs.getString(2);
									elname=rs.getString(3);
									ePanNum=rs.getString(4);
									eAge=rs.getInt(5);
									String [] row= {String.valueOf(empid),efname,elname,ePanNum,String.valueOf(eAge)};
									model.addRow(row);
								}
					
							
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}  

					}
					} );
				btnDisp.setBounds(50, 100, 130, 40);
				fmEmp.add(btnDisp);

				 fmEmp.add(sp);
				
				 fmEmp.addWindowListener(new WindowAdapter() {
			            public void windowClosing(WindowEvent we) {
			                System.exit(0);
			            }
			        });
				
				 
				    fmEmp.setSize(600, 600);   //setting frame size.
				    fmEmp.setBackground(Color.LIGHT_GRAY);
				    fmEmp.setTitle("Employee Details");
				  
				    fmEmp.setVisible(true);     //set frame visibilty true
				    
				
			
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}

}
