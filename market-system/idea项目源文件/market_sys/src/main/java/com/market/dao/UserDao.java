package com.market.dao;

import com.market.domain.User;
import com.market.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

    /**
     * 查询用户信息
     * @return
     */
    public List<User> findAll() {
        List<User> list = new ArrayList<>();

        try {
            String sql = "select * from user";
            list = runner.query(sql, new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet rs) throws SQLException {
                    List<User> l = new ArrayList<>();
                    while (rs.next()) {
                        User u = new User();
                        u.setId(rs.getInt(1));
                        u.setUsername(rs.getString(2));
                        u.setSex(rs.getInt(3));
                        u.setAge(rs.getInt(4));
                        u.setWork_unit(rs.getString(5));
                        u.setPhone(rs.getString(6));
                        u.setCreate_date(rs.getString(7));
                        u.setUser_exp(rs.getInt(8));
                        l.add(u);
                    }
                    return l;
                }
            });
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return list;
        }
    }

    /**
     * 根据手机号码或这id查询用户
     * @param phone_or_id
     * @return
     */
    public User findByPhoneOrId(String phone_or_id){
        String sql = "select * from user where id = ? or phone = ? limit 1";
        try{
            return runner.query(sql, new ResultSetHandler<User>() {
                @Override
                public User handle(ResultSet rs) throws SQLException {
                    User u = new User();
                    while (rs.next()){
                        u.setId(rs.getInt(1));
                        u.setUsername(rs.getString(2));
                        u.setSex(rs.getInt(3));
                        u.setAge(rs.getInt(4));
                        u.setWork_unit(rs.getString(5));
                        u.setPhone(rs.getString(6));
                        u.setCreate_date(rs.getString(7));
                        u.setUser_exp(rs.getInt(8));
                    }
                    return u;
                }
            }, phone_or_id, phone_or_id);

        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户等级
     * @param u
     * @return
     */
    public int getUserLevel(User u) {
        try {
            String sql = "select value from sys_cfg where name in ('level_1','level_2','level_3','level_4','level_5')";
            ArrayList<Integer> consumeList = new ArrayList<>();
            consumeList = runner.query(sql, new ResultSetHandler<ArrayList<Integer>>() {
                @Override
                public ArrayList<Integer> handle(ResultSet rs) throws SQLException {
                    ArrayList<Integer> l = new ArrayList<>(20);
                    while (rs.next()) {
                        l.add(rs.getInt(1));
                    }
                    return l;
                }
            });

            int exp = u.getUser_exp();
            int level = 0;
            for (int i = consumeList.size()-1; i >= 0; i--) {
                if (exp > consumeList.get(i)) {
                    level = i + 1;
                    break;
                }
            }
            return level;
        } catch (Exception e) {
            return 0;
        }
    }


    public int add(User u){
        try{
            String sql = "insert into user (username,sex,age,work_unit,phone,create_date,user_exp)values(?,?,?,?,?,?,?)";
            return runner.update(sql,u.getUsername(),u.getSex(),u.getAge(),u.getWork_unit(),u.getPhone(),u.getCreate_date(),u.getUser_exp());
        }catch (Exception e){
            return 0;
        }
    }


    public int update(User u){
        try{
            String sql = "update user set username=?,sex=?,age=?,work_unit=?,phone=? where id=?";
            return runner.update(sql,u.getUsername(),u.getSex(),u.getAge(),u.getWork_unit(),u.getPhone(),u.getId());
        }catch (SQLException e){
            return 0;
        }
    }

    public int delete(int userid){
        try{
            String sql = "delete from user where id = ?";
            return runner.update(sql,userid);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * 增加用户积分
     * @param exp
     * @param id
     * @return
     */
    public int addUserShoppingExp(int exp,int id) {
        String sql = "update user set user_exp = user_exp+? where id=?";
        try{
            return runner.update(sql,exp,id);
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * 根据用户名、手机号、id模糊查询用户
     * @param keyWords
     * @return
     */
    public List<User> fuzzyQueryByPhoneOrid(String keyWords) {
        String sql = "select * from user where username like '%"+keyWords+"%' or phone like '%"+keyWords+"%' or id like '%"+keyWords+"%'";
        System.out.println(sql);
        try{
            return runner.query(sql, new ResultSetHandler<List<User>>() {
                @Override
                public List<User> handle(ResultSet rs) throws SQLException {
                    List<User> l = new ArrayList<>();
                    while (rs.next()) {
                        User u = new User();
                        u.setId(rs.getInt(1));
                        u.setUsername(rs.getString(2));
                        u.setSex(rs.getInt(3));
                        u.setAge(rs.getInt(4));
                        u.setWork_unit(rs.getString(5));
                        u.setPhone(rs.getString(6));
                        u.setCreate_date(rs.getString(7));
                        u.setUser_exp(rs.getInt(8));
                        l.add(u);
                    }
                    return l;
                }
            });
        }catch(SQLException e){
            return null;
        }

    }
}
