package dao.daoInterface;

import entity.StationInformation;

import java.util.Date;
import java.util.List;

/**
 * Created by liangzhan on 18-3-20.
 * 这是站内消息表的操作接口
 */
public interface StationInformationDao {
    //存入推送消息记录的方法
    public String RmpushMessage(String adminID, String message, String date);
    //查询推荐记录的方法
    public List<StationInformation> getStationInformation();
}
