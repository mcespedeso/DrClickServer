package py.com.solumed.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 *
 * @author mcespedes
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

//    private static final String MESSAGES_PATH = "i18n/messages";

//    private static final String LOCALE_HEADER = "X-Locale";

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(localeChangeInterceptor());
    }

//    @Bean
//    public I18n i18n () {
//        return new I18n(messageSource());
//    }

//    @Bean
//    public LocalValidatorFactoryBean validator() {
//        LocalValidatorFactoryBean factory = new LocalValidatorFactoryBean();
//        factory.setMessageInterpolator(i18n());
//        factory.setValidationMessageSource(messageSource());
//
//        return factory;
//    }

//    @Bean
//    public MessageSource messageSource() {
//        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//        messageSource.setBasenames(MESSAGES_PATH);
//        messageSource.setFallbackToSystemLocale(false);
//
//        return messageSource;
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//        LocaleChangeInterceptor lci = new LocaleChangeInterceptor() {
//            @Override
//            public boolean preHandle(HttpServletRequest request,
//                    HttpServletResponse response, Object handler)
//                    throws ServletException {
//
//                String newLocale = request.getHeader(LOCALE_HEADER);
//                if (newLocale != null) {
//                    LocaleResolver localeResolver = RequestContextUtils
//                            .getLocaleResolver(request);
//                    if (localeResolver == null) {
//                        throw new IllegalStateException(
//                                "No LocaleResolver found: not in a DispatcherServlet request?");
//                    }
//                    try {
//                        localeResolver.setLocale(request, response,
//                                parseLocaleValue(newLocale));
//                    } catch (IllegalArgumentException ex) {
//                        if (isIgnoreInvalidLocale()) {
//                            logger.debug("Ignoring invalid locale value ["
//                                    + newLocale + "]: " + ex.getMessage());
//                        } else {
//                            throw ex;
//                        }
//                    }
//                }
//                return true;
//            }
//        };
//        return lci;
//    }
}
