package dao;

import jdbc.SqlSrvDBConn;
import model.User;
import model.User1;
import org.hibernate.Session;
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
            User user = null;
            String sql = "select * from User where username='" + username +
                    "' and password='" + password + "'";
            ResultSet resultSet = dbConnection.executeQuery(sql);
            try {
                if (resultSet != null && resultSet.next()) {
                    user = new User(username, password);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbConnection.closeStmt();
            return user;
        }
//    public User validate(String username, String password) {
//        String hql = "from User u where u.username = ? and u.password = ?";
//        Session session = HibernateSessionFactory.getSession();
//        Query query = session.createQuery(hql);
////        Query<User> query = HibernateSessionFactory.getSession().createQuery(hql, User.class);
//        query.setParameter(0, username);
//        query.setParameter(1, password);
//        List users = query.list();
//        Iterator it = users.iterator();
//        while (it.hasNext()) {
//            if (users.size() != 0) {
//                User user = (User) it.next();
//                return user;
//            }
//        }
//        HibernateSessionFactory.closeSession();
//        return null;
//    }
}

