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

public class VistaPartida extends JPanel{
	private JButton Sortir;

	public VistaPartida() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
	 	JLabel jlabel, jlabel2;
	 	JPanel aux = new JPanel();
        jlabel = new JLabel("             ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Puntuacion\n");
        jlabel.setFont(new Font("Tahoma",1,12));
        aux.add(jlabel);
        this.add(aux);
        genBotons(this);
        VistaPrincipal.getInstance().add(this);
        VistaPrincipal.getInstance().pack();
	}
	
	 private void genBotons(JPanel jp) {
		 
		 	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.RIGHT));

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
