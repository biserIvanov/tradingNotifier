package com.biso.analysis;

import java.util.List;

/**
 * Created by biso on 25.04.17.
 */
public class GraphicAnalyzer {
    private List<String> instrumentsToTrack;
    private List<String> timeChartsToUse;
    private List<String> emailNotificationList;
    private List<String> indicators;

    public GraphicAnalyzer(List<String> instrumentsToTrack, List<String> timeChartsToUse, List<String> indicators, List<String> emailNotificationList) {
        this.instrumentsToTrack = instrumentsToTrack;
        this.timeChartsToUse = timeChartsToUse;
        this.indicators = indicators;
        this.emailNotificationList = emailNotificationList;
    }

    public void run() {
        // TODO: implement the magic here
    }
}
