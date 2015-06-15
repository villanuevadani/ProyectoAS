package Domain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class VistaConsultarRanking extends JPanel{
	
	private JButton ok;
	
	public VistaConsultarRanking(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.DARK_GRAY);
		genBotons(this);
		 VistaPrincipal.getInstance().add(this);
	     VistaPrincipal.getInstance().pack();
		
	}
	
	
	 private void genBotons(JPanel jp) {
		 
		 	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));
	    	pb.setBackground(Color.DARK_GRAY);
	       	ok = new JButton(" OK ");
	    	pb.add(ok);
	    	jp.add(pb);
	    	ok.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                VistaPrincipal.getInstance().tancar();
	            }
	        });
	    	
	  }
}
