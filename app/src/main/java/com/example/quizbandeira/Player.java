package com.example.quizbandeira;
public class Player {
    public String name;
    public int score;

    public Player(String name, int point){
        this.name = name;
        this.score = point;
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
}
