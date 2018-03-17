package dao.daoInterface;

import entity.AdminLogin;

import java.util.List;

/**
 * Created by liangzhan on 18-3-13.
 * 这是对管理员相关表格操作的接口类
 */
public interface AdminLoginDao {
    //查询管理员表信息
    public AdminLogin findAdminMes(String adminId) ;

}
