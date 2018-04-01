package dao.daoInterface;

import entity.UserInformation;

import java.util.List;

/**
 * Created by liangzhan on 18-3-31.
 * 这是用户信息表的操作接口类
 */
public interface UserInformationDao {
    //通过用户Id获取用户的信息
    public UserInformation getUserInformationById(String userId);
    //获取所有用户信息
    public List<UserInformation> getUserInformations();
    //通过用户Id删除用户的信息
    public String deleteUserInformationById(String userId);
}
