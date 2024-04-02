package jwp.controller;

import core.db.MemoryUserRepository;
import jwp.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();
        User findUser = memoryUserRepository.findUserById(req.getParameter("userId"));

        //로그인 실패
        if(findUser==null || !(req.getParameter("password").equals(findUser.getPassword()))){
            resp.sendRedirect("/user/login_failed.jsp");
            return;
        }

        /**
         * 로그인 성공
         * 사용자 정보를 세션에 저장하고, 클라이언트에게는 쿠키를 통해 세션 식별자를 할당
         * Cookie: JSESSIONID=8803DFDD3F9F6039CB8826233009E890
         */
        HttpSession session = req.getSession();
        session.setAttribute("user",findUser);

        resp.sendRedirect("/");
    }
}
