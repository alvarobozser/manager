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
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class modificar extends JFrame {

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
	private JTextField busqueda;

	public void buscarmodelos() {

		String sql = "select * from modelos where ref=?";

		try {

			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, busqueda.getText());

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				referencia.setText(rs.getString("ref"));
				descripcion.setText(rs.getString("descripcion"));
				unds.setText(rs.getString("unidades"));
				temporada.setText(rs.getString("temporada"));

				JOptionPane.showMessageDialog(null, "Modelo Encontrado");
			} else {
				JOptionPane.showMessageDialog(null, "Modelo No Encontrado");
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void modificarmodelo() {

		String sql = "replace into modelos set ref=?,descripcion=?,unidades=?,temporada=?";

		try {

			PreparedStatement pst = con.prepareStatement(sql);

			pst.setString(1, referencia.getText());
			pst.setString(2, descripcion.getText());
			pst.setString(3, unds.getText());
			pst.setString(4, temporada.getText());

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Modelo Modificado con Exito");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Modificar");
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modificar frame = new modificar();
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
	public modificar() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(modificar.class.getResource("/imagenes/globa32 (2).png")));
		setTitle("Modificaciones");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(750, 300, 370, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1_1_1 = new JLabel("Referencia");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(26, 136, 113, 23);
		contentPane.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Descripcion");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(26, 170, 113, 23);
		contentPane.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_3 = new JLabel("Unidades");
		lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_3.setBounds(26, 206, 113, 23);
		contentPane.add(lblNewLabel_1_1_3);

		JLabel lblNewLabel_1_1_4 = new JLabel("Temporada");
		lblNewLabel_1_1_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_4.setBounds(26, 240, 113, 23);
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
		referencia.setBounds(149, 138, 143, 23);
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
		descripcion.setBounds(149, 172, 143, 23);
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
		unds.setBounds(149, 206, 143, 23);
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
		temporada.setBounds(149, 242, 143, 23);
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

		JButton modificar = new JButton("Modificar");
		modificar.setIcon(new ImageIcon(modificar.class.getResource("/imagenes/icons8-modify-16.png")));
		modificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarmodelo();

			}
		});
		modificar.setToolTipText("Modificar");
		modificar.setMnemonic('M');
		modificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		modificar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		modificar.setBackground(SystemColor.menu);
		modificar.setActionCommand("");
		modificar.setBounds(149, 276, 143, 23);
		contentPane.add(modificar);

		busqueda = new JTextField();
		busqueda.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				int limite = 10;

				char c = e.getKeyChar();
				if (busqueda.getText().length() >= limite) {
					e.consume();
					JOptionPane.showMessageDialog(null, "No puedes exceder de 10 caracteres");
				}
				if (c < '0' || c > '9') {
					e.consume();

				}

			}

		});
		busqueda.setToolTipText("Referencia Modelo,Solo Numeros");
		busqueda.setColumns(10);
		busqueda.setBounds(149, 103, 143, 23);
		contentPane.add(busqueda);

		JButton btnBuscarModelo = new JButton("Buscar Modelo");
		btnBuscarModelo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				buscarmodelos();
			}
		});
		btnBuscarModelo.setIcon(new ImageIcon(modificar.class.getResource("/imagenes/icons8-alejar-16.png")));
		btnBuscarModelo.setToolTipText("Busqueda");
		btnBuscarModelo.setMnemonic('C');
		btnBuscarModelo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBuscarModelo.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnBuscarModelo.setBackground(SystemColor.menu);
		btnBuscarModelo.setActionCommand("");
		btnBuscarModelo.setBounds(25, 102, 113, 23);
		contentPane.add(btnBuscarModelo);

		JLabel lblNewLabel = new JLabel("MP Manager");
		lblNewLabel.setIcon(new ImageIcon(modificar.class.getResource("/imagenes/globa32 (1).png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 277, 62);
		contentPane.add(lblNewLabel);
	}
}
