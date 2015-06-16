package Domain;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Set;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VistaPartida extends JPanel implements KeyListener{
	private JButton Sortir;
	private Boolean bboton;
	private JugarPartidaViewController jpvc;  
	private VistaPrincipal vp;
	private JLabel jlabel, jlabel2, jlabel3, jRecord, jpunt,jaux, jrec;
	private JButton matr[][]; 
	private ResultFerMovimentPartida res;
	private ResultJugarPartida rjp;
	private int puntuacio;

	public VistaPartida(VistaPrincipal v, JugarPartidaViewController j) {
		
		jpvc = j;
		rjp = jpvc.crearPartidaPressed();
		vp = v;
		bboton = false;
		matr = new JButton[4][4];
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.black);
	 	JPanel aux = new JPanel();
	 	aux.setLayout( new FlowLayout(FlowLayout.LEFT));
        jlabel = new JLabel("              ");
        jlabel.setForeground( new Color(0,0,0,0));
        aux.add(jlabel);
        jlabel = new JLabel("Puntuacion");
        jlabel.setForeground(Color.gray);
        jlabel.setFont(new Font("Tahoma",1,12));
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
        
        jpunt = new JLabel(Integer.toString(puntuacio));
        jaux = new JLabel("                   ");
        jrec = new JLabel("record");
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
        matr[0][0] = new JButton();
        matr[0][0].setBackground(Color.LIGHT_GRAY);
        matr[0][0].setPreferredSize(new Dimension(70,70));
        matr[0][0].setFont(new Font("Tahoma",1,40));
        row1.add(matr[0][0]);
        
        matr[0][1] = new JButton();
        matr[0][1].setBackground(Color.LIGHT_GRAY);
        matr[0][1].setPreferredSize(new Dimension(70,70));
        matr[0][1].setFont(new Font("Tahoma",1,40));
        row1.add(matr[0][1]);
        
        matr[0][2] = new JButton();
        matr[0][2].setBackground(Color.LIGHT_GRAY);
        matr[0][2].setPreferredSize(new Dimension(70,70));
        matr[0][2].setFont(new Font("Tahoma",1,40));
        row1.add(matr[0][2]);
        
        matr[0][3] = new JButton();
        matr[0][3].setBackground(Color.LIGHT_GRAY);
        matr[0][3].setPreferredSize(new Dimension(70,70));
        matr[0][3].setFont(new Font("Tahoma",1,40));
        row1.add(matr[0][3]);
        this.add(row1);
        
        JPanel row2 = new JPanel();
        row2.setBackground(Color.black);
        matr[1][0] = new JButton();
        matr[1][0].setBackground(Color.LIGHT_GRAY);
        matr[1][0].setPreferredSize(new Dimension(70,70));
        matr[1][0].setFont(new Font("Tahoma",1,40));
        row2.add(matr[1][0]);
        
        matr[1][1] = new JButton();
        matr[1][1].setBackground(Color.LIGHT_GRAY);
        matr[1][1].setPreferredSize(new Dimension(70,70));
        matr[1][1].setFont(new Font("Tahoma",1,40));
        row2.add(matr[1][1]);
        
        matr[1][2] = new JButton();
        matr[1][2].setBackground(Color.LIGHT_GRAY);
        matr[1][2].setPreferredSize(new Dimension(70,70));
        matr[1][2].setFont(new Font("Tahoma",1,40));
        row2.add(matr[1][2]);
        
        matr[1][3] = new JButton();
        matr[1][3].setBackground(Color.LIGHT_GRAY);
        matr[1][3].setPreferredSize(new Dimension(70,70));
        matr[1][3].setFont(new Font("Tahoma",1,40));
        row2.add(matr[1][3]);
        
        
        this.add(row2);
        
        JPanel row3 = new JPanel();
        row3.setBackground(Color.black);
        matr[2][0] = new JButton();
        matr[2][0].setBackground(Color.LIGHT_GRAY);
        matr[2][0].setPreferredSize(new Dimension(70,70));
        matr[2][0].setFont(new Font("Tahoma",1,40));
        row3.add(matr[2][0]);
        
        matr[2][1] = new JButton();
        matr[2][1].setBackground(Color.LIGHT_GRAY);
        matr[2][1].setPreferredSize(new Dimension(70,70));
        matr[2][1].setFont(new Font("Tahoma",1,40));
        row3.add(matr[2][1]);
        
        matr[2][2] = new JButton();
        matr[2][2].setBackground(Color.LIGHT_GRAY);
        matr[2][2].setPreferredSize(new Dimension(70,70));
        matr[2][2].setFont(new Font("Tahoma",1,40));
        row3.add(matr[2][2]);
        
        matr[2][3] = new JButton();
        matr[2][3].setBackground(Color.LIGHT_GRAY);
        matr[2][3].setPreferredSize(new Dimension(70,70));
        matr[2][3].setFont(new Font("Tahoma",1,40));
        row3.add(matr[2][3]);
        this.add(row3);
        
        JPanel row4 = new JPanel();
        row4.setBackground(Color.black);
        matr[3][0] = new JButton();
        matr[3][0].setBackground(Color.LIGHT_GRAY);
        matr[3][0].setPreferredSize(new Dimension(70,70));
        matr[3][0].setFont(new Font("Tahoma",1,40));
        row4.add(matr[3][0]);
        
        matr[3][1] = new JButton();
        matr[3][1].setBackground(Color.LIGHT_GRAY);
        matr[3][1].setPreferredSize(new Dimension(70,70));
        matr[3][1].setFont(new Font("Tahoma",1,40));
        row4.add(matr[3][1]);
        
        matr[3][2] = new JButton();
        matr[3][2].setBackground(Color.LIGHT_GRAY);
        matr[3][2].setPreferredSize(new Dimension(70,70));
        matr[3][2].setFont(new Font("Tahoma",1,40));
        row4.add(matr[3][2]);
        
        matr[3][3] = new JButton();
        matr[3][3].setBackground(Color.LIGHT_GRAY);
        matr[3][3].setPreferredSize(new Dimension(70,70));
        matr[3][3].setFont(new Font("Tahoma",1,40));
        row4.add(matr[3][3]);
        this.add(row4);
        ini();
        
        //io = new IOKeyListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        genBotons(this);
        vp.add(this);
        vp.pack();
	}
	
	private void ini(){
		puntuacio = rjp.getPuntInicial();
		Set<CasAmbNum> cas = rjp.getCasAmbNum();
	    int i = 0, j = 0;
		for (CasAmbNum c : cas) {
			System.out.println(c.getI() + " " + c.getJ() + " " + c.getNumero());
		    matr[c.getI()][c.getJ()].setText(Integer.toString(c.getNumero()));
		}
	}
	
	private void refresh(){
		puntuacio = res.getPuntuacio();
		Set<CasAmbNum> cas = res.getCasellesAmbNumero();
		System.out.println(cas.size() + " per pintar");
	    /*int i = 0, j = 0;*/
	    for(int z = 0; z < 4; ++z)
	    {
	    	for(int w=0; w < 4; ++ w)
	    	{
	    		 matr[z][w].setText(" ");
	    		 matr[z][w].setBackground(Color.LIGHT_GRAY);
	    		 matr[z][w].setForeground(Color.DARK_GRAY);
	    		 matr[z][w].setFont(new Font("Tahoma",1,40));
	    	}
	    }
		for (CasAmbNum c : cas) {
			System.out.println(c.getI() + " " + c.getJ() + " " + c.getNumero());
		    matr[c.getI()][c.getJ()].setText(Integer.toString(c.getNumero()));

		    if(c.getNumero() == 8) {
		    	matr[c.getI()][c.getJ()].setBackground(Color.YELLOW);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,40));
		    }
		    else if(c.getNumero() == 16){
		    	matr[c.getI()][c.getJ()].setBackground(Color.orange);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,25));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		    else if(c.getNumero() == 32) {
		    	matr[c.getI()][c.getJ()].setBackground(Color.magenta);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,25));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		    else if(c.getNumero() == 64) {
		    	matr[c.getI()][c.getJ()].setBackground(Color.RED);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,25));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		    else if(c.getNumero() == 128) {
		    	matr[c.getI()][c.getJ()].setBackground(Color.CYAN);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,15));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		    else if(c.getNumero() == 256){
		    	matr[c.getI()][c.getJ()].setBackground(Color.BLUE);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,15));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		    else if(c.getNumero() == 1024){
		    	matr[c.getI()][c.getJ()].setBackground(Color.GREEN);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,15));
		    }
		    else if(c.getNumero() == 2048){
		    	matr[c.getI()][c.getJ()].setBackground(Color.black);
		        matr[c.getI()][c.getJ()].setFont(new Font("Tahoma",1,15));
		        matr[c.getI()][c.getJ()].setForeground(Color.white);
		    }
		}
	}
	/*
	public void keyPressed(KeyEvent e) {
		System.out.println("0");
	    if(bboton){
	    	int key = e.getKeyCode();

		    if (key == KeyEvent.VK_LEFT) {
		    	System.out.println("1");
		        res = jpvc.direccioPressed("esquerra");
		    }

		    if (key == KeyEvent.VK_RIGHT) {
		    	System.out.println("2");
		    	res = jpvc.direccioPressed("dreta");
		    }

		    if (key == KeyEvent.VK_UP) {
		    	System.out.println("3");
		    	res = jpvc.direccioPressed("amunt");
		    }

		    if (key == KeyEvent.VK_DOWN) {
		    	System.out.println("4");
		    	res = jpvc.direccioPressed("avall");
		    }
		    bboton = false;
		    refresh();
	    }		
	}*/
	
	 public void keyPressed(String s){
		res = jpvc.direccioPressed(s);
     	refresh();
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
	 
	 public void keyTyped(KeyEvent e){}
	 public void keyReleased(KeyEvent e){}
	 public void keyPressed(KeyEvent e) {
	    	System.out.println("press");
	    	int key = e.getKeyCode();
		    
		    if (key == KeyEvent.VK_LEFT) {
		    	keyPressed("esquerra");
		    }

		    if (key == KeyEvent.VK_RIGHT) {
		    	keyPressed("dreta");
		    }

		    if (key == KeyEvent.VK_UP) {
		    	System.out.println("amunt is all in");
		    	keyPressed("amunt");
		    }

		    if (key == KeyEvent.VK_DOWN) {
		    	keyPressed("avall");
		    }
			
	    }
	 
	/*
	@Override
	public void keyReleased(KeyEvent arg0) {
		System.out.println("a");
		bboton = true;
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("0");
	    if(bboton){
	    	int key = e.getKeyCode();
	    

		    if (key == KeyEvent.VK_LEFT) {
		    	System.out.println("1");
		        res = jpvc.direccioPressed("esquerra");
		    }

		    if (key == KeyEvent.VK_RIGHT) {
		    	System.out.println("2");
		    	res = jpvc.direccioPressed("dreta");
		    }

		    if (key == KeyEvent.VK_UP) {
		    	System.out.println("3");
		    	res = jpvc.direccioPressed("amunt");
		    }

		    if (key == KeyEvent.VK_DOWN) {
		    	System.out.println("4");
		    	res = jpvc.direccioPressed("avall");
		    }
		    bboton = false;
		    puntuacio = res.getPuntuacio();
		    Set<CasAmbNum> cas = res.getCasellesAmbNumero();
		    int i = 0, j = 0;
			for (CasAmbNum c : cas) {
			    matr[i][j].setText(Integer.toString(c.getNumero()));
			    System.out.println("numero" + c.getNumero());
			    ++j;
			    if (j > 3){
			    	j = 0;
			    	++i;
			    }
			}
	    }
	
	}*/
}
