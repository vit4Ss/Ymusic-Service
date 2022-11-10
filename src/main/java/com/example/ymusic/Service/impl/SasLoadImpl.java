package com.example.ymusic.Service.impl;

import com.example.ymusic.Mapper.SasLoadMapper;
import com.example.ymusic.Service.SasLoadService;
import com.example.ymusic.domain.SasLoad;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SasLoadImpl implements SasLoadService {

    @Autowired
    SasLoadMapper sasLoadMapper;

    @Override
    public List<SasLoad> getSasLoad() {
        return sasLoadMapper.getSasLoad();
    }

    public SasLoad getSasLoadStatus(){
        return sasLoadMapper.getSasLoadStatus();
    }

    public void updateSasLoadStatus(int id,String taskCode,String status){
        sasLoadMapper.updateSasLoadStatus(id,taskCode,status);
        log.info("修改了taskCode:{},id:{}",taskCode,id);
    };

}
