package io.swagger.data.repository;

import io.swagger.data.entity.Statistic;
import org.springframework.data.repository.CrudRepository;

public interface StatisticsRepository extends CrudRepository<Statistic, Long> {
}
