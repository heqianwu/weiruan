/**
 * Created with IntelliJ IDEA.
 * User: qinliu
 * Date: 14-4-16
 * Time: 下午3:20
 * To change this template use File | Settings | File Templates.
 */

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class GameTest {
    
    
    Game game = null;
    Result result = null;
    PrintStream console = null;
    ByteArrayOutputStream bytes = null;

    @org.junit.Before
    public void setUp() throws Exception {
        game = new Game();
        //game.initGame();

        bytes = new ByteArrayOutputStream();
        console = System.out;

        System.setOut(new PrintStream(bytes));


    }

    @org.junit.After
    public void tearDown() throws Exception {
        //game.gameOver(result);
        System.setOut(console);
    }

    @org.junit.Test
    public void test1() throws Exception {
        result = game.playOldGame("A1,B1,B2,B3,C3");
        boolean b = result.equals(Result.X_WIN);
        assertEquals(b,true);
        //assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 X _ _\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X O _\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X O _\n"
                +"2 _ X _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X O _\n"
                +"2 _ X _\n"
                +"3 _ O _\n"
                +"  A B C\n"
                +"1 X O _\n"
                +"2 _ X _\n"
                +"3 _ O X\n",bytes.toString());
    }
    @org.junit.Test
    public void test2() throws Exception {
        result = game.playOldGame("A1,A2,B1,B2,C1");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 X _ _\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X _ _\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O O _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X X\n"
                +"2 O O _\n"
                +"3 _ _ _\n",bytes.toString());
    }
    @org.junit.Test
    public void test3() throws Exception {
        result = game.playOldGame("C1,A2,C2,B2,C3");
        assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 _ _ X\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O O X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O O X\n"
                +"3 _ _ X\n",bytes.toString());
    }
    @org.junit.Test
    public void test4() throws Exception {
        result = game.playOldGame("C1,A2,C2,C3,B2,A3,A1,B1,B3");
        assertEquals(Result.DRAW,result);
        assertEquals(
                 "  A B C\n"
                +"1 _ _ X\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ O\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O X X\n"
                +"3 _ _ O\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X _ X\n"
                +"2 O X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 O X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 O X X\n"
                +"3 O X O\n",bytes.toString());
    }
        @org.junit.Test
    public void test5() throws Exception {
        result = game.playOldGame("A1,C1,A2,B2,B1,A3");
        boolean b = result.equals(Result.O_WIN);
        assertEquals(b,true);
        //assertEquals(Result.X_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 X _ _\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X _ O\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X _ O\n"
                +"2 X _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X _ O\n"
                +"2 X O _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X O\n"
                +"2 X O _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X O\n"
                +"2 X O _\n"
                +"3 O _ _\n",bytes.toString());
    }
    @org.junit.Test
    public void test6() throws Exception {
        result = game.playOldGame("A1,A2,B1,B2,C3,C2");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 X _ _\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X _ _\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O O _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O O _\n"
                +"3 _ _ X\n"
                +"  A B C\n"
                +"1 X X _\n"
                +"2 O O O\n"
                +"3 _ _ X\n",bytes.toString());
    }
    @org.junit.Test
    public void test7() throws Exception {
        result = game.playOldGame("C1,A2,C2,A1,B2,A3");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 _ _ X\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 O _ X\n"
                +"2 O _ X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 O _ X\n"
                +"2 O X X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 O _ X\n"
                +"2 O X X\n"
                +"3 O _ _\n",bytes.toString());
    }
    @org.junit.Test
    public void test8() throws Exception {
        result = game.playNewGame("C1,A2,C2,C3,B2,A3,A1,B1,C1,B3,A2,B2");
        assertEquals(Result.O_WIN,result);
        assertEquals(
                 "  A B C\n"
                +"1 _ _ X\n"
                +"2 _ _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ _\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ _\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O _ X\n"
                +"3 _ _ O\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O X X\n"
                +"3 _ _ O\n"
                +"  A B C\n"
                +"1 _ _ X\n"
                +"2 O X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X _ _\n"
                +"2 O X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X O _\n"
                +"2 _ X X\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 _ X _\n"
                +"3 O _ O\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 _ X _\n"
                +"3 O O _\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 X _ _\n"
                +"3 O O _\n"
                +"  A B C\n"
                +"1 X O X\n"
                +"2 X O _\n"
                +"3 _ O _\n",bytes.toString());
    }
}
