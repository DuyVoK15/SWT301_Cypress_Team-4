/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieu.dto;

import hieu.dao.AccountDao;
import hieu.dao.PlantDao;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class TestConnection {

    public static void main(String[] arg) {
//        Account acc = AccountDao.geAccounts("test1@gmail.com", "test");
//        if (acc != null) {
//            if (acc.getRole() == 1) {
//                System.out.println("i am an test1");
//            } else {
//                System.out.println("i am a user");
//            }
//        } else {
//            System.out.println("login fail");
//        }
//        ArrayList<Account> list = AccountDao.getAccounts();
//        for (Account account : list) {
//            System.out.println(account.toString());
//        }
//        if (AccountDao.updateAccountStatus(4, 0) == true) {
//            System.out.println("Updated");
//        } else {
//            System.out.println("Update profile fail");
//        }
////        if (AccountDao.updateAccount("test@gmail.com", "testt", "testt", "654321") == true) {
////            System.out.println("Updated");
////        } else {
////            System.out.println("Update profile fail");
////        }
////        if (AccountDao.insertAccount("test4@gmail.com", "test4", "test4", "123456", 1, 0)) {
////            System.out.println("Added");
////        } else {
////            System.out.println("insert a new account fail");
////        }
//
//        ArrayList<Plant> list2 = PlantDao.getPlants( "vanda", "byname");
//        for (Plant plant : list2) {
//            System.out.println(plant.toString());
//        }
        ArrayList<Account> list2 = AccountDao.getAccountList("", "");
        for (Account account : list2) {
            System.out.println(account.toString());
        }

    }

}
