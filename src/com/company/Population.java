package com.company;

import java.util.ArrayList;

public class Population {


    /*
    SELECTION METHODS
            1 = roulette wheel selection
            2 = stochastic universal sampling
            3 = tournament selection
            4 = truncation selection.
    */
    private int selectionType = 1;

    /*
    CROSSOVER METHODS
        1 = Partially mapped crossover (PMX)
        2 = Order crossover (OX)
        3 = Cycle crossover (CX)
     */
    private int crossoverType = 1;

    private ArrayList<Tour> listOfTours=new ArrayList<>();

    public Population(int size, int selectionType, int crossoverType)
    {
        this.selectionType=selectionType;
        this.crossoverType=crossoverType;



    }
}
