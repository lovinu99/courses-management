import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JFrame implements ActionListener {
	public static boolean isLogin;
	JLabel l1, l2, l3;

	public JLabel getL1() {
		return l1;
	}

	public void setL1(JLabel l1) {
		this.l1 = l1;
	}

	public JLabel getL2() {
		return l2;
	}

	public void setL2(JLabel l2) {
		this.l2 = l2;
	}

	public JLabel getL3() {
		return l3;
	}

	public void setL3(JLabel l3) {
		this.l3 = l3;
	}

	public JTextField getTf1() {
		return tf1;
	}

	public void setTf1(JTextField tf1) {
		this.tf1 = tf1;
	}

	public JButton getBtn1() {
		return btn1;
	}

	public void setBtn1(JButton btn1) {
		this.btn1 = btn1;
	}

	public JPasswordField getP1() {
		return p1;
	}

	public void setP1(JPasswordField p1) {
		this.p1 = p1;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public static void setLogin(boolean isLogin) {
		LoginForm.isLogin = isLogin;
	}

	JTextField tf1;
	JButton btn1;
	JPasswordField p1;
	JFrame frame;

	LoginForm() {
		frame = new JFrame("Login Form");
		l1 = new JLabel("Login");
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Serif", Font.BOLD, 20));

		l2 = new JLabel("Username");
		l3 = new JLabel("Password");
		tf1 = new JTextField();
		p1 = new JPasswordField();
		btn1 = new JButton("Login");

		l1.setBounds(150, 20, 400, 30);
		l2.setBounds(50, 70, 200, 30);
		l3.setBounds(50, 110, 200, 30);
		tf1.setBounds(150, 70, 200, 30);
		p1.setBounds(150, 110, 200, 30);
		btn1.setBounds(150, 160, 100, 30);

		frame.add(l1);
		frame.add(l2);
		frame.add(tf1);
		frame.add(l3);
		frame.add(p1);
		frame.add(btn1);

		frame.setSize(420, 250);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public boolean isLogin() {
		return isLogin == true ? true : false;
	}

	public static void main(String[] args) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String uname = tf1.getText();
		@SuppressWarnings("deprecation")
		String pass = p1.getText();
		if (uname.equals("admin") && pass.equals("admin")) {
			System.out.println("aaaaaaaaaaa");
			isLogin = true;
		} else {
			JOptionPane.showMessageDialog(this, "Incorrect login or password", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}