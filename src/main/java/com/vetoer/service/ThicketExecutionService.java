package com.vetoer.service;

import com.vetoer.dto.LeagueExecution;
import com.vetoer.entity.Thicket;
import com.vetoer.entity.ThicketAdmin;

import java.util.List;

public interface ThicketExecutionService {
    // 查询该管理员手机是否已经注册
    ThicketAdmin queryAdmin(String phone);
    // 增加管理员用户
    LeagueExecution addAdmin(ThicketAdmin admin);
    // 加盟丛林闲居
    LeagueExecution addThicket(Thicket tck);
    // 通过给定id查询丛林闲居信息
    Thicket queryById(int id,int type);
    // 通过管理员电话查询加盟的丛林闲居
    List<Thicket> queryByAdminPhone(String phone,int type);
    // 通过给定丛林闲居名查询
    List<Thicket> queryByName(String name);
    // 查询丛林或闲居的数量
    int countThicket(int type);
    // 查询根据限定条件查询
    List<Thicket> queryAll(int offset,int limit,int type);
}
