package com.vetoer.dao;

import com.vetoer.entity.Thicket;
import com.vetoer.entity.ThicketAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Thicket dao.
 */

/**
 * 传入type值判断查询丛林还是闲居
 */
public interface ThicketDao {
    /**
     * 查找后台用户是否存在
     */
    ThicketAdmin queryAdminByPhone(String phone);

    /**
     * 添加管理员用户
     */
    int addAdmin(ThicketAdmin admin);

    /**
     * 添加丛林或闲居
     *
     * @param tck the tck
     */
    int addThicket(Thicket tck);

    /**
     * 通过id查询丛林闲居信息
     *
     * @param id the id
     * @return the thicket
     */
    Thicket queryById(@Param("id")int id,@Param("type")int type);

    /**
     * 通过用户电话查询他旗下的丛林闲居
     * @param phone
     * @return
     */
    List<Thicket> queryByAdminPhone(@Param("phone")String phone,@Param("type")int type);

    /**
     * 通过丛林闲居名查询
     */
    List<Thicket> queryByName(String name);

    /**
     * 查询丛林或闲居的总数量
     * @param type
     * @return
     */
    int countThicket(int type);

    /**
     * 查询所有丛林闲居
     *
     * @param offset the offset  查询起始位置
     * @param limit  the limit   查询数量
     * @return the list
     */
    List<Thicket> queryAll(@Param("offset") int offset, @Param("limit") int limit,@Param("type")int type);
}
