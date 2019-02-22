package com.itheima.service;

import com.itheima.domain.TbAsset;
import com.itheima.domain.TbAssetType;
import com.itheima.utils.AssetMsgs;
import com.itheima.utils.AssetSearch;
import com.itheima.utils.PageResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AssetService {
    PageResult findByPage();

    void fixedAssetImport(MultipartFile excelFile) throws IOException;

    void lowAssetImport(MultipartFile excelFile) throws IOException;

    void assetTypeImport(MultipartFile excelFile) throws IOException;

    List findAssetMsgs(List<TbAsset> list);

    PageResult search(AssetSearch assetSearch, List<Integer> idList);

    List<Integer> selectAllByParentId(String typeName);

    List<TbAssetType> selectAllByIdList(List<Integer> idList);

    List<TbAssetType> selectAllByIdList(List<TbAssetType> secondList, Integer secondTypeName);

    void assetAdd(TbAsset asset);

    TbAsset findOne(Integer id);

    AssetMsgs findAssetMsgs(TbAsset asset);

    void del(Integer id, Integer useableFlag);
}
