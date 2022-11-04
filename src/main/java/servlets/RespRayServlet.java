package servlets;

import controller.CategorieController;
import controller.PromoController;
import controller.RespRayController;
import controller.SubCatController;
import entity.CategorieEntity;
import entity.PromoEntity;
import entity.RespRayEntity;
import entity.SubCategorieEntity;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "RespRayServlet", value = "*.rr")
public class RespRayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.rr")) {
            req.getRequestDispatcher("/views/responsableRayon/login.jsp").forward(req, resp);
        }

        int testCokie = 0;
        if (path.equals("/dashboard.rr")){
            Cookie[] ck = req.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("respRay")) {
                        testCokie++;
                    }
                }
            }
            if (testCokie == 0) {

                resp.sendRedirect("/login.rr");
            } else {
//                Cookie[] ck = req.getCookies();
                int storeId = 0;
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("respRayStoreId")) {
                        storeId = Integer.parseInt(cookie.getValue());
                        testCokie++;
                    }
                }
                if (path.equals("/dashboard.rr")) {
                    ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getPromosByStoreId(storeId);
                    req.setAttribute("promos", promos);
                    req.getRequestDispatcher("views/responsableRayon/dashboard.jsp").forward(req, resp);
                }

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/login.rr")) {
            try {
                RespRayEntity respRay = RespRayController.login(req.getParameter("email"),req.getParameter("password"));
                if (respRay != null){
                    System.out.println(true);
                    Cookie ck=new Cookie("respRay",String.valueOf(respRay.getEmail()));
                    Cookie co=new Cookie("respRayStoreId",String.valueOf(respRay.getStoreByStoreId().getId()));
                    resp.addCookie(ck);
                    resp.addCookie(co);
                    resp.sendRedirect("/dashboard.rr");
                }else {
                    System.out.println(false);
                    resp.sendRedirect("/login.rr");

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
        if (path.equals("/confirm.rr")){
            System.out.println("test");
            PromoController.confirmPromo(Integer.parseInt(req.getParameter("promoid")));
            System.out.println(req.getParameter("promoid"));
            System.out.println("confirm");
            resp.sendRedirect("/dashboard.rr");
        }
        if (path.equals("/reject.rr")){
            PromoController.rejectPromo(Integer.parseInt(req.getParameter("promoid")));
            resp.sendRedirect("/dashboard.rr");
        }
    }
}
