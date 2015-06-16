package Domain;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPartidaAcabada extends JFrame{
	private JButton consultarRanking;
	private JButton Sortir;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	private JPanel panel;

	public VistaPartidaAcabada(VistaPrincipal v, JugarPartidaViewController j){
		vp = v; 
		jpvc = j;
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
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
		panel.add(jp1);
		JPanel jp2 = new JPanel();
		jp2.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl5 = new JLabel("8900");
		JLabel jl6 = new JLabel("15000");
		JLabel jl7 = new JLabel("              ");
		jp2.add(jl5);
		jp2.add(jl7);
		jp2.add(jl6);
		panel.add(jp2);
		JPanel jp3 = new JPanel();
		jp3.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl8 = new JLabel("FELICITATS :)");
		jl8.setFont(new Font("Tahoma",1,20));
		jp3.add(jl8);
		panel.add(jp3);
		genBotons(panel);
	     vp.add(panel);
	     vp.pack();
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
	            	vp.remove(jp);
	                vp.consultarRanking();
	            }
	        });
	    	Sortir.addActionListener(new ActionListener() {

	            @Override
	            public void actionPerformed(ActionEvent ae) {
	                vp.tancar();
	            }
	        });
	 }   	
}
