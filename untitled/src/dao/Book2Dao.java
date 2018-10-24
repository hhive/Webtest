package dao;

import model.Book2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import tool.HibernateSessionFactory;

public class Book2Dao {

    public Book2Dao() {

    }

    public boolean add (Book2 book2) {
        try{
            Session session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();
            System.out.println("add" + book2.getTitle());
            session.save(book2);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println("Exception" + e);
            return false;
        }
    }

    public boolean delete(Book2 book2) {
        try{
        System.out.println("delete" + book2.getBookId());
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(book2);
        transaction.commit();
        session.close();
        return true;
        } catch (Exception e) {
            System.out.println("Exception" + e);
            return false;
        }
    }
}
