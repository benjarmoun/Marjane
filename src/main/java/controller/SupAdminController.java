package controller;

import DAO.AdminDAo;
import DAO.SupAdminDAO;
import entity.AdminEntity;
import entity.SupAdminEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class SupAdminController {
    public static boolean login(String email,String pw) throws Exception {

        List<SupAdminEntity> lst = SupAdminDAO.getAllAdmins().stream()
                .filter(supAdmin -> supAdmin.getEmail().equals(email))
                .collect(Collectors.toList());

        for(int i =0 ; i< lst.size();i++){
            System.out.println(lst.get(i));
        }

        if(lst.size()!= 0 && lst.get(0).getPassword().equals(MD5(pw))){
            return true;
        }return false;

    }
}
