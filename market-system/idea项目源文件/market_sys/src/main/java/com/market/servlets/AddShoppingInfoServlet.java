package com.market.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.ShoppingInfoDao;
import com.market.domain.ResultInfo;
import com.market.domain.ShoppingInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;


/**
 * 此servlet完成想数据库中添加用户购物信息
 */
@WebServlet("/addShoppingInfoServlet")
public class AddShoppingInfoServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();//ajax返回bean
        ObjectMapper mapper = new ObjectMapper();//json工具
        ShoppingInfoDao shoppingInfoDao = new ShoppingInfoDao();


        try {
            //获取ajax参数
            String order_id = request.getParameter("order_id");
            String goods_name = request.getParameter("goods_name");
            String sort = request.getParameter("sort");
            int count = Integer.parseInt(request.getParameter("count"));
            Double price = Double.parseDouble(String.valueOf(request.getParameter("price")));

            ShoppingInfo s = new ShoppingInfo();

            s.setOrder_id(order_id);
            s.setGoods_name(goods_name);
            s.setSort(sort);
            s.setCount(count);
            s.setPrice(price);
            s.setDate(String.valueOf(Calendar.getInstance().getTimeInMillis()));

            //接受DAO操作参数
            int state = shoppingInfoDao.add(s);

            //判断操作成功与否
            if (state > 0) {
                System.out.println(state);
                res.setCode(0);
                res.setMsg("商品添加成功");
            } else {
                res.setMsg("商品添加失败");
            }
            //往客户端写出json数据
            mapper.writeValue(response.getOutputStream(), res);

        } catch (Exception e) {//异常处理
            e.printStackTrace();
            res.setMsg("商品添加失败");
            mapper.writeValue(response.getOutputStream(), res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
