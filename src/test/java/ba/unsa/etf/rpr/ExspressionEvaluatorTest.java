package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * @author Faris Ćosić
 * @version 1.0
 */
public class ExspressionEvaluatorTest {

    /**
     * Probnii test
     *
     */
    @Test
    public void Probni(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(3.0, evaluator.evaluate("( 1 + 2 ) "));
    }

    /**
     * testiramo da li je parsirano
     */

    @Test void Test1 (){
        String[] expected = new String[] {"(", "2", "+", "2", ")"};
        String[] result = ExpressionEvaluator.parsedString("( 2 + 2 )");
        assertArrayEquals(expected, result);
    }


    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test2(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(101.0, evaluator.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) ) "));
    }

    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test3(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(3.0, evaluator.evaluate("    ( 15 / 5 ) "));
    }

    /**
     * Provjera izuzetka
     *
     */
    @Test
    public void Test4(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(RuntimeException.class,
                ()->{evaluator.evaluate("(1+((2+3)*(4*5)))");});
    }

    /**
     * Provjera izuzetka
     *
     */
    @Test
    public void Test5(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(RuntimeException.class,
                ()->{evaluator.evaluate("( 1 + ( ( 2 + 3kdkgdk ) * ( 4 * 5 ) ) )");});
    }
    @Test
    public void Test5izuzetak(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(RuntimeException.class,
                ()->{evaluator.evaluate("( 1 + ( ( 2 + 3kdkgdk ) * ( 4 * 5sdas ) ) )");});
    }
    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test6(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(2.0, evaluator.evaluate(" ( 4 sqrt )"));
    }

    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test7(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(12.625, evaluator.evaluate("    ( 50.5 / 4 ) "));
    }

    @Test
    public void Test8(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        Throwable exception = assertThrows(RuntimeException.class,
                ()->{evaluator.evaluate("( 5 + 7 * / 3 )");});
    }

    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test9(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(5.0, evaluator.evaluate("( ( 4 sqrt ) + ( 21 / 7 ) )"));
    }
    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test10(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(0.0, evaluator.evaluate("( ( 25 sqrt ) - ( 25 / 5 ) )"));
    }

    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test
    public void Test11(){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(101.0, evaluator.evaluate(" ( 1 + ( 5 * 20 ) )"));
    }

    /**
     * Test da li baci izuzetak za klasu validiraj
     */
    @Test void Test12(){
        assertThrows(RuntimeException.class, () -> ExpressionEvaluator.validiraj("( 2 + 3 ) )"), "Invalid operands!");

    }
    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test void Test13 (){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(2.25, evaluator.evaluate("( 9 / ( 2 * 2 ) )"));
    }
    /**
     * Test da li racuna tacno evaluate
     *
     */
    @Test void Test14 (){
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        assertEquals(4.0, evaluator.evaluate("( ( 10 * 4 ) / ( 2 * 5 ) )"));
    }


}
