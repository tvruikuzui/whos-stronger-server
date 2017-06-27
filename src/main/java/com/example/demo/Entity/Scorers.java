package com.example.demo.Entity;

/**
 * Created by Aharon on 21/06/2017.
 */

public class Scorers implements Comparable<Scorers>{
    private String name;
    private int score;

    Scorers(){}

    public Scorers(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Scorers o) {
        if (this.score < o.getScore())
            return 1;
        else if (this.score > o.getScore())
            return -1;
        return 0;
    }
}
