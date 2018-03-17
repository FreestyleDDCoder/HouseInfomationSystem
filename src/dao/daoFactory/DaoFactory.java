package dao.daoFactory;

import dao.daoImpl.AdminLoginDaoImpl;
import dao.daoImpl.MenuDaoImpl;

/**
 * Created by liangzhan on 18-3-12.
 * 这是dao工厂类
 */
public class DaoFactory {
    public static AdminLoginDaoImpl getAdminDaoImpl(){
        return new AdminLoginDaoImpl();
    }

    public static MenuDaoImpl getMenuDaoImpl(){
        return new MenuDaoImpl();
    }
}
