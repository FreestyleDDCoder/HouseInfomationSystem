package dao.daoImpl;

import dao.MysqlConnect;
import dao.daoInterface.UserInformationDao;
import entity.UserInformation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzhan on 18-3-31.
 * 这是用户信息的实现类
 */
public class UserInformationImpl implements UserInformationDao {
    @Override
    public UserInformation getUserInformationById(String userId) {
        Connection connect = null;
        Statement statement = null;
        UserInformation userInformation = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_information WHERE  user_id=" + "\'" + userId + "\'");
            if (resultSet != null) {
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String mail = resultSet.getString(2);
                    String sex = resultSet.getString(3);
                    String motto = resultSet.getString(4);
                    String iconUrl = resultSet.getString(5);
                    String vip = resultSet.getString(6);
                    userInformation = new UserInformation(id, mail, sex, motto, iconUrl, vip);
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
        return userInformation;
    }

    @Override
    public List<UserInformation> getUserInformations() {
        Connection connect = null;
        Statement statement = null;
        ArrayList<UserInformation> userInformations = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM user_information");
            if (resultSet != null) {
                userInformations = new ArrayList<>();
                while (resultSet.next()) {
                    String id = resultSet.getString(1);
                    String mail = resultSet.getString(2);
                    String sex = resultSet.getString(3);
                    String motto = resultSet.getString(4);
                    String iconUrl = resultSet.getString(5);
                    String vip = resultSet.getString(6);
                    UserInformation userInformation = new UserInformation(id, mail, sex, motto, iconUrl, vip);
                    userInformations.add(userInformation);
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
        return userInformations;
    }

    @Override
    public String deleteUserInformationById(String userId) {
        Connection connect = null;
        Statement statement = null;
        String result = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            int i = statement.executeUpdate("DELETE FROM user_login WHERE user_id=" + "\'" + userId + "\'");
            if (i == 1) {
                result = "success";
            } else if (i == 0) {
                result = "没有查询到该用户！";
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
}
