package com.weidai.data.mapper;

import com.weidai.data.model.TExample;
import java.util.List;

public interface TExampleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TExample record);

    TExample selectByPrimaryKey(Integer id);

    List<TExample> selectAll();

    int updateByPrimaryKey(TExample record);
}