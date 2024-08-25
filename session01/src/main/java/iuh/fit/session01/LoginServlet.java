package iuh.fit.session01;

import iuh.fit.session01.bean.LoginBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="loginServlet", value = "/doLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getParameter("us");
        Object pass = req.getParameter("pws");
        PrintWriter out = resp.getWriter();
        if(user == null || pass == null) {
            out.println("<html><body>" +
                    "<h1>Username or password are not empty</title>" +
                    "</body>");
        }else {
            LoginBean checkLogin = new LoginBean();
            int res = checkLogin.login(user.toString(), pass.toString());
            if(res == 1) {
                out.println("<html><body>" +
                        "<h1>Login success</title>" +
                        "</body>");
            }
            if(res == 0) {
                out.println("<html><body>" +
                        "<h1>Password invalid</title>" +
                        "</body>");
            }
            if(res == -1) {
                out.println("<html><body>" +
                        "<h1>Username or password invalid</title>" +
                        "</body>");
            }
        }
    }
}
