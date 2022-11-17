package servlets;

import controller.*;
import entity.*;
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
        if (path.equals("/dashsup.sup") || path.equals("/addadmin.sup") || path.equals("/admins.sup") || path.equals("/promos.sup")) {
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
            } else

                if (path.equals("/dashsup.sup")){
                    ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getAllCurrentPromos();

                    req.setAttribute("promos", promos);

                    int sotresStats = StoreController.getNumberOfStores();
                    try {
                        int adminsStats = AdminController.getAll().size();
                        req.setAttribute("adminsStats",adminsStats);

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    req.setAttribute("sotresStats",sotresStats);

                    int respRayStats = RespRayController.getAll().size();
                    req.setAttribute("respRayStats",respRayStats);


                    req.getRequestDispatcher("views/supAdmin/dashboard.jsp").forward(req, resp);
            } else

                if (path.equals("/promos.sup")){
                    ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getAllCurrentPromos();
                    req.setAttribute("promos", promos);
                    req.getRequestDispatcher("views/supAdmin/promos.jsp").forward(req, resp);
                } else

                if (path.equals("/addadmin.sup")) {
                    ArrayList<StoreEntity> store = (ArrayList<StoreEntity>) StoreController.getAllStores();
                    req.setAttribute("store", store);
                    req.getRequestDispatcher("views/supAdmin/addAdmin.jsp").forward(req, resp);

            }else

                if (path.equals("/admins.sup")){
                    try {
                        ArrayList<AdminEntity> admins = (ArrayList<AdminEntity>) AdminController.getAll();
                        req.setAttribute("admins", admins);
                        req.getRequestDispatcher("views/supAdmin/admins.jsp").forward(req, resp);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/loginsup.sup")) {
            try {
                SupAdminEntity supadmin = SupAdminController.login(req.getParameter("email"),req.getParameter("password"));
                if (supadmin != null){
                    Cookie ck=new Cookie("supadmin",String.valueOf(supadmin.getEmail()));
                    resp.addCookie(ck);
                    resp.sendRedirect("/dashsup.sup");
                }else {
                    resp.sendRedirect("/loginsup.sup");
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (path.equals("/logout.sup")) {

            Cookie userNameCookieRemove = new Cookie("supadmin", "");
            userNameCookieRemove.setMaxAge(0);
            resp.addCookie(userNameCookieRemove);
            resp.sendRedirect("/loginsup.sup");

        }

        if(path.equals("/addadmin.sup")){

            String email = req.getParameter("email");
            String pw = req.getParameter("pw");
            int storeId = Integer.parseInt(req.getParameter("store"));
            try {
                AdminController.ResgisterAdmin(email,pw,storeId);
                resp.sendRedirect("/dashsup.sup");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }



        }
    }
}
