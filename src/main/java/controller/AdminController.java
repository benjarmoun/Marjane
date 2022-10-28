package controller;

import DAO.AdminDAo;
import Services.Hash;
import entity.AdminEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class AdminController {
    public static boolean login(String email,String pw) throws Exception {

        List<AdminEntity> lst = AdminDAo.getAllAdmins().stream()
                .filter(admin -> admin.getEmail().equals(email))
                .collect(Collectors.toList());

        if(lst.size()!= 0 && lst.get(0).getPassword().equals(MD5(pw))){
            return true;
        }return false;

    }
    public static boolean ResgisterAdmin(String email, String pw, int storeId) throws Exception {
        AdminEntity admin = new AdminEntity();
        admin.setEmail(email);
        admin.setPassword(Hash.MD5(pw));
        admin.setStoreId(storeId);
        AdminDAo.addAdmin(admin);
        SendMail.sendAccountInfos("benjarmoun123@gmail.com", "Welcome.\nYour email address is "+ email+ " and your password is "+ pw +"");

        return true;
    }

}
