package edu.iis.mto.multithread;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.concurrent.Executor;

import static org.mockito.Mockito.*;

public class RadarTest {


    @Rule
    public RepeatRule repeatRule = new RepeatRule();
    private Executor executor;
    private PatriotBattery batteryMock;

    @Before
    public void init() {
        executor = Runnable::run;
        batteryMock = mock(PatriotBattery.class);
    }


    @Test
    @RepeatRule.Repeat(times = 10)
    public void launchPatriotOnceWhenNoticesAScudMissile() {

        LaunchPatriot launchPatriot = new LaunchPatriot(1, batteryMock);
        BetterRadar betterRadar = new BetterRadar(launchPatriot, executor);
        betterRadar.notice(new Scud());
        verify(batteryMock).launchPatriot();
    }


    @Test
    @RepeatRule.Repeat(times = 10)
    public void shouldNotLaunchPatriotWhenNotNoticesAScudMissile() {
        LaunchPatriot launchPatriot = new LaunchPatriot(100, batteryMock);
        BetterRadar radar = new BetterRadar(launchPatriot, executor);
        verify(batteryMock, times(0)).launchPatriot();
    }


    @Test
    @RepeatRule.Repeat(times = 10)
    public void shouldLaunchTenPatriotsWhenNoticesTwoScud() {

        LaunchPatriot launchPatriot = new LaunchPatriot(10, batteryMock);
        BetterRadar radar = new BetterRadar(launchPatriot, executor);
        radar.notice(new Scud());
        radar.notice(new Scud());

        verify(batteryMock, times(10)).launchPatriot();
    }

}
