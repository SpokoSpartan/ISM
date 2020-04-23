package io.swagger.logic.service;

import io.swagger.api.response.AggregatedStatistic;
import io.swagger.api.response.StatisticResponse;
import io.swagger.data.entity.Statistic;
import io.swagger.data.repository.StatisticsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

@Service
public class StatisticService {

    private final StatisticsRepository statisticsRepository;

    public StatisticService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public void saveInvocation(String className, String methodName, long duration) {
        Statistic statistic = new Statistic(duration, className, methodName);
        statisticsRepository.save(statistic);
    }

    public List<AggregatedStatistic> getAggregatedStatistics() {
        Iterable<Statistic> statistics = statisticsRepository.findAll();

        Map<String, AggregatedStatistic> aggregatedStatistics = new HashMap<>();

        StreamSupport.stream(statistics.spliterator(), false)
                .forEach(statistic -> {
                    createUniqueStatisticIfNotExists(aggregatedStatistics, statistic);
                    updateAggregatedStatistic(aggregatedStatistics, statistic);
                });

        countAverageDurations(aggregatedStatistics);

        return new ArrayList<>(aggregatedStatistics.values());
    }

    private void createUniqueStatisticIfNotExists(Map<String, AggregatedStatistic> aggregatedStatistics, Statistic statistic) {
        if (!aggregatedStatistics.containsKey(statistic.getFullName())) {
            aggregatedStatistics.put(statistic.getFullName(), new AggregatedStatistic(statistic.getClassName(), statistic.getMethodName()));
        }
    }

    private void updateAggregatedStatistic(Map<String, AggregatedStatistic> aggregatedStatistics, Statistic statistic) {
        AggregatedStatistic aggregatedStatistic = aggregatedStatistics.get(statistic.getFullName());
        aggregatedStatistic.setCallCount(aggregatedStatistic.getCallCount() + 1);
        StatisticResponse statisticResponse = new StatisticResponse(statistic.getTimestamp(), statistic.getDuration());
        aggregatedStatistic.addStatistic(statisticResponse);
    }

    private void countAverageDurations(Map<String, AggregatedStatistic> aggregatedStatistic) {
        for (Map.Entry<String, AggregatedStatistic> statisticEntry : aggregatedStatistic.entrySet()) {
            long allElapsedTimes = statisticEntry.getValue().getStatistics().stream()
                    .map(StatisticResponse::getExecutionTime)
                    .mapToLong(Long::longValue).sum();
            long occurrences = statisticEntry.getValue().getStatistics().size();
            statisticEntry.getValue().setAverageExecutionTime(allElapsedTimes / occurrences);
        }
    }

}
