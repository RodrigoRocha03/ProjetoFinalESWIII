package util;

import java.util.Properties;

import javax.imageio.spi.ServiceRegistry;
import javax.security.auth.login.Configuration;
import org.hibernate.SessionFactory;
import org.omg.CORBA.Environment;

public class HibernateUtil {

		 private static SessionFactory sessionFactory;
		    public static SessionFactory getSessionFactory() {
		        if (sessionFactory == null) {
		            try {
		                Configuration configuration = new Configuration();


		                Properties settings = new Properties();
		                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
		                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/Portaria?createDatabaseIfNotExist=true");
		                settings.put(Environment.USER, "root");
		                settings.put(Environment.PASS, "8970Roferocha");
		                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		                settings.put(Environment.SHOW_SQL, "true");
		                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
		                settings.put(Environment.HBM2DDL_AUTO, "update");

		                configuration.setProperties(settings);
		                configuration.addAnnotatedClass(Visitante.class);
		                configuration.addAnnotatedClass(Funcionario.class);
		                configuration.addAnnotatedClass(Chaves.class);
		                configuration.addAnnotatedClass(AgendarSala.class);
		                
		                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
		                    .applySettings(configuration.getProperties()).build();

		                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		            } catch (Exception e) {
		                e.printStackTrace();
		            }
		        }
		        return sessionFactory;
		    }
	}