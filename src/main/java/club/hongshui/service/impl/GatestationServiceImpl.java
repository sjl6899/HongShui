package club.hongshui.service.impl;

import club.hongshui.domain.Gatestation;
import club.hongshui.domain.Site;
import club.hongshui.mapper.GatestationMapper;
import club.hongshui.service.GatestationService;
import club.hongshui.util.PageResult;
import club.hongshui.util.QueryPageBean;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatestationServiceImpl implements GatestationService {
    @Autowired
    private GatestationMapper gatestationMapper;

    @Override
    public int delete(String id) {
        int i=gatestationMapper.delete(id);
        return i;
    }
    @Override
    public int addgate(Gatestation gatestation) {
        return gatestationMapper.addgate(gatestation);
    }

    @Override
    public int setting(Gatestation gatestation) {
        return gatestationMapper.setting(gatestation);
    }

    @Override
    public Page<Gatestation> vselect() {
        return gatestationMapper.vselect();
    }

    @Override
    public PageResult pageQuery(QueryPageBean queryPageBean) {
        Integer currentPage = queryPageBean.getCurrentPage();
        Integer pageSize = queryPageBean.getPageSize();
        //完成分页查询，基于mybatis框架提供的分页助手插件完成
        PageHelper.startPage(currentPage,pageSize);

        Page<Gatestation> page = gatestationMapper.vselect();
        long total = page.getTotal();
        List<Gatestation> rows = page.getResult();
        return new PageResult(total,rows);
    }

    @Override
    public Gatestation findById(Integer id) {
        return gatestationMapper.findById(id);
    }



}
