package com.market.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.ShoppingInfoDao;
import com.market.domain.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;


/**
 * 查询不同性别会员的消费
 */
@WebServlet("/findCustomerConsumeBySexServlet")
public class FindCustomerConsumeBySexServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        ShoppingInfoDao shoppingInfoDao = new ShoppingInfoDao();

        try{
            Map<String, String> customerConsumeBySex = shoppingInfoDao.findCustomerConsumeBySex();
            if(customerConsumeBySex!=null){
                res.setMsg("ok");
                res.setCode(0);
            }else{
                res.setMsg("error");
            }
            res.setData(customerConsumeBySex);
            mapper.writeValue(response.getOutputStream(),res);
        } catch (SQLException e) {
            e.printStackTrace();
            res.setMsg("error");
            mapper.writeValue(response.getOutputStream(),res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
