package Domain;

import java.util.Comparator;


public class TuplaComparator implements Comparator<Tupla>{

	@Override
    public double compare(Tupla t1, Tupla t2) {
        return (t2.getPuntuacio() - t1.getPuntuacio());
    }
	
}
