package com.itheima.controller;

/**
 * Created by geekhoon on 2019/1/16.
 */

import com.itheima.domain.Result;
import com.itheima.utils.FastDFSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * 文件上传Controller
 * @author Administrator
 *
 */
@RestController
public class UploadController {

    @Value("${FILE_SERVER_URL}")
    private String FILE_SERVER_URL;//文件服务器地址

    @Autowired
    ArrayList<String> list;

    @RequestMapping("/upload")
    public Result upload(MultipartFile file){
        System.out.println(list);
        //1、取文件的扩展名
        String originalFilename = file.getOriginalFilename();
        String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        try {
            //2、创建一个 FastDFS 的客户端
            FastDFSClient fastDFSClient = new FastDFSClient("classpath:config/fdfs_client.conf");
            //3、执行上传处理
            String path = fastDFSClient.uploadFile(file.getBytes(), extName);
            //4、拼接返回的 url 和 ip 地址，拼装成完整的 url
            String url = FILE_SERVER_URL + path;
            //System.out.println(url);
            Result result = new Result();
            result.setSuccess(true);
            list.add(url);
            System.out.println(list);
            return new Result(true,list);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, null);
        }
    }
}

