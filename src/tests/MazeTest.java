
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/// <summary>
/// Maze.Test - A class for testing the Maze class
///
/// Assignment:     #2
/// Course:         ADEV-3001
/// Date Created:   Feb.10th, 2018
///
/// Revision Log
/// Who         When        Reason
/// ----------- ----------- ---------------
///
/// @author: Scott Wachal
/// @version 1.0
/// </summary>
public class MazeTest
{
    // Put the maze files inside of a directory called: src/maze_files/
    private static String mazeWithExitPath = "src/maze_files/simpleWithExit.maze";
    private static String mazeWithoutExitPath = "src/maze_files/simpleWithoutExit.maze";

    String basicMazeOutput =
            "WWWWWWWWWWWWW\n" +
            "W     W     W\n" +
            "W WWW W WWW W\n" +
            "W W       W W\n" +
            "W WWWWWWW WWW\n" +
            "W   W   W   W\n" +
            "WWW W WWW   W\n" +
            "W     W   WEW\n" +
            "W WWWWW W WWW\n" +
            "W       W   W\n" +
            "WWWWWWWWWWWWW";

    String basicMazeSearched =
            "WWWWWWWWWWWWW\n" +
            "W.    W     W\n" +
            "W.WWW W WWW W\n" +
            "W.W       W W\n" +
            "W.WWWWWWW WWW\n" +
            "W...WVVVW   W\n" +
            "WWW.WVWWW...W\n" +
            "W...VVW...WEW\n" +
            "W.WWWWW.WVWWW\n" +
            "W.......WVVVW\n" +
            "WWWWWWWWWWWWW";

    String basicMazeNoExitSearched =
            "No exit found in maze!\n\n" +
            "WWWWWWWWWWWWW\n" +
            "WVVVVVWVVVVVW\n" +
            "WVWWWVWVWWWVW\n" +
            "WVWVVVVVVVWVW\n" +
            "WVWWWWWWWVWWW\n" +
            "WVVVWVVVWVVVW\n" +
            "WWWVWVWWWVVVW\n" +
            "WVVVVVWVVVWVW\n" +
            "WVWWWWWVWVWWW\n" +
            "WVVVVVVVWVVVW\n" +
            "WWWWWWWWWWWWW";

    String stringPath =
            "Path to follow from Start [1, 1] to Exit [7, 11] - 27 steps:\n"+
            "[1, 1]\n[2, 1]\n[3, 1]\n[4, 1]\n[5, 1]\n[5, 2]\n[5, 3]\n[6, 3]\n" +
            "[7, 3]\n[7, 2]\n[7, 1]\n[8, 1]\n[9, 1]\n[9, 2]\n[9, 3]\n[9, 4]\n" +
            "[9, 5]\n[9, 6]\n[9, 7]\n[8, 7]\n[7, 7]\n[7, 8]\n[7, 9]\n[6, 9]\n" +
            "[6, 10]\n[6, 11]\n[7, 11]\n";

    Stack<Point> stackPath;

    private Point startingPoint;
    char[][] basicMaze;
    char[][] basicMazeNoExit;

    /// <summary>
    /// Sets up the mazes used for the tests.
    /// </summary>
    @BeforeEach
    void setup()
    {
        basicMaze = new char[11][];

        startingPoint = new Point(1, 1);
        basicMaze[0] =  "WWWWWWWWWWWWW".toCharArray();
        basicMaze[1] =  "W     W     W".toCharArray();
        basicMaze[2] =  "W WWW W WWW W".toCharArray();
        basicMaze[3] =  "W W       W W".toCharArray();
        basicMaze[4] =  "W WWWWWWW WWW".toCharArray();
        basicMaze[5] =  "W   W   W   W".toCharArray();
        basicMaze[6] =  "WWW W WWW   W".toCharArray();
        basicMaze[7] =  "W     W   WEW".toCharArray();
        basicMaze[8] =  "W WWWWW W WWW".toCharArray();
        basicMaze[9] =  "W       W   W".toCharArray();
        basicMaze[10] = "WWWWWWWWWWWWW".toCharArray();


        basicMazeNoExit = new char[11][];
        basicMazeNoExit[0] =  "WWWWWWWWWWWWW".toCharArray();
        basicMazeNoExit[1] =  "W     W     W".toCharArray();
        basicMazeNoExit[2] =  "W WWW W WWW W".toCharArray();
        basicMazeNoExit[3] =  "W W       W W".toCharArray();
        basicMazeNoExit[4] =  "W WWWWWWW WWW".toCharArray();
        basicMazeNoExit[5] =  "W   W   W   W".toCharArray();
        basicMazeNoExit[6] =  "WWW W WWW   W".toCharArray();
        basicMazeNoExit[7] =  "W     W   W W".toCharArray();
        basicMazeNoExit[8] =  "W WWWWW W WWW".toCharArray();
        basicMazeNoExit[9] =  "W       W   W".toCharArray();
        basicMazeNoExit[10] = "WWWWWWWWWWWWW".toCharArray();

        stackPath = new Stack<Point>();
        stackPath.push(new Point(7, 11));
        stackPath.push(new Point(6, 11));
        stackPath.push(new Point(6, 10));
        stackPath.push(new Point(6, 9));
        stackPath.push(new Point(7, 9));
        stackPath.push(new Point(7, 8));
        stackPath.push(new Point(7, 7));
        stackPath.push(new Point(8, 7));
        stackPath.push(new Point(9, 7));
        stackPath.push(new Point(9, 6));
        stackPath.push(new Point(9, 5));
        stackPath.push(new Point(9, 4));
        stackPath.push(new Point(9, 3));
        stackPath.push(new Point(9, 2));
        stackPath.push(new Point(9, 1));
        stackPath.push(new Point(8, 1));
        stackPath.push(new Point(7, 1));
        stackPath.push(new Point(7, 2));
        stackPath.push(new Point(7, 3));
        stackPath.push(new Point(6, 3));
        stackPath.push(new Point(5, 3));
        stackPath.push(new Point(5, 2));
        stackPath.push(new Point(5, 1));
        stackPath.push(new Point(4, 1));
        stackPath.push(new Point(3, 1));
        stackPath.push(new Point(2, 1));
        stackPath.push(new Point(1, 1));
    }

    //region Constructor Tests
    /// <summary>
    /// Checks to make sure the constructor initializes the appropriate variables
    /// </summary>
    @Test
    public void Maze_Constructor_existing_maze_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMaze);

        assertEquals(maze.getRowLength(), basicMaze.length);
        assertEquals(maze.getColumnLength(), basicMaze[0].length);
        assertEquals(maze.getStartingPoint().getRow(), startingPoint.getRow());
        assertEquals(maze.getStartingPoint().getColumn(), startingPoint.getColumn());

        char[][] existingMaze = maze.getMaze();

        for (int i = 0; i < existingMaze.length; i++)
        {
            for (int k = 0; k < existingMaze[i].length; k++)
            {
                assertEquals(existingMaze[i][k], basicMaze[i][k]);
            }
        }
    }

    /// <summary>
    /// If the existing maze has an invalid Row, throw an exception
    /// </summary>
    @Test
    public void Maze_Constructor_existingMaze_throws_error_on_negative_row_Test()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> new Maze(-1, startingPoint.getColumn(), basicMaze));
    }
    /// <summary>
    /// If the existing maze has an invalid Column, throw an exception
    /// </summary>
    @Test
    public void Maze_Constructor_existingMaze_throws_error_on_negative_column_Test()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> new Maze(startingPoint.getRow() ,- 1, basicMaze));
    }
    /// <summary>
    /// If the existing maze has an invalid Row, throw an exception
    /// </summary>
    @Test
    public void Maze_Constructor_existingMaze_throws_error_on_row_value_greater_than_maze_Test()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> new Maze(basicMaze.length, startingPoint.getColumn(), basicMaze));
    }
    /// <summary>
    /// If the existing maze has an invalid Column, throw an exception
    /// </summary>
    @Test
    public void Maze_Constructor_existingMaze_throws_error_on_column_value_greater_than_maze_Test()
    {
        assertThrows(IndexOutOfBoundsException.class, () -> new Maze(startingPoint.getRow(), basicMaze[0].length, basicMaze));
    }

    /// <summary>
    /// Checks to make sure the constructor instantializes the appropriate variables from the file
    /// </summary>
    @Test
    public void Maze_Constructor_file_maze_Test()
    {
        Maze maze = new Maze(mazeWithExitPath);

        // note that the file is the same maze as the hardcoded char array basicMaze
        assertEquals(maze.getRowLength(), basicMaze.length);
        assertEquals(maze.getColumnLength(), basicMaze[0].length);
        assertEquals(maze.getStartingPoint().getRow(), startingPoint.getRow());
        assertEquals(maze.getStartingPoint().getColumn(), startingPoint.getColumn());

        char[][] fileMaze = maze.getMaze();

        for (int i = 0; i < fileMaze.length; i++)
        {
            for (int k = 0; k < fileMaze[i].length; k++)
            {
                assertEquals(fileMaze[i][k], basicMaze[i][k]);
            }
        }
    }

    //endregion

    //region PrintMaze()
    ///// <summary>
    ///// Tests PrintMaze() returns a string version of the maze.
    ///// </summary>
    @Test
    public void PrintMaze_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMaze);

        String mazeOutput = maze.printMaze();

        assertEquals(mazeOutput, basicMazeOutput);
    }
    //endregion

    //region DepthFirstSearch()
    ///// <summary>
    ///// Tests DepthFirstSearch() returns appropriate error string when used on a maze without an exit.
    ///// </summary>
    @Test
    public void DepthFirstSearch_maze_with_no_exit_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMazeNoExit);

        String mazeOutput = maze.depthFirstSearch();
        assertEquals(mazeOutput, basicMazeNoExitSearched);
    }

    ///// <summary>
    ///// Tests DepthFirstSearch() returns path to follow string when used on a maze with an exit.
    ///// </summary>
    @Test
    public void DepthFirstSearch_maze_with_exit_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMaze);

        String mazeOutput = maze.depthFirstSearch();
        assertEquals(mazeOutput, stringPath + basicMazeSearched);
    }
    //endregion

    //region GetPathToFollow()
    ///// <summary>
    ///// Tests GetPathToFollow() throws an exception when we have not yet searched the maze.
    ///// </summary>
    @Test
    public void GetPathToFollow_before_search_throws_exception_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMaze);
        assertThrows(UnsupportedOperationException.class, () -> maze.getPathToFollow());
    }

    ///// <summary>
    ///// Tests GetPathToFollow() returns an empty stack when no exit found.
    ///// </summary>
    @Test
    public void GetPathToFollow_on_maze_with_no_exit_returns_empty_stack_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMazeNoExit);
        maze.depthFirstSearch();
        Stack<Point> path = maze.getPathToFollow();
        assertTrue(path.isEmpty());
    }

    ///// <summary>
    ///// Tests GetPathToFollow() returns a stack containing the path used from start (at Top()) to end (at bottom).
    ///// </summary>
    @Test
    public void GetPathToFollow_on_maze_with_exit_returns_ordered_stack_path_Test()
    {
        Maze maze = new Maze(startingPoint.getRow(), startingPoint.getColumn(), basicMaze);
        maze.depthFirstSearch();
        Stack<Point> path = maze.getPathToFollow();
        assertFalse(path.isEmpty());

        while (path.isEmpty())
        {
            assertEquals(path.pop(), stackPath.pop());
        }
    }
    //endregion
}