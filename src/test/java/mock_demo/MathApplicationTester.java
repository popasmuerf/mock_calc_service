package mock_demo;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import mock_demo.service.CalculatorService;
import mock_demo.util.MathApplication;

/*
    Here we  test  MathApplication class , by
    injefctin it in a mock of the calculatatorService 
    Interface....


    In other words...we inject the mocked interface as a dependency into 
    the MathApplication class.....
*/





//Attaches a runner with the test class to initiatilize
//the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //annotation is used ot create and inject the mock object
    @InjectMocks
    MathApplication mathApplication  = new MathApplication();

    //is used to create the mock object to be injected
    @Mock
    CalculatorService calcService ;

    @Test
    public void testAdd(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //add the behavior of calc service to subtract two numbers..
        when(calcService.subtract(10.0,20.0)).thenReturn(-10.0);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);
        Assert.assertEquals(mathApplication.subtract(10.0,20.0), -10.0);
        //vefiry the behavior
        verify(calcService).add(10.0,20.0);
        verify(calcService).subtract(10.0, 20.0);
    }



}//end