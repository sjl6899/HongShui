package club.hongshui.service.impl;

import club.hongshui.domain.Site;
import club.hongshui.mapper.SiteMapper;
import club.hongshui.service.SiteService;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteMapper siteMapper;
    @Override
    public int delete(String id) {
        int i=siteMapper.delete(id);
        return i;
    }

    @Override
    public int addsite(Site site) {
        return siteMapper.addsite(site);
    }

    @Override
    public int setting(Site site) {
        return siteMapper.setting(site);
    }

    @Override
    public Page<Site> vselect() {
        return siteMapper.vselect();
    }



    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        //完成分页查询，基于mybatis框架提供的分页助手插件完成
        PageHelper.startPage(currentPage,pageSize);

        Page<Site> page = siteMapper.vselect();
        long total = page.getTotal();
        List<Site> rows = page.getResult();
        return new PageResult(total,rows);
    }

    @Override
    public Site findById(Integer id) {
        return siteMapper.findById(id);
    }


}
