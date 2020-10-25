package com.market.utils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

public class JDBCUtil {
    private static DataSource ds;

    static {
        Properties prop = new Properties();
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");

        try {
            prop.load(is);
            ds = DruidDataSourceFactory.createDataSource(prop);
        } catch (Exception var3) {
            var3.printStackTrace();
        }
    }

    public JDBCUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Statement stat, Connection conn) {
        close((ResultSet)null, stat, conn);
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static void close(ResultSet rs, Statement stat, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException var6) {
                var6.printStackTrace();
            }
        }

        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}
