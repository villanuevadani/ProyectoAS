package Domain;

import org.hibernate.Session;

public class CtrlJocDB implements ICtrlJoc{
	@Override
	public int get() throws Exception{
		Session s = null;
		Joc2048 j = null;

		s = HibernateUtil.getSessionFactory().getCurrentSession();
		s.beginTransaction();
		j = (Joc2048) s.get(Joc2048.class);
		if(j == null) return new Joc2048();
		else return j;
	}

}
