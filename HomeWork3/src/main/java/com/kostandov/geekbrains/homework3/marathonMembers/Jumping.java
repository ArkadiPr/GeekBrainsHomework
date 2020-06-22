package com.kostandov.geekbrains.homework3.marathonMembers;

import com.kostandov.geekbrains.homework3.obstacles.Wall;

public interface Jumping extends MarathonMember {
    boolean jump(Wall wall);
}
