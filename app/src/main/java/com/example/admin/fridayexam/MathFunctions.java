package com.example.admin.fridayexam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Admin on 11/10/2017.
 */

public class MathFunctions {

    public static void main(String[] args) {
        int[] numbers = {2,3,4,5,5,6,7,8,8};
        ArrayList<Integer> most = new ArrayList<Integer>();
         most = mostOccurence(numbers);
         fizzBuzz(15);
         fizzBuzz(9);
         fizzBuzz(17);
         fizzBuzz(25);
         armstrong(153);

    }

    /**
     * This function will return the most occurence of an integer in an integer array.
     * I'm returning it as an ArrayList because given a list, the most occurence can happen more than once.
     * ex: 2,3,4,5,5,6,7,8,8  in this example 5 and 8 are returned in the ArrayList
     * @param numbers
     * @return
     */
    public static ArrayList<Integer> mostOccurence(int[] numbers)
    {
        ArrayList<Integer> most = new ArrayList<Integer>();
        HashMap<Integer, Integer> counter = new HashMap<Integer, Integer>();
        //initialize all our values in the hashmap first
        int index = 0;
        while (index < numbers.length)
        {
            counter.put(new Integer(numbers[index]), new Integer(0));
            index++;
        }
        index = 0;
        //now we increment the counter values for each number added
        while (index < numbers.length)
        {
            Integer num = new Integer(numbers[index]);
            if (counter.containsKey(num))
            {
                Integer value = counter.get(num);
                counter.put(num, new Integer(value.intValue()+1));
            }
            index++;
        }
            //now we find the max count
        int maxCount = 1;
        for (Iterator i = counter.keySet().iterator(); i.hasNext();)
        {
            Integer key =  (Integer)i.next();
            Integer count = (Integer) counter.get(key);
            if (count.intValue() > maxCount)
            {
                maxCount = count.intValue();
            }
        }
        for (Iterator i = counter.keySet().iterator(); i.hasNext();)
        {
            Integer key =  (Integer)i.next();
            Integer value = (Integer) counter.get(key);
            if (value.intValue() == maxCount)
            {
                most.add(key);
            }
        }

        return most;
    }

    /**
     * Starting from numCheck, a message is printed on the following conditions:
     * if a number is divisible by three, it will type out “fizz” – divisible by five, it will type out “buzz” –
     * if divisible by both, it will type out “fizz buzz” – if not divisible by either, it will type out the number
     * @param numCheck

     */
    public static void fizzBuzz(int numCheck)
    {
        if ((numCheck % 3) == 0 && (numCheck % 5) == 0)
        {
            System.out.println("Fizz Buzz");
        }
        else if ((numCheck%3==0))
        {
            System.out.println("Fizz");
        }
        else if ((numCheck%5==0))
        {
            System.out.println("Buzz");
        }
        else
        {
            System.out.println(numCheck);
        }

    }

    /**
     * This method will do the following:check or find if a number is Armstrong number or not.
     An Armstrong number of three digit is a number whose sum of cubes of its digit is equal to its number. For example 153
     is an Armstrong number of 3 digit because 1^3+5^3+3^3 or 1+125+27=153
     Method will both print to System.out if it's Armstrong and return true or false accordingly
     * @param number
     * @return
     */
    public static boolean armstrong(int number)
    {
        boolean isArmstrong = false;
        int numCopy = number;
        int mod = 0;
        int total = 0;
        while (number >= 1)
        {
            mod = number % 10;

            total += Math.pow(mod, 3);

            number = number / 10;

        }

        if (total == numCopy)
        {
            System.out.println("Your number is Armstrong.");
            isArmstrong = true;
        }
        else
        {
            System.out.println("your number is NOT Armstrong");
        }
        return isArmstrong;
    }
}
