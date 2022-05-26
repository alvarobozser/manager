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

import org.w3c.dom.events.EventTarget;

import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class agregarusuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtusuario;

	/**
	 * Launch the application.
	 * 
	 */

	conexion cc = new conexion();
	Connection con = cc.conectarSQL();
	private JPasswordField txtpass;

	public void agregarusuario() {

		String pass = String.valueOf(txtpass.getPassword());
		String sql = "insert into usuarios (nombre, pass) VALUES (?, ?)";

		try {

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, txtusuario.getText());
			pst.setString(2, pass);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con Exito");

			login interfaz = new login();
			interfaz.setVisible(true);

			this.dispose();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ha habido un error en el registro");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agregarusuarios frame = new agregarusuarios();
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
	public agregarusuarios() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setFont(new Font("Tahoma", Font.PLAIN, 12));
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(agregarusuarios.class.getResource("/imagenes/globa32 (2).png")));
		setResizable(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		setTitle("Registro");
		setBounds(750, 300, 385, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("Registrate\u00A1 ;)");
		contentPane.setBackground(new Color(245, 245, 245));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MP Manager");
		lblNewLabel.setIcon(new ImageIcon(agregarusuarios.class.getResource("/imagenes/globa32 (1).png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 277, 62);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Nuevo Usuario");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 89, 106, 14);
		contentPane.add(lblNewLabel_1_1);
		JButton agregar = new JButton("Registrate");

		agregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarusuario();
			}

		});
		agregar.setBackground(SystemColor.control);
		agregar.setActionCommand("");
		agregar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		agregar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		agregar.setMnemonic('R');
		agregar.setToolTipText("Registrate");
		agregar.setBounds(215, 143, 87, 30);
		contentPane.add(agregar);

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
		txtusuario.setToolTipText("Nombre Usuario, solo permite letras");
		txtusuario.setColumns(10);
		txtusuario.setBounds(139, 89, 161, 18);
		contentPane.add(txtusuario);

		JLabel lblNewLabel_1_1_1 = new JLabel("Password");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(23, 114, 72, 14);
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
		txtpass.setToolTipText("Introduce tu Pass, solo permite numeros");
		txtpass.setColumns(10);
		txtpass.setBounds(139, 114, 161, 18);
		contentPane.add(txtpass);

		JButton btnIniciaSesion = new JButton("Inicia Sesion");
		btnIniciaSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login nuevo = new login();
				nuevo.setVisible(true);
				dispose();
			}
		});
		btnIniciaSesion.setToolTipText("Logueate\u00A1");
		btnIniciaSesion.setMnemonic('I');
		btnIniciaSesion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIniciaSesion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIniciaSesion.setBackground(SystemColor.menu);
		btnIniciaSesion.setActionCommand("");
		btnIniciaSesion.setBounds(215, 196, 87, 30);
		contentPane.add(btnIniciaSesion);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Pulsa aqui si estas registrado,");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(10, 207, 208, 23);
		contentPane.add(lblNewLabel_1_1_1_1);
	}
}
