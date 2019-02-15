package com.itheima.service;

import com.itheima.domain.TbAsset;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AssetService {
    List<TbAsset> findByPage();

    void fixedAssetImport(MultipartFile excelFile) throws IOException;

    void lowAssetImport(MultipartFile excelFile) throws IOException;

    void assetTypeImport(MultipartFile excelFile) throws IOException;

    List findAssetMsgs(List<TbAsset> list);
}
