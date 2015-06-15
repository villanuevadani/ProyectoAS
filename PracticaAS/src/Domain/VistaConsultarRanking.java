package Domain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaConsultarRanking extends JPanel{
	
	private JButton ok;
	private JugarPartidaViewController jpvc;
	private VistaPrincipal vp;
	
	public VistaConsultarRanking(VistaPrincipal v, JugarPartidaViewController j){
		vp = v;
		jpvc = j;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.DARK_GRAY);
		
		 
	     String[] columnNames = {"Jugadors", "Millor Puntuacio"};
	     String[][] data = {{"Aleix", "500"}, {"German", "470"}, {"Victor", "400"}, {"Dani", "250"}, {"Jazz", "150"},};
	     
	     JPanel jtable = new JPanel();
	 	jtable.setLayout( new FlowLayout(FlowLayout.CENTER));
	 	jtable.setSize(300, 300);
	     JTable table = new JTable(data, columnNames);
	     JScrollPane scrollPane = new JScrollPane(table);
	     table.setPreferredScrollableViewportSize(new Dimension(500, 300));
	     table.setSize(1500, 1500);
	     jtable.add(table);
	     jtable.setLayout(new BorderLayout());
	    jtable.add(table.getTableHeader(), BorderLayout.PAGE_START);
	    jtable.add(table, BorderLayout.CENTER);
	    this.add(jtable);
	     genBotons(this);
	     vp.add(this);
	     vp.pack();
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
	                vp.tancar();
	            }
	        });
	    	
	  }
}
