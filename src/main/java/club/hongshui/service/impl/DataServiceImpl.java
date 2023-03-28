package club.hongshui.service.impl;

import club.hongshui.mapper.DataMapper;
import club.hongshui.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private DataMapper dataMapper;
    @Override
    public List<String> bqselect() {
        return dataMapper.bqselect();
    }

    @Override
    public List<String> cyselect() {
        return dataMapper.cyselect();
    }

    @Override
    public List<String> bsselect() {
        return dataMapper.bsselect();
    }

    @Override
    public List<String> sfselect() {
        return dataMapper.sfselect();
    }

    @Override
    public List<String> plselect() {
        return dataMapper.plselect();
    }

    @Override
    public List<String> zsselect() {
        return dataMapper.zsselect();
    }

    @Override
    public List<String> masselect() {
        return dataMapper.masselect();
    }

    @Override
    public List<String> xyselect() {
        return dataMapper.xyselect();
    }

    @Override
    public List<String> bxselect() {
        return dataMapper.bxselect();
    }

    @Override
    public List<String> jyselect() {
        return dataMapper.jyselect();
    }

    @Override
    public List<String> hzselect() {
        return dataMapper.hzselect();
    }

    @Override
    public List<String> dfselect() {
        return dataMapper.dfselect();
    }

    @Override
    public List<String> xdselect() {
        return dataMapper.xdselect();
    }
    @Override
    public double Txdselectseven() {
        return dataMapper.Txdselectseven();
    }

    @Override
    public double Tdfselectseven() {
        return dataMapper.Tdfselectseven();
    }

    @Override
    public double Thzselectseven() {
        return dataMapper.Thzselectseven();
    }

    @Override
    public double Txdselectsix() { return dataMapper.Txdselectsix(); }

    @Override
    public double Tdfselectsix() { return dataMapper.Tdfselectsix(); }

    @Override
    public double Thzselectsix() {
        return dataMapper.Thzselectsix();
    }

    @Override
    public double Txdselectsixt() {
        return dataMapper.Txdselectsixt();
    }

    @Override
    public double Tdfselectsixt() { return dataMapper.Tdfselectsixt(); }

    @Override
    public double Thzselectsixt() {
        return dataMapper.Thzselectsixt();
    }
}
