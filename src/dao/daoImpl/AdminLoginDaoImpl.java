package dao.daoImpl;

import dao.MysqlConnect;
import dao.daoInterface.AdminLoginDao;
import entity.AdminLogin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzhan on 18-3-13.
 * 这是对管理员登录表相关操作的实现类
 */
public class AdminLoginDaoImpl implements AdminLoginDao {
    /**
     * @param adminId 管理员ID
     * @return 返回管理员实例，包含密码权限
     */
    public AdminLogin findAdminMes(String adminId) {
        Connection connect = null;
        Statement statement = null;
        AdminLogin adminLogin = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT  admin_password,admin_permission FROM admin_login WHERE admin_id=" + "\'" + adminId + "\'");
            if (resultSet != null) {
                adminLogin = new AdminLogin();
                while (resultSet.next()) {
                    adminLogin.setAdminPassword(resultSet.getString(1));
                    adminLogin.setAdminPermission(resultSet.getString(2));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null)
                    statement.close();
                if (connect != null)
                    connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return adminLogin;
    }
}
