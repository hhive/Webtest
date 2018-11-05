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

import java.util.Iterator;
import java.util.List;

public class UserDaoImp extends BaseDAO implements UserDao {

    public User validate(String username, String password) {
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
        System.out.println("saveUser:" + user.getUsername());
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }
}
