import com.company.MapData;
import org.junit.Assert;
import org.junit.Test;

public class MapDataTests {


    //These tests use the default
    @Test
    public void toNodeIsInvalid()
    {
        Assert.assertEquals(-1, MapData.getDistance('A','Z'));
    }

    @Test
    public void fromNodeIsInvalid()
    {
        Assert.assertEquals(-1, MapData.getDistance('Z','A'));
    }


    @Test
    public void distanceFromAtoC()
    {
        Assert.assertEquals(231, MapData.getDistance('A','C'));
    }



}
