package com.zoucai.zucai.model;

import lombok.Data;


@Data
public class Event {
    private Long id;

    private String eventDate;

    private String eventNumber;

    private String league;

    private String homeTeam;

    private String visitingTeam;

    private Integer homFalfScore;

    private Integer visitingFalfScore;

    private Integer homeScore;

    private Integer visitingScore;

    private Long winningOdds;

    private Long negativeOdds;

    private Long flatOdds;

    private Integer gameOver;
}