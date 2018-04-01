package dao.daoImpl;

import dao.MysqlConnect;
import dao.daoInterface.MenuDao;
import entity.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzhan on 18-3-13.
 * 用于加载菜单的dao实现类
 */
public class MenuDaoImpl implements MenuDao {
    /**
     * 获取二级菜单和具体页面地址
     *
     * @param r1 一级菜单
     * @return 二级菜单和具体页面地址
     */
    public List<Menu> finR2andUrl(String r1) {
        Connection connect = MysqlConnect.getConnect();
        Statement statement = null;
        List<Menu> list = new ArrayList<Menu>();
        try {
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rank2,rankUrl FROM menu WHERE rank1=" +  " \'" + r1 + "\'");
            if (resultSet != null) {
                while (resultSet.next()) {
                    Menu menu = new Menu();
                    menu.setRank2(resultSet.getString(1));
                    menu.setRankUrl(resultSet.getString(2));
                    list.add(menu);
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
        return list;
    }

    /**
     * 通过管理员权限显示相应的菜单
     *
     * @param adminPermission 管理员权限
     * @return 返回菜单的列表
     */
    public List<Menu> findRank1Menus(String adminPermission) {
        Connection connect = MysqlConnect.getConnect();
        Statement statement = null;
        List<Menu> list = new ArrayList<Menu>();
        try {
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT rank1 FROM menu WHERE adminPermission=" + " \'" + adminPermission + "\'"+"ORDER BY rank1");
            if (resultSet != null) {
                while (resultSet.next()) {
                    Menu menu = new Menu();
                    menu.setRank1(resultSet.getString(1));
                    list.add(menu);
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
        return list;
    }
}
