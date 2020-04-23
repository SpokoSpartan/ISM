import {Component, OnInit} from '@angular/core';
import {AggregatedStatistic} from "../../domains/AggregatedStatistic";
import {HttpClient} from "@angular/common/http";
import {API_URL} from "../../config";
import {ChartDataSets, ChartOptions, ChartType} from "chart.js";
import {Label} from "ng2-charts";


@Component({
    selector: 'app-statistics',
    templateUrl: './statistics.component.html',
    styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

    ALL_METHOD_STATS = 'All aggregated methods';

    isMainChartSelected = true;

    // Method chart
    lineChartType: ChartType = 'line';
    lineChartPlugins = [];
    lineChartOptions: ChartOptions = {
        responsive: true,
    };
    lineChartLabels: Label[] = [];
    lineChartData: ChartDataSets[] = [
        {data: [], label: 'Single function calls time'}
    ];
    lineChartLegend = true;

    // Aggregated chart
    barChartOptions: ChartOptions = {
        responsive: true,
    };
    barChartLabels: Label[] = [];
    barChartType: ChartType = 'bar';
    barChartLegend = true;
    barChartPlugins = [];

    barChartData: ChartDataSets[] = [
        {data: [], label: 'Functions calls'}
    ];

    statistics: AggregatedStatistic[] = [];
    availableStatistics: string[] = [];

    constructor(private http: HttpClient) {
    }

    ngOnInit(): void {
        this.initStatistics().subscribe(x => {
            this.statistics = x;
            this.setBarChart(x);
        });
    }

    initStatistics() {
        return this.http.get<AggregatedStatistic[]>(API_URL + '/stats/aggregated', {withCredentials: true});
    }

    changeStatsPress() {
        const selectedStats = (<HTMLInputElement>document.getElementById('select')).value;
        console.log(selectedStats);
        this.changeChart(selectedStats);
    }

    changeChart(selectedStats: string) {
        if (selectedStats === this.ALL_METHOD_STATS) {
            this.setBarChart(this.statistics);
        } else {
            this.statistics.forEach(s => {
                if (s.methodName === selectedStats) {
                    this.setLineChart(s);
                    return;
                }
            });
        }
    }

    setBarChart(aggregatedStatistic: AggregatedStatistic[]) {
        this.barChartLabels = aggregatedStatistic.map(z => z.methodName);
        this.barChartData = [{data: aggregatedStatistic.map(z => z.callCount), label: 'Functions calls'}];
        const stats: string[] = [];
        stats.push(this.ALL_METHOD_STATS);
        aggregatedStatistic.forEach(z => stats.push(z.methodName));
        this.availableStatistics = stats;
        this.isMainChartSelected = true;
    }

    setLineChart(aggregatedStatistic: AggregatedStatistic) {
        this.lineChartLabels = aggregatedStatistic.statistics.map(z => new Date(z.timestamp).toDateString());
        this.lineChartData = [{
            data: aggregatedStatistic.statistics.map(z => z.executionTime),
            label: 'Single function calls time'
        }];
        this.isMainChartSelected = false;
    }

}
