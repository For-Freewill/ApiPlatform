package cn.springmvc.dao;

import cn.springmvc.model.Funcrole;
import cn.springmvc.model.FuncroleCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FuncroleMapper {
    long countByExample(FuncroleCriteria example);

    int deleteByExample(FuncroleCriteria example);

    int deleteByPrimaryKey(String funcroleid);

    int insert(Funcrole record);

    int insertSelective(Funcrole record);

    List<Funcrole> selectByExample(FuncroleCriteria example);

    Funcrole selectByPrimaryKey(String funcroleid);

    int updateByExampleSelective(@Param("record") Funcrole record, @Param("example") FuncroleCriteria example);

    int updateByExample(@Param("record") Funcrole record, @Param("example") FuncroleCriteria example);

    int updateByPrimaryKeySelective(Funcrole record);

    int updateByPrimaryKey(Funcrole record);
}