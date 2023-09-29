package p06_TirePressureMonitoringSystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;


public class AlarmTest {

    private static final double LOW_PRESSURE_VALUE = 14.00;
    private static final double HIGH_PRESSURE_VALUE = 25.00;
    private static final double NORMAL_PRESSURE_VALUE = 20.00;
    private Alarm alarm;
    private Sensor sensor;

    @Before
    public void setUp() {
        sensor = mock(Sensor.class);
        alarm = new Alarm(sensor);
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfLowPressure() {
        //Check alarm when pressure is below Low Threshold: 17
        when(sensor.popNextPressurePsiValue()).thenReturn(LOW_PRESSURE_VALUE);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOnBecauseOfHighPressure() {
        //Check alarm when pressure is above High Threshold: 21
        when(sensor.popNextPressurePsiValue()).thenReturn(HIGH_PRESSURE_VALUE);
        alarm.check();

        assertTrue(alarm.getAlarmOn());
    }

    @Test
    public void testAlarmShouldBeOff() {
        //Check alarm when pressure is normal
        when(sensor.popNextPressurePsiValue()).thenReturn(NORMAL_PRESSURE_VALUE);
        alarm.check();
        assertFalse(alarm.getAlarmOn());
    }


}