package com.company;

import java.util.Random;

public class Tour {

    private String route;
    private double fitness;
    private int distance;
    private Random rnd = new Random();

    public Tour(String route)
    {
        this.route=route;
        setFitness();
    }

    //Creates a random tour of cities A to highestNode
    public Tour(char highestNode)
    {
        char[] cities = new char[highestNode-('A'-1)];
        for(int i=0;i<cities.length; i++)
        {
            cities[i]=(char)('A'+i);
        }

        //shuffle
        for(int i=0;i<cities.length; i++)
        {
            char temp = cities[i];
            int randomPos = rnd.nextInt(cities.length);
            cities[i]=cities[randomPos];
            cities[randomPos] = temp;
        }
        route="X"+new String(cities)+"X";
        setFitness();
    }



    //NB case study says highest fitness value is assigned to the shortest tour.
    public void setFitness()
    {
        calculateDistance();
        fitness = 1/(double)distance;
    }

    private void calculateDistance()
    {
        distance = 0;
        for(int i=0; i<route.length()-1; i++)
        {
            distance+= MapData.getDistance(route.charAt(i), route.charAt(i+1));
        }
    }





    //To mutate, swap  two random nodes (not X)
    public void mutate()
    {
        //pick two positions exculding first and last node.
        int nodeOne = 1+rnd.nextInt(route.length()-2); //-2 as one off to exclude the last X
        int nodeTwo = 1+rnd.nextInt(route.length()-2); // and another 1 off to compensate for the +1

        //Convert to char array and swap nodes
        char[] nodes = route.toCharArray();
        char temp = nodes[nodeOne];
        nodes[nodeOne]=nodes[nodeTwo];
        nodes[nodeTwo]= temp;

        // Convert back to string.
        route = new String(nodes);

    }


    public String getRoute()
    {
        return route;
    }

    public double getFitness()
    {
        return fitness;
    }

    public int getDistance()
    {
        return distance;
    }
}
