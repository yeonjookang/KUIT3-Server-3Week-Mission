package jwp.controller;


import core.db.MemoryUserRepository;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/")
public class HomeController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Servlet 3.0이상부터 Tomcat은 웹 애플리케이션의 루트 경로에서 index.html, index.jsp, index.htm 등과 같은 디폴트 문서를 찾아서 응답
        RequestDispatcher rd = req.getRequestDispatcher("/home.jsp");
        HttpSession session = req.getSession();
        rd.forward(req,resp);
    }
}
