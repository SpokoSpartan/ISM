import {StatisticResponse} from "./StatisticResponse";

export interface AggregatedStatistic {
    averageExecutionTime: number;
    callCount: number;
    className: string;
    methodName: string;
    statistics: StatisticResponse[];
}
