package com.example.ymusic.Service;

import com.example.ymusic.domain.SasLoad;

import java.util.List;


public interface  SasLoadService  {
    List<SasLoad>  getSasLoad();

    SasLoad getSasLoadStatus();

    void updateSasLoadStatus(int id,String taskCode,String status);
}
