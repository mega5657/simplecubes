/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Atog
 */
public class Unlocks {

    int tierUnlocked = 0;
    int totalBalance = 0;
    int spentBalance = 0;
    int currentBalance = 0;
    boolean firstCreation = true;
    boolean multipleBlocks = false;
    boolean doubleJump = false;

    public int getTierUnlocked() {
        return tierUnlocked;
    }

    public void setTierUnlocked(int tierUnlocked) {
        this.tierUnlocked = tierUnlocked;
    }

    public int getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(int totalBalance) {
        this.totalBalance = totalBalance;
    }

    public int getSpentBalance() {
        return spentBalance;
    }

    public void setSpentBalance(int spentBalance) {
        this.spentBalance = spentBalance;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public boolean isFirstCreation() {
        return firstCreation;
    }

    public void setFirstCreation(boolean firstCreation) {
        this.firstCreation = firstCreation;
    }

    public boolean isMultipleBlocks() {
        return multipleBlocks;
    }

    public void setMultipleBlocks(boolean multipleBlocks) {
        this.multipleBlocks = multipleBlocks;
    }

    public boolean isDoubleJump() {
        return doubleJump;
    }

    public void setDoubleJump(boolean doubleJump) {
        this.doubleJump = doubleJump;
    }
    
            

}
