package com.zoucai.zucai.service;

import com.zoucai.zucai.mapper.DualColoreBallMapper;
import com.zoucai.zucai.mapper.EventMapper;
import com.zoucai.zucai.model.DualColoreBall;
import com.zoucai.zucai.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "dualColoreBallService")
public class DualColoreBallService {
    @Autowired
    private DualColoreBallMapper dualColoreBallMapper;//这里会报错，但是并不会影响

    public void insertData(DualColoreBall dualColoreBall){
        dualColoreBallMapper.insert(dualColoreBall);
    }

    public List<DualColoreBall> queryDualColoreBallData() {
        return dualColoreBallMapper.queryDualColoreBallData();
    }
}
