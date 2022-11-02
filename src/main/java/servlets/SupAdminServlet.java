package servlets;

import controller.PromoController;
import controller.SupAdminController;
import entity.PromoEntity;
import entity.SupAdminEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "SupAdminServlet", value = "*.sup")


public class SupAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/loginsup.sup")) {
            req.getRequestDispatcher("views/supAdmin/login.jsp").forward(req, resp);
        }

        int testCokie = 0;
        if (path.equals("/dashsup.sup")) {
            Cookie[] ck = req.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("supadmin")) {
                        testCokie++;
                    }
                }
            }
            if (testCokie == 0) {

                resp.sendRedirect("/loginsup.sup");
            } else {
                ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getAllCurrentPromos();
//                System.out.println();
                req.setAttribute("promos", promos);
                req.getRequestDispatcher("views/supAdmin/dashboard.jsp").forward(req, resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/loginsup.sup")) {
            try {
                System.out.println("test");
                SupAdminEntity supadmin = SupAdminController.login(req.getParameter("email"),req.getParameter("password"));
                if (supadmin != null){
                    System.out.println(true);
                    Cookie ck=new Cookie("supadmin",String.valueOf(supadmin.getEmail()));
                    resp.addCookie(ck);
                    resp.sendRedirect("/dashsup.sup");
                }else {
                    System.out.println(false);
                    resp.sendRedirect("/loginsup.sup");

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
    }
}
