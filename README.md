# Break-Out-Project
Members: Matthias Flath, Grant Auleciems, Seth Bickford
<br><br>
Our final project is going to be a break-out style game. The player will control a reflective paddle in an attempt to keep a small ball from falling off the screen. There are blocks placed in the room that the ball damages when the ball collides with them. When the blocks break the player gain points. The level ends when you have broken all the obstacles in the room. Sometimes the broken blocks will drop power ups that can have a variety of effects. Breaking all the blocks in the level advances to the next level. When a ball falls off the bottom of the screen you lose a life. The game ends when you run out of lives. 
<br><br>
**Paddle:**<br>
Controlled by the player. Ball bounces off this<br>

**Ball:**<br>
Moves at continous speed with a trail following it. Bounces off of the paddle, the walls, and the obstacles. If it falls off the bottom dereases lives by 1.<br>
Note:If extra balls are spawned need to make sure it is the last ball to fall off before it decreases lives.<br>
<br>
**Blocks:**<br>
Balls bounce off these. Different kinds require different amount of hits before they break.<br>
Breaking increases score and gives chance to spawn powerup in its place.<br>
<br>
**Power Ups:**<br>
Activate when the ball hits it. Created randomly when a brick is broken.<br>
Extra Life: increases lives by 1<br>
Extra Balls: Spawns additional balls (3-5 more)<br>
Larger Paddle: Increases size of paddle for an amount of time.<br>
Piercing Shot: Stops bouncing off of bricks. Just goes through them breaking them. Ends after certain time.<br>
Larger Ball: Increases size of ball for an amount of time.<br>
Safety Net: Creates a floor that prevents you from losing any lives for a short amount of time.<br>
Shadow Ball: Creates 5-20 fake balls that look the same as the actual balls. The fake balls on't bounce off of the paddle, only the sides of the screen. Last for a limited amount of time.
Strobe Ball: Turns the ball the same color as the background so it is invisible, then back to how it was, then the same color as the background, then back and so on. Have to keep track of the trajectory of the ball while invisible -> adds skill.
