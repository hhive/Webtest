package dao;

import jdbc.SqlSrvDBConn;
import model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

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

        public User getUser(String username) {
            User user = null;
            String sql = "select * from User where id='" + username + "'";
            ResultSet resultSet = dbConnection.executeQuery(sql);
            try {
                if (resultSet != null && resultSet.next()) {
                    user = new User(username, resultSet.getString("password"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            dbConnection.closeStmt();
            return user;
        }
    }

