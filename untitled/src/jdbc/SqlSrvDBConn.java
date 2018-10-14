package jdbc;
import java.sql.*;

public class SqlSrvDBConn {
	private Statement stmt;
    private Connection conn;
    ResultSet rs;
    //在构造方法中创建数据库连接
    public SqlSrvDBConn(){
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://localhost:3306/webtest?autoReconnect=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "8888";
    	stmt=null;
    	try{
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url,user,password);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	rs=null;

    }
    //执行查询类的SQL语句，有返回集
    public ResultSet executeQuery(String sql)
    {
        try
        {
        	stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
        	rs=stmt.executeQuery(sql);
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
        return rs;
    }

    /**
     * insert
     */
    public int executeUpdate(String sql) {
        int rows = 0;
        try
        {
            stmt=conn.createStatement();
            rows = stmt.executeUpdate(sql);

        }catch(SQLException e){
            System.err.println("Data.executeUpdate: " + e.getMessage());
        }
        return rows;
    }
    //关闭对象
    public void closeStmt()
    {
        try
        {
            stmt.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
    public void closeConn()
    {
        try
        {
            conn.close();
        }catch(SQLException e){
        	System.err.println("Data.executeQuery: " + e.getMessage());
        }
    }
}
