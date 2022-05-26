import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class introducirmodelo extends JFrame {

	private JPanel contentPane;
	private JTextField referencia;
	private JTextField descripcion;
	private JTextField unds;
	private JTextField temporada;

	/**
	 * Launch the application.
	 */
	conexion cc = new conexion();
	Connection con = cc.conectarSQL();

	public void introducirmodelo() {

		String sql = "insert into modelos (ref,descripcion,unidades,temporada) VALUES (?,?,?,?)";

		try {

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, referencia.getText());
			pst.setString(2, descripcion.getText());
			pst.setString(3, unds.getText());
			pst.setString(4, temporada.getText());

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Modelo Introducido con Exito");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No hay datos que introducir");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					introducirmodelo frame = new introducirmodelo();
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
	public introducirmodelo() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(introducirmodelo.class.getResource("/imagenes/globa32 (2).png")));
		setTitle("Introducir Modelos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(750, 300, 370, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1 = new JLabel("Introduccion Nuevos Modelos");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(102, 84, 214, 23);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Referencia");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(20, 112, 113, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Descripcion");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(20, 146, 113, 23);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Unidades");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(20, 180, 113, 23);
		contentPane.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Temporada");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_4.setBounds(20, 214, 113, 23);
		contentPane.add(lblNewLabel_1_1_4);

		referencia = new JTextField();
		referencia.setToolTipText("Solo Numeros");
		referencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 10;
				char c = e.getKeyChar();
				if (referencia.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 10 caracteres");
				}

				if (c < '0' || c > '9') {
					e.consume();

				}
			}
		});
		referencia.setColumns(10);
		referencia.setBounds(138, 114, 143, 23);
		contentPane.add(referencia);

		descripcion = new JTextField();
		descripcion.setToolTipText("Solo Letras");
		descripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 20;
				char c = e.getKeyChar();
				if (descripcion.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 20 caracteres");
				}

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
					e.consume();

				}
			}
		});
		descripcion.setColumns(10);
		descripcion.setBounds(138, 148, 143, 23);
		contentPane.add(descripcion);

		unds = new JTextField();
		unds.setToolTipText("Solo Numeros");
		unds.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 5;
				char c = e.getKeyChar();
				if (unds.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 5 caracteres");
				}
				if (c < '0' || c > '9') {
					e.consume();

				}
			}

		});
		unds.setColumns(10);
		unds.setBounds(138, 182, 143, 23);
		contentPane.add(unds);

		temporada = new JTextField();
		temporada.setToolTipText("Solo Letras");
		temporada.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 10;
				char c = e.getKeyChar();
				if (temporada.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 10 caracteres");
				}

				if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
					e.consume();

				}
			}
		});
		temporada.setColumns(10);
		temporada.setBounds(138, 216, 143, 23);
		contentPane.add(temporada);

		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnAtras.setIcon(new ImageIcon(modificar.class.getResource("/imagenes/icons8-atr\u00E1s-16.png")));
		btnAtras.setToolTipText("Retrocede a Inicio");
		btnAtras.setMnemonic('s');
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAtras.setBackground(SystemColor.menu);
		btnAtras.setActionCommand("");
		btnAtras.setBounds(20, 310, 113, 23);
		contentPane.add(btnAtras);

		JButton anadir = new JButton("A\u00F1adir Modelo");
		anadir.setIcon(new ImageIcon(
				introducirmodelo.class.getResource("/imagenes/icons8-agregar-a-bandeja-de-entrada-color-16.png")));
		anadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				introducirmodelo();
			}

		});
		anadir.setToolTipText("A\u00F1adir Modelo");
		anadir.setMnemonic('M');
		anadir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		anadir.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		anadir.setBackground(SystemColor.menu);
		anadir.setActionCommand("");
		anadir.setBounds(138, 250, 143, 23);
		contentPane.add(anadir);

		JLabel lblNewLabel = new JLabel("MP Manager");
		lblNewLabel.setIcon(new ImageIcon(introducirmodelo.class.getResource("/imagenes/globa32 (1).png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 277, 62);
		contentPane.add(lblNewLabel);
	}
}