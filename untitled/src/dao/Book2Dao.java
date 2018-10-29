package dao;

import model.Book2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tool.HibernateSessionFactory;

import java.util.List;

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

    public boolean modifyBook (Book2 book2) {
        try {
            System.out.println("modifyBook" + book2.getBookId());
            Session session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(book2);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List findSome(String title, int pageNow, int pageSize) {
       try {
           String hql = "from Book2 where title like '%"
                   + title + "%' or author like '%" + title + "%'";
           Session session = HibernateSessionFactory.getSession();
           Transaction transaction = session.beginTransaction();
           Query query = session.createQuery(hql);
           int firstResult = (pageNow - 1) * pageSize;
           query.setFirstResult(firstResult);
           query.setMaxResults(pageSize);
           List list = query.list();
           transaction.commit();
           session.close();
           session = null;
           return list;
       } catch (Exception e) {
           e.printStackTrace();
           return null;
       }
    }

    public int findSomeSize(String title) {
        String hql = "from Book2 where title like '%"
                + title + "%' or author like '%" + title + "%'";
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }
}
