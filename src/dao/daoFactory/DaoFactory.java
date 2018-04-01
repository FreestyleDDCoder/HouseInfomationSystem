package dao.daoFactory;

import dao.daoImpl.*;

/**
 * Created by liangzhan on 18-3-12.
 * 这是dao工厂类
 */
public class DaoFactory {
    public static AdminLoginDaoImpl getAdminDaoImpl() {
        return new AdminLoginDaoImpl();
    }

    public static MenuDaoImpl getMenuDaoImpl() {
        return new MenuDaoImpl();
    }

    public static StationInformationImpl getStationInformationImpl() {
        return new StationInformationImpl();
    }

    public static UserInformationImpl getUserInformationImpl() {
        return new UserInformationImpl();
    }

    public static HouseKindsImpl getHouseKindsImpl() {
        return new HouseKindsImpl();
    }
}
