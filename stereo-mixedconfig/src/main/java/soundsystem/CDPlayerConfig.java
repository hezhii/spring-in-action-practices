package soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;

@Configuration
//@Import(CDConfig.class) // 或者创建一个更高级的配置
public class CDPlayerConfig {
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) { // IntelliJ 这里报错，编辑器的原因，没有识别 SoundSystemConfig 中的 @Import
        return new CDPlayer(compactDisc);
    }
}
