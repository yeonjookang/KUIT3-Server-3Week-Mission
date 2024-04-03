package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ListUserController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Object value = session.getAttribute("user");
        if(value==null){
            return "redirect:/users/loginForm";
        }
        User findUser = (User) value;
        request.setAttribute("users", MemoryUserRepository.getInstance().findAll());
        request.setAttribute("user",findUser);
        return "/user/list.jsp";
    }
}
