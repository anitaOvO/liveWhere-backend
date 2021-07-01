package com.javaclimb.livewhere.domain;

import java.sql.Date;
import java.sql.Timestamp;

public class Time {
    private Date dayStart;
    private Date dayEnd;

    public Date getDayStart() {
        return dayStart;
    }

    public void setDayStart(Date dayStart) {
        this.dayStart = dayStart;
    }

    public Date getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Date dayEnd) {
        this.dayEnd = dayEnd;
    }
}
