/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Atog
 */
public class PlayerFile {

    int totalPoints = 0;
    int currentPoints = 0;
    int spentPoints = 0;

    public void setTotalPoints(int x) {
        totalPoints = x;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setCurrentPoints(int x) {
        currentPoints = x;
    }

    public int getCurrentPoints() {
        return currentPoints;
    }

    public void setSpentPoints(int x) {
        spentPoints = x;
    }

    public int getSpentPoints(int x) {
        return spentPoints;
    }
}
