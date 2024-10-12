package dev.byli.robot.archetype.entrypoints.scheduled;

public interface PullEventsCron {

    String PULL_EVENTS_CRON_EXPRESSION = "0 0 0 * * *";

    void pullEvents();

}
