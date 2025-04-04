package com.ipartek.formacion.multimodulo.presentacion.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocio;
import com.ipartek.formacion.multimodulo.logicanegocio.AnonimoNegocioImpl;

public class Aplicacion {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion window = new Aplicacion();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Aplicacion() {
		initialize();
		
		AnonimoNegocio negocio = new AnonimoNegocioImpl();
	
		// Crear un modelo para la tabla
        DefaultTableModel modelo = (DefaultTableModel)table.getModel();
        
        // Añadir columnas
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripción");
        
        // Añadir filas
        for(var p: negocio.listarProductos()) {
        	modelo.addRow(new Object[]{p.getId(), p.getNombre(), p.getPrecio(), p.getDescripcion()});
        }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.CENTER);
	}

}
