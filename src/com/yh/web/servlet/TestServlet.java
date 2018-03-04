package com.yh.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yh.web.service.TestService;
import com.yh.web.service.TestServiceImpl;
@WebServlet("/test/list")
public class TestServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
       
    TestService testService = new TestServiceImpl();
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        List<Object> list = testService.getTestList();
        PrintWriter out = null;
        System.out.println("list:"+list.toString());
        try {
            out = response.getWriter();
            out.write(list.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        out.flush();
        out.close();
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
