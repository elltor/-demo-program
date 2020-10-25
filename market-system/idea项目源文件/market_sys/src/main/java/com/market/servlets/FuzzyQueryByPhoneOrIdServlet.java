package com.market.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.UserDao;
import com.market.domain.ResultInfo;
import com.market.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 模糊查询用户，根据用户名、手机号码、id
 */
@WebServlet("/fuzzyQueryByPhoneOrIdServlet")
public class FuzzyQueryByPhoneOrIdServlet extends HttpServlet {
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
            String keyWords = request.getParameter("keyWords");
            System.out.println("keywords:"+keyWords);

            List<User> userList = userDao.fuzzyQueryByPhoneOrid(keyWords);

            if (userList != null) {
                res.setCode(0);
                res.setMsg("ok");
                res.setData(userList);
                mapper.writeValue(response.getOutputStream(), res);
                return;
            } else {
                res.setMsg("error");
                mapper.writeValue(response.getOutputStream(), res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg("error");
            mapper.writeValue(response.getOutputStream(), res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
