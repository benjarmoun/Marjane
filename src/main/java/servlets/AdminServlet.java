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

@WebServlet(name = "AdminServlet", value = "*.ad")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if (path.equals("/login.ad")) {
            req.getRequestDispatcher("views/admin/login.jsp").forward(req, resp);
        }


        int testCokie = 0;
        if (path.equals("/dashboard.ad") || path.equals("/addpromo.ad")){
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
                    ArrayList<PromoEntity> promos = (ArrayList<PromoEntity>) PromoController.getPromosByStoreId(storeId);
                    req.setAttribute("promos", promos);
                    req.getRequestDispatcher("views/admin/dashboard.jsp").forward(req, resp);
                } else if (path.equals("/addpromo.ad")) {
                    ArrayList<CategorieEntity> cat = (ArrayList<CategorieEntity>) CategorieController.getAllCategories();
                    req.setAttribute("cat", cat);
                    ArrayList<SubCategorieEntity> subCat = (ArrayList<SubCategorieEntity>) SubCatController.getAllSubCategories();
                    subCat.forEach(subCategorieEntity -> System.out.println(subCategorieEntity.getName()));
                    req.setAttribute("subCat", subCat);

                    req.getRequestDispatcher("views/admin/addPromo.jsp").forward(req, resp);
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

        if (path.equals("/addpromo.ad")){

        }
    }
}
