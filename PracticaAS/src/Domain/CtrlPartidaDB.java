package Domain;

import org.hibernate.Session;

	public class CtrlPartidaDB implements ICtrlPartida {
		
		@Override
		public Partida get (int idPartida) throws Exception{
			Session s = null;
			Partida p = null;
			
			try{
				s = HibernateUtil.getSessionFactory().getCurrentSession();
				s.beginTransaction();
				p = (Partida) s.get(Partida.class, idPartida);
			}
			
			catch (RuntimeException exc){
				s.getTransaction().rollback();
				throw new Exception("Partida no existeix");
			}
			return p;
		}

	}
