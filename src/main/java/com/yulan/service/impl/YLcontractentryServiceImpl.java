package com.yulan.service.impl;

import com.yulan.dao.YLcontractentryDao;
import com.yulan.pojo.YLcontract_v2015;
import com.yulan.service.YLcontractentryService;
import com.yulan.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class YLcontractentryServiceImpl implements YLcontractentryService {
    @Autowired
    private YLcontractentryDao yLcontractentryDao;

    private YLcontract_v2015 yLcontract_v2015;

    private StringUtil stringUtil;

    @Override
    public Map<String, Object> showStateEchartYCl(String year) {
        String Y="全部年份";
        if (year!=null){
            Y=year;
        }
        List x=new ArrayList();
        List y=new ArrayList();
        Map<String,Object> map=new HashMap<>();
        List<Map> list=yLcontractentryDao.getYLcBySate(year);
        for(Map m:list){
            switch (m.get("STATE").toString()){
                case "ONCREATE":
                    y.add("初始状态");
                    x.add(m.get("NUMS"));
                    break;
                case "CUSTOMERPORCESSING":
                    y.add("客户填写中");
                    x.add(m.get("NUMS"));
                    break;
                case "CUSTOMERPORCESSING2":
                    y.add("客户修改中");
                    x.add(m.get("NUMS"));
                    break;
                case "BUSINESSCHECKING":
                    y.add("业务员审核中");
                    x.add(m.get("NUMS"));
                    break;
                case "APPROVED":
                    y.add("已通过");
                    x.add(m.get("NUMS"));
                    break;
                case "BIILDEPCHECKING":
                    y.add("订单部审核");
                    x.add(m.get("NUMS"));
                    break;
                case "CUSTOMERAFFIRM":
                    y.add("客户查看确认中");
                    x.add(m.get("NUMS"));
                    break;
                case "CSA_CHECK":
                    y.add("销售副总批准中");
                    x.add(m.get("NUMS"));
                    break;
                case "DEP_MARKET_CHECK":
                    y.add("市场部审核中");
                    x.add(m.get("NUMS"));
                    break;
                case "SALEMANFILLING":
                    y.add("业务员填写中");
                    x.add(m.get("NUMS"));
                    break;
                case "ASM_CHECKING":
                    y.add("销售中心经理审核中");
                    x.add(m.get("NUMS"));
                    break;
                default:break;
            }
        }
        map.put("textname",Y+"协议网签执行汇总");
        map.put("y",y);
        map.put("x",x);

        return map;

    }

    @Override
    public Map getYClbyStateandCID(Integer start, Integer number,String year) throws UnsupportedEncodingException {
        Map map=new HashMap<String,Object>(2);
        List<Map<String,Object>> list=yLcontractentryDao.getYLcbyStateandCID(start,number,year);
        List<Map<String,Object>> list2=new ArrayList<>();
        for (Map<String,Object> m:list){
            String area_code=yLcontractentryDao.getArea_code(m.get("CID").toString());
            String area_name=yLcontractentryDao.getAreaName(area_code);
            m.put("MARKETNAME", StringUtil.getUtf8(area_name));
            String owner=yLcontractentryDao.getCenter_mangerId(area_code);
            String managerName=yLcontractentryDao.getName(owner);
            m.put("SUBMARKETMANAGERNAME",StringUtil.getUtf8(managerName));
            list2.add(m);
        }
        map.put("data",list2);
        map.put("count",yLcontractentryDao.count(year));

        return map;
    }

    @Override
    public List<Map<String, Object>> getAllStates() {
        List<Map<String,Object>> list=yLcontractentryDao.getAllStates();
        List<Map<String,Object>> states=new ArrayList<>();
        for (Map m:list){
            Map<String,Object> map=new HashMap<>();
            map.put("id",m.get("STATE"));
            switch (m.get("STATE").toString()){
                case "ONCREATE":
                    map.put("name","初始状态");

                    break;
                case "CUSTOMERPORCESSING":
             
                    map.put("name","客户填写中");
                    break;
                case "CUSTOMERPORCESSING2":

                    map.put("name","客户修改中");
                    break;
                case "BUSINESSCHECKING":

                    map.put("name","业务员审核中");
                    break;
                case "APPROVED":

                    map.put("name","已通过");
                    break;
                case "BIILDEPCHECKING":

                    map.put("name","订单部审核");
                    break;
                case "CUSTOMERAFFIRM":

                    map.put("name","客户查看确认中");
                    break;
                case "CSA_CHECK":

                    map.put("name","销售副总批准中");
                    break;
                case "DEP_MARKET_CHECK":

                    map.put("name","市场部审核中");
                    break;
                case "SALEMANFILLING":

                    map.put("name","业务员填写中");
                    break;
                case "ASM_CHECKING":

                    map.put("name","销售中心经理审核中");
                    break;
                default:break;
            }
            states.add(map);
        }
        return states;
    }

    @Override
    public YLcontract_v2015 getYLcontract_v2015(String ccid) throws IOException {
        if(yLcontractentryDao.getYLcontract_v2015(ccid) == null){
            return null;
        }else{
            yLcontract_v2015 = yLcontractentryDao.getYLcontract_v2015(ccid);
            String preferedbrand = stringUtil.getUtf8(yLcontract_v2015.getPreferedbrand());
            yLcontract_v2015.setPreferedbrand(preferedbrand);
            return yLcontract_v2015;
        }

    }

    @Override
    public boolean createYLcontract_v2015(YLcontract_v2015 yLcontract_v2015) throws IOException {
        yLcontract_v2015.setPreferedbrand(stringUtil.setUtf8(yLcontract_v2015.getPreferedbrand()));
        return yLcontractentryDao.createYLcontract_v2015(yLcontract_v2015);
    }

    @Override
    public String getYLcontractHTML(Map<String, Object> data) {

        return null;
    }
}
