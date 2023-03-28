package club.hongshui.Dao;

import club.hongshui.domain.Site;
import com.github.pagehelper.Page;

public interface SiteDao {
    /**
     * 按条件查询检查项数据
     * @param queryString
     * @return
     */
    Page<Site> selectByCondition(String queryString);
}
