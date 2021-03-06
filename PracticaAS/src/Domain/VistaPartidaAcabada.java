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

public class VistaPartidaAcabada extends JPanel{
	private JButton consultarRanking;
	private JButton Sortir;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	private JPanel panel;
	private int puntuacio, record;

	public VistaPartidaAcabada(VistaPrincipal v, JugarPartidaViewController j){
		vp = v; 
		jpvc = j;
		puntuacio = jpvc.getPuntuacio();
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JPanel jp1 = new JPanel();
		jp1.setLayout( new FlowLayout(FlowLayout.CENTER));
		JLabel jl1 = new JLabel("Puntuaci�");
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
		JLabel jl5 = new JLabel(Integer.toString(puntuacio));
		JLabel jl6 = new JLabel("-");
		JLabel jl7 = new JLabel("              ");
		jp2.add(jl5);
		jp2.add(jl7);
		jp2.add(jl6);
		this.add(jp2);
		JPanel jp3 = new JPanel();
		jp3.setLayout( new FlowLayout(FlowLayout.CENTER));
		String msg;
		if(jpvc.estaGuanyada()) msg = "FELICITATS :)";
		else msg = "GAME OVER :(";
		JLabel jl8 = new JLabel(msg);
		jl8.setFont(new Font("Tahoma",1,20));
		jp3.add(jl8);
		this.add(jp3);
		genBotons(this);
	     vp.add(this);
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
