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

public class VistaPartidaAcabada extends JPanel{
	private JButton consultarRanking;
	private JButton Sortir;

	public VistaPartidaAcabada(){
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel jp1 = new JPanel();
		jp1.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl1 = new JLabel("Puntuació");
		JLabel jl2 = new JLabel("Record");
		JLabel jl3 = new JLabel("USER1");
		JLabel jl4 = new JLabel("              ");
		jp1.add(jl1);
		jp1.add(jl4);
		jp1.add(jl2);
		jp1.add(jl3);
		this.add(jp1);
		JPanel jp2 = new JPanel();
		jp2.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl5 = new JLabel("8900");
		JLabel jl6 = new JLabel("15000");
		JLabel jl7 = new JLabel("              ");
		jp2.add(jl5);
		jp2.add(jl7);
		jp2.add(jl6);
		this.add(jp2);
		JPanel jp3 = new JPanel();
		jp3.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl8 = new JLabel("FELICITATS :)");
		jl8.setFont(new Font("Tahoma",1,20));
		jp3.add(jl8);
		this.add(jp3);
		genBotons(this);
	     VistaPrincipal.getInstance().add(this);
	     VistaPrincipal.getInstance().pack();
	}
	
	 private void genBotons(JPanel jp) {
		 
		 	JPanel pb = new JPanel();
	    	pb.setLayout( new FlowLayout(FlowLayout.CENTER));
	    	pb.setBackground(Color.DARK_GRAY);
	       	consultarRanking = new JButton(" Consultar Ranking ");
	    	pb.add(consultarRanking);
	      	Sortir = new JButton(" Sortir ");
	    	pb.add(Sortir);
	    	jp.add(pb);
	    	consultarRanking.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	            	VistaPrincipal.getInstance().remove(jp);
	                VistaPrincipal.getInstance().consultarRanking();
	            }
	        });
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                VistaPrincipal.getInstance().tancar();
	            }
	        });
	 }   	
}
