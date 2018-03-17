package entity;

import java.util.Date;

/**
 * Created by liangzhan on 18-3-14.
 * 这是用户好友表
 */
public class UserFriends {
    private String userId;
    private String friendId;
    private Date addTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFriendId() {
        return friendId;
    }

    public void setFriendId(String friendId) {
        this.friendId = friendId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}
