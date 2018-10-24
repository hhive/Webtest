package tool;

import com.sun.xml.internal.ws.handler.HandlerException;
import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.ArrayList;

public class HibernateSessionFactory {
    ArrayList list;
    private static final ThreadLocal<Session> threadLocal = new ThreadLocal<>();
    private static Configuration configuration = new Configuration();
    private static SessionFactory sessionFactory = null;

    static {
        try {
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            System.out.println("%%%% Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    private HibernateSessionFactory() {

    }

    public static Session getSession() {
        Session session = (Session) threadLocal.get();
            if (session == null || !session.isOpen()) {
                if (sessionFactory == null) {

                }
                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                threadLocal.set(session);
            }
        return  session;
    }

    public static void rebuildSessionFactory() {
        try {
            configuration.configure();
            sessionFactory = configuration.buildSessionFactory();

        } catch (Exception e) {
            System.out.println("%%%% Error reCreating SessionFactory %%%%");
            e.printStackTrace();
        }
    }

    public static void closeSession() throws HandlerException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if(session != null) {
            session.close();
        }
    }
}
