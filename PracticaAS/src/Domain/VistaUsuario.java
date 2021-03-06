package Domain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class VistaUsuario extends JPanel{
	
	private JButton IniciarSessio;
	private JButton Sortir;
	private JTextField tf1, tf2;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	private JTextArea jtext;
	
	
	public VistaUsuario(VistaPrincipal v, JugarPartidaViewController j){
		vp = v;
		jpvc = j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 	JLabel jlabel, jlabel2;
	 	JPanel aux = new JPanel();
        jlabel = new JLabel("             ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Username:\n");
        jlabel.setForeground(Color.darkGray);
        jlabel.setFont(new Font("Tahoma",1,12));
        aux.add(jlabel);
        tf1 = new JTextField(20);
        aux.add(tf1);
        
        JPanel aux2 = new JPanel();
        jlabel2 = new JLabel("             ");
        jlabel2.setForeground( new Color(0,0,0,0));
        aux2.add(jlabel2);
       
        jlabel2 = new JLabel("Password:\n");
        jlabel2.setForeground(Color.darkGray);
        jlabel2.setFont(new Font("Tahoma",1,12));
        aux2.add(jlabel2);
        tf2 = new JTextField(20);
        aux2.add(tf2);        
       JPanel aux3 = new JPanel();
       jtext = new JTextArea(3,30);
       aux3.add(jtext);
       
        this.add(aux);
        this.add(aux2);
     	genBotons(this);
		this.add(aux3);
		vp.add(this);
	    vp.pack();
	 
	}
	
	 private void genBotons(JPanel jp) {
		 
		 	
	    	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));

	    	IniciarSessio = new JButton(" Iniciar Sessi� ");
	    	pb.add(IniciarSessio); 
	    	
	    	Sortir = new JButton(" Sortir ");
	    	pb.add(Sortir);
	    	jp.add(pb);
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                vp.tancar();
	            }
	        });
	    	IniciarSessio.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	try {
	            		System.out.println("asfasdgagsdg");
	            		System.out.println(tf1.getText());
	            		System.out.println(tf2.getText());
						jpvc.iniciarSessioPressed(tf1.getText(), tf2.getText());
					} catch (Exception e) {
						jtext.setText(e.toString());
					}
	            	vp.remove(jp);
	                vp.seleccionarOpcion();
	            }
	        });
	  }

}
