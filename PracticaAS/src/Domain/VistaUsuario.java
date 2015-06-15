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
	private JTextField tf;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	public VistaUsuario(VistaPrincipal v, JugarPartidaViewController j){
		vp = v;
		jpvc = j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 	JLabel jlabel, jlabel2;
	 	JPanel aux = new JPanel();
	 	//aux.setBackground(Color.gray);
        jlabel = new JLabel("             ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Username:\n");
        jlabel.setForeground(Color.darkGray);
        jlabel.setFont(new Font("Tahoma",1,12));
        aux.add(jlabel);
        JTextField textField = new JTextField(20);
        aux.add(textField);
        
        JPanel aux2 = new JPanel();
       // aux2.setBackground(Color.DARK_GRAY);
        jlabel2 = new JLabel("             ");
        jlabel2.setForeground( new Color(0,0,0,0));
        aux2.add(jlabel2);
       
        jlabel2 = new JLabel("Password:\n");
        jlabel2.setForeground(Color.darkGray);
        jlabel2.setFont(new Font("Tahoma",1,12));
        aux2.add(jlabel2);
        JTextField textField2 = new JTextField(20);
        aux2.add(textField2);        
        
        //aux.setLayout( new FlowLayout(FlowLayout.LEFT));
        //aux2.setLayout( new FlowLayout(FlowLayout.LEFT));
       JPanel aux3 = new JPanel();
       JTextArea jtext = new JTextArea(3,30);
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
	    	//pb.setBackground(Color.DARK_GRAY);
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));

	    	IniciarSessio = new JButton(" Iniciar Sessió ");
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
	            	vp.remove(jp);
	                vp.seleccionarOpcion();
	            }
	        });
	  }

}
