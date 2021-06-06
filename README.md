# Space-Invaders

**Tank**

This is a player controlled entity that can be moved by pressing the left and right arrow keys on the keyboard and moves at a rate of 1 pixel per a frame . The tank is 22x14 pixels, it starts at the bottom-middle of the display. A tank can fire projectiles which can hit the barriers or enemy invaders. It can shoot multiple projectiles towards the invaders. If an enemy projectile hits the tank, it will lose a hit point, if the tank is hit 3 times, the game should transition to a Game Over screen since the tank has been destroyed.

**Invader**

Each invader has a unique starting position but move in time with every other invader. The invader swarm moves from the top-middle of the screen to the player's barriers. Once an invader has reached the barriers, the game should transition to a Game Over screen.

Invaders will move 30 steps in one direction before moving down and heading 30 steps in the other direction. Each sideways step will constitute a movement of 1 pixel, each step is made every two frames. When an invader moves downward, it will move 8 pixels down and transition to it's other sprite.

The invaders are part of a larger swarm, the swarm starts with 40 invaders (10 invaders per row, 4 rows). Each invader is 16x16 pixels, this will correspond with the size of their sprites. They will have the same collision area as their sprites.

Once an invader is hit, it is considered to have been destroyed and should no longer be rendered by the game. When all invaders have been hit, this will result in the player winning the game and transitioning to the Next Level screen.

Every 5 seconds, an invader will be randomly selected to fire a projectile downwards.

**Barrier**

A barrier is composed of 9 different components, each component can sustain 3 hits. Once a component has been destroyed, it no longer offers protection for the tank. When a barrier sustains a hit, it will change to a different sprite, indicating that it has been damaged. The player is provided with 3 barriers, each barrier, left barrier is at least 20 pixels away from the left boundary described in the application section, the center barrier starts in the centre of the screen, right barrier is at least 20 pixels away from the right boundary. Each barrier is at least 10 pixels above the tank's location.

A barrier can be hit by the tank and an invader.

**Projectile**

A projectile can be fired by both the tank and an invader, however, an invader's projectile will not hit any other invader (only the barrier and tank). The tank can hit the barrier as well as any invader. Once a projectile impacts with another entity, it will cease to exist.

The projectile is 1x3 pixels and travels upwards 1px per frame.

**Game Conditions**

The goal of the game is for the player to destroy all invaders before either the tank is destroyed or the invaders land.
The player wins when the following conditions have been met: 

* All invaders are destroyed.

The computer wins when one of the following conditions have been met:

* An invader reaches the barriers (10px away from the barriers). 

* The tank is hit 3 times and destroyed.

**Application**
Your application will need to adhere to the following specification
640 width 480 height window with a black background.
Left boundary (tank cannot move past this point) at x 180, Right boundary at x 460.
Must maintain a frame rate of 60 frames per second.
Your application must be able to compile and run using build & gradle run
Your program must not exhibit any memory leak, try to load all assets prior to usage.
You must use the processing library, you cannot use any other framework such as javafx, awt or jogl.
