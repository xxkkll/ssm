package com.lbyier.collectionInfo.service.impl;

import com.lbyier.collectionInfo.dao.CollectionInfoDao;
import com.lbyier.collectionInfo.model.CollectionInfo;
import com.lbyier.collectionInfo.service.CollectionInfoService;
import com.util.ErrorCode;
import com.util.ResponseVo;
import com.util.TimeStampToDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author LByier
 * @date 2020/11/7 10:57
 */
@Service
public class CollectionInfoServiceImpl implements CollectionInfoService {
    @Autowired
    private CollectionInfoDao collectionInfoDao;

    @Override
    public ResponseVo updateInfo() {
        /*
         *methodName: updateInfo
         * @Description: 查询温湿度传感器数据
           * @param
         * @return com.util.ResponseVo
         * @author: bier
         * @date 2020/11/7 17:31
         */
        ResponseVo responseVo = new ResponseVo(false, ErrorCode.FAIL,"查询温湿度传感器数据失败，请重试！");
        List<CollectionInfo> collectionInfo =collectionInfoDao.updateInfo();
        if (collectionInfo!=null){
            System.out.println("得到的原始数据"+collectionInfo);
            //将数据成封装x,y轴需要的数组
            String[] arryx= new String[collectionInfo.size()];
            String[] arryTem=new String[collectionInfo.size()];
            String[] arryhum=new String[collectionInfo.size()];
            //格式化日期
            TimeStampToDate tstd = new TimeStampToDate();
            for (int i=0;i<collectionInfo.size();i++){
                arryx[i]=tstd.Function(collectionInfo.get(i).getCreateTime(),"yyyy-MM-dd hh:mm:ss");
                arryTem[i]=collectionInfo.get(i).getTemp();
                arryhum[i]=collectionInfo.get(i).getHum();
            }
            List list=new ArrayList();
            list.add(arryx);
            list.add(arryTem);
            list.add(arryhum);


            responseVo.setMsg("查询温湿度数据成功");
            responseVo.setCode(ErrorCode.SUCCESS);
            responseVo.setData(list);
            responseVo.setSuccess(true);
            return responseVo;
        }

        return null;
    }
}
