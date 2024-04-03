package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemoryUserRepository memoryUserRepository = MemoryUserRepository.getInstance();
        User findUser = memoryUserRepository.findUserById(request.getParameter("userId"));

        //로그인 실패
        if(findUser==null || !(request.getParameter("password").equals(findUser.getPassword()))){
            return "redirect:/user/login_failed.jsp";
        }

        /**
         * 로그인 성공
         * 사용자 정보를 세션에 저장하고, 클라이언트에게는 쿠키를 통해 세션 식별자를 할당
         * Cookie: JSESSIONID=8803DFDD3F9F6039CB8826233009E890
         */
        HttpSession session = request.getSession();
        session.setAttribute("user",findUser);

        return "redirect:/";
    }
}
