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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "AdminServlet", value = "*.ad")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.ad")) {
            req.getRequestDispatcher("views/admin/login.jsp").forward(req, resp);
        }


        int testCokie = 0;
        if (path.equals("/dashboard.ad") || path.equals("/addpromo.ad") || path.equals("/addrespray.ad")){
            Cookie[] ck = req.getCookies();
            if (ck != null) {
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("admin")) {
                        testCokie++;
                    }
                }
            }
            if (testCokie == 0) {

                resp.sendRedirect("/login.ad");
            } else {
//                Cookie[] ck = req.getCookies();
                int storeId = 0;
                for (Cookie cookie : ck) {
                    if (cookie.getName().equals("adminStoreId")) {
                        storeId = Integer.parseInt(cookie.getValue());
                        testCokie++;
                    }
                }
                if (path.equals("/dashboard.ad")) {
                    ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getPromosByStoreIdForAdmins(storeId);
                    req.setAttribute("promos", promos);
                    req.getRequestDispatcher("views/admin/dashboard.jsp").forward(req, resp);
                } else

                    if (path.equals("/addpromo.ad")) {
                    ArrayList<CategorieEntity> cat = (ArrayList<CategorieEntity>) CategorieController.getAllCategories();
                    req.setAttribute("cat", cat);
                    ArrayList<SubCategorieEntity> subCat = (ArrayList<SubCategorieEntity>) SubCatController.getAllSubCategories();
//                    subCat.forEach(subCategorieEntity -> System.out.println(subCategorieEntity.getName()));
                    req.setAttribute("subCat", subCat);

                    LocalDate date = LocalDate.now();
//                    System.out.println("date:"+date);
                    req.setAttribute("date", date);

                    req.getRequestDispatcher("views/admin/addPromo.jsp").forward(req, resp);
                } else

                    if (path.equals("/addrespray.ad")) {

                        req.getRequestDispatcher("views/admin/addRespRay.jsp").forward(req, resp);
                    }
            }
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/login.ad")) {
            try {
                AdminEntity admin = AdminController.login(req.getParameter("email"),req.getParameter("password"));
                if (admin != null){
                    System.out.println(true);
                    Cookie ck=new Cookie("admin",String.valueOf(admin.getEmail()));
                    Cookie co=new Cookie("adminStoreId",String.valueOf(admin.getStoreByStoreId().getId()));
                    resp.addCookie(ck);
                    resp.addCookie(co);
                    resp.sendRedirect("/dashboard.ad");
                }else {
                    System.out.println(false);
                    resp.sendRedirect("/login.ad");

                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (path.equals("/logout.ad")) {
            Cookie Remove = new Cookie("admin", "");
            Remove.setMaxAge(0);
            resp.addCookie(Remove);
            Cookie RemoveId = new Cookie("adminStoreId", "");
            RemoveId.setMaxAge(0);
            resp.addCookie(RemoveId);
            resp.sendRedirect("/login.ad");

        }

        Cookie[] ck = req.getCookies();
        if (path.equals("/addpromo.ad")){
            int storeId = 0;
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("adminStoreId")) {
                    storeId = Integer.parseInt(cookie.getValue());
                }
            }

            int catid = Integer.parseInt(req.getParameter("category"));
            int val = Integer.parseInt(req.getParameter("value"));
            LocalDate start = LocalDate.parse(req.getParameter("startdate"));
            LocalDate end = LocalDate.parse(req.getParameter("enddate"));
            PromoController.createPromo(catid,val,start,end,storeId);

            resp.sendRedirect("/addpromo.ad");



        }

        if (path.equals("/addrespray.ad")){

            int storeId = 0;
            for (Cookie cookie : ck) {
                if (cookie.getName().equals("adminStoreId")) {
                    storeId = Integer.parseInt(cookie.getValue());
                }
            }

            try {
                String email = req.getParameter("email");
                String pw = req.getParameter("pw");
                RespRayController.ResgisterRespRay(email,pw,storeId);

                resp.sendRedirect("/dashboard.ad");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        if (path.equals("/delete.ad")){
            int id = Integer.parseInt(req.getParameter("promoid"));
            PromoController.deletePromo(id);
            resp.sendRedirect("/dashboard.ad");
        }
    }
}
