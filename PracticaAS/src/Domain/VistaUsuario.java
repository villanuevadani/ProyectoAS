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
import javax.swing.JTextField;

public class VistaUsuario extends JPanel{
	
	private JButton CrearPartida;
	private JButton Sortir;
	private JTextField tf;
	public VistaUsuario(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 	JLabel jlabel, jlabel2;
	 	JPanel aux = new JPanel();
        jlabel = new JLabel("             ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Username:\n");
        jlabel.setFont(new Font("Tahoma",1,12));
        aux.add(jlabel);
        JTextField textField = new JTextField(20);
        aux.add(textField);
        
        JPanel aux2 = new JPanel();
        jlabel2 = new JLabel("             ");
        jlabel2.setForeground( new Color(0,0,0,0));
        aux2.add(jlabel2);
        jlabel2 = new JLabel("Password:\n");
        jlabel2.setFont(new Font("Tahoma",1,12));
        aux2.add(jlabel2);
        JTextField textField2 = new JTextField(20);
        aux2.add(textField2);        
        
        //aux.setLayout( new FlowLayout(FlowLayout.LEFT));
        //aux2.setLayout( new FlowLayout(FlowLayout.LEFT));
       
        this.add(aux);
        this.add(aux2);
		genBotons(this);
		 VistaPrincipal.getInstance().add(this);
	     VistaPrincipal.getInstance().pack();
	 
	}
	
	 private void genBotons(JPanel jp) {
		 
		 	
	    	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.RIGHT));

	    	CrearPartida = new JButton(" Crear Partida ");
	    	pb.add(CrearPartida); 
	    	
	    	Sortir = new JButton(" Sortir ");
	    	pb.add(Sortir);
	    	jp.add(pb);
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                VistaPrincipal.getInstance().tancar();
	            }
	        });
	  }

}
