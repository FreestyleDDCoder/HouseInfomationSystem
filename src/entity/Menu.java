package entity;

/**
 * Created by liangzhan on 18-3-13.
 * 这是菜单实体
 */
public class Menu {
    private String rank1;
    private String rank2;
    private String rankUrl;
    private String adminPermission;

    public String getAdminPermission() {
        return adminPermission;
    }

    public void setAdminPermission(String adminPermission) {
        this.adminPermission = adminPermission;
    }

    public String getRank1() {
        return rank1;
    }

    public void setRank1(String rank1) {
        this.rank1 = rank1;
    }

    public String getRank2() {
        return rank2;
    }

    public void setRank2(String rank2) {
        this.rank2 = rank2;
    }

    public String getRankUrl() {
        return rankUrl;
    }

    public void setRankUrl(String rankUrl) {
        this.rankUrl = rankUrl;
    }
}
