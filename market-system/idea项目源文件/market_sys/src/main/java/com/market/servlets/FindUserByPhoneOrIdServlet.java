package com.market.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.market.dao.ShoppingInfoDao;
import com.market.dao.UserDao;
import com.market.domain.ResultInfo;
import com.market.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 根据手机号或会员id查询用户
 */
@WebServlet("/findUserByPhoneOrIdServlet")
public class FindUserByPhoneOrIdServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //响应体数据类型,编码格式
        response.setContentType("application/json;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        ResultInfo res = new ResultInfo();
        ObjectMapper mapper = new ObjectMapper();
        UserDao userDao = new UserDao();

        try{
            String phone_or_id = request.getParameter("phone_or_id");

            User u = userDao.findByPhoneOrId(phone_or_id);
            int level = userDao.getUserLevel(u);

            if(u!=null){
                u.setLevel(level);
                res.setCode(0);
                res.setMsg("ok");
                res.setData(u);
            }else{
                res.setCode(-1);
                res.setMsg("error, 改用户不存或查询信息有误");
                res.setData(null);
            }

            mapper.writeValue(response.getOutputStream(),res);
        }catch (Exception e){
            res.setCode(-1);
            res.setMsg("error, 改用户不存或查询信息有误");
            res.setData(null);
            mapper.writeValue(response.getOutputStream(),res);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
