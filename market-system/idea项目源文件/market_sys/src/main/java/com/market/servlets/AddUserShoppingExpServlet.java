package com.market.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.UserDao;
import com.market.domain.ResultInfo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 根据购物信息为用户加相应积分
 */
@WebServlet("/addUserShoppingExpServlet")
public class AddUserShoppingExpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        UserDao userDao = new UserDao();
        try {

            int exp = Integer.parseInt(request.getParameter("exp"));
            int userid = Integer.parseInt(request.getParameter("userid"));

            int state = userDao.addUserShoppingExp(exp,userid);
            if (state > 0) {
                res.setCode(0);
                res.setMsg("OK");
            } else {
                res.setMsg("error");
            }
            mapper.writeValue(response.getOutputStream(), res);
        }catch (Exception e){
            res.setMsg("error");
            mapper.writeValue(response.getOutputStream(), res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
