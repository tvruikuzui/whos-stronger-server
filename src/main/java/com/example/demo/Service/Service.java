package com.example.demo.Service;

import com.example.demo.Entity.Scorers;

import java.util.*;

/**
 * Created by Aharon on 21/06/2017.
 */
@org.springframework.stereotype.Service
public class Service {

    static List<Scorers> leaderBoard = new ArrayList<>();

    {
        leaderBoard.add(new Scorers("ahron0",0));
        leaderBoard.add(new Scorers("ahron1",1));
        leaderBoard.add(new Scorers("ahron2",2));
        leaderBoard.add(new Scorers("ahron3",3));
        leaderBoard.add(new Scorers("ahron4",4));
        leaderBoard.add(new Scorers("ahron5",5));
        leaderBoard.add(new Scorers("ahron6",6));
        leaderBoard.add(new Scorers("ahron7",7));
        leaderBoard.add(new Scorers("ahron8",8));
        leaderBoard.add(new Scorers("ahron9",9));
        Collections.sort(leaderBoard);
    }

    public Collection<Scorers> getTopScorers() {
        return leaderBoard;
    }

    public String addScorer(Scorers scorer) {
        if (leaderBoard.size() == 10 && leaderBoard.get(9).getScore() < scorer.getScore()) {
            if (containsName(scorer)) return "error";
            for (int i = 0; i < leaderBoard.size(); i++) {
                if (leaderBoard.get(i).getScore() < scorer.getScore()) {
                    leaderBoard.add(i, scorer);
                    leaderBoard.remove(10);
                    return "ok";
                }
            }
        }else
            if (leaderBoard.size() < 10) {
                if (leaderBoard.add(scorer)) {
                    Collections.sort(leaderBoard);
                    return "ok";
                }
            }
        return "error";

    }

    private boolean containsName(Scorers scorer) {
        for (Scorers s :
                leaderBoard) {
            if (s.getName().equals(scorer.getName()))
                return true;
        }
        return false;
    }
}
