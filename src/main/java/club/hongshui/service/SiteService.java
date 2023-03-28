package club.hongshui.service;

import club.hongshui.domain.Site;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface SiteService {

    int delete(String id);
    int addsite(@Param("site") Site site);
    int setting(@Param("site") Site site);
    Page<Site> vselect();


    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult pageQuery(QueryPageBean queryPageBean);
    /**
     * 根据id查询包裹数据
     * @param id
     * @return
     */
    Site findById(Integer id);
}
