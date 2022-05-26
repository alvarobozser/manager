import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;

	/**
	 * Launch the application.
	 * 
	 */

	conexion cc = new conexion();
	Connection con = cc.conectarSQL();
	private JPasswordField txtpass;

	public void validarusuario() {

		int resultado = 0;
		String pass = String.valueOf(txtpass.getPassword());
		String usuario = txtusuario.getText();
		String sql = "select * from usuarios where nombre='" + usuario + "' and pass='" + pass + "' ";
		try {

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			if (rs.next()) {

				resultado = 1;

				if (resultado == 1) {

					secondaryinterfaz interfaz = new secondaryinterfaz();
					interfaz.setVisible(true);
					JOptionPane.showMessageDialog(null, "Acceso Concedido");
					this.dispose();

				}
			} else {
				JOptionPane.showMessageDialog(null, "Error de Acceso, Usuario no Registrado");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/imagenes/globa32 (2).png")));
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Login");
		setBounds(750, 300, 385, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Logeate\u00A1 ;)");
		contentPane.setBackground(new Color(245, 245, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 89, 57, 14);
		contentPane.add(lblNewLabel_1_1);
		JButton login = new JButton("Login");

		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarusuario();
			}
		});
		login.setBackground(SystemColor.control);
		login.setActionCommand("");
		login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		login.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		login.setMnemonic('L');
		login.setToolTipText("Login");
		login.setBounds(215, 143, 85, 30);
		contentPane.add(login);

		txtusuario = new JTextField();
		txtusuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 10;
				char c = e.getKeyChar();
				if (txtusuario.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 10 caracteres");
				}
				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
					e.consume();

				}
			}
		});
		txtusuario.setToolTipText("Nombre Usuario,solo permite letras");
		txtusuario.setColumns(10);
		txtusuario.setBounds(139, 89, 161, 18);
		contentPane.add(txtusuario);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(23, 114, 79, 14);
		contentPane.add(lblNewLabel_1_1_1);

		txtpass = new JPasswordField();
		txtpass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 6;
				char c = e.getKeyChar();
				if (txtpass.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 6 caracteres");
				}
				if (c < '0' || c > '9') {
					e.consume();

				}
			}
		});
		txtpass.setToolTipText("Introduce tu Pass,solo permite numeros");
		txtpass.setColumns(10);
		txtpass.setBounds(139, 114, 161, 18);
		contentPane.add(txtpass);

		JButton agregar = new JButton("Registrate");
		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarusuarios nuevo = new agregarusuarios();
				nuevo.setVisible(true);
				dispose();
			}
		});
		agregar.setToolTipText("Registrate");
		agregar.setMnemonic('R');
		agregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agregar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		agregar.setBackground(SystemColor.menu);
		agregar.setActionCommand("");
		agregar.setBounds(215, 196, 85, 30);
		contentPane.add(agregar);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Si no estas registrado, ");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(23, 207, 161, 23);
		contentPane.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel = new JLabel("MP Manager");
		lblNewLabel.setIcon(new ImageIcon(login.class.getResource("/imagenes/globa32 (1).png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 277, 62);
		contentPane.add(lblNewLabel);
	}
}
