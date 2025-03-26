package bases;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SwingEjemplo {
	private static JLabel l;
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		JFrame ventana = new JFrame();
		ventana.setSize(400, 300);

		Container contenido = ventana.getContentPane();
		contenido.setLayout(new FlowLayout());
		
//		Escuchador
//		JLabel l = new JLabel("Hola"); // NOSONAR
		
//		Escuchador2
		l = new JLabel("Hola");
		
		JButton b = new JButton("Púlsame");
		
		contenido.add(l);
		contenido.add(b);
		
//		Escuchador e = new Escuchador(l); // NOSONAR
//		b.addActionListener(e); // NOSONAR
		
//		Escuchador2
//		b.addActionListener(new Escuchador2()); // NOSONAR
		
//		CLASE ANÓNIMA
//		NOSONAR {
//		b.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				l.setText("Pulsado desde clase ANÓNIMA");
//			}
//		});
//		}
		
		// LAMBDA
		b.addActionListener(e -> l.setText("Pulsado desde lambda"));

		ventana.setVisible(true);
	}
	
	// CLASE INTERNA
	static class Escuchador2 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			l.setText("Pulsado");
		}
	}
}

class Escuchador implements ActionListener {
	private JLabel label;
	
	Escuchador(JLabel label) {
		this.label = label;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		label.setText("Pulsado");
	}
	
}