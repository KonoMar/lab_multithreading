package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private LaunchPatriot launch;
    private Executor executor;


    public BetterRadar(LaunchPatriot launch, Executor executor) {
        this.launch = launch;
        this.executor = executor;
    }


    public void notice(Scud enemyMissle) {
        launchPatriot();
    }

    private void launchPatriot() {
        executor.execute(launch);
    }
}
