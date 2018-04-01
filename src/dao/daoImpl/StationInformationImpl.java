package dao.daoImpl;

import dao.MysqlConnect;
import dao.daoInterface.StationInformationDao;
import entity.StationInformation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangzhan on 18-3-20.
 * 这是站内消息表格操作的实现类
 */
public class StationInformationImpl implements StationInformationDao {
    @Override
    public String RmpushMessage(String adminID, String message, String date) {
        Connection connect = null;
        Statement statement = null;
        String result = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            int i = statement.executeUpdate("INSERT into station_information (admin_id,information_content,push_time) VALUES (" + "\'" + adminID + "\'" + "," + "\'" + message + "\'" + "," + "\'" + date + "\'" + ")");
            if (i == 1) {
                result = "success";
            } else if (i == 0) {
                result = "fail";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            result = "fail" + e.getMessage();
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

    /**
     * @return 站内消息的列表
     */
    @Override
    public List<StationInformation> getStationInformation() {
        Connection connect = null;
        Statement statement = null;
        List<StationInformation> stationInformations = null;
        try {
            connect = MysqlConnect.getConnect();
            statement = connect.createStatement();
            //按照时间降序
            ResultSet resultSet = statement.executeQuery("SELECT * FROM station_information ORDER BY push_time DESC");
            if (resultSet != null) {
                stationInformations = new ArrayList<>();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                while (resultSet.next()) {
                    StationInformation stationInformation = new StationInformation();
                    stationInformation.setAdminId(resultSet.getString(1));
                    stationInformation.setInformationContent(resultSet.getString(2));
                    stationInformation.setPushTime(simpleDateFormat.parse(resultSet.getString(3)));
                    stationInformations.add(stationInformation);
                }
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return stationInformations;
    }
}
