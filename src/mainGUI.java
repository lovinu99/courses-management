import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class mainGUI extends JPanel implements ActionListener {
	JButton but1;
	JButton but2;
	JButton but3;
	JTable	table;
	public mainGUI() {
		setLayout(new BorderLayout());
		but1 =  new JButton("1");
		but2 =  new JButton("2");
		but3 =  new JButton("3");
		JPanel leftJPanel = new JPanel();
		leftJPanel.setLayout(new BoxLayout(leftJPanel, BoxLayout.Y_AXIS));
		leftJPanel.add(but2);leftJPanel.add(but3);
		JPanel container = new JPanel();
		JPanel topPanel = new JPanel();
		container.setLayout(new BorderLayout());
		container.add(but1); 
//		container.add(but2); container.add(but3);
		String[][] data = { 
            { "Kundan Kumar Jha", "4031", "CSE" }, 
            { "Anand Jha", "6014", "IT" } 
        }; 
  
        // Column Names 
        String[] columnNames = { "Name", "Roll Number", "Department" }; 
        table = new JTable(data, columnNames)
        {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
            {
                Component c = super.prepareRenderer(renderer, row, column);

                //  Alternate row color

                if (!isRowSelected(row))
                    c.setBackground(row % 2 == 0 ? getBackground() : Color.ORANGE);

                return c;
            }
        };
        JScrollPane scrollPane= new JScrollPane(table,
        		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS
				);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, (int) 2,true));
        container.add(scrollPane, BorderLayout.CENTER);
        topPanel.add(but1);
//
        container.setSize(20, 200);
        container.add(topPanel, BorderLayout.NORTH);
        container.add(leftJPanel, BorderLayout.WEST);
		add(container);
		
		
	}
	public static void main(String[] args) {

		
	}
	public static void CreateAndShowGui() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame mainFrame = new JFrame("portal");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainGUI gui = new mainGUI();
		mainFrame.setContentPane(gui);
		mainFrame.pack();
		mainFrame.setVisible(true);
		// action when close window
//		mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
//		    @Override
//		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
//		        if (JOptionPane.showConfirmDialog(mainFrame, 
//		            "Are you sure you want to saved_string?", "Close Window?", 
//		            JOptionPane.YES_NO_OPTION,
//		            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
//		        	try {
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}  	
//
//		            System.exit(0);
//		        }
//		        else {
//		        	System.exit(0);
//				}
//		    }
//		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}

