import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class ComponentesContenedores extends JFrame {
    private JPanel panelFlow;
    private JPanel panelBorder;
    private JPanel panelGrid;
    public ComponentesContenedores(){
        super();
        setSize(900,400); // tamaño de la ventana
        setResizable(false);
        setLocationRelativeTo(null); // centrar la ventana
        setTitle("Componentes y Contenedores 20110374");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addComponents();
        setVisible(true);
        dialog();




    }
    private void addComponents(){
        jPanel();
        jLabel();
        jTextArea();
        jTextField();
        jButton();
        jCheckBox();
        jRadioButton();
        jListModel();
        jComboBox();
        jScrollBar();
        jTable();

        jMenu();

    }
    private void jPanel(){
        panelFlow = new JPanel(); //Panel
        panelFlow.setLayout(new FlowLayout()); // quitar el layout
        panelFlow.setBackground(Color.BLUE);
       // this.getContentPane().add(panelFlow); // agregar el panel a la ventana
        panelBorder = new JPanel();
        panelBorder.setLayout(new BorderLayout());
        panelBorder.setBackground(Color.YELLOW);
        this.getContentPane().add(panelBorder);
        panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(3,10));
        panelGrid.setBackground(Color.GREEN);
       // this.getContentPane().add(panelGrid);

    }
    private void jLabel(){
        JLabel etiqueta = new JLabel("Jlabel",SwingConstants.CENTER); //Etiqueta
        JLabel videojuego = new JLabel("JCheckBox/JRadioButton",SwingConstants.LEFT);
        videojuego.setBounds(70,90,150,20);
        etiqueta.setBounds(0,100,50,15);
        etiqueta.setOpaque(true);
        etiqueta.setForeground(Color.DARK_GRAY);
        etiqueta.setBackground(Color.GREEN);
        etiqueta.setFont(new Font("onyx",Font.BOLD,20));
        panelBorder.add(etiqueta);
        panelBorder.add(videojuego);

    }
    private void jTextArea(){
        JTextArea area = new JTextArea("Bienvenido al JTextArea!!");
        area.setBounds(230,100,130,50);
        area.setVisible(true);
        panelBorder.add(area);
        panelBorder.setVisible(true);
    }
    private void jTextField(){
        JTextField campo  =new JTextField("Bienvenido al JTextField");
        campo.setBounds(380,100,150,50);
        panelBorder.add(campo);
    }
    private void jButton(){
        JButton boton = new JButton("Boton");
        boton.setBounds(540,100,100,30);
        panelBorder.add(boton);

    }
    private void jCheckBox(){
        JCheckBox juego1 = new JCheckBox("Halo");
        JCheckBox juego2 = new JCheckBox("Fallout");
        juego1.setBounds(70,110,50,20);
        juego2.setBounds(70,130,70,20);
        panelBorder.add(juego1);
        panelBorder.add(juego2);
    }
    private void jRadioButton(){
        JRadioButton juego3 = new JRadioButton("Elden Ring");
        JRadioButton juego4 = new JRadioButton("Terraria");
        juego3.setBounds(70,150,90,20);
        juego4.setBounds(70,170,80,20);
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(juego3);
        grupo.add(juego4);
        panelBorder.add(juego3);
        panelBorder.add(juego4);
    }
    private void jListModel(){
        DefaultListModel<String> lista = new DefaultListModel<>();
        lista.addElement("JListModel");
        lista.addElement("Lunes");
        lista.addElement("Martes");
        lista.addElement("Miércoles");
        lista.addElement("Jueves");
        lista.addElement("Viernes");
        JList<String> list = new JList<>(lista);
        list.setBounds(670,100,80,110);
        panelBorder.add(list);
    }
    private void jComboBox(){
        String colors[] = {"JComboBox","Rojo","Negro","Blanco","Gris","Azul"};
        JComboBox combo = new JComboBox<>(colors);
        combo.setBounds(0,200,100,20);
        panelBorder.add(combo);
    }
    private void jScrollBar(){
        JScrollBar scrollBar = new JScrollBar();
        scrollBar.setBounds(865,0,20,300);
        panelBorder.add(scrollBar);
    }
    private void jTable(){
        String[][] datos = {{"Rafael Ruiz","20","México"},{"Juan Guarnizo","25","Colombia"},
                {"Ibai Llanos","26","España"}};
        String[] columnas = {"Nombre","Edad","País"};
        JTable tabla = new JTable(datos,columnas);
        tabla.setBounds(100,180,230,80);
        JScrollPane scrollPane = new JScrollPane(tabla);
        panelBorder.add(scrollPane);
    }
    private void jMenu(){
        JMenuBar barra = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem opc1 = new JMenuItem("Copiar");
        JMenuItem opc2 = new JMenuItem("Pegar");
        JMenuItem opc3 = new JMenuItem("Cortar");
        menu.add(opc1);
        menu.addSeparator();
        menu.add(opc2);
        menu.addSeparator();
        menu.add(opc3);
        barra.add(menu);
        this.setJMenuBar(barra);

    }

    private void dialog(){
        JOptionPane.showMessageDialog(null,"FlowBorder","Saludo",JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args){
        ComponentesContenedores ventana = new ComponentesContenedores();
    }

}
