package mealplan;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Christopher
 */
public class MealPlan {

    public static void main(String[] args) {
        
        /*
            This program creates an array and passes it by reference to other
            methods. 
                The process flow: 
                1. Get from user the number of semester weeks.
                2. Print the array with no values. Should be all zero.
                3. Pass the array into a method where you get from user 
                   the value of cost per day to be saved into the array.
                4. compute the total cost by passing into a method the
                   array and the number of weeks in the semester.
                5. Print out the results.
        */
        
        
        //call getTotalMealWeeks method, which returns the number of weeks.
        int numWeeks = getTotalMealWeeks();
        double[] dailyMealCost = new double[7];
        
        //print array contents before calling the method, should be all zeroes
        System.out.println("Before calling the method: " +
            Arrays.toString(dailyMealCost));
        
        //call dailyMealCost method - uses call by reference.
        getDailyMealCost(dailyMealCost);
        
        //print array contents after calling method.
        System.out.println("After calling the method: " +
            Arrays.toString(dailyMealCost));
        /* use the number of weeks and daily meal cost array to find the total
           note, then numweeks is a call by value, but the dailyMealCost is
           an array, so it is passing the address of the variable to the method     
        */ 
        double totalCost = computeMealPlanCost(numWeeks,dailyMealCost);
        
        //use a method to print out the total cost.
        printTotalMealPlanCost(totalCost);
                
    }
    
    //Method for getting from user the total number of semester weeks.
    //return the value to the main program from the point the method
    //was called.
    public static int getTotalMealWeeks(){
            
            Scanner in = new Scanner(System.in);
            System.out.println("How many weeks are in your semester? ");
            int totalWeeks = in.nextInt();
            
            return totalWeeks;
    }
    
    //Get from user the 7 price values of cost for each day.
    //7 is the size of the array representing one week. Store
    //the each value in the array.
    public static void getDailyMealCost(double [] dailyCost){
         
        Scanner in = new Scanner(System.in);
        
        for (int i = 0; i < dailyCost.length; i++){
            
            System.out.println("Enter the cost for the day  " +
                    (i + 1));
            
            dailyCost[i] = in.nextDouble();
            
        }
    }
        
    //Accumulate the cost of each day that is stored in the array and
    //return that value to the main program at the point this method
    //was called.
    public static double computeMealPlanCost(int numWeeks,double [] dailyCost){
        
        double totalCost = 0, weeklyCost = 0;
        for(int i = 0; i < dailyCost.length; i++){
            
            weeklyCost += dailyCost[i];
            
        }
        
        totalCost = weeklyCost * numWeeks;
        return totalCost;
        
    }  
    
    //print out the results.
    public static void printTotalMealPlanCost(double total){
        
        System.out.printf("Your estimated total meal plan cost for the " +
                "semester is: $%5.2f", total);
        
        System.out.println();
    }
}
