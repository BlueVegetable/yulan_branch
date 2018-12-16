package com.yulan.dao;

import com.yulan.pojo.YLcontract_v2015;
import com.yulan.pojo.YLcontractentryShow;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface YLcontractentryDao {
    List<Map<String,Object>> getYLcbyStateandCID(@Param("start")Integer start, @Param("number") Integer number,@Param("year")String year);

    List<Map> getYLcBySate(@Param("year")String year);

    String getArea_code(String CID);//关联customer

    String getAreaName(String area_code);//关联Area_code

    String getCenter_mangerId(@Param("area_code")String area_code);//关联Area_owner

    String getName(String owner);//HES_EMPLOYEE

    int count(@Param("year")String year);

    List<Map<String,Object>> getAllStates();

    String getState(@Param("CID")String CID,@Param("year")Integer year);


    YLcontract_v2015 getYLcontract_v2015(@Param("CCID") String ccid);

    boolean createYLcontract_v2015(YLcontract_v2015 yLcontract_v2015);

    YLcontractentryShow getYLcontractHTML(@Param("ID") Integer ID);
}
