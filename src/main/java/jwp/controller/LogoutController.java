package jwp.controller;

import core.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogoutController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //세션 데이터 삭제
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "redirect:/";
    }
}
