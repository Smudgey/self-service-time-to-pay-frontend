/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.play.java.frontend.bootstrap;

import com.kenshoo.play.metrics.JavaMetricsFilter;
import org.apache.commons.lang3.ArrayUtils;
import play.Application;
import play.GlobalSettings;
import play.Logger;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
import play.filters.headers.SecurityHeadersFilter;
import play.libs.F;
import play.mvc.Http.RequestHeader;
import play.mvc.Result;
import uk.gov.hmrc.crypto.ApplicationCrypto;
import uk.gov.hmrc.play.java.config.ServicesConfig;
import uk.gov.hmrc.play.java.filters.*;

import static uk.gov.hmrc.play.java.config.ServicesConfig.getConfBool;

public class DefaultFrontendGlobal extends GlobalSettings {
    private Class[] frontendFilters = new Class[]{
            JavaMetricsFilter.class,
            HeadersFilter.class,
            SessionCookieCryptoFilter.class,
            DeviceIdCookieFilter.class,
            LoggingFilter.class,
            AuditFilter.class,
            CSRFExceptionsFilter.class,
            CSRFFilter.class,
            CacheControlFilter.class,
            RoutingFilter.class,
            RecoveryFilter.class
    };

    private GraphiteConfig graphiteConfig = null;
    private ShowErrorPage showErrorPage = null;
    private ErrorAuditing errorAuditing = null;
    private String blockedPaths = null;

    private final Class[] securityFilters = new Class[]{SecurityHeadersFilter.class};

    private boolean enableSecurityHeaderFilter() {
        return getConfBool("security.headers.filter.enabled", true);
    }

    @Override
    public void onStart(Application app) {
        Logger.info("Starting frontend : {} : in mode {}", ServicesConfig.appName(), app.getWrappedApplication().mode());
        super.onStart(app);
        ApplicationCrypto.verifyConfiguration();
        graphiteConfig = new GraphiteConfig("microservice.metrics");
        showErrorPage = new ShowErrorPage();
        errorAuditing = new ErrorAuditing();
        graphiteConfig.onStart(app);
        RoutingFilter.init(showErrorPage, blockedPaths);
    }

    @Override
    public void onStop(Application app) {
        super.onStop(app);
        graphiteConfig.onStop(app);
    }

    @Override
    public F.Promise<Result> onBadRequest(RequestHeader rh, String error) {
        errorAuditing.onBadRequest(rh, error);
        return showErrorPage.onBadRequest(rh, error);
    }

    @Override
    public F.Promise<Result> onHandlerNotFound(RequestHeader rh) {
        errorAuditing.onHandlerNotFound(rh);
        return showErrorPage.onHandlerNotFound(rh);
    }

    @Override
    public F.Promise<Result> onError(RequestHeader rh, Throwable t) {
        errorAuditing.onError(rh, t);
        return showErrorPage.onError(rh, t);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends EssentialFilter> Class<T>[] filters() {
        if (enableSecurityHeaderFilter()) {
            return ArrayUtils.addAll(securityFilters, frontendFilters);
        } else {
            return frontendFilters;
        }
    }
}