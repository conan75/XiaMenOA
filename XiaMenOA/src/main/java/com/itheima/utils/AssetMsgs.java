package com.itheima.utils;

import com.itheima.domain.TbAsset;
import com.itheima.domain.TbAssetType;

public class AssetMsgs {
    private TbAsset asset;
    private TbAssetType assetType;

    @Override
    public String toString() {
        return "AssetMsgs{" +
                "asset=" + asset +
                ", assetType=" + assetType +
                '}';
    }

    public TbAsset getAsset() {
        return asset;
    }

    public void setAsset(TbAsset asset) {
        this.asset = asset;
    }

    public TbAssetType getAssetType() {
        return assetType;
    }

    public void setAssetType(TbAssetType assetType) {
        this.assetType = assetType;
    }
}
