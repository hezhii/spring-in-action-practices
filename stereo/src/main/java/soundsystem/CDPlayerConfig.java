package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDPlayerConfig {
    @Bean
    public CompactDisc compactDisc() {
        return new SgtPeppers();
    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) { // 不管 CompactDisc 是采用什么方法创建，Spring 都会传入。
        return new CDPlayer(compactDisc);
    }

//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(compactDisc());
//    }
}
