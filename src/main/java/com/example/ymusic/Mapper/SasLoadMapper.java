package com.example.ymusic.Mapper;

import com.example.ymusic.domain.SasLoad;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SasLoadMapper {
    List<SasLoad> getSasLoad();

    SasLoad getSasLoadStatus();

    void updateSasLoadStatus(int id,String taskCode,String status);
}
