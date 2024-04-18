import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FizzBuzzTest {
    @Test
    public void IfNumberMultipeBy3_Them_Fizz(){
        //Arrange
        int valueToTest = 3;
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act
        String result = fizzBuzz.checkNumber(valueToTest);
        //Assert
        assertEquals("Fizz",result);
    }

    @Test
    public void IfNumberMultipeBy5_Them_Buzz(){
        //Arrange
        int valueToTest = 10;
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act
        String result = fizzBuzz.checkNumber(valueToTest);
        //Assert
        assertEquals("Buzz",result);
    }

    @Test
    public void IfNumberMultipeBy5And3_Them_FizzBuzz(){
        //Arrange
        int valueToTest = 15;
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act
        String result = fizzBuzz.checkNumber(valueToTest);
        //Assert
        assertEquals("FizzBuzz",result);
    }

    @Test
    public void CheckingMaxValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals(100,fizzBuzz.getMaxValue());
    }

    @Test
    public void CheckingMinValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals(1,fizzBuzz.getMinValue());
    }

    @Test
    public void CheckingMultipeThreeValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals(3,fizzBuzz.getOperationBy3Value());
    }

    @Test
    public void CheckingMultipeFiveValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals(5,fizzBuzz.getOperationBy5Value());
    }

    @Test
    public void CheckingFizzValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals("Fizz",fizzBuzz.getFizzValue());
    }

    @Test
    public void CheckingMBuzzValue(){
        //Arrange
        FizzBuzz fizzBuzz = new FizzBuzz();
        //Act

        //Assert
        assertEquals("Buzz",fizzBuzz.getBuzzValue());
    }

    @Test
    public void checkIflimitsare1to100(){
        
    }
}
