package bases;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingEjemplo {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		JFrame ventana = new JFrame();
		ventana.setSize(400, 300);

		Container contenido = ventana.getContentPane();
		contenido.setLayout(new FlowLayout());
		
		JLabel l = new JLabel("Hola");
		JButton b = new JButton("Púlsame");
		
		contenido.add(l);
		contenido.add(b);
		
		b.addActionListener(e -> l.setText("PULSADO"));
		
		ventana.setVisible(true);
	}
}
