package kr.co.ihab.speechear.api.component;

import kr.co.ihab.speechear.api.component.listener.PrettyPrinter;
import org.jooq.ExecuteListenerProvider;
import org.jooq.impl.DefaultExecuteListenerProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DataSourceConfiguration {
    @Bean
    public ExecuteListenerProvider executeListenerProvider() {
        return new DefaultExecuteListenerProvider(new PrettyPrinter());
    }
}
