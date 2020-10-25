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
 * 删除用户
 */
@WebServlet("/deleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        int userid = Integer.parseInt(request.getParameter("userid"));
        UserDao userDao = new UserDao();

        try {
            int state = userDao.delete(userid);

            if (state > 0) {
                System.out.println(state);
                res.setCode(0);
                res.setMsg("删除成功");
                mapper.writeValue(response.getOutputStream(), res);
            } else {
                res.setMsg("删除失败");
                mapper.writeValue(response.getOutputStream(), res);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.setMsg("删除失败");
            mapper.writeValue(response.getOutputStream(), res);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
