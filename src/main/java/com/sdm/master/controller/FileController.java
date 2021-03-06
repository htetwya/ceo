package com.sdm.master.controller;

import com.sdm.master.repository.FileRepository;
import com.sdm.master.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.*;

@Controller
@RequestMapping("/files/")
public class FileController {

    @Autowired
    FileService fileService;

    @Autowired
    FileRepository fileRepository;

    @GetMapping("/{id}/{fileName}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable("id") String id,
            @PathVariable("fileName") String fileName,
            @RequestParam(value = "width",required = false,defaultValue = "0") int width,
            @RequestParam(value = "height",required = false,defaultValue = "0") int height,
            @RequestParam(value = "is64",required = false,defaultValue = "0") boolean is64
    ){
        Dimension dimension = null;
        if(width>0 && height <= 0){
            dimension = new Dimension(width,width);
        }else if(height > 0 && width <= 0){
            dimension = new Dimension(height,height);
        }else if(width > 0 && height > 0){
            dimension = new Dimension(width,height);
        }

        return fileService.downloadFile(id,fileName,dimension,is64,true);
    }

}
