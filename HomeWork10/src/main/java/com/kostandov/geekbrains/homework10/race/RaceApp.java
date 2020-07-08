package com.kostandov.geekbrains.homework10.race;


import com.kostandov.geekbrains.homework10.race.stages.Road;
import com.kostandov.geekbrains.homework10.race.stages.Tunnel;

public class RaceApp {
    public static void main(String[] args) {
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        race.begin();
    }
}
