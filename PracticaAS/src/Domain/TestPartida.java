package Domain;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;



public class TestPartida {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	AnnotationConfiguration config = new AnnotationConfiguration();
		
		//crear tabla de UsuariRegistrat
		//config.addAnnotatedClass(UsuariRegistrat.class);
	config.addAnnotatedClass(Jugador.class);
		config.addAnnotatedClass(Partida.class);
		config.configure("hibernate.cfg.xml");
		new SchemaExport(config).create(true, true);
	}

}
