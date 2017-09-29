package com.vetoer.dao;

import com.vetoer.BaseTest;
import com.vetoer.entity.Thicket;
import com.vetoer.entity.ThicketAdmin;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ThicketDaoTest extends BaseTest {
    @Autowired
    private ThicketDao thicketDao;

    @Test
    public void testAddThicket(){
        ThicketAdmin admin = new ThicketAdmin();
        admin.setAdminId(1);
        admin.setName("tg");
        admin.setPhone("118828");
        admin.setPassword("1111");
        Thicket thicket = new Thicket();
        thicket.setName("江西理工大学-南昌校区");
        thicket.setSiteType("国内");
        thicket.setAddressType("闲居");
        thicket.setAddress("sss");
        thicket.setPrice(112.9);
        thicket.setState(1);
        thicket.setType(0);
        thicket.setThicketAdmin(admin);
//        int adminresult = thicketDao.addAdmin(admin);
//        System.out.println("----------");
//        System.out.println(adminresult);
        int result = thicketDao.addThicket(thicket);
        System.out.println("-------------");
        System.out.println(result);
    }
    @Test
    public void testqueryById(){
        int id = 2;
        int type=1;
        Thicket thicket = thicketDao.queryById(id,type);
        System.out.println(thicket);
    }
    @Test
    public void testqueryAdmin(){
        String phone = "118828";
        ThicketAdmin admin = thicketDao.queryAdminByPhone(phone);
        System.out.println(admin);
    }
    @Test
    public void testqueryByName(){
        String name = "%江西理工%";
        List<Thicket> thickets = thicketDao.queryByName(name);
        for(Thicket thicket:thickets){
            System.out.println(thicket);
        }
    }
    @Test
    public void testqueryAdminThicket(){
        String phone = "118828";
        int type=0;
        List<Thicket> thicket_list = thicketDao.queryByAdminPhone(phone,type);
        for(Thicket thicket:thicket_list){
            System.out.println(thicket);
        }
    }
}
