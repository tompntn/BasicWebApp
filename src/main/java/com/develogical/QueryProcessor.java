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
        return "";
    }
}
