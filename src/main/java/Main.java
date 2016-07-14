import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.common.OperationExecutor;
import ua.goit.log.LogAspect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class, LogAspect.class);
        //ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "aop-context.xml");


        OperationExecutor operationExecutor = applicationContext.getBean("operationExecutor", OperationExecutor.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please, input expression. For example: 5 + 3 or 95 * 5.");
        try {
            String expression = reader.readLine();
            System.out.println(expression + " = " + operationExecutor.executeOperation(expression));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
