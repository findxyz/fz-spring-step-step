package com.expression;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.List;

/**
 * Created by Administrator on 2015-4-9.
 */
public class AExpressionMain {

    public static void main(String[] args){
        /*
        * In standalone usage of SpEL there is a need to create
        * the parser,
        * parse expressions
        * and perhaps provide evaluation contexts
        * and a root context object.
        * */

        /*
        * However, more common usage is
        * to provide only the SpEL expression string as part of a configuration file,
        * for example for Spring bean or Spring Web Flow definitions.
        * In this case, the parser, evaluation context, root object and any predefined variables are all set up implicitly,
        * requiring the user to specify nothing other than the expressions.
        * */

        // parser
        ExpressionParser parser = new SpelExpressionParser();
        // parse expressions
        Expression exp = parser.parseExpression("'Hello World'");
        String message = (String) exp.getValue();
        System.out.println(message);

        Expression exp2 = parser.parseExpression("'Hello World'.concat('!')");
        String message2 = (String) exp2.getValue();
        System.out.println(message2);

        Expression exp3 = parser.parseExpression("'AaHello World a'.bytes");
        byte[] message3 = (byte[]) exp3.getValue();
        for(int i=0; i<message3.length; i++){
            System.out.println(message3[i]);
        }

        Expression exp4 = parser.parseExpression("'AaHello World a'.bytes.length");
        int length = (Integer) exp4.getValue();
        System.out.println(length);

        // root context object
        Inventor inventor = new Inventor("zhang san", "2010-01-01", "china");
        Expression exp5 = parser.parseExpression("name");
        String name = (String) exp5.getValue(inventor);
        System.out.println(name);

        // evaluation contexts
        EvaluationContext context = new StandardEvaluationContext(inventor);
        String name2 = (String) exp5.getValue(context);
        System.out.println(name2);

        inventor.setName("li si");
        System.out.println((String) exp5.getValue(inventor));
        System.out.println((String) exp5.getValue(context));

        Expression exp6 = parser.parseExpression("name == 'li si'");
        boolean result = exp6.getValue(inventor, boolean.class);
        System.out.println(result);

        inventor.myBooleans.add(true);
        Expression exp7 = parser.parseExpression("myBooleans[0]");
        exp7.setValue(inventor, "false");
        System.out.println(inventor.myBooleans);

        // Turn on:
        // - auto null reference initialization
        // - auto collection growing
        SpelParserConfiguration config = new SpelParserConfiguration(true,true);
        ExpressionParser configParser = new SpelExpressionParser(config);
        Expression exp8 = configParser.parseExpression("list[3]");
        Object o = exp8.getValue(inventor, List.class);
        System.out.println(inventor.list);
    }
}
