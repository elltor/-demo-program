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

/**
 * 删除当前订单
 */
@WebServlet("/deleteNowOrderServlet")
public class DeleteNowOrderServlet extends HttpServlet {
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
            String order_id = request.getParameter("order_id");
            int state = shoppingInfoDao.delByOrderId(order_id);
            if(state>0){
                res.setCode(0);
                res.setMsg("ok");
            }else{
                res.setCode(-1);
                res.setMsg("error");
            }
            mapper.writeValue(response.getOutputStream(),res);
        }catch (Exception e){
            e.printStackTrace();
            res.setMsg("error");
            mapper.writeValue(response.getOutputStream(),res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
