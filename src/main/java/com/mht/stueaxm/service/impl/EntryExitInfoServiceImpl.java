package com.mht.stueaxm.service.impl;

import com.mht.stueaxm.domain.StudentEntryExit;
import com.mht.stueaxm.mapper.EntryExitInfoMapper;
import com.mht.stueaxm.service.EntryExitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/19&16:39
 */
@Service
public class EntryExitInfoServiceImpl implements EntryExitInfoService {

    @Autowired
    private EntryExitInfoMapper entryExitInfoMapper;

    @Override
    public void addEntryExitInfo(StudentEntryExit studentEntryExit) {
        entryExitInfoMapper.insert(studentEntryExit);
    }

    @Override
    public List<StudentEntryExit> list(){return entryExitInfoMapper.selectList(null);}
}
