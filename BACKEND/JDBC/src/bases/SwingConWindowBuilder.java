package bases;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class SwingConWindowBuilder {

	private JFrame frame;
	private JLabel lblResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				SwingConWindowBuilder window = new SwingConWindowBuilder();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingConWindowBuilder() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 102);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel);

		JTextField tfNombre = new JTextField();
		tfNombre.setBounds(66, 8, 86, 20);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		JButton btnSaludar = new JButton("Saludar");
		btnSaludar.addActionListener(e -> lblResultado.setText("Hola " + tfNombre.getText()));
		btnSaludar.setBounds(162, 7, 89, 23);
		frame.getContentPane().add(btnSaludar);

		lblResultado = new JLabel("");
		lblResultado.setBounds(10, 36, 243, 14);
		frame.getContentPane().add(lblResultado);
	}
}
