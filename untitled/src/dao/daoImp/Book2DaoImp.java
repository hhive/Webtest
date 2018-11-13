package dao.daoImp;

import dao.BaseDAO;
import dao.Book2Dao;
import model.Book2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class Book2DaoImp extends BaseDAO implements Book2Dao {
    public Book2DaoImp() {

    }

    public boolean add (Book2 book2) {
        try{
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(book2);
//            session.save(author);
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
            Session session = getSessionFactory().openSession();
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

    public boolean modify (Book2 book2) {
        try {
            System.out.println("modifyBook" + book2.getBookId());
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            session.update(book2);
//            session.update(author);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List findAll(int pageNow, int pageSize) {
        try {
            String hql = "from Book2 where bookId not in (select isbn from Lend)";
            Session session = getSessionFactory().openSession();
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
        Session session = getSessionFactory().openSession();;
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }

    public List findSome(String title, int pageNow, int pageSize) {
        try {
            String hql = "from Book2 where title like '%"
                    + title + "%' or author.name like '%" + title + "%' or author.email =" + "'" + title + "'";
            Session session = getSessionFactory().openSession();
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
        Session session = getSessionFactory().openSession();;
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }

    public Book2 findById(String id) {
        try {
            String hql = "from Book2 where bookId = '" + id + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List Book2List = query.list();
            if (Book2List.size() > 0) {
                Book2 book2 = (Book2)Book2List.get(0);
                return book2;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int findByAuthor(String author) {
        try {
            String hql = "from Book2 where author.name = '" + author + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List Book2List = query.list();
            session.close();
            return Book2List.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
