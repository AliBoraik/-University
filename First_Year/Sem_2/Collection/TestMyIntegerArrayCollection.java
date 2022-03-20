package Collection;

import org.junit.Assert;
import org.junit.Test;

public class TestMyIntegerArrayCollection {

    // Tet Driven Development
    @Test
    public void createdCollectionIsEmpty() {
        // Assert
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        Assert.assertTrue(a.isEmpty());
    }

    @Test
    public void addElementToEmptyListMakesItNonEmpty() {
        MyIntegerArrayCollection a = new MyIntegerArrayCollection();
        a.add(1);
        Assert.assertFalse(a.isEmpty());
    }

}
