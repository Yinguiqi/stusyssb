package com.mht.stueaxm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.mht.stueaxm.domain.StudentEntryExit;
import com.mht.stueaxm.mapper.EntryExitInfoMapper;
import com.mht.stueaxm.service.EntryExitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Kirtico
 * @date 2023/7/19&16:39
 */
@Service
public class EntryExitInfoServiceImpl implements EntryExitInfoService {

    @Autowired
    private EntryExitInfoMapper entryExitInfoMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public void addEntryExitInfo(StudentEntryExit studentEntryExit) {
        entryExitInfoMapper.insert(studentEntryExit);
    }

    @PostConstruct
    @Override
    public void setRedis(){
        List<StudentEntryExit> studentEntryExits = entryExitInfoMapper.selectList(null);
        System.out.println(1);
        String s = JSON.toJSONString(studentEntryExits, SerializerFeature.WriteClassName);
        redisTemplate.boundValueOps("EntryExit").set(s);
    }
    @Override
    public List<StudentEntryExit> list(){
        String str = (String) redisTemplate.boundValueOps("EntryExit").get();
        List<StudentEntryExit> studentEntryExits =  (List<StudentEntryExit>)JSON.parse(str, Feature.SupportAutoType);
        return studentEntryExits;
    }
    // 每隔5秒执行一次 setRedis 方法
    @Scheduled(fixedRate = 5000)
    public void refreshRedisData(){
        setRedis();
    }
}
