package Domain;

import java.util.Comparator;


public class TuplaComparator implements Comparator<Tupla>{

	@Override
    public int compare(Tupla t1, Tupla t2) {
		if(t1.getPuntuacio() < t2.getPuntuacio()) return -1;
		else if(t1.getPuntuacio() == t2.getPuntuacio()) return 0;
		else return 1;
    }
	
}
