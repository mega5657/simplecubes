/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JTTorres15
 */
public class LevelGenerator {

    int difficulty = 0;
    Obstacle obstacleList[];
    int groundLevel = 0;
    int distance = 0; 

    
    public LevelGenerator(int difficulty, int groundLevel) {
        this.difficulty = difficulty;
        obstacleList = new Obstacle[5];

        this.groundLevel = groundLevel;
        
           if (difficulty == 1) {
            generateEasyLevel();
        }

        if (difficulty == 2) {
            generateMediumLevel();
        }

        if (difficulty == 3) {
            generateHardLevel();
        }
    }

    public void update() {
        if (difficulty == 1) {
            generateEasyLevel();
        }

        if (difficulty == 2) {
            updateMediumLevel();
        }

        if (difficulty == 3) {
            updateHardLevel();
        }
    }

    private void generateEasyLevel() {
        for (int i = 0; i < obstacleList.length; i++) {
        }
    }

    private void generateMediumLevel() {
    }

    private void generateHardLevel() {
    }

    private void updateEasyLevel() {
        for (int i = 0; i < obstacleList.length; i++) {
        }
    }

    private void updateMediumLevel() {
    }

    private void updateHardLevel() {
    }
}
