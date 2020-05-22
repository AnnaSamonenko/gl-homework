package homework1.repository;

import homework1.entities.Role;
import homework1.entities.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.Query;
import java.util.List;

public class Repository {

    private static SessionFactory sessionFactory;

    static {
        try {
            loadSessionFactory();
        } catch (Exception e) {
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
    }

    public static void loadSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("/hibernate.cfg.xml");
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Role.class);
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(srvcReg);
    }

    public List<User> findUsersByRole(String role) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        String select = "FROM User u INNER JOIN Role r ON u.id = r.id WHERE r.name =: role";
        Query query = session.createQuery(select);
        query.setParameter("role", role);
        List<User> users = query.getResultList();
        session.getTransaction().commit();
        session.close();
        return users;
    }

    public void createUser(User user) {
    }

    public void createRole(Role role) {
    }
}
