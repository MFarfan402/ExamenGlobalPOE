
package examenglobalzoologico.View;

import examenglobalzoologico.Controller.Controladora;
import examenglobalzoologico.Model.Ave;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class FormularioRegistroAnimal extends JFrame{
    
    private final ImageIcon icon = new ImageIcon("zoo.png");
    private final JLabel lblIcon = new JLabel();
    
    private final JLabel lblInstrucciones = new JLabel("");
    
    private final JTextField txtEspecie = new JTextField();
    private final JLabel lblEspecie = new JLabel("Especie:");
    
    private final JTextField txtNombre = new JTextField();
    private final JLabel lblNombre = new JLabel("Nombre Animal:");
    
    private final JTextField txtJaula = new JTextField();
    private final JLabel lblJaula = new JLabel("ID Jaula:");
    
    private final JTextField txtColorPlumas = new JTextField();
    private final JLabel lblColorPlumas = new JLabel("Color Plumaje:");
    
    private final JTextField txtAlturaMaxima = new JTextField();
    private final JLabel lblAlturaMaxima = new JLabel("Altura Maxima Vuelo (m):");
    
    private final JTextField txtPeso = new JTextField();
    private final JLabel lblPeso = new JLabel("Peso (kg):");
    
    private final JRadioButton rdHerviboro = new JRadioButton("Herviboro");
    private final JRadioButton rdCarniboro = new JRadioButton("Carnivoro"); 
    private final ButtonGroup btnGroup = new ButtonGroup();
    private final JLabel lblTipoAve = new JLabel("Tipo de Ave:");
    private final JPanel pnlTipoAve = new JPanel();
    
    private final JButton btnGuardar = new JButton("GUARDAR");
    
    private Controladora controladora;
        
    public FormularioRegistroAnimal(Controladora controladora) {
        this.controladora = controladora;
        inicializarFormulario();
    }

    private void inicializarFormulario() {
        setTitle("Formulario de Registro de Nuevo Animal");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(22,21,34));
        
        setLayout(null);
        
        lblIcon.setBounds(600, 10, 50, 50);
        lblIcon.setIcon(icon);
        add(lblIcon);
        
        lblInstrucciones.setBounds(50, 15, 600, 25);
        lblInstrucciones.setText("Ingresa los datos del nuevo animal."
                + " Todos los campos son obligatorios.");
        lblInstrucciones.setForeground(Color.WHITE);
        add(lblInstrucciones);
        
        lblEspecie.setForeground(Color.WHITE);
        lblEspecie.setBounds(50, 50, 200, 20); add(lblEspecie);
        txtEspecie.setBounds(50, 70, 250, 25); add(txtEspecie);
        
        lblNombre.setForeground(Color.WHITE);
        lblNombre.setBounds(350, 50, 200, 20); add(lblNombre);
        txtNombre.setBounds(350, 70, 250, 25); add(txtNombre);
        
        lblColorPlumas.setForeground(Color.WHITE);
        lblColorPlumas.setBounds(50, 110, 200, 20); add(lblColorPlumas);
        txtColorPlumas.setBounds(50, 130, 250, 25); add(txtColorPlumas);
        
        lblJaula.setForeground(Color.WHITE);
        lblJaula.setBounds(350, 110, 200, 20); add(lblJaula);
        txtJaula.setBounds(350, 130, 250, 25); add(txtJaula);
        
        lblAlturaMaxima.setForeground(Color.WHITE);
        lblAlturaMaxima.setBounds(50, 180, 200, 20); add(lblAlturaMaxima);
        txtAlturaMaxima.setBounds(50, 200, 250, 25); add(txtAlturaMaxima);
        
        lblPeso.setForeground(Color.WHITE);
        lblPeso.setBounds(350, 180, 200, 20); add(lblPeso);
        txtPeso.setBounds(350, 200, 250, 25); add(txtPeso);
        
        lblTipoAve.setForeground(Color.WHITE);
        rdHerviboro.setForeground(Color.WHITE);
        rdCarniboro.setForeground(Color.WHITE);
        lblTipoAve.setBounds(50, 250, 200, 20); add(lblTipoAve);
        btnGroup.add(rdHerviboro);
        btnGroup.add(rdCarniboro);
        pnlTipoAve.setBounds(50, 280, 200, 20); 
        pnlTipoAve.setLayout(new BoxLayout(pnlTipoAve, BoxLayout.X_AXIS));
        rdHerviboro.setBackground(new Color(22,21,34));
        rdCarniboro.setBackground(new Color(22,21,34));
        pnlTipoAve.setBackground(new Color(22,21,34));
        pnlTipoAve.add(rdHerviboro);
        pnlTipoAve.add(rdCarniboro);
        add(pnlTipoAve);
        
        btnGuardar.setBounds(350, 250, 250, 70); add(btnGuardar);
        btnGuardar.setBackground(new Color(57,132,165));
        btnGuardar.setBorder(new LineBorder(Color.WHITE, 0));
        btnGuardar.setForeground(Color.WHITE);
        btnGuardar.addActionListener((ActionEvent e) -> {
            guardarDatoYSalir();
        });
    }

    private void guardarDatoYSalir() {
        String valorEspecie = txtEspecie.getText();
        String valorNombre = txtNombre.getText();
        String valorColorPlumas = txtColorPlumas.getText();
        String valorJaula = txtJaula.getText();
        String valorPeso = txtPeso.getText();
        String valorAltura = txtAlturaMaxima.getText();
        if(valorEspecie.equals("") ||
            valorNombre.equals("") ||
            valorColorPlumas.equals("") ||
            valorJaula.equals("") ||
            valorPeso.equals("") ||
            valorAltura.equals("")
        )
            JOptionPane.showMessageDialog(null, "Revise que se hayan registrado todos los datos", 
                "Precaucion!" ,JOptionPane.ERROR_MESSAGE);
        else {
            Ave ave = new Ave(
                valorEspecie, valorNombre, 
                Float.parseFloat(valorPeso),
                Integer.parseInt(valorJaula), 
                valorColorPlumas,
                Integer.parseInt(valorAltura), 
                rdHerviboro.isSelected()
            );
            controladora.lista.insertarNodoFinal(ave);
            JOptionPane.showMessageDialog(null, "Animal insertado correctamente!", 
                "Operacion exitosa!" ,JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    
}
