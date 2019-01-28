package com.itheima.service;

import com.itheima.domain.TbPeriod;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PeriodService {
    List<TbPeriod> findList();

    List<TbPeriod> findByPage();

    TbPeriod findOne(Integer pid);

    void savePeriod(TbPeriod period);

    void addPeriod(MultipartFile excelFile, TbPeriod period) throws Exception;

    int delperiod(Integer bid);
}
