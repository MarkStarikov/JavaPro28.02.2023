package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BalloonSearcherTest {

    private BalloonSearcher researcher;

    @Before
    public void initiate() {
        researcher = new BalloonSearcher();
    }

    @Test
    public void maxQuantityOfBalloonsTest()  {
        int maxQuantityOfBalloons = researcher.maxQuantityOfBalloons("loonbalxballpoon");

        Assert.assertEquals(2, maxQuantityOfBalloons);
    }
    @Test
    public void numJewelsIsInStonesNullTest() {
        int maxQuantityOfBalloons = researcher.maxQuantityOfBalloons(null );

        Assert.assertEquals(-1, maxQuantityOfBalloons);

    }

}
