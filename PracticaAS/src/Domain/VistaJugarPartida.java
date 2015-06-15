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




public class VistaJugarPartida extends JPanel{
	
	private JButton JugarPartida;
	private JButton Sortir;
	private JTextField tf;
	
	public VistaJugarPartida(){
		  this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	      JLabel jlabel;
	        
	      /*  jlabel = new JLabel("             ");
	        jlabel.setForeground( new Color(0,0,0,0));
	        this.add(jlabel);*/
	        jlabel = new JLabel("2048");
	        jlabel.setForeground(Color.darkGray);
	        jlabel.setFont(new Font("Tahoma",1,50));
	        //jlabel.setHorizontalAlignment(JLabel.CENTER);
	        JPanel aux = new JPanel();
	       // aux.setBackground(Color.gray);
	        aux.setLayout( new FlowLayout(FlowLayout.CENTER));
	        aux.add(jlabel);
	        this.add(aux);
	        genBotons(this);
	        VistaPrincipal.getInstance().add(this);
	        VistaPrincipal.getInstance().pack();
	 
	}
	

	
	 private void genBotons(JPanel jp) {
	    	JPanel pb = new JPanel();
	    	//pb.setBackground(Color.gray);
	    	pb.setLayout( new FlowLayout(FlowLayout.RIGHT));

	    	JugarPartida = new JButton(" Jugar Partida ");
	    	pb.add(JugarPartida); 
	    	
	    	Sortir = new JButton(" Sortir ");
	    	pb.add(Sortir);
	    	jp.add(pb);
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                VistaPrincipal.getInstance().tancar();
	            }
	        });
	    	JugarPartida.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	VistaPrincipal.getInstance().remove(jp);
	                VistaPrincipal.getInstance().identificacioUsuari();
	            }
	        });
	  }
	

	
}
