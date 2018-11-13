package dao.daoImp;

import dao.BaseDAO;
import dao.LendDao;
import model.Lend;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class LendDaoImp extends BaseDAO implements LendDao {
    public boolean borrow(Lend lend) {
        try{
            System.out.println("lend borrow");
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.save(lend);
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    public boolean reBack (Lend lend) {
        try{
            String hql = "delete from Lend  where name = '" + lend.getName()
                    + "'and isbn ='" +  lend.getIsbn() + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public List findBorrowBook(String username, int pageNow, int pageSize) {
        try {
            String hql = "from Book2 where bookId  in (select isbn from Lend where name = '" + username + "')";
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

    public int findBorrowBookSize(int pageNow, int pageSize) {
        try {
            String hql = "from Book2 where bookId  in (select isbn from Lend)";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List list = query.list();
            transaction.commit();
            session.close();
            session = null;
            return list.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int findLendId(Lend lend) {
        String myName = lend.getName();
        String myIsbn = lend.getIsbn();
        try {
            String hql = "select id from Lend  where name = '" + lend.getName()
                    + "'and isbn ='" +  lend.getIsbn() + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql);
            List list = query.list();
            transaction.commit();
            session.close();
            session = null;
            return (int)list.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
