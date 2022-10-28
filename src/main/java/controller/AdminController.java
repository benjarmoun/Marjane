package controller;

import DAO.AdminDAo;
import entity.AdminEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class AdminController {
    public static boolean login(String email,String pw) throws Exception {

        List<AdminEntity> lst = AdminDAo.getAllAdmins().stream()
                .filter(admin -> admin.getEmail().equals(email))
                .collect(Collectors.toList());

        if(lst.get(0).getPassword().equals(MD5(pw))){
            return true;
        }return false;

    }
    public static void ResgisterAdmin(AdminEntity admin){
        AdminDAo.addAdmin(admin);
    }

}
