package entity;

import java.util.Date;

/**
 * Created by liangzhan on 18-3-15.
 * 这是站内消息实体
 */
public class StationInformation {
    private String adminId;
    private String informationContent;
    private Date pushTime;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getInformationContent() {
        return informationContent;
    }

    public void setInformationContent(String informationContent) {
        this.informationContent = informationContent;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}
