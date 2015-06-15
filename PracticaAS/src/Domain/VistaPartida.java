package Domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPartida extends JPanel{
	private JButton Sortir;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;

	public VistaPartida(VistaPrincipal v, JugarPartidaViewController j) {
		vp = v;
		jpvc = j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);


	 	JLabel jlabel, jlabel2, jlabel3, jRecord;
	 	JPanel aux = new JPanel();
	 	aux.setLayout( new FlowLayout(FlowLayout.LEFT));
        jlabel = new JLabel("              ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Puntuació\n");
        jlabel.setForeground(Color.gray);
        jlabel.setFont(new Font("Tahoma",1,12));
        //aux.add(jlabel);
        jlabel2 = new JLabel("Record");
        jlabel2.setForeground(Color.gray);
        jlabel2.setFont(new Font("Tahoma",1,12));
        jlabel3 = new JLabel("                    ");
        aux.add(jlabel);
        aux.add(jlabel3);
        aux.add(jlabel2);
       
        jRecord = new JLabel("User1");
        jRecord.setFont(new Font("Tahoma",1,12));
        jRecord.setForeground(Color.gray);
        aux.add(jRecord);
        this.add(aux);
        
        JPanel aux2 = new JPanel();
        aux2.setLayout( new FlowLayout(FlowLayout.CENTER));
        JLabel jpunt,jaux, jrec;
        jpunt = new JLabel("99999");
        jaux = new JLabel("                   ");
        jrec = new JLabel("99999");
        jpunt.setForeground(Color.darkGray);
        jpunt.setFont(new Font("Tahoma",1,22));
        jrec.setForeground(Color.darkGray);
        jrec.setFont(new Font("Tahoma",1,22));
        aux2.add(jpunt);
        aux2.add(jaux);
        aux2.add(jrec);
        this.add(aux2);
        
        JPanel row1 = new JPanel();
        row1.setBackground(Color.black);
      //  row1.setLayout(new GridLayout(4,4));
        JButton j11 = new JButton();
        j11.setBackground(Color.LIGHT_GRAY);
        j11.setPreferredSize(new Dimension(70,70));
        row1.add(j11);
        
        JButton j12 = new JButton();
        j12.setBackground(Color.LIGHT_GRAY);
        j12.setPreferredSize(new Dimension(70,70));
        row1.add(j12);
        
        JButton j13 = new JButton();
        j13.setBackground(Color.LIGHT_GRAY);
        j13.setPreferredSize(new Dimension(70,70));
        row1.add(j13);
        
        JButton j14 = new JButton();
        j14.setBackground(Color.LIGHT_GRAY);
        j14.setPreferredSize(new Dimension(70,70));
        row1.add(j14);
        this.add(row1);
        
        JPanel row2 = new JPanel();
        row2.setBackground(Color.black);
        JButton j21 = new JButton();
        j21.setBackground(Color.LIGHT_GRAY);
        j21.setPreferredSize(new Dimension(70,70));
        row2.add(j21);
        
        JButton j22 = new JButton();
        j22.setBackground(Color.LIGHT_GRAY);
        j22.setPreferredSize(new Dimension(70,70));
        row2.add(j22);
        
        JButton j23 = new JButton();
        j23.setBackground(Color.LIGHT_GRAY);
        j23.setPreferredSize(new Dimension(70,70));
        row2.add(j23);
        
        JButton j24 = new JButton();
        j24.setBackground(Color.LIGHT_GRAY);
        j24.setPreferredSize(new Dimension(70,70));
        row2.add(j24);
        
        this.add(row2);
        
        JPanel row3 = new JPanel();
        row3.setBackground(Color.black);
        JButton j31 = new JButton();
        j31.setBackground(Color.LIGHT_GRAY);
        j31.setPreferredSize(new Dimension(70,70));
        row3.add(j31);
        
        JButton j32 = new JButton();
        j32.setBackground(Color.LIGHT_GRAY);
        j32.setPreferredSize(new Dimension(70,70));
        row3.add(j32);
        
        JButton j33 = new JButton();
        j33.setBackground(Color.LIGHT_GRAY);
        j33.setPreferredSize(new Dimension(70,70));
        row3.add(j33);
        
        JButton j34 = new JButton();
        j34.setBackground(Color.LIGHT_GRAY);
        j34.setPreferredSize(new Dimension(70,70));
        row3.add(j34);
        this.add(row3);
        
        JPanel row4 = new JPanel();
        row4.setBackground(Color.black);
        JButton j41 = new JButton();
        j41.setBackground(Color.LIGHT_GRAY);
        j41.setPreferredSize(new Dimension(70,70));
        row4.add(j41);
        
        JButton j42 = new JButton();
        j42.setBackground(Color.LIGHT_GRAY);
        j42.setPreferredSize(new Dimension(70,70));
        row4.add(j42);
        
        JButton j43 = new JButton();
        j43.setBackground(Color.LIGHT_GRAY);
        j43.setPreferredSize(new Dimension(70,70));
        row4.add(j43);
        
        JButton j44 = new JButton();
        j44.setBackground(Color.LIGHT_GRAY);
        j44.setPreferredSize(new Dimension(70,70));
        row4.add(j44);
        this.add(row4);
        
        
        genBotons(this);
        vp.add(this);
        vp.pack();
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
	                vp.tancar();
	            	//vp.remove(jp);
	            	//vp.partidaAcabada();
	            }
	        });
	  }
}
