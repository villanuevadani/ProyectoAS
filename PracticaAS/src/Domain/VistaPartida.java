package Domain;

import java.awt.Color;
import java.awt.Dimension;
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
        JPanel row1 = new JPanel();
     
        JButton j1 = new JButton();
        j1.setBackground(Color.CYAN);
        j1.setPreferredSize(new Dimension(70,70));
        row1.add(j1);
        
        JButton j2 = new JButton();
        j2.setBackground(Color.CYAN);
        j2.setPreferredSize(new Dimension(70,70));
        row1.add(j2);
        
        JButton j3 = new JButton();
        j3.setBackground(Color.CYAN);
        j3.setPreferredSize(new Dimension(70,70));
        row1.add(j3);
        
        JButton j4 = new JButton();
        j4.setBackground(Color.CYAN);
        j4.setPreferredSize(new Dimension(70,70));
        row1.add(j4);
        this.add(row1);
        
        JPanel row2 = new JPanel();
      
        JButton j12 = new JButton();
        j12.setBackground(Color.CYAN);
        j12.setPreferredSize(new Dimension(70,70));
        row1.add(j12);
        
        JButton j22 = new JButton();
        j22.setBackground(Color.CYAN);
        j22.setPreferredSize(new Dimension(70,70));
        row1.add(j22);
        
        JButton j32 = new JButton();
        j32.setBackground(Color.CYAN);
        j32.setPreferredSize(new Dimension(70,70));
        row1.add(j32);
        
        JButton j42 = new JButton();
        j42.setBackground(Color.CYAN);
        j42.setPreferredSize(new Dimension(70,70));
        row1.add(j42);
        this.add(row2);
        
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
