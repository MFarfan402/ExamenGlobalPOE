package examenglobalzoologico.View;

import examenglobalzoologico.Controller.Controladora;
import examenglobalzoologico.Model.Ave;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FormularioBusquedaIndividual extends JFrame{
    
    private final ImageIcon icon = new ImageIcon("zoo.png");
    private final JLabel lblIcon = new JLabel();
    
    private final JLabel lblInstrucciones = new JLabel("");
    private final JLabel lblInstrucciones2 = new JLabel("");
    private final JLabel lblInstrucciones3 = new JLabel("");
    
    private final JTextField txtEspecie = new JTextField();
    private final JLabel lblEspecie = new JLabel("Especie:");
    
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblNombre = new JLabel("Nombre:");
    
    private final JLabel lblResultadoEspecie = new JLabel("Especie:  Sin Resultado");
    private final JLabel lblResultadoNombre = new JLabel("Nombre:  Sin Resultado");
    private final JLabel lblResultadoJaulaId = new JLabel("Jaula ID:  Sin Resultado");
    private final JLabel lblResultadoPeso = new JLabel("Peso:  Sin Resultado");
    private final JLabel lblResultadoColorPlumas = new JLabel("Color plumas:  Sin Resultado");
    private final JLabel lblResultadoAlturaMax = new JLabel("Altura Max:  Sin Resultado");
    private final JLabel lblResultadoHervibora = new JLabel("Tipo Alimentacion:  Sin Resultado");
    
    private final JButton btnConsultar = new JButton("CONSULTAR");
    private final JButton btnEliminar = new JButton("ELIMINAR");
    
    private Controladora controladora;
    
    public FormularioBusquedaIndividual(boolean esEliminacion, Controladora controladora){
        this.controladora = controladora;
        inicializarFormulario(esEliminacion);
    }

    private void inicializarFormulario(boolean esEliminacion) {
          
        String tituloVentana = (esEliminacion) ? 
            "Formulario de Eliminacion de Registro" :
            "Formulario de Consulta Individual" ;
            
        setTitle(tituloVentana);        
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(22,21,34));
        
        setLayout(null);
        
        lblIcon.setBounds(600, 10, 50, 50);
        lblIcon.setIcon(icon);
        add(lblIcon);
        
        lblInstrucciones.setBounds(50, 30, 600, 15);
        lblInstrucciones.setText("Realiza la busqueda de un animal.");
        lblInstrucciones.setForeground(Color.WHITE);
        add(lblInstrucciones);
        
        lblInstrucciones2.setBounds(50, 45, 600, 15);
        lblInstrucciones2.setText("Puedes buscarlo por su especie o por su nombre.");
        lblInstrucciones2.setForeground(Color.WHITE);
        add(lblInstrucciones2);
        
        lblInstrucciones3.setBounds(50, 60, 600, 15);
        lblInstrucciones3.setText("El resultado se mostrara de lado derecho.");
        lblInstrucciones3.setForeground(Color.WHITE);
        add(lblInstrucciones3);
        
        lblEspecie.setForeground(Color.WHITE);
        lblEspecie.setBounds(50, 100, 200, 20); add(lblEspecie);
        txtEspecie.setBounds(50, 120, 250, 25); add(txtEspecie);
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(50, 160, 200, 20); add(lblNombre);
        txtNombre.setBounds(50, 180, 250, 25); add(txtNombre);
        
        lblResultadoEspecie.setForeground(Color.WHITE);
        lblResultadoNombre.setForeground(Color.WHITE);
        lblResultadoJaulaId.setForeground(Color.WHITE);
        lblResultadoPeso.setForeground(Color.WHITE);
        lblResultadoColorPlumas.setForeground(Color.WHITE);
        lblResultadoAlturaMax.setForeground(Color.WHITE);
        lblResultadoHervibora.setForeground(Color.WHITE);
        lblResultadoEspecie.setBounds(400, 50, 200, 20); add(lblResultadoEspecie);
        lblResultadoNombre.setBounds(400, 75, 200, 20); add(lblResultadoNombre);
        lblResultadoJaulaId.setBounds(400, 100, 200, 20); add(lblResultadoJaulaId);
        lblResultadoPeso.setBounds(400, 125, 200, 20); add(lblResultadoPeso);
        lblResultadoColorPlumas.setBounds(400, 150, 200, 20); add(lblResultadoColorPlumas);
        lblResultadoAlturaMax.setBounds(400, 175, 200, 20); add(lblResultadoAlturaMax);
        lblResultadoHervibora.setBounds(400, 200, 200, 20); add(lblResultadoHervibora);
        
        btnConsultar.setBounds(50, 240, 250, 70); add(btnConsultar);
        btnConsultar.setBackground(new Color(57,132,165));
        btnConsultar.setBorder(new LineBorder(Color.WHITE, 0));
        btnConsultar.setForeground(Color.WHITE);
        btnConsultar.addActionListener((ActionEvent e) -> {
            logicaConsultaDatos();
        });
        
        if(esEliminacion) {
            btnEliminar.setBounds(350, 240, 250, 70);
            btnEliminar.setBackground(new Color(57,132,165));
            btnEliminar.setBorder(new LineBorder(Color.WHITE, 0));
            btnEliminar.setForeground(Color.WHITE);
            add(btnEliminar);
            btnEliminar.addActionListener((ActionEvent e) -> {
                logicaEliminarDato();
            });
        }
        
        if(controladora.lista.estaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay valores registrados aun.", 
                "Error!" ,JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    private void logicaConsultaDatos() {
        if(txtEspecie.getText().equals("")) {
            if(txtNombre.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Inserte un valor a buscar en el campo de nombre o especie.", 
                "Precaucion!" ,JOptionPane.ERROR_MESSAGE); 
            } else {
                consultarDato(txtNombre.getText(), true);
            }
        } else {
            consultarDato(txtEspecie.getText(), false);
        }
    }
    
    private void logicaEliminarDato() {
        if( lblResultadoEspecie.getText().equals("Especie:  Sin Resultado"))
            JOptionPane.showMessageDialog(null, "Primero debe realizar la busqueda del animal.", 
                "Precaucion!" ,JOptionPane.WARNING_MESSAGE);
        else {
            String output = "Esta seguro que desea eliminar el animal?";
            int input = JOptionPane.showConfirmDialog(null, output, "Atencion!", JOptionPane.YES_NO_CANCEL_OPTION); 
            if( input == 0) {
                String finalString = lblResultadoNombre.getText().replace("Nombre:  ", "");
                eliminarDato(finalString);
            }
                
        }
    }

    private void consultarDato(String valor, boolean esNombre) {
        Ave aveResultado = controladora.lista.obtenerValor(valor, esNombre);
        String outputString = esNombre ? 
                "No se encontro el animal con el nombre: " + valor :
                "No se encontro la especie: " + valor;
        if (aveResultado.getEspecie() == null) {
            JOptionPane.showMessageDialog(null, outputString, 
                "Error!" ,JOptionPane.WARNING_MESSAGE);
            llenarDatosInterfaz(null);
        }
        else llenarDatosInterfaz(aveResultado);
    }

    private void eliminarDato(String valor) {
        controladora.lista.eliminarNodoPorNombre(valor);
        JOptionPane.showMessageDialog(null, "Se ha eliminado el animal", 
                "Operacion Correcta!" ,JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    private void llenarDatosInterfaz(Ave aveResultado) {
        String resultadoNoEncontado = "  Sin Resultado";
        if(aveResultado == null) {
            lblResultadoEspecie.setText("Especie:" + resultadoNoEncontado);
            lblResultadoNombre.setText("Nombre:" + resultadoNoEncontado);
            lblResultadoJaulaId.setText("Jaula ID:" + resultadoNoEncontado);
            lblResultadoPeso.setText("Peso:" + resultadoNoEncontado);
            lblResultadoColorPlumas.setText("Color plumas:" + resultadoNoEncontado);
            lblResultadoAlturaMax.setText("Altura Max:" + resultadoNoEncontado);
            lblResultadoHervibora.setText("Tipo Alimentacion:" + resultadoNoEncontado);
        } else { 
            String outputString = aveResultado.getEsHervibora() ? "Herviboro" : "Carnivoro";
            lblResultadoEspecie.setText("Especie:  " + aveResultado.getEspecie());
            lblResultadoNombre.setText("Nombre:  " + aveResultado.getNombre());
            lblResultadoJaulaId.setText("Jaula ID:  " + aveResultado.getNumeroJaula());
            lblResultadoPeso.setText("Peso:  " + aveResultado.getPeso());
            lblResultadoColorPlumas.setText("Color plumas:  " + aveResultado.getColorPlumaje());
            lblResultadoAlturaMax.setText("Altura Max:  " + aveResultado.getAlturaMaximaVuelo());
            lblResultadoHervibora.setText("Tipo Alimentacion:  " + outputString);
        }
    }
}