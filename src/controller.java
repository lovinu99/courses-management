import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class controller implements ActionListener {
	public JButton loginButton;
	public static LoginForm login_form;

	public controller() {
		login_form = new LoginForm();
		login_form.getBtn1().addActionListener(this);
		login_form.getBtn1().setActionCommand("login");
	}

	public static void main(String[] args) {
		new controller();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comandString = e.getActionCommand();
		switch (comandString) {
		case "login":
			String uname = login_form.getTf1().getText();
			@SuppressWarnings("deprecation")
			String pass = login_form.getP1().getText();
			if (uname.equals("admin") && pass.equals("admin")) {
				mainGUI.CreateAndShowGui();
				login_form.getFrame().setVisible(false);
				login_form.getFrame().removeAll();
			} else {
				login_form.getL1().setText("Tài khoản sai, nhập lại");
			}
			break;

		default:
			break;
		}
	}
}
