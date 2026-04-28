package principal;

import java.util.Collection;
import java.util.List;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Precipitaciones;

public class Tabla extends JFrame{
    // Modelo de tabla para gestionar los datos
    private DefaultTableModel tableModel;
    
    // Tabla que muestra los datos
    private JTable tabla;
    
    

    /**
     * Constructor que inicializa el JFrame y carga los datos.
     * 
     * @param title Título de la ventana
     */
    public Tabla(String title) {
        // Llama al constructor de JFrame con el título
        super(title);
        
        // Inicializa los atributos
        inicializarComponentes();
        
        
        
        // Configura el JFrame después de inicializar componentes
        configurarFrame();
    }

    /**
     * Inicializa los componentes de la tabla:
     * - Define las columnas de la tabla
     * - Crea el modelo de tabla
     * - Crea la JTable con el modelo
     * - Añade la tabla a un JScrollPane para permitir scroll
     */
    private void inicializarComponentes() {
        // Array con los nombres de las columnas de la tabla
        // Cada posición representa una columna en el mismo orden
        String[] columnas = {
            "Fecha",           // Columna 0: vehicleMake
            "Estación Meteorológica",          // Columna 1: vehicleModel
            "Provincia",             // Columna 2: vehicleYear
            "Precipitación"             // Columna 3: vehicleVin
                   
        };

        // Crea un DefaultTableModel con las columnas definidas
        // Este modelo gestiona los datos de la tabla (filas y columnas)
        tableModel = new DefaultTableModel(columnas, 0) {
            // Override para hacer las celdas no editables
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // Todas las celdas son de solo lectura
            }
        };

        // Crea la JTable con el modelo definido
        // JTable es el componente visual que muestra la tabla
        tabla = new JTable(tableModel);

        // Ajusta el ancho de las columnas para mejor visualización
        // Columna VIN más ancha porque suele tener códigos largos
        tabla.getColumnModel().getColumn(3).setPreferredWidth(180);
    }

    /**
     * Configura las propiedades del JFrame:
     * - Tamaño por defecto
     * - Posición al center
     * - Operación de cierre
     * - Añade el JScrollPane con la tabla
     */
    private void configurarFrame() {
        // Establece el tamaño de la ventana: ancho 900, alto 400 píxeles
        setSize(900, 400);

        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);

        // Define que ocurre al cerrar la ventana:
        // EXIT_ON_CLOSE = terminar la aplicación al cerrar la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea un JScrollPane que contiene la tabla
        // JScrollPane proporciona barras de desplazamiento automáticas
        // cuando el contenido de la tabla excede el área visible
        JScrollPane scrollPane = new JScrollPane(tabla);

        // Añade el JScrollPane al centro del BorderLayout
        // BorderLayout.CENTER hace que ocupe todo el espacio disponible
        add(scrollPane, BorderLayout.CENTER);
    }

    public void cargarDatos (List<Precipitaciones> lista){

        for (Precipitaciones p : lista) {
            
            Object[] fila = {
                p.getFecha(),
                p.getEstacionMeteorologica(),
                p.getProvincia(),
                p.getPrecipitacion()
                
            };
           this.tableModel.addRow(fila);
        } 


    }

}
