package com.vetoer.service.impl;

import com.vetoer.dao.ThicketDao;
import com.vetoer.dto.LeagueExecution;
import com.vetoer.entity.Thicket;
import com.vetoer.entity.ThicketAdmin;
import com.vetoer.enums.LeagueEnum;
import com.vetoer.service.ThicketExecutionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ThicketExecutionServiceImpl implements ThicketExecutionService {
    // 日志对象
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    // 注入service依赖
    @Autowired
    private ThicketDao thicketDao;

    @Override
    public ThicketAdmin queryAdmin(String phone) {
        if(phone!=null){
            ThicketAdmin admin = thicketDao.queryAdminByPhone(phone);
            return admin;
        }
        return null;
    }

    @Override
    public LeagueExecution addAdmin(ThicketAdmin admin) {
        if(admin!=null){
            ThicketAdmin queryAdmin = queryAdmin(admin.getPhone());
            // 该管理员没有注册
            if(queryAdmin==null){
                int result = thicketDao.addAdmin(admin);
                if(result<=0){
                    // 增加后台用户失败
                    return new LeagueExecution(admin.getPhone(), LeagueEnum.REGISTER_FAILED);
                }
                return new LeagueExecution(admin.getPhone(),LeagueEnum.REGISTER_SUCCESS);
            }
        }
        return null;
    }

    @Override
    public LeagueExecution addThicket(Thicket tck) {
        if(tck!=null){
            int result = thicketDao.addThicket(tck);
            // 增加丛林信息成功
            if(result>0){
                return new LeagueExecution(LeagueEnum.SUCCESS,tck);
            }
        }
        return new LeagueExecution(tck.getThicketAdmin().getPhone(),LeagueEnum.FAILED);
    }

    @Override
    public Thicket queryById(int id,int type) {
        Thicket thicket = thicketDao.queryById(id,type);
        return thicket;
    }

    @Override
    public List<Thicket> queryByAdminPhone(String phone,int type) {
        return thicketDao.queryByAdminPhone(phone,type);
    }

    @Override
    public List<Thicket> queryByName(String name) {
        List<Thicket> thicket_list = thicketDao.queryByName(name);
        return thicket_list;
    }
}
