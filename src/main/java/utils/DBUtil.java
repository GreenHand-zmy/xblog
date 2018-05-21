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

    public static DataSource getDateSource() {
        return dataSource;
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            conn = getDateSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int executeUpdate(String sql, Object... params) {
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

    public static Long executeInsert(String sql, Object... params) {
        Long num = null;
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            num = runner.insert(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }

    public static int getCount(String sql, Class clazz, Object... params) {
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

    public static <T> T getObject(String sql, Class<T> clazz, Object... params) {
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            return runner.query(conn, sql, new BeanHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> List<T> getObjects(String sql, Class<T> clazz, Object... params) {
        Connection conn = getConn();
        QueryRunner runner = new QueryRunner();
        try {
            return runner.query(conn, sql, new BeanListHandler<>(clazz), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
