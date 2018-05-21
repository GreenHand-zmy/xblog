package utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ZH on 2018/5/21.
 */
public class DBUtil {
    private static DataSource dataSource = new ComboPooledDataSource();

    public DataSource getDateSource() {
        return dataSource;
    }

    public Connection getConn() {
        Connection conn = null;
        try {
            conn = getDateSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public int executeUpdate(String sql, Object... params) {
        int num = 0;
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            num = runner.update(conn, sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public int getCoount(String sql, Class clazz, Object... params) {
        int num = 0;
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            Object obj = runner.query(conn, sql, new ScalarHandler(), params);
            num = Integer.parseInt(obj.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public <T> T getObject(String sql, Class clazz, Object... params) {
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            return (T) runner.query(conn, sql, new BeanHandler<Class>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List getObjects(String sql, Class clazz, Object... params) {
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            return runner.query(conn, sql, new BeanListHandler<Class>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
