package horse;

import horse.algorythm.HorseRiding;
import org.junit.Assert;
import org.junit.Test;

public class HorseRidingTest {

    @Test
    public void testCountDistance() {
        test1();
        test2();
        test3();
        test4();
    }

    private void test1() {
        Assert.assertEquals(0, new HorseRiding(1, 1, "A1", "A1").countDistance());
    }

    private void test2() {
        Assert.assertEquals(-1, new HorseRiding(3, 3, "A1", "B2").countDistance());
    }

    private void test3() {
        Assert.assertEquals(3, new HorseRiding(4, 4, "D4", "C4").countDistance());
    }

    private void test4() {
        Assert.assertEquals(4, new HorseRiding(4, 4, "A1", "B2").countDistance());
    }
}