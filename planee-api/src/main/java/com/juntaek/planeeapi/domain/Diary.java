package com.juntaek.planeeapi.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class Diary extends BaseEntity {

    @Id
    private Long id;
    private String title;
    private String content;
    private LocalDate createDate;
}
