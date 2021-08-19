package examenglobalzoologico.View;

import examenglobalzoologico.Controller.Controladora;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author MFARFAN
 */
public class VistaGeneral extends JFrame{
    
    private final ImageIcon icon = new ImageIcon("zoo.png");
    private final JLabel lblIcon = new JLabel();
    private final JLabel lblInstrucciones = new JLabel("");
    
    private final JTextArea txtArea = new JTextArea();
    private JScrollPane scroll;
    
    private Controladora controladora;
    public VistaGeneral(Controladora controladora) {
        this.controladora = controladora;
        inicializarFormulario();
    }

    private void inicializarFormulario() {
        
        setTitle("Consulta de Todos los Registros");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(22,21,34));
        
        setLayout(null);
        
        lblIcon.setBounds(600, 10, 50, 50);
        lblIcon.setIcon(icon);
        add(lblIcon);
        
        lblInstrucciones.setText("Se muestran todos los registros almacenados en la siguiente ventana:");
        lblInstrucciones.setBounds(25, 25, 600, 25);
        lblInstrucciones.setForeground(Color.WHITE);
        add(lblInstrucciones);
        
        txtArea.setEditable(false);
        String outputString = "";
        for(int i = 0; i < controladora.lista.getLongitudLista(); i++) {
            outputString += controladora.lista.obtenerValorPorIndice(i);
        }
        if (outputString.equals("")) outputString = "No hay valores por mostrar.";
        txtArea.setText(outputString);
        scroll = new JScrollPane(txtArea);
        scroll.setBounds(25, 65, 580, 250);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        add(scroll);
    }
    
    
}
