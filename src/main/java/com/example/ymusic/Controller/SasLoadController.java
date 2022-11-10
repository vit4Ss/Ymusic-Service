package com.example.ymusic.Controller;

import com.example.ymusic.Service.SasLoadService;
import com.example.ymusic.domain.SasLoad;
import com.example.ymusic.util.SasLoadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
@Controller
@Slf4j
@RequestMapping("/")
public class SasLoadController {
    final
    SasLoadService sasLoadService;
    SasLoadUtils sasLoadUtils;

    public SasLoadController(SasLoadService sasLoadService,SasLoadUtils sasLoadUtils) {
        this.sasLoadService = sasLoadService;
        this.sasLoadUtils = sasLoadUtils;
    }

    @RequestMapping("/")
    public List<SasLoad> getSasInfo(){
        return sasLoadService.getSasLoad();
}

@RequestMapping("/test")
    public SasLoad getSasLoadStatus(){
        SasLoad sasLoad = sasLoadService.getSasLoadStatus();
        System.out.println("sasLoad===================================="+sasLoad+"================================================");
        sasLoadUtils.getSasLoadStatus(sasLoad);
        //sasLoad.setStatus("running");
        //sasLoadService.updateSasLoadStatus(sasLoad.getId(),sasLoad.getTaskCode(),sasLoad.getStatus());
        log.info("{}",sasLoadService.getSasLoadStatus());
        return sasLoadService.getSasLoadStatus();
    }
}

