# Java OOP Project: bullet shooting game with GUI

This is a project from UChicago Java Programming course. The goal of this project is to apply OOP and user interfaces techniques to create a game interact with users.

### Demo
<p align = 'center'>
<img src = 'https://github.com/zachhuang4026/Bullet-Shooting-Game-Java/blob/decdaf43f666e050e3443d43ee3ba912d4555b12/demo_bullet_shooting.gif'>
</p>



The repo includes 3 sub-repo:
- controller: contains drivers to excute game and sound
- model: contains objects and interfaces as the contents of the game 
-- Falcon/NewShipFloater: players carrier which can shoot bullets
-- Shotgun: bullet shotgun to controll fire
-- Bullet: weapons to attack asteroids
-- Asteroids: foes of the Falcon
-- CollisionOp/GameOpList: data structure to store player movement log
-- CommandCenter: receive user input from keyboard
-- Movable: interface to management all game objects
-- Sprite: interface to management movements

- view: GUI for game
