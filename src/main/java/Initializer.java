import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;

/**
 * Created by leens on 3/17/2017.
 */
public class Initializer extends AbstractHttpSessionApplicationInitializer {
    public Initializer() {
        super(Config.class);
    }
}
