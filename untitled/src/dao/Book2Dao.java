package dao;

import model.Author;
import model.Book2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import tool.HibernateSessionFactory;

import java.util.List;

public class Book2Dao {

    public Book2Dao() {

    }

    public boolean add (Book2 book2, Author author) {
        try{
            Session session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();
            book2.setAuthor(author);
            session.save(book2);
            session.save(author);
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

    public boolean modifyBook (Book2 book2, Author author) {
        try {
            System.out.println("modifyBook" + book2.getBookId());
            Session session = HibernateSessionFactory.getSession();
            Transaction transaction = session.beginTransaction();
            book2.setAuthor(author);
            session.update(book2);
            session.update(author);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List findAll(int pageNow, int pageSize) {
        try {
            String hql = "from Book2";
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

    public int findAllSize() {
        String hql = "from Book2";
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }

    public List findSome(String title, int pageNow, int pageSize) {
       try {
           String hql = "from Book2 where title like '%"
                   + title + "%' or author.name like '%" + title + "%'";
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
                + title + "%' or author.name like '%" + title + "%'";
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }
}
