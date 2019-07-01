

How does Mockita add functionality to an interface ?
======================================
Mockito adds functionality(such as it is) to 
an interface via using the method :

    when()


This method adds some definition(functionality) to the method signatures included within the mocked interface.


Example of using the when(...) method to 
provide functionality to specified interface
contracts below:

//code
//adding the behavior of calc service to add two
//numbers

`when(calService.add(10.0,20.0)).thenReturn(30.00);`


Above we have instructed Mockito to give a behavior
of adding 10 and 20 to the add(...) method of 
calcService and as a result, to reutn the value 
30.00

At this point of time, Mock recorded the behavior and is a working mock object.




Example 
===============================================
Step-1 Crate an interface called 
CalculatorService to provide the required math
functions....

    `public interface CalculatorService {
    public double add(double input1, double input2);
    public double subtract(double input1, double input2);
    public double multiply(double input1, double input2);
    public double divide(double input1, double input2);
    }`


Step-2 Create some code to represent the math application that uses the methods in the mocked 
service interface as a dependency...



`
        public class MathApplication {
   private CalculatorService calcService;

   public void setCalculatorService(CalculatorService calcService){
      this.calcService = calcService;
   }
   
   public double add(double input1, double input2){
      return calcService.add(input1, input2);
   }
   
   public double subtract(double input1, double input2){
      return calcService.subtract(input1, input2);
   }
   
   public double multiply(double input1, double input2){
      return calcService.multiply(input1, input2);
   }
   
   public double divide(double input1, double input2){
      return calcService.divide(input1, input2);
   }
}
`







