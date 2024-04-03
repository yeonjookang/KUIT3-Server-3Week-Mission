package jwp.controller;

import core.db.MemoryUserRepository;
import core.mvc.Controller;
import jwp.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UpdateUserFormController implements Controller {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        User findUser = MemoryUserRepository.getInstance().findUserById(userId);

        HttpSession session = request.getSession();
        User sessionUser = (User)session.getAttribute("user");
        if(sessionUser==null || !(sessionUser.isSameUser(findUser))){
            return "redirect:/";
        }
        request.setAttribute("user",findUser);
        return "redirect:/user/updateForm.jsp";
    }
}
