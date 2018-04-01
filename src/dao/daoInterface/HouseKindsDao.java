package dao.daoInterface;

import entity.HouseKinds;

import java.util.List;

/**
 * Created by liangzhan on 18-4-1.
 * 这是楼房类型表格操作接口
 */
public interface HouseKindsDao {
    //通过楼房类型ID删除楼房类型
    public String houseKindsDeleteById(String kindsId);

    //更新楼房类型
    public String housekindsUpdate(String kindsId, String houseKinds);

    //增加楼房类型
    public String housekindsAdd(String kindsId, String houseKinds);

    //查询所有的楼房类型
    public List<HouseKinds> housekindsQuery();
}
