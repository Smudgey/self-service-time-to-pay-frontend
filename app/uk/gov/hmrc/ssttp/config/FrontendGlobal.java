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

import org.apache.commons.lang3.ArrayUtils;
import play.api.mvc.EssentialFilter;
import uk.gov.hmrc.play.java.frontend.bootstrap.DefaultFrontendGlobal;
import uk.gov.hmrc.play.java.frontend.bootstrap.ShowErrorPage;
import uk.gov.hmrc.play.java.frontend.filters.WhitelistFilter;

public class FrontendGlobal extends DefaultFrontendGlobal {
    private ShowErrorPage errorPage = (pageTitle, heading, message, request) -> views.html.error_template.render(pageTitle, heading, message);

    @Override
    protected ShowErrorPage showErrorPage() {
        return errorPage;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends EssentialFilter> Class<T>[] filters() {
        return ArrayUtils.addAll(new Class[] {WhitelistFilter.class}, super.filters());
    }
}
