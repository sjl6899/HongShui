package club.hongshui.service;

import club.hongshui.domain.Gatestation;
import club.hongshui.domain.Site;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GatestationService {
    int addgate(@Param("gatestation") Gatestation gatestation);
    int setting(@Param("gatestation") Gatestation gatestation);
    Page<Gatestation> vselect();
    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    PageResult pageQuery(QueryPageBean queryPageBean);
    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    Gatestation findById(Integer id);

    /**
     * 根据id删除数据
     * @param id
     */
    int delete(String id);
}
