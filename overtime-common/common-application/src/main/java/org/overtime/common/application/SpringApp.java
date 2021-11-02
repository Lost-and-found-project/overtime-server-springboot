package org.overtime.common.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * SpringApplication 启动器工具。
 *
 * @author ForteScarlet
 */
@SuppressWarnings({"UnusedReturnValue", "unused"})
@Slf4j
public final class SpringApp {

    /**
     * 根据提供的参数启动Spring。
     *
     * @param args           args
     * @param primarySources primary sources.
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext run(String[] args, Class<?>... primarySources) {
        if (primarySources.length == 0) {
            log.warn("SpringApp.run(args, primarySources), but 'primarySources' was empty.");
        }
        return new SpringApplication(primarySources).run(args);
    }

    /**
     * 通过 {@link StandardControllerApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandardController(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandardControllerApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


    /**
     * 通过 {@link StandardResourceApiApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandardResourcesApi(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandardResourceApiApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


    /**
     * 通过 {@link StandardNoHandlerApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandardNoHandler(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandardNoHandlerApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


    /**
     * 通过 {@link StandaloneControllerApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandaloneController(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandaloneControllerApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


    /**
     * 通过 {@link StandaloneResourceApiApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandaloneResourcesApi(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandaloneResourceApiApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


    /**
     * 通过 {@link StandaloneNoHandlerApplication} 启动spring application。
     *
     * @param args args
     * @return {@link ConfigurableApplicationContext}
     */
    public static ConfigurableApplicationContext runStandaloneNoHandler(String[] args, Class<?>... primarySources) {
        Class<?>[] ps = new Class<?>[primarySources.length + 1];
        ps[0] = StandaloneNoHandlerApplication.class;
        System.arraycopy(primarySources, 0, ps, 1, primarySources.length);
        return run(args, ps);
    }


}
