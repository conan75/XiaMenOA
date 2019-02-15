package com.itheima.mapper;

import com.itheima.domain.TbAssetType;
import com.itheima.domain.TbAssetTypeExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TbAssetTypeMapper {
    int countByExample(TbAssetTypeExample example);

    int deleteByExample(TbAssetTypeExample example);

    int deleteByPrimaryKey(Integer typeId);

    int insert(TbAssetType record);

    int insertSelective(TbAssetType record);

    List<TbAssetType> selectByExample(TbAssetTypeExample example);

    TbAssetType selectByPrimaryKey(Integer typeId);

    int updateByExampleSelective(@Param("record") TbAssetType record, @Param("example") TbAssetTypeExample example);

    int updateByExample(@Param("record") TbAssetType record, @Param("example") TbAssetTypeExample example);

    int updateByPrimaryKeySelective(TbAssetType record);

    int updateByPrimaryKey(TbAssetType record);

    @Update("truncate table tb_asset_type")
    void truncate();

    @Select("select count(1) from tb_asset_type where type_name=#{typeName} and parent_id=#{parentId}")
    int selectTypeName(@Param("typeName") String typeName,@Param("parentId")int parentId);

    @Select("select max(type_id) from tb_asset_type")
    int selectMaxId();

    @Select("select type_id from tb_asset_type where type_name=#{typeName} and parent_id=#{parentId}")
    Integer selectIdByTypeName(@Param("typeName") String stringCellValue, @Param("parentId") int parentId);

    @Select("select parent_id from tb_asset_type where type_id=#{typeId}")
    Integer selectParentIdById(Integer typeId);

    /**
     * 该注解sql无法使用
     * @param parentId
     * @return
     */
    @Select("select * from tb_asset_type where type_id=#{parentId}")
    TbAssetType selectByTypeId(Integer parentId);
}