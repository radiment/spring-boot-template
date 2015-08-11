package crash;

import org.crsh.shell.Shell;
import org.crsh.shell.ShellFactory;
import org.crsh.shell.impl.command.CRaSHShellFactory;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class SpringSecurityShelFactory extends CRaSHShellFactory implements ShellFactory {
    @Override
    public Shell create(Principal principal) {
        return super.create(principal);
    }
}
