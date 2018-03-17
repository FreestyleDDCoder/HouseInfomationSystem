package entity;

import java.util.Date;

/**
 * Created by liangzhan on 18-3-15.
 * 这是楼盘评论实体
 */
public class HouseRemark {
    private String houseId;
    private String userId;
    private String houseRemark;
    private Date houseRemarkTime;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHouseRemark() {
        return houseRemark;
    }

    public void setHouseRemark(String houseRemark) {
        this.houseRemark = houseRemark;
    }

    public Date getHouseRemarkTime() {
        return houseRemarkTime;
    }

    public void setHouseRemarkTime(Date houseRemarkTime) {
        this.houseRemarkTime = houseRemarkTime;
    }
}
