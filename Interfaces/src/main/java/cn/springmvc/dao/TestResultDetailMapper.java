package cn.springmvc.dao;

import cn.springmvc.model.TestResultDetail;
import cn.springmvc.model.TestResultDetailCriteria;
import cn.springmvc.model.TestResultDetailKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TestResultDetailMapper {
    long countByExample(TestResultDetailCriteria example);

    int deleteByExample(TestResultDetailCriteria example);

    int deleteByPrimaryKey(TestResultDetailKey key);

    int insert(TestResultDetail record);

    int insertSelective(TestResultDetail record);

    List<TestResultDetail> selectByExampleWithBLOBs(TestResultDetailCriteria example);

    List<TestResultDetail> selectByExample(TestResultDetailCriteria example);

    TestResultDetail selectByPrimaryKey(TestResultDetailKey key);

    int updateByExampleSelective(@Param("record") TestResultDetail record, @Param("example") TestResultDetailCriteria example);

    int updateByExampleWithBLOBs(@Param("record") TestResultDetail record, @Param("example") TestResultDetailCriteria example);

    int updateByExample(@Param("record") TestResultDetail record, @Param("example") TestResultDetailCriteria example);

    int updateByPrimaryKeySelective(TestResultDetail record);

    int updateByPrimaryKeyWithBLOBs(TestResultDetail record);

    int updateByPrimaryKey(TestResultDetail record);
}