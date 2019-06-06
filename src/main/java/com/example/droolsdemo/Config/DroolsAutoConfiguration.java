package com.example.droolsdemo.Config;

import com.example.droolsdemo.Enum.RulesEnums;
import org.kie.api.KieServices;
import org.kie.api.builder.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description  初始化规则引擎
 * @Author maxiaowei
 * @create 2019/2/18 17:59
 * @Version 1.0
 **/
@Configuration
public class DroolsAutoConfiguration {

    @Bean
    public Map<String, KieSession> getMapKieSession(){
        Map<String,KieSession> map = new HashMap<>();
        try {
            for (RulesEnums enums : RulesEnums.values()){
                KieServices kieServices = KieServices.Factory.get();
                KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
                ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
                Resource[] resources = resourcePatternResolver.getResources("classpath:" + enums.path + "**/*.*");
                for (Resource resource : resources) {
                    kieFileSystem.write(ResourceFactory.newClassPathResource(enums.path + resource.getFilename(), "UTF-8"));
                }
                final KieRepository kieRepository = kieServices.getRepository();
                kieRepository.addKieModule(() -> kieRepository.getDefaultReleaseId());
//                kieRepository.addKieModule(new KieModule() {
//                    @Override
//                    public ReleaseId getReleaseId() {
//                        return kieRepository.getDefaultReleaseId();
//                    }
//                });
                KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
                kieBuilder.buildAll();
                KieContainer kieContainer = kieServices.newKieContainer(kieRepository.getDefaultReleaseId());
                KieSession kieSession = kieContainer.newKieSession();
                map.put(enums.name,kieSession);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
