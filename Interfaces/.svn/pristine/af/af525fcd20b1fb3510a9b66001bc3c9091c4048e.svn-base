package cn.springmvc.dao;

import cn.springmvc.model.Function;
import cn.springmvc.model.FunctionCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FunctionMapper {
    long countByExample(FunctionCriteria example);

    int deleteByExample(FunctionCriteria example);

    int deleteByPrimaryKey(String funcid);

    int insert(Function record);

    int insertSelective(Function record);

    List<Function> selectByExample(FunctionCriteria example);

    Function selectByPrimaryKey(String funcid);

    int updateByExampleSelective(@Param("record") Function record, @Param("example") FunctionCriteria example);

    int updateByExample(@Param("record") Function record, @Param("example") FunctionCriteria example);

    int updateByPrimaryKeySelective(Function record);

    int updateByPrimaryKey(Function record);
}