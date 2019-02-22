package com.itheima.utils;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.TbAssetType;

import java.util.List;

/**
 * 该工具类是用来封装前台往后台传递的参数
 */
public class AssetTypeVo {
    private List<TbAssetType> secondList;

    @Override
    public String toString() {
        return "AssetTypeVo{" +
                "secondList=" + secondList +
                '}';
    }

    public List<TbAssetType> getSecondList() {
        return secondList;
    }

    public void setSecondList(String secondList) {
        List<TbAssetType> list = JSON.parseArray(secondList, TbAssetType.class);
        this.secondList = list;
    }
}
