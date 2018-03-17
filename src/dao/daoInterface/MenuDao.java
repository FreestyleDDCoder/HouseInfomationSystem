package dao.daoInterface;

import entity.Menu;

import java.util.List;

/**
 * Created by liangzhan on 18-3-15.
 * 菜单表接口
 */
public interface MenuDao {
    public List<Menu> finR2andUrl(String r1);

    public List<Menu> findRank1Menus(String adminPermission);
}
