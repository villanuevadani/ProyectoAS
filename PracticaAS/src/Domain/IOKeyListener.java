package Domain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Set;

public class IOKeyListener implements KeyListener{
	VistaPartida vp;
	public IOKeyListener(VistaPartida v){
		vp=v;
	}
	
	/** Handle the key typed event from the text field. */
    public void keyTyped(KeyEvent e) {
    		System.out.println("type");
    	    	int key = e.getKeyCode();
    	    
    		    if (key == KeyEvent.VK_LEFT) {
    		    	vp.keyPressed("esquerra");
    		    }

    		    if (key == KeyEvent.VK_RIGHT) {
    		    	vp.keyPressed("dreta");
    		    }

    		    if (key == KeyEvent.VK_UP) {
    		    	vp.keyPressed("amunt");
    		    }

    		    if (key == KeyEvent.VK_DOWN) {
    		    	vp.keyPressed("avall");
    		    }
    			
 	}


    /** Handle the key-pressed event from the text field. */
    public void keyPressed(KeyEvent e) {
    	System.out.println("press");
    	int key = e.getKeyCode();
	    
	    if (key == KeyEvent.VK_LEFT) {
	    	vp.keyPressed("esquerra");
	    }

	    if (key == KeyEvent.VK_RIGHT) {
	    	vp.keyPressed("dreta");
	    }

	    if (key == KeyEvent.VK_UP) {
	    	System.out.println("amunt is all in");
	    	vp.keyPressed("amunt");
	    }

	    if (key == KeyEvent.VK_DOWN) {
	    	vp.keyPressed("avall");
	    }
		
    }

    /** Handle the key-released event from the text field. */
    public void keyReleased(KeyEvent e) {
        
    }
}
