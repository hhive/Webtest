package dao.daoImp;

import dao.BaseDAO;
import dao.UserDao;
import model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class UserDaoImp extends BaseDAO implements UserDao {

    public User validate(String username, String password) {
        System.out.println("validate" + username + password);
        String hql="from User u where u.username=? and u.password=?";
        Session session=getSessionFactory().openSession();//改
        Query query=session.createQuery(hql);
        query.setParameter(0, username);
        query.setParameter(1, password);
        List users=query.list();
        Iterator it=users.iterator();
        while(it.hasNext())
        {
            if(users.size()!=0){
                User user=(User)it.next();	//创建持久化的 JavaBean 对象 user
//                Transaction transaction = session.beginTransaction();
//                User user1 = new User("aa","123");
//                System.out.println(user1.getUsername());
//                session.save(user1);
//                transaction.commit();
//                session.close();
                return user;
            }
        }
        session.close();//改
        return null;
    }

    public void saveUser(User user) {
        try {
            System.out.println("saveUser" + user.getRole());
            System.out.println("saveUser:" + user.getUsername());
//        String hql = "insert into user values(?,?,?)";
            //String hql = "insert into user values('" + user.getUsername() + "','" + user.getPassword() + "','" + user.getRole() + "')";
            Session session = getSession();
            Transaction transaction = session.beginTransaction();
//        session.createQuery(hql).executeUpdate();
            session.save(user);
            transaction.commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List findAll(int pageNow, int pageSize) {
        try {
            String hql = "from User";
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
        String hql = "from User";
        Session session = getSessionFactory().openSession();;
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }

    public List findSome(String title, int pageNow, int pageSize) {
        try {
            String hql = "from User where username like '%"
                    + title + "%' or role like '%" + title + "%'";
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
        String hql = "from User where username like '%"
                + title + "%' or role like '%" + title + "%'";
        Session session = getSessionFactory().openSession();;
        Transaction transaction = session.beginTransaction();
        int size = session.createQuery(hql).list().size();
        session.close();
        return size;
    }

    public boolean modify(User user) {
        try {
            String hql = "update User set password ='" + user.getPassword() + "'  where username = '" + user.getUsername()
                    + "'and role ='" +  user.getRole() + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean delete(User user) {
        try {
            String hql = "delete from User  where username = '" + user.getUsername()
                    + "'and password ='" +  user.getPassword() + "'";
            Session session = getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();
            session.createQuery(hql).executeUpdate();
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}

