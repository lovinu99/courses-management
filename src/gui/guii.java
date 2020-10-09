package gui;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.sun.xml.fastinfoset.util.StringArray;

import antlr.collections.List;
import entity.Lop;
import entity.MonHoc;
import entity.account;
import entity.phuckhao;
import entity.sinhvien;
import entity.sv_mhPK;
import entity.sv_monhoc;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.ComponentOrientation;

import javax.imageio.ImageIO;
import javax.persistence.Converts;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;
import util.HibernateUtil;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.border.EtchedBorder;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Font;
import javax.swing.SwingConstants;

public class guii implements ActionListener, TableModelListener {

	private static final String[][][][] String = null;
	JFrame frame;
	JPanel main_panel;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JLabel lb4;
	JButton but4;
	JButton but3;
	JButton but2;
	JButton but1;
	private JTextField tk_t;
	private JPasswordField mk_t;
	JScrollPane sp_dssv;
	JScrollPane sp_dsdiem;
	JTable table;
	JTable table1;
	Session session = null;
	private JLabel lb5;
	private JTextField tf5;
	JPanel butlist_1;
	JPanel butlist;
	int issv;

	/**
	 * Launch the application.
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		guii window = new guii();
		window.frame.setVisible(true);
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public guii() throws IOException {
		session = HibernateUtil.getSessionFactory().openSession();
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBackground(Color.WHITE);
		frame.setTitle("1712318");
		frame.getContentPane().setSize(new Dimension(5, 6));
		frame.setResizable(false);
		frame.setMinimumSize(new Dimension(1100, 600));
		String[][] data = { { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" }, { "", "", "", "", "" },
				{ "", "", "", "", "" }, { "", "", "", "", "" } };

		// Column Names
		String[] columnNames = { "A", "B", "C", "D" };
//	        String[] columnNames = { "MSSV","Họ Tên", "Giới tính","CMND" };
		String[][] data1 = { { "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },
				{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },
				{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },
				{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },
				{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },
				{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" },{ "", "", "", "", "", "","" }
				};
		String[] columnNames1 = { "A", "B", "C", "D", "E","F","G" };
		main_panel = new JPanel();
		main_panel.setBackground(Color.WHITE);
		main_panel.setVisible(false);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.NORTH, main_panel, 11, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, main_panel, 10, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, main_panel, 550, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, main_panel, 1074, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(main_panel);
		main_panel.setLayout(null);
		JPanel login_p = new JPanel();
		login_p.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		springLayout.putConstraint(SpringLayout.NORTH, login_p, 67, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, login_p, 198, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, login_p, 451, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, login_p, 873, SpringLayout.WEST, frame.getContentPane());
		login_p.setBackground(SystemColor.control);
		frame.getContentPane().add(login_p);
		login_p.setLayout(null);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 146, 160);
		main_panel.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_1.setLayout(null);

		JLabel name_user_t = new JLabel("New label");
		name_user_t.setHorizontalAlignment(SwingConstants.CENTER);
		name_user_t.setFont(new Font("Arial", Font.BOLD, 18));
		name_user_t.setBounds(10, 11, 126, 81);
		panel_1.add(name_user_t);

		JButton dangxuat_b = new JButton("đăng xuất");
		dangxuat_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main_panel.setVisible(false);
				login_p.setVisible(true);
				TableModel tm1 = table.getModel();
				TableModel tm2 = table1.getModel();
				cleartable(tm1, 5);
				cleartable(tm2, 7);

			}
		});
		dangxuat_b.setBounds(10, 97, 126, 23);
		panel_1.add(dangxuat_b);

		JButton doimk_b = new JButton("đổi mật khẩu");
		doimk_b.addActionListener(this);
		doimk_b.setActionCommand("change_pw");
		doimk_b.setBounds(10, 126, 126, 23);
		panel_1.add(doimk_b);
		
		butlist = new JPanel();
		butlist.setBounds(0, 171, 146, 368);
		main_panel.add(butlist);
		butlist.setAlignmentY(10.0f);
		butlist.setAlignmentX(10.0f);
		butlist.setLayout(new GridLayout(0, 1, 0, 0));

		JButton import_b = new JButton("Import");
		import_b.addActionListener(this);
		import_b.setActionCommand("import");
		import_b.setBounds(new Rectangle(10, 10, 0, 0));
		butlist.add(import_b);

		JButton add_b = new JButton("Thêm");
		add_b.addActionListener(this);
		add_b.setActionCommand("add");
		butlist.add(add_b);

		JButton show_table_b = new JButton("Xem Danh sách");
		show_table_b.addActionListener(this);
		show_table_b.setActionCommand("show");
		butlist.add(show_table_b);

		JButton change_b = new JButton("Sửa");
		change_b.addActionListener(this);
		change_b.setActionCommand("change");
		butlist.add(change_b);

		JButton phuckhao_b = new JButton("Phúc khảo");
		phuckhao_b.addActionListener(this);
		phuckhao_b.setActionCommand("phuckhao");
		butlist.add(phuckhao_b);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(167, 0, 897, 160);
		main_panel.add(panel_3);
		panel_3.setLayout(null);

		JPanel input_panel = new JPanel();
		input_panel.setLayout(null);
		input_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		input_panel.setBounds(20, 11, 623, 141);
		panel_3.add(input_panel);

		lb1 = new JLabel("New label");
		lb1.setBounds(23, 14, 210, 14);
		input_panel.add(lb1);

		lb2 = new JLabel("New label");
		lb2.setBounds(23, 45, 210, 14);
		input_panel.add(lb2);

		lb3 = new JLabel("New label");
		lb3.setBounds(23, 75, 210, 14);
		input_panel.add(lb3);

		lb4 = new JLabel("New label");
		lb4.setBounds(23, 106, 210, 14);
		input_panel.add(lb4);

		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(290, 11, 305, 20);
		input_panel.add(tf1);

		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(290, 42, 305, 20);
		input_panel.add(tf2);

		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(290, 72, 305, 20);
		input_panel.add(tf3);

		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(290, 103, 305, 20);
		input_panel.add(tf4);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(653, 11, 234, 141);
		panel_3.add(panel_2);
		but1 = new JButton("New button");
		but1.setBounds(34, 11, 166, 23);
		panel_2.add(but1);

		but3 = new JButton("New button");
		but3.setBounds(34, 73, 166, 23);
		panel_2.add(but3);

		but4 = new JButton("New button");
		but4.setBounds(34, 107, 166, 23);
		panel_2.add(but4);

		but2 = new JButton("New button");
		but2.setBounds(34, 45, 166, 23);
		panel_2.add(but2);

		lb5 = new JLabel("Lớp");
		lb5.setVisible(false);
		lb5.setBounds(34, 11, 166, 23);
		panel_2.add(lb5);

		tf5 = new JTextField();
		tf5.setBounds(34, 42, 166, 26);
		panel_2.add(tf5);
		tf5.setColumns(10);
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
//		Session session = HibernateUtil.getSessionFactory().openSession();
//		Vector<Vector<String>> a = Lop.toJtable(session, "17CTT3");
//		System.out.println(a);
		table = new JTable(data, columnNames);
		table.getModel().addTableModelListener(this);
		sp_dssv = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		sp_dssv.setBounds(167, 171, 897, 368);
		main_panel.add(sp_dssv);
		sp_dssv.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		sp_dssv.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));

		// login form

		BufferedImage myPicture = ImageIO.read(new File("icon.png"));
		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBounds(43, 102, 199, 199);

		JLabel lblNewLabel_5 = new JLabel("T\u00EAn \u0111\u0103ng nh\u1EADp");
		lblNewLabel_5.setBackground(SystemColor.control);
		lblNewLabel_5.setBounds(282, 153, 96, 14);

		tk_t = new JTextField();
		tk_t.setBounds(416, 150, 199, 20);

		tk_t.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("M\u1EADt kh\u1EA9u");
		lblNewLabel_6.setBackground(SystemColor.control);
		lblNewLabel_6.setBounds(282, 213, 96, 14);
		login_p.add(lblNewLabel_6);
		login_p.add(tk_t);
		login_p.add(lblNewLabel_5);
		login_p.add(picLabel);

		mk_t = new JPasswordField();
		mk_t.setBounds(416, 210, 199, 20);

		JButton dangnhap_b = new JButton("\u0110\u0103ng nh\u1EADp");
		dangnhap_b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = tk_t.getText();
				
				if ((s.equals("admin") && mk_t.getText().equals("admin"))
						|| (account.getmk(session, s).equals(mk_t.getText()))) {
					login_p.setVisible(false);
					main_panel.setVisible(true);
					visible_false_all();
					if ((s.equals("admin"))) {
						name_user_t.setText("Giáo vụ");
						issv=0;
						butlist.setVisible(true);
						butlist_1.setVisible(false);
					}
					else {
						name_user_t.setText(s);
						issv=1;
						butlist.setVisible(false);
						butlist_1.setVisible(true);
					}
				} else {
					tk_t.setText("sai tai khoan");
				}
			}
		});
		dangnhap_b.setBounds(381, 265, 124, 23);
		login_p.add(dangnhap_b);
		login_p.add(mk_t);
		login_p.add(lblNewLabel_6);
		login_p.add(tk_t);
		login_p.add(lblNewLabel_5);
		login_p.add(picLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		table1 = new JTable(data1, columnNames1);
		sp_dsdiem = new JScrollPane(table1);
		table1.setFillsViewportHeight(true);
		sp_dsdiem.setVisible(false);
		sp_dsdiem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		sp_dsdiem.setBorder(new LineBorder(new Color(130, 135, 144), 2, true));
		sp_dsdiem.setBounds(166, 171, 898, 368);
		main_panel.add(sp_dsdiem);
		
		butlist_1 = new JPanel();
		butlist_1.setAlignmentY(10.0f);
		butlist_1.setAlignmentX(10.0f);
		butlist_1.setBounds(0, 171, 146, 368);
		main_panel.add(butlist_1);
		butlist_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton xem_diem = new JButton("Xem điểm");
		xem_diem.setActionCommand("show");
		xem_diem.addActionListener(this);
		xem_diem.setActionCommand("xemdiem");
		butlist_1.add(xem_diem);
		
		JButton phuckhao_b_1 = new JButton("Thêm phúc khảo");
		phuckhao_b_1.addActionListener(this);
		phuckhao_b_1.setActionCommand("phuckhaosv");
		butlist_1.add(phuckhao_b_1);
		tf4.setVisible(false);
		but4.setVisible(false);
		lb4.setVisible(false);
		lb5.setVisible(false);
		tf5.setVisible(false);
//		panel_3.setVisible(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		int  i=0;
		i=0;
		Lop l = null;
		TableModel tm1 = table.getModel();
		TableModel tm2 = table1.getModel();
		cleartable(tm1, 5);
		cleartable(tm2, 7);
		switch (issv) {
		case 0:
					switch (s) {
					case "import":
						visible_false_all();
						lb1.setText("Nhập file lớp cần import");
						but1.setText("import lớp");
						lb2.setText("Nhập file tkb lớp cần import");
						but2.setText("import tkb");
						lb3.setText("Nhập file bảng điểm cần import");
						but3.setText("import bảng điểm");
						but1.setActionCommand("import_class");
						but2.setActionCommand("import_tkb");
						but3.setActionCommand("import_diem");
						visible(1, 1, 1, 0,0);
						visible_but(1, 1, 1, 0);
						
						break;
					case "import_class":
						if(tf1.getText()==null)
							System.out.println("loi");
						else {
							try {
								Lop.ThemLop(session, tf1.getText()+".csv");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						break;
					case "import_tkb":
						if(tf1.getText()==null)
							System.out.println("loi");
						else {
							try {
								Lop.Themtkb(session, tf2.getText()+".csv");
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						break;
					case "import_diem":
						if(tf1.getText()==null)
							System.out.println("loi");
						else {
							try {
								sv_monhoc.themBangDiem(session, tf3.getText()+".csv");
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						break;
					case "show":
						
						visible_false_all();
						lb1.setText("Nhập tên lớp cần xem");
						but1.setText("xem lớp");
						lb2.setText("Nhập tên tkb lớp cần xem");
						but2.setText("xem tkb");
						lb3.setText("Nhập tên môn học cần xem điểm");
						but3.setText("xem bảng điểm");
						but1.setActionCommand("show_class");
						but2.setActionCommand("show_tkb");
						but3.setActionCommand("show_diem");
			
						visible(1, 1, 1, 0, 0);
						visible_but(1, 1, 1, 0);
						break;
					case "show_class":		
						sp_dssv.setVisible(true);
						sp_dsdiem.setVisible(false);
						if(tf1.getText()==null)
							System.out.println("loi");
						else {
							l =  session.get(Lop.class, tf1.getText());
							TableModel tm = table.getModel();
							i=0;
							tm.setValueAt("MSSV", i, 0);
							tm.setValueAt("Họ tên", i, 1);
							tm.setValueAt("Giới tính", i, 2);
							tm.setValueAt("CMND", i, 3);
							i=1;
							for (sinhvien sv : l.getDssv()) {
								tm.setValueAt(sv.getMSSV(), i, 0);
								tm.setValueAt(sv.getTen(), i, 1);
								tm.setValueAt(sv.getGioitinh(), i, 2);
								tm.setValueAt(sv.getCMND(), i, 3);
								i++;
							}
							while(tm.getValueAt(i, 0)!="") {
								tm.setValueAt("", i, 0);
								tm.setValueAt("", i, 1);
								tm.setValueAt("", i, 2);
								tm.setValueAt("", i, 3);
								i++;
							}
						}
						break;
					case "show_tkb":
						if(tf2.getText()==null)
							System.out.println("loi");
						else {
							l =  session.get(Lop.class,tf2.getText());
							TableModel tm = table.getModel();
							i=0;
							tm.setValueAt("STT", i, 0);
							tm.setValueAt("Mã Môn", i, 1);
							tm.setValueAt("Tên môn học", i, 2);
							tm.setValueAt("Phòng học", i, 3);
							i=1;
							for (MonHoc mh : l.getDsmh()) {
								tm.setValueAt(Integer.toString(i), i, 0);
								tm.setValueAt(mh.getMaMH(), i, 1);
								tm.setValueAt(mh.getTenmh(), i, 2);
								tm.setValueAt(mh.getPhong(), i, 3);
								i++;
							}
							while(tm.getValueAt(i, 0)!="") {
								tm.setValueAt("", i, 0);
								tm.setValueAt("", i, 1);
								tm.setValueAt("", i, 2);
								tm.setValueAt("", i, 3);
								i++;
							}
						}
						break;
					case "show_diem":
						sp_dssv.setVisible(false);
						sp_dsdiem.setVisible(true);
						if(tf3.getText()==null)
							System.out.println("loi");
						else {
							MonHoc mh =  session.get(MonHoc.class,tf3.getText());
							TableModel tm = table1.getModel();
							i=0;
							tm.setValueAt("MSSV", i, 0);
							tm.setValueAt("Họ Tên", i, 1);
							tm.setValueAt("Giữa kì", i, 2);
							tm.setValueAt("Cuối kì", i, 3);
							tm.setValueAt("Khác", i, 4);
							tm.setValueAt("Tổng kết", i, 5);
							tm.setValueAt("Kết quả", i, 6);
							i=1;
							for (sv_monhoc svmh : mh.getDsdiem()) {
								tm.setValueAt(svmh.getSv().getMSSV(), i, 0);
								tm.setValueAt(svmh.getSv().getTen(), i, 1);
								tm.setValueAt(Integer.toString(svmh.getGk()), i, 2);
								tm.setValueAt(Integer.toString(svmh.getCk()), i, 3);
								tm.setValueAt(Integer.toString(svmh.getKhac()), i, 4);
								tm.setValueAt(Integer.toString(svmh.getTk()), i, 5);
								if(svmh.getTk()>=5)
									tm.setValueAt("Đậu", i, 6);
								else 
									tm.setValueAt("Rớt", i, 6);
								i++;
							}
							while(tm.getValueAt(i, 0)!="") {
								tm.setValueAt("", i, 0);
								tm.setValueAt("", i, 1);
								tm.setValueAt("", i, 2);
								tm.setValueAt("", i, 3);
								tm.setValueAt("", i, 4);
								tm.setValueAt("", i, 5);
								tm.setValueAt("", i, 6);
								i++;
							}
						}
						break;
					
					case "add_submit":
						sinhvien.addsv(tf1.getText(),tf2.getText() ,tf3.getText(),tf4.getText(),tf5.getText());
						break;
					case "change":
						visible_false_all();
						lb1.setText("MSSV cần sửa điểm");
						lb2.setText("Môn học");
						lb3.setText("Điểm (format): gk,ck,khac,tk");
						but1.setText("Sửa điểm");
						but1.setActionCommand("change_submit");
						visible(1, 1, 1, 0, 0);
						visible_but(1, 0, 0, 0);
						break;
					case "change_submit":
						String[] tempdata = tf3.getText().split(",");
						System.out.println(tempdata[0]);
						sv_monhoc.suadiem(tf1.getText(), tf2.getText(), Integer.valueOf(tempdata[0]), Integer.valueOf(tempdata[1]), Integer.valueOf(tempdata[2]), Integer.valueOf(tempdata[3]));			
						break;
					case "change_pw":
						visible_false_all();
						System.out.println("aaaaaa");
						lb1.setText("Tên tài khoản");
						lb2.setText("Nhập mật khẩu mới");
						but1.setText("đổi mật khẩu");
						but1.setActionCommand("change_pw_submit");
						visible_but(1, 0, 0, 0);
						visible(1, 1,0, 0, 0);
						break;
					case "change_pw_submit":
						account acc = account.getacc(session,tf1.getText());
						acc.DoiMK(session, tf2.getText());
						break;
					case "phuckhao":
						visible_false_all();
						lb1.setText("Chọn Phúc khảo");
						lb2.setText("Điểm sau phúc khảo");
						but1.setText("Cập nhật điểm");
						but1.setActionCommand("submit_pk");
						but2.setActionCommand("disable_pk");
						but2.setText("Hủy phúc khảo");
						but3.setText("xem phúc khảo");
						but3.setActionCommand("show_pk");
						visible(1, 1, 0, 0, 0);
						visible_but(1, 1,1,0);
						break;
					case "submit_pk":
						phuckhao cur = session.get(phuckhao.class, tf1.getText());
						sv_monhoc sv_mh_pk = session.get(sv_monhoc.class, new sv_mhPK(cur.getMssv(), cur.getMon()));
						System.out.println(sv_mh_pk);
						session.clear();
						if(cur.getCotdiem().equals("gk"))
							sv_monhoc.suadiem(cur.getMssv(), cur.getMon(), Integer.valueOf(tf2.getText()), sv_mh_pk.getCk(), sv_mh_pk.getKhac(), sv_mh_pk.getTk());
						if(cur.getCotdiem().equals("ck"))
							sv_monhoc.suadiem(cur.getMssv(), cur.getMon(), sv_mh_pk.getGk(), Integer.valueOf(tf2.getText()), sv_mh_pk.getKhac(), sv_mh_pk.getTk());
						if(cur.getCotdiem().equals("khac"))
						{
							sv_monhoc.suadiem(cur.getMssv(), cur.getMon(), sv_mh_pk.getGk(), sv_mh_pk.getCk(), Integer.valueOf(tf2.getText()), sv_mh_pk.getTk());
							System.out.println("aaaaa");
						}
						if(cur.getCotdiem().equals("tk"))
							sv_monhoc.suadiem(cur.getMssv(), cur.getMon(), sv_mh_pk.getGk(), sv_mh_pk.getCk(), sv_mh_pk.getKhac(), Integer.valueOf(tf2.getText()));
						break;
					case "disable_pk":
						phuckhao cur1 = session.get(phuckhao.class, tf1.getText());
						cur1.setStatus(-1);
						Transaction tran1 = session.beginTransaction();
						session.update(cur1);
						tran1.commit();
						break;
					case "show_pk":
						sp_dssv.setVisible(false);
						sp_dsdiem.setVisible(true);
						java.util.List<phuckhao> lpk = session.createQuery("from phuckhao").list();
						i=0;
						TableModel tm = table1.getModel();
						while(tm.getValueAt(i, 0)!="") {
							tm.setValueAt("", i, 0);
							tm.setValueAt("", i, 1);
							tm.setValueAt("", i, 2);
							tm.setValueAt("", i, 3);
							tm.setValueAt("", i, 4);
							tm.setValueAt("", i, 5);
							tm.setValueAt("", i, 6);
							i++;
						}
						i=0;
						tm.setValueAt("MSSV", i, 0);
						tm.setValueAt("Họ Tên", i, 1);
						tm.setValueAt("Môn", i, 2);
						tm.setValueAt("Cột điểm", i, 3);
						tm.setValueAt("Điểm mong muốn", i, 4);
						tm.setValueAt("Lý do", i, 5);
						tm.setValueAt("trạng thái", i, 6);
						i++;
						for (phuckhao pk : lpk) {
							tm.setValueAt(pk.getMssv(), i, 0);
							tm.setValueAt(pk.getHoten(), i, 1);
							tm.setValueAt(pk.getMon(), i, 2);
							tm.setValueAt(pk.getCotdiem(), i, 3);
							tm.setValueAt(Integer.toString(pk.getDiemmm()), i, 4);
							tm.setValueAt(pk.getLydo(), i, 5);
							tm.setValueAt(Integer.toString(pk.getStatus()), i, 6);
							i++;
						}

						break;
					case "add":
						visible_false_all();
						lb2.setText("Tên sinh viên");
						lb1.setText("Mã số sinh viên");
						lb3.setText("Giới tính");
						lb4.setText("Số chứng minh nhân dân");			
						but4.setText("Thêm");
						but4.addActionListener(this);
						but4.setActionCommand("add_submit");
						visible(1,1,1,1,1);
						visible_but(0, 0, 0, 1);
						break;
					default:
						break;
					}
					break;
					

		/////////////////////////////////////////////////////////////////////// sinh vien
		default:
					switch (s) {
					case "xemdiem":
						visible_false_all();
						lb1.setText("Nhập môn cần xem điểm");
						but1.setText("Xem điểm");
						but1.setActionCommand("xemdiemsv");
						visible_but(1,0 , 0, 0);
						visible(1, 0, 0, 0,0);
						sp_dssv.setVisible(false);
						sp_dsdiem.setVisible(true);
						
						break;
					case "xemdiemsv":
						i=0;
						TableModel tm = table1.getModel();

						tm.setValueAt("Tên môn học", i, 0);
						tm.setValueAt("Giữa kì", i, 1);
						tm.setValueAt("Cuối kì", i, 2);
						tm.setValueAt("Khác", i, 3);
						tm.setValueAt("Tổng kết", i, 4);
						i=1;
						while(tm.getValueAt(i, 0)!="") {
							tm.setValueAt("", i, 0);
							tm.setValueAt("", i, 1);
							tm.setValueAt("", i, 2);
							tm.setValueAt("", i, 3);
							tm.setValueAt("", i, 4);
							tm.setValueAt("", i, 5);
							tm.setValueAt("", i, 6);
							i++;
						}
						i=1;
						sv_monhoc temp = session.get(sv_monhoc.class, new sv_mhPK(tk_t.getText(), tf1.getText()));
						tm.setValueAt(temp.getMh().getTenmh(), i, 0);
						tm.setValueAt(Integer.toString(temp.getGk()), i, 1);
						tm.setValueAt(Integer.toString(temp.getCk()), i, 2);
						tm.setValueAt(Integer.toString(temp.getKhac()), i, 3);
						tm.setValueAt(Integer.toString(temp.getTk()), i, 4);
						if(temp.getTk()>=5)
							tm.setValueAt("Đậu", i, 6);
						else 
							tm.setValueAt("Rớt", i, 6);
						break;
					case "phuckhaosv":
						visible_false_all();
						lb1.setText("Môn cần phúc khảo");
						lb2.setText("Cột điểm cần phúc khảo");
						lb3.setText("Điểm mong muốn");
						lb4.setText("Lý do");
						visible(1, 1, 1, 1, 0);
						but1.setText("tạo phúc khảo");
						visible_but(1, 0, 0, 0);
						but1.setActionCommand("phuckhaosv_submit");
						break;
					case "phuckhaosv_submit":
						sinhvien svpk =  session.get(sinhvien.class,tk_t.getText());
						phuckhao pk =  new phuckhao(svpk.getMSSV(),svpk.getTen() ,tf1.getText(), tf2.getText(), Integer.valueOf(tf3.getText()), tf4.getText(), 0);
						phuckhao.thempk(pk);
						break;
					case "change_pw":
						visible_false_all();
						System.out.println("aaaaaa");
						lb1.setText("Tên tài khoản");
						lb2.setText("Nhập mật khẩu mới");
						but1.setText("đổi mật khẩu");
						but1.setActionCommand("change_pw_submit");
						visible_but(1, 0, 0, 0);
						visible(1, 1,0, 0, 0);
						break;
					case "change_pw_submit":
						account acc = account.getacc(session,tf1.getText());
						acc.DoiMK(session, tf2.getText());
						break;
					default:
						break;
					}
			break;
		}
	}
	public void visible_but(int a, int b, int c, int d) {
		if(a==1) {
			but1.setVisible(true);
		}
		if(b==1) {
			but2.setVisible(true);
		}
		if(c==1) {
			but3.setVisible(true);
		}
		if(d==1) {
			but4.setVisible(true);
		}
	}
	public void visible(int a, int b, int c, int d, int e) {
		if(a==1) {
			lb1.setVisible(true);
			tf1.setVisible(true);
		}
		if(b==1) {
			lb2.setVisible(true);
			tf2.setVisible(true);
		}
		if(c==1) {
			lb3.setVisible(true);
			tf3.setVisible(true);
		}
		if(d==1) {
			lb4.setVisible(true);
			tf4.setVisible(true);
		}
		if(e==1) {
			lb5.setVisible(true);
			tf5.setVisible(true);
		}
	}
	public void visible_false_all() {
	lb1.setVisible(false);
	lb2.setVisible(false);
	lb3.setVisible(false);
	lb4.setVisible(false);
	lb5.setVisible(false);
	
	but1.setVisible(false);
	but2.setVisible(false);
	but3.setVisible(false);
	but4.setVisible(false);
	
	tf1.setVisible(false);
	tf2.setVisible(false);
	tf3.setVisible(false);
	tf4.setVisible(false);
	tf5.setVisible(false);
	
	tf1.setText("");
	tf2.setText("");
	tf3.setText("");
	tf4.setText("");
	tf5.setText("");
	}
	@Override
	public void tableChanged(TableModelEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void cleartable(TableModel tm,int col) {
		int i=0;
		while(tm.getValueAt(i, 0)!="") {
			for(int j=0;j<col;j++)
				tm.setValueAt("", i, j);
			i++;
		}
	}
}
