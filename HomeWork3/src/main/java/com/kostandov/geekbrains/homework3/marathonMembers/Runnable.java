package com.kostandov.geekbrains.homework3.marathonMembers;

import com.kostandov.geekbrains.homework3.obstacles.Treadmill;

public interface Runnable extends MarathonMember {
    boolean run(Treadmill treadmill);
}
