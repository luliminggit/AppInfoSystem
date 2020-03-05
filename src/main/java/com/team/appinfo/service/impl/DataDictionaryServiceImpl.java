package com.team.appinfo.service.impl;

import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.mapper.DataDictionaryMapper;
import com.team.appinfo.service.DataDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
    @Autowired
    private DataDictionaryMapper dataDictionaryMapper;

    @Override
    public List<DataDictionary> getStatus() {
        return dataDictionaryMapper.getStatus();

    }

    @Override
    public List<DataDictionary> getFlatFrom() {
        return dataDictionaryMapper.getFlatFrom();
    }
}
