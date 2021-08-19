package examenglobalzoologico.View;

import examenglobalzoologico.Controller.Controladora;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javafx.scene.layout.Border;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class MainMenu extends JFrame{
    private final ImageIcon icon = new ImageIcon("zoo.png");
    private final JLabel lblIcon = new JLabel();
    
    private final JButton btnNuevoAnimal = new JButton("NUEVO REGISTRO");
    private final JButton btnConsultaGeneralAnimales = new JButton("CONSULTA GENERAL");
    private final JButton btnConsultaIndividualAnimal = new JButton("CONSULTA INDIVIDUAL");
    private final JButton btnEliminarAnimal = new JButton("ELIMINAR ANIMAL");
    
    private final JLabel lblInstrucciones = new JLabel("");
    private final JLabel lblTitulo = new JLabel("");
    
    private Controladora controladora; 
    public MainMenu(Controladora controladora) {
        this.controladora = controladora;
        inicializarFormulario();
    }

    private void inicializarFormulario() {
    
        setTitle("Sistema de Administracion Zoologico");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(22,21,34));
        
        setLayout(null);
        
        lblIcon.setBounds(600, 10, 50, 50);
        lblIcon.setIcon(icon);
        add(lblIcon);
        
        lblTitulo.setText("SISTEMA DE ADMINISTRACION DE ANIMALES");
        lblTitulo.setHorizontalAlignment( SwingConstants.CENTER );
        lblTitulo.setBounds(0, 20, 700, 50);
        lblTitulo.setForeground(Color.WHITE);
        add(lblTitulo);
        
        lblInstrucciones.setText("Acciones disponibles:");
        lblInstrucciones.setBounds(40, 45, 200, 50);
        lblInstrucciones.setForeground(Color.WHITE);
        add(lblInstrucciones);
        
        btnNuevoAnimal.setSize(300,100);
        btnNuevoAnimal.setLocation(40, 80);
        btnNuevoAnimal.setBackground(new Color(57,132,165));
        btnNuevoAnimal.setBorder(new LineBorder(Color.WHITE, 1));
        btnNuevoAnimal.setForeground(Color.WHITE);
        add(btnNuevoAnimal);
        btnNuevoAnimal.addActionListener((ActionEvent e) -> {
            mostrarFormularioRegistro();
        });
        
        btnConsultaGeneralAnimales.setSize(300, 100);
        btnConsultaGeneralAnimales.setLocation( 340, 80);
        btnConsultaGeneralAnimales.setBackground(new Color(57,132,165));
        btnConsultaGeneralAnimales.setBorder(new LineBorder(Color.WHITE, 1));
        btnConsultaGeneralAnimales.setForeground(Color.WHITE);
        add(btnConsultaGeneralAnimales);
        btnConsultaGeneralAnimales.addActionListener((ActionEvent e) -> {
            mostrarFormularioConsultaGeneral();
        });
        
        btnConsultaIndividualAnimal.setSize(300, 100);
        btnConsultaIndividualAnimal.setLocation(40, 180);
        btnConsultaIndividualAnimal.setBackground(new Color(57,132,165));
        btnConsultaIndividualAnimal.setBorder(new LineBorder(Color.WHITE, 1));
        btnConsultaIndividualAnimal.setForeground(Color.WHITE);
        add(btnConsultaIndividualAnimal);
        btnConsultaIndividualAnimal.addActionListener((ActionEvent e) -> {
            mostrarFormularioConsultaIndividual();
        });
        
        
        btnEliminarAnimal.setSize(300,100);
        btnEliminarAnimal.setLocation(340, 180);
        btnEliminarAnimal.setBackground(new Color(57,132,165));
        btnEliminarAnimal.setBorder(new LineBorder(Color.WHITE, 1));
        btnEliminarAnimal.setForeground(Color.WHITE);
        add(btnEliminarAnimal);
        btnEliminarAnimal.addActionListener((ActionEvent e) -> {
            mostrarFormularioEliminar();
        });
    }
    
    private void mostrarFormularioRegistro(){
        FormularioRegistroAnimal formularioNuevoRegistro = new FormularioRegistroAnimal(controladora);
        formularioNuevoRegistro.setVisible(true);
    }
    
    private void mostrarFormularioConsultaGeneral() {
        VistaGeneral vistaGeneral = new VistaGeneral(controladora);
        vistaGeneral.setVisible(true);
    }
    
    private void mostrarFormularioConsultaIndividual(){
        //dispose();
        FormularioBusquedaIndividual formularioBusqueda = new FormularioBusquedaIndividual(false, controladora);
        formularioBusqueda.setVisible(true);
        
    }
    
    private void mostrarFormularioEliminar() {
        //dispose();
        FormularioBusquedaIndividual formularioBusqueda = new FormularioBusquedaIndividual(true, controladora);
        formularioBusqueda.setVisible(true);
    }
}
