package controller;

import DAO.AdminDAo;
import DAO.RespRayDAO;
import Services.Hash;
import entity.AdminEntity;
import entity.RespRayEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class RespRayController {
    public static RespRayEntity login(String email,String pw) throws Exception {

        List<RespRayEntity> lst = RespRayDAO.getAllRespRay()
                .stream()
                .filter(resp -> resp.getEmail().equals(email))
                .collect(Collectors.toList());

        for(int i =0 ; i< lst.size();i++){
            System.out.println(lst.get(i));
        }

        if(lst.size()!= 0 && lst.get(0).getPassword().equals(MD5(pw))){
            return lst.get(0);
        }return null;

    }
    public static boolean ResgisterRespRay(String email, String pw, int storeId) throws Exception {
        RespRayEntity resp = new RespRayEntity();
        resp.setEmail(email);
        resp.setPassword(Hash.MD5(pw));
        resp.setStoreId(storeId);
        RespRayDAO.addRespRay(resp);
        SendMail.sendAccountInfos("benjarmoun123@gmail.com", "Welcome.\nYour email address is "+ email+ " and your password is "+ pw +"");
        return true;
    }
}
