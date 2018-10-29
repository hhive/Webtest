package dao;

import jdbc.SqlSrvDBConn;
import model.User;
import org.hibernate.query.Query;
import tool.HibernateSessionFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

public class UserDao {
        private SqlSrvDBConn dbConnection;

        public UserDao() {
            dbConnection = new SqlSrvDBConn();
        }

        public User validate(String username, String password) {
            String hql = "from User where username = ? and password = ?";
            Query query = HibernateSessionFactory.getSession().createQuery(hql);
            query.setParameter(0, username);
            query.setParameter(1, password);
            List Users = query.list();
            Iterator it = Users.iterator();
            while (it.hasNext()) {
                if (Users.size() != 0) {
                    User myUser = (User) it.next();
                    System.out.println(myUser.getPassword());
                    return myUser;
                }
            }
            HibernateSessionFactory.closeSession();
            return null;
        }
    }

