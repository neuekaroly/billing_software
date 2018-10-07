import model.NewsPaper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        //NewsPaper newsPaper = new NewsPaper("Blikk", 2.5);

        //create(newsPaper);

        deleteAll();

        read();
    }

    public static SessionFactory getSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(NewsPaper.class);
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration
                .buildSessionFactory(builder.build());
        return sessionFactory;
    }

    public static Integer create(NewsPaper newsPaper) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(newsPaper);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully created " + newsPaper.toString());
        return newsPaper.getId();
    }

    public static List<NewsPaper> read() {
        Session session = getSessionFactory().openSession();
        @SuppressWarnings("unchecked")
        List<NewsPaper> newsPapers = session.createQuery("FROM NewsPaper").list();
        session.close();
        System.out.println("Found " + newsPapers.size() + " newspapers");
        return newsPapers;
    }

    public static void deleteAll() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("DELETE FROM NewsPaper ");
        query.executeUpdate();
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted all newspapers.");

    }
}
