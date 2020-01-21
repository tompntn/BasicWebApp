package com.develogical;

public class QueryProcessor {

    public String process(String query) {
        String queryStr = query.toLowerCase();
        if (queryStr.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (queryStr.contains("what is your team name")) {
            return  "bois reborn";
        } else if (queryStr.contains("what is") && queryStr.contains("plus")) {
            // what%20is%200%20plus%2011
            String[] argsLeft = queryStr.split("what is ");
            String[] argsRight = argsLeft[1].split(" plus ");
            return Integer.toString(Integer.parseInt(argsRight[0]) + Integer.parseInt(argsRight[1]));
        }
        else if (queryStr.contains("what is") && queryStr.contains("multiplied")) {
            // what%20is%200%20plus%2011
            String[] argsLeft = queryStr.split("what is ");
            String[] argsRight = argsLeft[1].split(" multiplied by ");
            return Integer.toString(Integer.parseInt(argsRight[0]) * Integer.parseInt(argsRight[1]));
        }

        else if (queryStr.contains("which of the following numbers is the largest")) {
            String[] argsLeft = queryStr.split("which of the following numbers is the largest: ");
            String[] argsRight = argsLeft[1].split(", ");

            int maxInt = Integer.MIN_VALUE;
            for (String arg: argsRight) {

                Integer thisVal = Integer.parseInt(arg);
                maxInt = Math.max(maxInt, thisVal);

            }

            return Integer.toString(maxInt);
        }

        else if (queryStr.contains("which of the following numbers is both square and cube")) {
            String[] argsLeft = queryStr.split("which of the following numbers is both square and cube: ");
            String[] argsRight = argsLeft[1].split(", ");

            for (String arg: argsRight) {

                Integer thisVal = Integer.parseInt(arg);

                boolean isSquare = ((thisVal - Math.floor(thisVal)) == 0);

                double cubeRoot = Math.pow(thisVal,1.0/3.0);
                boolean isCube = Math.round(cubeRoot) == cubeRoot;

                if (isSquare && isCube) {
                    return arg;
                }

            }

            return "";
        }


        // what%20is%20the%2016th%20number%20in%20the%20Fibonacci%20sequence
        else if (queryStr.contains("Fibonacci sequence")) {
            String[] argsLeft = queryStr.split("what is the ");
            String[] argsRight = argsLeft[1].split("th number in the Fibonacci sequence");

            Integer n = Integer.parseInt(argsRight[0]);

            return Integer.toString(fib(n));

        }

        // which%20city%20is%20the%20Eiffel%20tower%20in
        else if (queryStr.contains("which city is the eiffel tower in")) {
            return "paris";
        }

        // who%20played%20James%20Bond%20in%20the%20film%20Dr%20No
        else if (queryStr.contains("who played James Bond in the film Dr No")) {
            return "Sean Connery";
        }


        else if (queryStr.contains("which of the following numbers are primes")) {
            String[] argsLeft = queryStr.split("which of the following numbers are primes: ");
            String[] argsRight = argsLeft[1].split(", ");


            String result = "";
            for (String arg: argsRight) {

                Integer thisVal = Integer.parseInt(arg);

                if (isPrime(thisVal)) {
                    if (!result.equals("")) {
                        result += "," + arg;
                    } else {
                        result += arg;
                    }
                }

            }

            return result;
        }

        return "";
    }

    static boolean isPrime(int n) {
        for(int i=2;i<n;i++) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    static int fib(int n)
    {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}


