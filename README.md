
# Wayfinder

Wayfinder is a pathfinding library for small robots (like those in First Tech Challenge) to automatically determine the best way to get from one point to another, rather than having a programmer write each motor move in sequence.

## How does Wayfinder work?

Wayfinder, like any pathfinding program, needs a few components to work properly. The most important of these are as follows:

### Point-to-point navigation

The pathfinding process can be boiled down to finding a series of point-to-point movements which need to be made in order to get to a destination. As a result, your robot only needs to know how to move towards a single point. The simplest strategy for moving between points is to simply turn the robot towards the target point and move forward until you reach it. This works well, but is not always the best strategy: for example, if the current waypoint is just a marker along a longer path to a different goal, you might not want to put the extra time in to stop on the waypoint itself.

Strategies which avoid stopping at each waypoint along the way are often called 'path tracking' algorithms. While there are many such algorithms, two of the most popular include 'Follow the Carrot' and 'Pure Pursuit', which work well, but are known to 'cut corners', a problem when trying to follow paths precisely.

Wayfinder uses **information needed here.**

### Pathfinding

**talk about A Star, weighted graphs, Dijkstra's algorithm here**

### Mapping

**talk about random tree mapping, free space, and obstacle detection here**

### Free Space Detection

**talk about how obstacles are detected, and how robot dimensions factor in**

### Localization

**talk about how the robot knows where it is here. Known starting location, odometry, etc should also be here**

## How do I use Wayfinder

**talk about package use here**
