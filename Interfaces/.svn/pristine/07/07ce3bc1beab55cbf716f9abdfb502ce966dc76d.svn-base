package cn.springmvc.dao;

import cn.springmvc.model.TestResult;
import cn.springmvc.model.TestResultCriteria;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestResultMapper {
    long countByExample(TestResultCriteria example);

    int deleteByExample(TestResultCriteria example);

    int deleteByPrimaryKey(Date runtime);

    int insert(TestResult record);

    int insertSelective(TestResult record);

    List<TestResult> selectByExample(TestResultCriteria example);

    TestResult selectByPrimaryKey(Date runtime);

    int updateByExampleSelective(@Param("record") TestResult record, @Param("example") TestResultCriteria example);

    int updateByExample(@Param("record") TestResult record, @Param("example") TestResultCriteria example);

    int updateByPrimaryKeySelective(TestResult record);

    int updateByPrimaryKey(TestResult record);
}