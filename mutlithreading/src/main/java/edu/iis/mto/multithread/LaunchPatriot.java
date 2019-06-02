package edu.iis.mto.multithread;

public class LaunchPatriot implements Runnable{

    private int numberOfPatriots;
    private PatriotBattery patriotBattery;


    public LaunchPatriot(int numberOfPatriots, PatriotBattery patriotBattery) {
        this.numberOfPatriots = numberOfPatriots;
        this.patriotBattery = patriotBattery;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfPatriots; i++) {
            patriotBattery.launchPatriot();
        }
    }
}
