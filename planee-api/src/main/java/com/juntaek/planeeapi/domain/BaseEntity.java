package com.juntaek.planeeapi.domain;

import java.time.LocalDateTime;

public class BaseEntity {

    protected LocalDateTime createTime;
    protected LocalDateTime updateTime;
    protected Long createUserNo;
    protected Long updateUserNo;
}
