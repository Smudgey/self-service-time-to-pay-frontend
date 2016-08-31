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

import uk.gov.hmrc.play.java.config.ServicesConfig;

public class FrontendConfig extends ServicesConfig {

    private static final String contactHost = getConfString("contact-frontend.host", "");
    private static final String contactFormServiceIdentifier = "self-service-time-to-pay";

    public String assetsPrefix = loadConfig("assets.url") + loadConfig("assets.version");
    public String analyticsToken = loadConfig("google-analytics.token");
    public String analyticsHost = loadConfig("google-analytics.host");
    public String reportAProblemPartialUrl = String.format("%s/contact/problem_reports_ajax?service=%s", contactHost, contactFormServiceIdentifier);
    public String reportAProblemNonJSUrl = String.format("%s/contact/problem_reports_nonjs?service=%s", contactHost, contactFormServiceIdentifier);

    public FrontendConfig() throws Exception {
        super();
    }
}