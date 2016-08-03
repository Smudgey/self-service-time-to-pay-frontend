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

package uk.gov.hmrc.ssttp.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import uk.gov.hmrc.play.config.RunMode$;

import java.util.List;

public class SsttpFrontendConfig {
    private static final String contactHost = "contact-frontend.host";
    private static final String contactFormServiceIdentifier = "self-service-time-to-pay";

    public String assetsPrefix = getString("assets.url") + getString("assets.version");
    public String analyticsToken = getString("google-analytics.token");
    public String analyticsHost = getString("google-analytics.host");
    public String reportAProblemPartialUrl = getString(contactHost) + "/contact/problem_reports_ajax?service="+ contactFormServiceIdentifier;
    public String reportAProblemNonJSUrl = getString(contactHost) + "/contact/problem_reports_nonjs?service="+contactFormServiceIdentifier;

    public static boolean getBoolean(String name) {
        return call(Config::getBoolean, name);
    }

    public static String getString(String name) {
        return call(Config::getString, name);
    }

    public static List<String> getStringList(String name) {
        return call(Config::getStringList, name);
    }

    private static <T> T call(ConfigFunc<T> func, String basePath) {
        String runMode = RunMode$.MODULE$.env();
        Config config = ConfigFactory.load();
        String envBasedPath = String.format("%s.%s", runMode, basePath);

        return func.get(config, config.hasPath(envBasedPath) ? envBasedPath : basePath);
    }

    interface ConfigFunc<T> {
        T get(Config config, String path);
    }
}