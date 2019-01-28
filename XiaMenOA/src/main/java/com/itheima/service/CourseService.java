package com.itheima.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CourseService {

    void addPeriod(MultipartFile excelFile) throws IOException;
}
