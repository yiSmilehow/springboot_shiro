package com.shiroapache.mapper;

import com.shiroapache.pojo.Resources;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ResourcesMapper {

    /**
     * 查询所有的资源权限 状态有效、且按sortnum升序排序
     */
    @Select("  select * from resources where `status`=1 ORDER BY sortnum asc ")
    List<Resources> selectAllByStatusAndSortNumAsc();

}
