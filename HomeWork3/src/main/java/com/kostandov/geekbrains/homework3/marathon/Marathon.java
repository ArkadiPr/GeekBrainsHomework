package com.kostandov.geekbrains.homework3.marathon;

import com.kostandov.geekbrains.homework3.marathonMembers.MarathonMember;
import com.kostandov.geekbrains.homework3.obstacles.MarathonObstacle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marathon {
    private List<MarathonMember> members;
    private List<MarathonObstacle> obstacles;

    public Marathon(List<MarathonMember> members, List<MarathonObstacle> obstacles) {
        this.members = members;
        this.obstacles = obstacles;
    }

    public void runMarathon(){
        members.stream().forEach(marathonMember -> currentMemberMarathon(marathonMember,obstacles));

    }
    private void currentMemberMarathon(MarathonMember marathonMember, List<MarathonObstacle> marathonObstacles){
        boolean resultOfObstacle;
        for(MarathonObstacle marathonObstacle : marathonObstacles){
            resultOfObstacle=marathonMember.passObstacle(marathonObstacle);
            if(!resultOfObstacle)
                break;
        }
    }
}
