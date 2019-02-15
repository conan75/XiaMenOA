package com.itheima.mapper;

import com.itheima.domain.TbAsset;
import com.itheima.domain.TbAssetExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TbAssetMapper {
    int countByExample(TbAssetExample example);

    int deleteByExample(TbAssetExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbAsset record);

    int insertSelective(TbAsset record);

    List<TbAsset> selectByExample(TbAssetExample example);

    TbAsset selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbAsset record, @Param("example") TbAssetExample example);

    int updateByExample(@Param("record") TbAsset record, @Param("example") TbAssetExample example);

    int updateByPrimaryKeySelective(TbAsset record);

    int updateByPrimaryKey(TbAsset record);
}