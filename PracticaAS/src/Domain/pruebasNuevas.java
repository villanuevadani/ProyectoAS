package Domain;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class pruebasNuevas {
	public static void main(String[] args){
		AnnotationConfiguration config = new AnnotationConfiguration();
		config.addAnnotatedClass(UsuariRegistrat.class);
		config.addAnnotatedClass(Joc2048.class);
		config.addAnnotatedClass(Partida.class);
		config.addAnnotatedClass(Jugador.class);
		//config.addAnnotatedClass(Casella.class);
		config.configure("hibernate.cfg.xml");
		
		new SchemaExport(config).create(true, true);
	}

}
