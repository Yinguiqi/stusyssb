package com.mht.stueaxm.service;

import com.mht.stueaxm.domain.StudentEntryExit;

import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/19&16:40
 */
public interface EntryExitInfoService {

    void addEntryExitInfo(StudentEntryExit studentEntryExit);

    List<StudentEntryExit> list();
}
