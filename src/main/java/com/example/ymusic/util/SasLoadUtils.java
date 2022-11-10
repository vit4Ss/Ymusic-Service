package com.example.ymusic.util;

import com.example.ymusic.Service.SasLoadService;
import com.example.ymusic.domain.SasLoad;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Slf4j
@Component
public class SasLoadUtils {

    final
    SasLoadService sasLoadService;

    public SasLoadUtils(SasLoadService sasLoadService) {
        this.sasLoadService = sasLoadService;
    }

    public void getSasLoadStatus(SasLoad sasLoad){
        log.info("调用了");
        sasLoad.setStatus("running");
        sasLoadService.updateSasLoadStatus(sasLoad.getId(),sasLoad.getTaskCode(),sasLoad.getStatus());
        log.info("修改了id:{}",sasLoad.getId());
    }
}
