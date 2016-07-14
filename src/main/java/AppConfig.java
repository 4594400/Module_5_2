import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import ua.goit.common.OperationExecutor;
import ua.goit.common.OperationProvider;
import ua.goit.log.LogAspect;
import ua.goit.operation.OperationDivide;
import ua.goit.operation.OperationMultiply;
import ua.goit.parser.Parser;
import ua.goit.parser.ParserDouble;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    @Scope("prototype")
    public OperationExecutor operationExecutor() {
        OperationExecutor operationExecutor = new OperationExecutor();
        operationExecutor.setOperationProvider(operationProvider());
        operationExecutor.setParser(parser());
        return operationExecutor;
    }


    @Bean
    public OperationProvider operationProvider() {
        OperationProvider operationProvider  =  new OperationProvider();
        operationProvider.init();
        operationProvider.addNewOperation(new OperationMultiply());
        operationProvider.addNewOperation(new OperationDivide());
        return operationProvider;
    }

    @Bean
    @Scope("prototype")
    public Parser parser() {
        Parser parser = new ParserDouble();
        return parser;
    }


}
