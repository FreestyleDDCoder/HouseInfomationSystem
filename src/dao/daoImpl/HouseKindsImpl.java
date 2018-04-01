package dao.daoImpl;

import dao.MysqlConnect;
import dao.daoInterface.HouseKindsDao;
import entity.HouseKinds;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzhan on 18-4-1.
 * 这是楼房类型实现类
 */
public class HouseKindsImpl implements HouseKindsDao {
    @Override
    public String houseKindsDeleteById(String kindsId) {
        Connection connect = null;
        Statement statement = null;
        String result = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            int i = statement.executeUpdate("DELETE FROM house_kinds WHERE kinds_id=" + "\'" + kindsId + "\'");
            if (i == 1) {
                result = "success";
            } else if (i == 0) {
                result = "没有查询到该楼房类型！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = e.getMessage();
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
        return result;
    }

    @Override
    public String housekindsUpdate(String kindsId, String houseKinds) {
        Connection connect = null;
        Statement statement = null;
        String result = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            int i = statement.executeUpdate("UPDATE house_kinds SET house_kinds=" + "\'" + houseKinds + "\'" + "WHERE kinds_id=" + "\'" + kindsId + "\'");
            if (i == 1) {
                result = "success";
            } else if (i == 0) {
                result = "没有查询到该楼房类型！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = e.getMessage();
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
        return result;
    }

    @Override
    public String housekindsAdd(String kindsId, String houseKinds) {
        Connection connect = null;
        Statement statement = null;
        String result = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            int i = statement.executeUpdate("INSERT into house_kinds (kinds_id,house_kinds) VALUES (" + "\'" + kindsId + "\'" + "," + "\'" + houseKinds + "\'" + ")");
            if (i == 1) {
                result = "success";
            } else if (i == 0) {
                result = "已经存在该楼房类型！";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = e.getMessage();
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
        return result;
    }

    @Override
    public List<HouseKinds> housekindsQuery() {
        Connection connect = null;
        Statement statement = null;
        List<HouseKinds> houseKinds = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            //按照时间降序
            ResultSet resultSet = statement.executeQuery("SELECT * FROM house_kinds");
            if (resultSet != null) {
                houseKinds = new ArrayList<>();
                while (resultSet.next()) {
                    HouseKinds houseKinds1 = new HouseKinds();
                    houseKinds1.setKindsId(resultSet.getString(1));
                    houseKinds1.setHouseKinds(resultSet.getString(2));
                    houseKinds.add(houseKinds1);
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
        return houseKinds;
    }
}
