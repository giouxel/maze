# Maze Solver
An application, solving mazes using Breadth-first search and Depth-first search algorithms, developed using Spring Boot
### System Dependencies
- Java 8
- Web Server like Apache Tomcat
> WAR file that will be deployed to server can be created from command line by using jar tool of JDK. Use `jar -cvf projectname.war *` inside the project directory
### Application Up and Running
Access the application from `http://localhost:8080`

Sample input:
```
A .txt file containing the below definition is uploaded to the application:

____G__X
___XXX__
X______X
__XXXX__
___X____
__S__X__
```
Sample output:
```
Depth First Search output:

(6:3 (S)), (6:4), (6:5), (5:5), (5:6), (5:7), (5:8), (4:8), (4:7), (3:7), (3:6), (3:5), (3:4), (3:3), (3:2), (2:2), (2:3), (1:3), (1:4), (1:5 (G))

__**G__X
_**XXX__
X******X
__XXXX**
___X****
__S**X__

Breadth First Search output:

(6:3 (S)), (6:2), (5:2), (4:2), (3:2), (3:3), (2:3), (1:3), (1:4), (1:5 (G))

__**G__X
__*XXX__
X**____X
_*XXXX__
_*_X____
_*S__X__
```
### References
[https://en.wikipedia.org/wiki/Maze_solving_algorithm](https://en.wikipedia.org/wiki/Maze_solving_algorithm)

[https://en.wikipedia.org/wiki/Depth-first_search](https://en.wikipedia.org/wiki/Depth-first_search)

[https://en.wikipedia.org/wiki/Breadth-first_search](https://en.wikipedia.org/wiki/Breadth-first_search)

[https://www.baeldung.com/java-solve-maze](https://www.baeldung.com/java-solve-maze)
