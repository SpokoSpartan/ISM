package io.swagger.api.response;

import java.util.Date;

public class StatisticResponse {

    private Date timestamp;
    private long executionTime;

    public StatisticResponse(Date timestamp, long executionTime) {
        this.timestamp = timestamp;
        this.executionTime = executionTime;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public long getExecutionTime() {
        return executionTime;
    }

}
