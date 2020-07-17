package com.juntaek.planeeapi.domain;

import java.time.LocalDateTime;

public class Plan {

    private Long id;
    private String content;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private PlanCategory category;
    private CreateType createType;
    private Diary diary;
}
