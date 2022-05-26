import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.SystemColor;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.codec.Base64.OutputStream;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;

public class secondaryinterfaz extends JFrame {

	private JPanel contentPane;
	private static JTable visor;
	private JTextField textField;
	private JTextField txtBuscar;

	/**
	 * Launch the application.
	 */

	public static void mostrar() {
		String sql = "select * from modelos";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void mostrarundsasc() {
		String sql = "select * from modelos order by unidades asc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void mostrarundsdesc() {
		String sql = "select * from modelos order by unidades desc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void referenciadesc() {
		String sql = "select * from modelos order by ref desc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void referenciaasc() {
		String sql = "select * from modelos order by ref asc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void descripcionasc() {
		String sql = "select * from modelos order by descripcion asc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void descripciondesc() {
		String sql = "select * from modelos order by descripcion desc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void temporadaasc() {
		String sql = "select * from modelos order by temporada asc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void temporadadesc() {
		String sql = "select * from modelos order by temporada desc";
		Statement st;
		conexion con = new conexion();

		Connection conexion = con.conectarSQL();

		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("Referencia");
		model.addColumn("Descripcion");
		model.addColumn("Unidades");
		model.addColumn("Temporada");

		visor.setModel(model);

		String[] datos = new String[5];
		try {

			st = conexion.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				datos[0] = rs.getString(1);
				datos[1] = rs.getString(2);
				datos[2] = rs.getString(3);
				datos[3] = rs.getString(4);

				model.addRow(datos);

			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					secondaryinterfaz frame = new secondaryinterfaz();
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
	public secondaryinterfaz() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(secondaryinterfaz.class.getResource("/imagenes/globa32 (2).png")));
		setTitle("Bienvenido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 761, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(WIDTH);
			}
		});
		btnSalir.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/apagar16.png")));
		btnSalir.setToolTipText("Salir Programa");
		btnSalir.setMnemonic('s');
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSalir.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSalir.setBackground(SystemColor.menu);
		btnSalir.setActionCommand("");
		btnSalir.setBounds(598, 506, 132, 31);
		contentPane.add(btnSalir);

		JButton inicio = new JButton("Inicio");
		inicio.setHorizontalAlignment(SwingConstants.LEFT);
		inicio.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/icons8-casa-16.png")));
		inicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				login nueva = new login();
				nueva.setVisible(true);
				dispose();

			}
		});
		inicio.setToolTipText("Vuelve a Inicio");
		inicio.setMnemonic('o');
		inicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		inicio.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		inicio.setBackground(SystemColor.menu);
		inicio.setActionCommand("");
		inicio.setBounds(15, 84, 132, 31);
		contentPane.add(inicio);

		JButton nuevousuario = new JButton("Registrar Usuario");
		nuevousuario.setHorizontalAlignment(SwingConstants.LEFT);
		nuevousuario.setIcon(new ImageIcon(
				secondaryinterfaz.class.getResource("/imagenes/icons8-a\u00F1adir-usuario-masculino-16.png")));
		nuevousuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarusuarios nueva = new agregarusuarios();
				nueva.setVisible(true);
				dispose();

			}
		});
		nuevousuario.setToolTipText("Nuevo Usuario");
		nuevousuario.setMnemonic('N');
		nuevousuario.setFont(new Font("Tahoma", Font.PLAIN, 12));
		nuevousuario.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		nuevousuario.setBackground(SystemColor.menu);
		nuevousuario.setActionCommand("");
		nuevousuario.setBounds(157, 84, 132, 31);
		contentPane.add(nuevousuario);

		JButton btnModificarDatos = new JButton("Modificar Modelos");
		btnModificarDatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarDatos.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/icons8-modify-16.png")));
		btnModificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar nueva = new modificar();
				nueva.setVisible(true);

			}
		});
		btnModificarDatos.setToolTipText("Modificar Modelos");
		btnModificarDatos.setMnemonic('M');
		btnModificarDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificarDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnModificarDatos.setBackground(SystemColor.menu);
		btnModificarDatos.setActionCommand("");
		btnModificarDatos.setBounds(441, 84, 139, 31);
		contentPane.add(btnModificarDatos);

		JButton btnIntroducirDatos = new JButton("Introducir Modelos");
		btnIntroducirDatos.setHorizontalAlignment(SwingConstants.LEFT);
		btnIntroducirDatos.setIcon(new ImageIcon(
				secondaryinterfaz.class.getResource("/imagenes/icons8-agregar-a-bandeja-de-entrada-color-16.png")));
		btnIntroducirDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				introducirmodelo nuevo = new introducirmodelo();
				nuevo.setVisible(true);

			}
		});
		btnIntroducirDatos.setToolTipText("Introduce Modelos");
		btnIntroducirDatos.setMnemonic('I');
		btnIntroducirDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnIntroducirDatos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIntroducirDatos.setBackground(SystemColor.menu);
		btnIntroducirDatos.setActionCommand("");
		btnIntroducirDatos.setBounds(299, 84, 132, 31);
		contentPane.add(btnIntroducirDatos);

		JLabel lblNewLabel = new JLabel("MP Manager");
		lblNewLabel.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/globa32 (1).png")));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 25));
		lblNewLabel.setBounds(23, 11, 277, 62);
		contentPane.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 221, 715, 274);
		contentPane.add(scrollPane);

		JButton btnEliminarModelos = new JButton("Eliminar Modelo");
		btnEliminarModelos
				.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/icons8-eliminar-16.png")));
		btnEliminarModelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminarmodelo nueva = new eliminarmodelo();
				nueva.setVisible(true);

			}
		});
		btnEliminarModelos.setToolTipText("Elimina Modelo");
		btnEliminarModelos.setMnemonic('M');
		btnEliminarModelos.setHorizontalAlignment(SwingConstants.LEFT);
		btnEliminarModelos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarModelos.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnEliminarModelos.setBackground(SystemColor.menu);
		btnEliminarModelos.setActionCommand("");
		btnEliminarModelos.setBounds(591, 84, 139, 31);
		contentPane.add(btnEliminarModelos);

		visor = new JTable();
		visor.setEnabled(false);
		scrollPane.setViewportView(visor);

		JButton btnOrdenarasc = new JButton("");
		btnOrdenarasc.setIcon(
				new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/punta-de-flecha-hacia-arriba (1).png")));
		btnOrdenarasc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarundsdesc();
			}
		});
		btnOrdenarasc.setToolTipText("Ordenar Unidades");
		btnOrdenarasc.setMnemonic('O');
		btnOrdenarasc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarasc.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarasc.setBackground(SystemColor.menu);
		btnOrdenarasc.setActionCommand("");
		btnOrdenarasc.setBounds(505, 190, 23, 23);
		contentPane.add(btnOrdenarasc);

		JButton btnOrdenarReferencias = new JButton("");
		btnOrdenarReferencias.setIcon(
				new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/punta-de-flecha-hacia-arriba (1).png")));
		btnOrdenarReferencias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referenciadesc();
			}
		});
		btnOrdenarReferencias.setToolTipText("Ordenar Referencias");
		btnOrdenarReferencias.setMnemonic('r');
		btnOrdenarReferencias.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarReferencias.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarReferencias.setBackground(SystemColor.menu);
		btnOrdenarReferencias.setActionCommand("");
		btnOrdenarReferencias.setBounds(145, 190, 23, 23);
		contentPane.add(btnOrdenarReferencias);

		JButton btnOrdenarDescripcion = new JButton("");
		btnOrdenarDescripcion.setIcon(
				new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/punta-de-flecha-hacia-arriba (1).png")));
		btnOrdenarDescripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descripcionasc();
			}
		});
		btnOrdenarDescripcion.setToolTipText("Ordenar Descripcion");
		btnOrdenarDescripcion.setMnemonic('D');
		btnOrdenarDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarDescripcion.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarDescripcion.setBackground(SystemColor.menu);
		btnOrdenarDescripcion.setActionCommand("");
		btnOrdenarDescripcion.setBounds(324, 190, 23, 23);
		contentPane.add(btnOrdenarDescripcion);

		JButton btnOrdenarTemporada3 = new JButton("");
		btnOrdenarTemporada3.setIcon(
				new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/punta-de-flecha-hacia-arriba (1).png")));
		btnOrdenarTemporada3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temporadaasc();
			}
		});
		btnOrdenarTemporada3.setToolTipText("Ordenar Temporada");
		btnOrdenarTemporada3.setMnemonic('D');
		btnOrdenarTemporada3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarTemporada3.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarTemporada3.setBackground(SystemColor.menu);
		btnOrdenarTemporada3.setActionCommand("");
		btnOrdenarTemporada3.setBounds(683, 190, 23, 23);
		contentPane.add(btnOrdenarTemporada3);

		JButton btnOrdenarReferencias_1 = new JButton("");
		btnOrdenarReferencias_1.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/abajo.png")));
		btnOrdenarReferencias_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				referenciaasc();
			}
		});
		btnOrdenarReferencias_1.setToolTipText("Ordenar Referencias");
		btnOrdenarReferencias_1.setMnemonic('r');
		btnOrdenarReferencias_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarReferencias_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarReferencias_1.setBackground(SystemColor.menu);
		btnOrdenarReferencias_1.setActionCommand("");
		btnOrdenarReferencias_1.setBounds(171, 190, 23, 23);
		contentPane.add(btnOrdenarReferencias_1);

		JButton btnOrdenarDescripcion_1 = new JButton("");
		btnOrdenarDescripcion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				descripciondesc();
			}
		});
		btnOrdenarDescripcion_1.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/abajo.png")));
		btnOrdenarDescripcion_1.setToolTipText("Ordenar Descripcion");
		btnOrdenarDescripcion_1.setMnemonic('D');
		btnOrdenarDescripcion_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarDescripcion_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarDescripcion_1.setBackground(SystemColor.menu);
		btnOrdenarDescripcion_1.setActionCommand("");
		btnOrdenarDescripcion_1.setBounds(350, 190, 23, 23);
		contentPane.add(btnOrdenarDescripcion_1);

		JButton btnOrdenardesc = new JButton("");
		btnOrdenardesc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarundsasc();
			}
		});
		btnOrdenardesc.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/abajo.png")));
		btnOrdenardesc.setToolTipText("Ordenar Unidades");
		btnOrdenardesc.setMnemonic('O');
		btnOrdenardesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenardesc.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenardesc.setBackground(SystemColor.menu);
		btnOrdenardesc.setActionCommand("");
		btnOrdenardesc.setBounds(528, 190, 23, 23);
		contentPane.add(btnOrdenardesc);

		JButton btnOrdenarTemporada_1 = new JButton("");
		btnOrdenarTemporada_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temporadadesc();
			}
		});
		btnOrdenarTemporada_1.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/abajo.png")));
		btnOrdenarTemporada_1.setToolTipText("Ordenar Temporada");
		btnOrdenarTemporada_1.setMnemonic('D');
		btnOrdenarTemporada_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOrdenarTemporada_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOrdenarTemporada_1.setBackground(SystemColor.menu);
		btnOrdenarTemporada_1.setActionCommand("");
		btnOrdenarTemporada_1.setBounds(707, 190, 23, 23);
		contentPane.add(btnOrdenarTemporada_1);

		JLabel lblNewLabel_1 = new JLabel("Informacion Stocks");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(15, 126, 174, 23);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Ordenar Referencias");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(15, 190, 132, 23);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("Ordenar Descripciones");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1.setBounds(199, 190, 132, 23);
		contentPane.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_1_1 = new JLabel("Ordenar Unidades");
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1.setBounds(390, 190, 109, 23);
		contentPane.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Ordenar Temporada");
		lblNewLabel_2_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2_1_1_1.setBounds(565, 190, 117, 23);
		contentPane.add(lblNewLabel_2_1_1_1);

		JButton btnModificarDatos_1 = new JButton("");
		btnModificarDatos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarmodelo nueva = new buscarmodelo();
				nueva.setVisible(true);

			}
		});
		btnModificarDatos_1.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/lupa (1).png")));
		btnModificarDatos_1.setToolTipText("Buscar Modelo");
		btnModificarDatos_1.setMnemonic('M');
		btnModificarDatos_1.setHorizontalAlignment(SwingConstants.LEFT);
		btnModificarDatos_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnModificarDatos_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnModificarDatos_1.setBackground(SystemColor.menu);
		btnModificarDatos_1.setActionCommand("");
		btnModificarDatos_1.setBounds(707, 156, 23, 23);
		contentPane.add(btnModificarDatos_1);

		JLabel lblNewLabel_1_1 = new JLabel("Busqueda");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(643, 156, 64, 23);
		contentPane.add(lblNewLabel_1_1);

		JButton refrescar = new JButton("");
		refrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrar();
			}
		});
		refrescar.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/girar.png")));
		refrescar.setToolTipText("Refrescar");
		refrescar.setMnemonic('r');
		refrescar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		refrescar.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		refrescar.setBackground(SystemColor.menu);
		refrescar.setActionCommand("");
		refrescar.setBounds(603, 156, 30, 23);
		contentPane.add(refrescar);

		JButton btnGenerarPdf = new JButton("Generar PDF");
		btnGenerarPdf.setIcon(new ImageIcon(secondaryinterfaz.class.getResource("/imagenes/icons8-exportar-pdf-16.png")));
		btnGenerarPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Document documento = new Document();
				JFileChooser seleccion = new JFileChooser();
				
				try {
					int opcion= seleccion.showSaveDialog(null);
					if(opcion==seleccion.APPROVE_OPTION) {
					
					//String ruta = System.getProperty("user.home");
					//PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Nuevo Informe.pdf"));
					FileOutputStream salida=new FileOutputStream(seleccion.getSelectedFile());
					PdfWriter.getInstance(documento, salida);
					
					Paragraph parrafo = new Paragraph();
					parrafo.setAlignment(Paragraph.ALIGN_CENTER);
					parrafo.add("Informe Stocks \n\n");
					parrafo.setFont(FontFactory.getFont("Tahoma", 18,Font.BOLD, BaseColor.BLACK));
					parrafo.add("Modelos Registrados \n\n");
					documento.open();
					documento.add(parrafo);
					
					PdfPTable tabla = new PdfPTable(4);
					tabla.addCell("Referencia");
					tabla.addCell("Descripcion");
					tabla.addCell("Unidades");
					tabla.addCell("Temporada");

					try {
						String sql = "select * from modelos";
						conexion con = new conexion();
						Connection conexion = con.conectarSQL();
						PreparedStatement pst = conexion.prepareStatement(sql);

						ResultSet rs = pst.executeQuery();

						if (rs.next()) {

							do {
								tabla.addCell(rs.getString(1));
								tabla.addCell(rs.getString(2));
								tabla.addCell(rs.getString(3));
								tabla.addCell(rs.getString(4));

							} while (rs.next());

							documento.add(tabla);

						}

					} catch (DocumentException | SQLException e1) {
						// TODO: handle exception
					}

					documento.close();
					JOptionPane.showMessageDialog(null, "Informe Generado con Exito");
					}
				} catch (DocumentException | HeadlessException | FileNotFoundException e1) {

				} catch (IOException e2) {
					System.out.println("Error en la imagen" + e2);
				}
				
				
			}
			
		});
		btnGenerarPdf.setToolTipText("Generar Informe");
		btnGenerarPdf.setMnemonic('E');
		btnGenerarPdf.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnGenerarPdf.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGenerarPdf.setBackground(SystemColor.menu);
		btnGenerarPdf.setActionCommand("");
		btnGenerarPdf.setBounds(15, 160, 132, 23);
		contentPane.add(btnGenerarPdf);
		
		JLabel lblNewLabel_1_2 = new JLabel("Menu Usuarios");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(598, 11, 132, 23);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Generar Tabla Modelos");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1_1_1.setBounds(470, 156, 132, 23);
		contentPane.add(lblNewLabel_1_1_1_1);

		mostrar();

	}
}
