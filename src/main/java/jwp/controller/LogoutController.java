package jwp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/logout")
public class LogoutController extends HttpServlet {

    /**
     * 세션은 고유한 식별자를 가지기 때문에 쿠키값으로 들어온 sessionId로 세션을 찾고,
     * 해당 세션에서 key 값이 "user"인 value 를 찾는 과정을 거친다.
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //세션 데이터 삭제
        HttpSession session = req.getSession();
        session.removeAttribute("user");

        resp.sendRedirect("/");
    }
}