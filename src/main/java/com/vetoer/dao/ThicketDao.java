package com.vetoer.dao;

import com.vetoer.entity.Thicket;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * The interface Thicket dao.
 */
public interface ThicketDao {
    /**
     * 添加丛林
     *
     * @param tck the tck
     */
    void addThicket(Thicket tck);

    /**
     * 通过id查询丛林信息
     *
     * @param id the id
     * @return the thicket
     */
    Thicket queryById(int id);

    /**
     * 查询所有丛林
     *
     * @param offset the offset  查询起始位置
     * @param limit  the limit   查询数量
     * @return the list
     */
    List<Thicket> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
