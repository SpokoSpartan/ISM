package io.swagger.api.response;

import java.util.ArrayList;
import java.util.List;

public class AggregatedStatistic {

    private String className;
    private String methodName;
    private int callCount = 0;
    private long averageExecutionTime = 0;
    private List<StatisticResponse> statistics;

    public AggregatedStatistic(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
        statistics = new ArrayList<>();
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }

    public void setAverageExecutionTime(long averageExecutionTime) {
        this.averageExecutionTime = averageExecutionTime;
    }

    public void addStatistic(StatisticResponse statistic) {
        this.statistics.add(statistic);
    }


    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public int getCallCount() {
        return callCount;
    }

    public long getAverageExecutionTime() {
        return averageExecutionTime;
    }

    public List<StatisticResponse> getStatistics() {
        return statistics;
    }

}
