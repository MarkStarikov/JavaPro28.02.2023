package org.example;

import org.junit.Assert;
import org.junit.Test;

public class JewelerTest {

    @Test
    public void numJewelsIsInStonesTest()  {
       Jeweler tester = new Jeweler();
       int numJewelsIsInStones = tester.numJewelsIsInStones("udK", "hcJLrDdPsukfsluoLK");

        Assert.assertEquals(4, numJewelsIsInStones);
    }
    @Test
    public void numJewelsIsInStonesNullTest() {
        Jeweler tester = new Jeweler();
         int numJewelsIsInStones = tester.numJewelsIsInStones(null, "hcJLrDdPsukfsluoLK");

        Assert.assertEquals(-1, numJewelsIsInStones);

        }


}
