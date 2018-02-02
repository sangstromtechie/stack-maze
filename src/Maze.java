/**
 * Maze - A class that is used to read a maze file and store the relevant data about the starting point and maze.
 *
 * <pre>
 *
 * Assignment:     #1
 * Course:         ADEV-3001
 * Date Created:   February 2nd 2018
 *
 * Revision Log
 * Who       When          Reason
 * --------- ------------- ---------------------------------
 *
 * </pre>
 *
 * @author Christian Wenham
 * @version 1.0
 *
 */
public class Maze {

    private Point startPoint;
    private String[][] maze;

    public void Maze() {
        this.startPoint = null;
        this.maze = null;
    }

    public void readMazeFile(String mazeFileName) {

    }

    public Point getStartingPoint() {
        return startPoint;
    }

    public String[][] getMaze() {
        return maze;
    }
}
