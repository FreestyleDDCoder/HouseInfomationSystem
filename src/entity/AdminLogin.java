package entity;

/**
 * Created by liangzhan on 18-3-13.
 *这是管理员登录表实体
 */
public class AdminLogin {
    //管理员账号，密码，权限
    private String adminId;
    private String adminPassword;
    private String adminPermission;

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(String adminPermission) {
        this.adminPermission = adminPermission;
    }
}
