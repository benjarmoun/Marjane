package controller;

import DAO.AdminDAo;
import DAO.RespRayDAO;
import entity.AdminEntity;
import entity.RespRayEntity;

import java.util.List;
import java.util.stream.Collectors;

import static Services.Hash.MD5;

public class RespRayController {
    public static boolean login(String email,String pw) throws Exception {

        List<RespRayEntity> lst = RespRayDAO.getAllRespRay().stream()
                .filter(resp -> resp.getEmail().equals(email))
                .collect(Collectors.toList());

        if(lst.get(0).getPassword().equals(MD5(pw))){
            return true;
        }return false;

    }
}
