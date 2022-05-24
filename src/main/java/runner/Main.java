package runner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import utils.NewHibernateUtil;

public class Main {
    public static void main(String[] args) {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();

        Task_1.Task_1(session);
        Task_2.Task_2(session);
        Task_3.Task_3(session);

        session.flush();
        transaction.commit();
        session.close();
        sf.close();
    }
}