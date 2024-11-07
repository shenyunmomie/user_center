package com.swshenyun.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.swshenyun.context.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入自动填充");
        strictInsertFill(metaObject,"createTime", LocalDateTime.class,LocalDateTime.now());
        strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
        strictInsertFill(metaObject,"createUser", Long.class, BaseContext.getCurrentId());
        strictInsertFill(metaObject,"updateUser", Long.class,BaseContext.getCurrentId());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("更新自动填充");
        strictInsertFill(metaObject,"updateTime", LocalDateTime.class,LocalDateTime.now());
        strictInsertFill(metaObject,"updateUser", Long.class,BaseContext.getCurrentId());
    }
}
