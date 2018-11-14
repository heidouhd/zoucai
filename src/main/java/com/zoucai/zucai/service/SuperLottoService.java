package com.zoucai.zucai.service;

import com.zoucai.zucai.mapper.EventMapper;
import com.zoucai.zucai.mapper.SuperLottoMapper;
import com.zoucai.zucai.model.Event;
import com.zoucai.zucai.model.SuperLotto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "superLottoService")
public class SuperLottoService {
    @Autowired
    private SuperLottoMapper superLottoMapper;//这里会报错，但是并不会影响

    public void insertData(SuperLotto superLotto){
        superLottoMapper.insert(superLotto);
    }
}
