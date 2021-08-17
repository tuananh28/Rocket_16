package co.vti.backend;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.vti.entity.TestingCategory;

public class TestHibernate {

	public static void main(String[] args) {
		Session session = null;
		try {
			session = buildSessionFactory().openSession();

			TestingCategory category = new TestingCategory();
			category.setName("Hibernate1");

			session.save(category);

			System.out.println("Create Success !");
			session.getTransaction().commit();
		} finally {

			if (session != null) {
				session.close();
			}
		}
	}

	private static SessionFactory buildSessionFactory() {
		// load configuration
		Configuration configuration = new Configuration();
		configuration.configure("hibernate.cfg.xml");

		// add entity
		configuration.addAnnotatedClass(TestingCategory.class);

		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).build();
		return configuration.buildSessionFactory(serviceRegistry);
	}

}
