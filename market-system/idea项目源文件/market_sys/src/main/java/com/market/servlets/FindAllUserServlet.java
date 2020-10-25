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
 * 查询所有用户
 */
@WebServlet("/findAllUserServlet")
public class FindAllUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        UserDao userDao = new UserDao();

        List<User> userList = userDao.findAll();
        for(int i=0;i<userList.size();i++){
            userList.get(i).setLevel(userDao.getUserLevel(userList.get(i)));
        }

        ObjectMapper mapper = new ObjectMapper();

        ResultInfo res = new ResultInfo();
        res.setMsg("ok");
        res.setCode(0);
        res.setData(userList);
        mapper.writeValue(response.getOutputStream(),res);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
