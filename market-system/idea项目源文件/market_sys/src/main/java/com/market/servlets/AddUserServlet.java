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
import java.util.Calendar;

/**
 * 添加用户
 */
@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
    UserDao userDao = new UserDao();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();

        try {
            //从ajax中获得请求参数
            String username = String.valueOf(request.getParameter("username"));
            int sex = Integer.parseInt(request.getParameter("sex"));
            int age = Integer.parseInt(String.valueOf(request.getParameter("age")));
            String phone = String.valueOf(request.getParameter("phone"));
            String work_unit = String.valueOf(request.getParameter("work_unit"));
            System.out.println("sex:"+sex);

            User u = new User();
            u.setUsername(username);
            u.setSex(sex);
            u.setAge(age);
            u.setWork_unit(work_unit);
            u.setPhone(phone);
            u.setCreate_date(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            u.setUser_exp(0);

            //往数据库中添加用户
            int state = userDao.add(u);

            if (state > 0) {
                System.out.println(state);
                res.setCode(0);
                res.setMsg("会员注册成功");
                mapper.writeValue(response.getOutputStream(), res);
            } else {
                res.setMsg("注册失败");
                mapper.writeValue(response.getOutputStream(), res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg("注册失败");
            mapper.writeValue(response.getOutputStream(), res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
