package io.swagger.api.impl;

import io.swagger.api.interfaces.StatisticsApi;
import io.swagger.api.response.AggregatedStatistic;
import io.swagger.logic.service.StatisticService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@PreAuthorize("isAuthenticated()")
@RestController
@RequestMapping("/stats")
public class StatisticsController implements StatisticsApi {

    private final StatisticService statisticService;

    public StatisticsController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Override
    public ResponseEntity<List<AggregatedStatistic>> getStatistics() {
        return ResponseEntity.ok(statisticService.getAggregatedStatistics());
    }

}
