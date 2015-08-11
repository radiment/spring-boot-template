import org.crsh.cli.Argument
import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.springframework.beans.factory.BeanFactory
import org.tepmplate.HelloService
import org.tepmplate.auth.AuthenticateResolver

public class hello {

    @Usage("say hello")
    @Command
    def main(@Usage("Name") @Argument String name) {
        BeanFactory factory = context.attributes['spring.beanfactory'] as BeanFactory;
        AuthenticateResolver resolver = factory.getBean(AuthenticateResolver.class);
        resolver.resolveAuthenticate(context.getSession());
        HelloService service = factory.getBean(HelloService.class);
        return service.hello(name);
    }
}