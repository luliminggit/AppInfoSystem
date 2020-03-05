package com.team.appinfo.mapper;

import com.team.appinfo.entity.DataDictionary;
import com.team.appinfo.entity.DataDictionaryExample;
import java.util.List;

public interface DataDictionaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataDictionary record);

    int insertSelective(DataDictionary record);

    List<DataDictionary> selectByExample(DataDictionaryExample example);

    DataDictionary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataDictionary record);

    int updateByPrimaryKey(DataDictionary record);

    List<DataDictionary> getStatus();

    List<DataDictionary> getFlatFrom();
}