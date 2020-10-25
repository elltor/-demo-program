package com.market.dao;

import com.market.domain.ShoppingInfo;
import com.market.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingInfoDao {
    /**
     * DBUtils 工具
     */
    private QueryRunner runner = new QueryRunner(JDBCUtil.getDataSource());

    /**
     * 查询所有购物信息
     * @return
     */
    public List<ShoppingInfo> finAll() {
        String sql = "select * from shopping_info";
        List<ShoppingInfo> list = new ArrayList<>();
        try {
            list = runner.query(sql, new ResultSetHandler<List<ShoppingInfo>>() {
                @Override
                public List<ShoppingInfo> handle(ResultSet rs) throws SQLException {
                    ArrayList<ShoppingInfo> l = new ArrayList<>();
                    while (rs.next()) {
                        ShoppingInfo s = new ShoppingInfo();
                        s.setId(rs.getInt(1));
                        s.setOrder_id(rs.getString(2));
                        s.setUserid(rs.getInt(3));
                        s.setGoods_name(rs.getString(4));
                        s.setSort(rs.getString(5));
                        s.setCount(rs.getInt(6));
                        s.setPrice(rs.getDouble(7));
                        s.setDate(rs.getString(8));
                        l.add(s);
                    }
                    return l;
                }
            });
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }

    }

    /**
     * 添加购物信息
     * @param s
     * @return
     */
    public int add(ShoppingInfo s) {
        String sql = "insert into shopping_info (order_id,goods_name,sort,count,price,date)values(?,?,?,?,?,?)";
        try {
            return runner.update(sql, s.getOrder_id(), s.getGoods_name(), s.getSort(), s.getCount(), s.getPrice(), s.getDate());
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }

    }

    /**
     * 删除购物信息
     * @param id
     * @return
     */
    public int del(int id) {
        String sql = "delete from shopping_info where id=?";
        try {
            return runner.update(sql, id);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 根据用户id更新购物信息
     * @param order_id
     * @param userid
     * @return
     */
    public int updateUserid(String order_id, int userid) {
        String sql = "update shopping_info set userid=? where order_id = ?";
        try {
            return runner.update(sql, userid, order_id);
        }catch (SQLException e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 删除用户购物信息
     * @param order_id
     * @return
     */
    public int delByOrderId(String order_id) {
        String sql = "delete from shopping_info where order_id = ?";
        try {
            return runner.update(sql, order_id);
        }catch (SQLException e){
            return 0;
        }
    }

    /**
     * 查询每类的销售金额
     * @return
     * @throws SQLException
     */
    public Map<String,String> findSortPrice() throws SQLException {
        String sql = "SELECT sort,SUM( price ) FROM shopping_info GROUP BY sort";
        return runner.query(sql, new ResultSetHandler<Map<String,String>>() {
            @Override
            public Map<String, String> handle(ResultSet rs) throws SQLException {
                Map<String,String> map = new HashMap<>();
                Double totalPrice = 0.0;
                while(rs.next()){
                    map.put(rs.getString(1),rs.getString(2));
                    totalPrice+=rs.getDouble(2);
                }
                map.put("totalPrice",totalPrice.toString());
                return map;
            }
        });

    }

    /**
     * 查询不同性别会员的消费额度
     * @return
     * @throws SQLException
     */
    public Map<String,String> findCustomerConsumeBySex() throws SQLException {
        String sql = "SELECT user.sex,SUM( shopping_info.price ) FROM user INNER JOIN shopping_info ON user.id = shopping_info.userid GROUP BY user.sex";
        return runner.query(sql, new ResultSetHandler<Map<String, String>>() {
            @Override
            public Map<String, String> handle(ResultSet rs) throws SQLException {
                Map<String,String> map = new HashMap<>();
                Double totalPrice = 0.0;
                while(rs.next()){
                    map.put(rs.getString(1),rs.getString(2));
                    totalPrice+=rs.getDouble(2);
                }
                map.put("totalPrice",totalPrice.toString());
                return map;
            }
        });
    }
}
