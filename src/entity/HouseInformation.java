package entity;

import java.util.Date;

/**
 * Created by liangzhan on 18-3-14.
 * 这是楼房信息表对应的实体类
 */
public class HouseInformation {
    private String houseId;
    private String houseName;
    private String houseAddress;
    private String houseKinds;
    private String housePrice;
    private String houseArea;
    private Date houseInTime;

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseAddress() {
        return houseAddress;
    }

    public void setHouseAddress(String houseAddress) {
        this.houseAddress = houseAddress;
    }

    public String getHouseKinds() {
        return houseKinds;
    }

    public void setHouseKinds(String houseKinds) {
        this.houseKinds = houseKinds;
    }

    public String getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(String housePrice) {
        this.housePrice = housePrice;
    }

    public String getHouseArea() {
        return houseArea;
    }

    public void setHouseArea(String houseArea) {
        this.houseArea = houseArea;
    }

    public Date getHouseInTime() {
        return houseInTime;
    }

    public void setHouseInTime(Date houseInTime) {
        this.houseInTime = houseInTime;
    }
}
