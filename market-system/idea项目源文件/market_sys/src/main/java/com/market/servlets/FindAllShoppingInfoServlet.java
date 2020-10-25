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
import java.util.List;


/**
 * 查询所有购物信息
 */
@WebServlet("/findAllShoppingInfoServlet")
public class FindAllShoppingInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        ShoppingInfoDao shoppingInfoDao = new ShoppingInfoDao();

        //查询所有用户购买记录
        List<ShoppingInfo> shoppingInfos = shoppingInfoDao.finAll();
        if (shoppingInfos != null) {
            res.setCode(0);
            res.setMsg("ok");
            res.setData(shoppingInfos);
        } else {
            res.setMsg("error");
        }
        mapper.writeValue(response.getOutputStream(), res);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
