package cn.springmvc.dao;

import cn.springmvc.model.Dept;
import cn.springmvc.model.DeptCriteria;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeptMapper {
    long countByExample(DeptCriteria example);

    int deleteByExample(DeptCriteria example);

    int deleteByPrimaryKey(String deptid);

    int insert(Dept record);

    int insertSelective(Dept record);

    List<Dept> selectByExample(DeptCriteria example);

    Dept selectByPrimaryKey(String deptid);

    int updateByExampleSelective(@Param("record") Dept record, @Param("example") DeptCriteria example);

    int updateByExample(@Param("record") Dept record, @Param("example") DeptCriteria example);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
}