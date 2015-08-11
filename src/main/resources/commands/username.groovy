import org.crsh.cli.Command
import org.crsh.cli.Usage
import org.springframework.beans.factory.BeanFactory
import org.tepmplate.auth.AuthenticateResolver

public class username {

    @Usage("get username")
    @Command
    def main() {
        BeanFactory factory = context.attributes['spring.beanfactory'] as BeanFactory;
        AuthenticateResolver service = factory.getBean(AuthenticateResolver.class);
        return service.getUsername(context.getSession());
    }
}