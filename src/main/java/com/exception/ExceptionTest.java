package com.exception;

public class ExceptionTest {

    public static void main(String[] args) throws MyException{
        try{
            int a = 1/0;
        }catch(ArithmeticException ae){
            /*
                Exception in thread "main" MyException: a
                    at ExceptionTest.main(ExceptionTest.java:8)
                Caused by: java.lang.ArithmeticException: / by zero
                    at ExceptionTest.main(ExceptionTest.java:6)
             */
            throw new MyException("a", ae);
            
            /*
                Exception in thread "main" MyException: a
                    at ExceptionTest.main(ExceptionTest.java:14)
                throw new MyException("a");
             */
        }
    }
}
