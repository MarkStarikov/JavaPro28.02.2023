package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoodPairSearcherTest {
    private GoodPairSearcher checker;

    @Before
    public void initiate() {
        checker = new GoodPairSearcher();
    }

    @Test
    public void goodPairIdentificationTest() {
        int[] numbers = new int[]{1, 2, 3, 1, 1, 3};
        int goodPair = checker.goodPairIdentification(numbers);

        Assert.assertEquals(4, goodPair);

    }

    @Test
    public void goodPairIdentificationIfEmptyTest() {
        int[] numbers = new int[4];
        int goodPair = checker.goodPairIdentification(numbers);

        Assert.assertEquals(6, goodPair);
    }
}

