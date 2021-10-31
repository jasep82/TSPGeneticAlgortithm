import com.company.Tour;
import org.junit.Assert;
import org.junit.Test;

public class TourTests {

    @Test
    public void makeTourAndCheckAccessors()
    {
        Tour t = new Tour("XABCDEFGHX");
        Assert.assertNotNull(t);
        Assert.assertEquals("XABCDEFGHX",t.getRoute());
        //NB Just test fitness has been changed will check validity in next test.
        Assert.assertNotEquals(0.0, t.getFitness());
    }


    @Test
    public void checkFitnessOnCreation()
    {
        Tour t = new Tour("XAFGJX");
        /*
            X->A is 94
            A->F is 108
            F->G is 173
            G->J is 139
            J->X is 90

            94+108+173+139+90 = 604
         */

        Assert.assertEquals(604,t.getDistance());

        // 1/604 = 0.001655629139073
        Assert.assertEquals("0.0016556",(""+t.getFitness()).substring(0,9));

    }

    @Test
    public void makeValidRandomTour()
    {
        Tour t = new Tour('F');
        isValidTour(t.getRoute(),'F');
    }

    @Test
    public void checkFitnessOfRandomTour()
    {
        Tour t = new Tour('B');
        //Can only be
        //XABX or XBAX (Which are the same)
        //X->A is 94
        //A->B is 156
        //B-> X is 76
        // 94+156+76 = 326
        Assert.assertEquals(326, t.getDistance());

        // 1/326 = 0.003067484662577
        Assert.assertEquals("0.003067", (""+t.getFitness()).substring(0,8));

    }


    @Test
    public void checkMutation()
    {
        //Check 10 random mutations

        Tour t = new Tour("XABCDEFGHIJKLMNOPQRSTX");
        boolean changeMade = false;
        String originalRoute = t.getRoute();
        for(int i=0;i<10;i++)
        {
            t.mutate();
            if(!originalRoute.equals(t.getRoute()))changeMade=true;
            isValidTour(t.getRoute(),'T');

        }

        //Check routes are actually changing!
        Assert.assertTrue(changeMade);

    }



    private void isValidTour(String givenRoute, char highestNode)
    {
        //Check starts and ends with X
        Assert.assertEquals('X',givenRoute.charAt(0));
        Assert.assertEquals('X',givenRoute.charAt(givenRoute.length()-1));

        //check each char appears once and only once
        boolean duplicateFound=false;
        String warningMessage="Route: "+givenRoute+"\n";

        //1 a§nd -1 to avoid Xs
        for(int j=1;j<givenRoute.length()-1; j++)
        {
            char node = givenRoute.charAt(j);
            for(int k=j+1; k<givenRoute.length(); k++)
            {
                Assert.assertFalse(node>highestNode);

                if(givenRoute.charAt(k)==node)
                {
                    duplicateFound = true;
                    warningMessage+="Duplicate: "+node;
                }
            }
        }
        Assert.assertFalse(warningMessage, duplicateFound);
    }
}
