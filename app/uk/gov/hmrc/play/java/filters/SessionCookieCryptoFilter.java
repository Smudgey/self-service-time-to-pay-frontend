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

package uk.gov.hmrc.play.java.filters;

import play.api.mvc.EssentialAction;
import play.api.mvc.Filter$class;
import play.api.mvc.RequestHeader;
import play.api.mvc.Result;
import scala.Function1;
import scala.concurrent.Future;
import uk.gov.hmrc.play.filters.frontend.CookieCryptoFilter;
import uk.gov.hmrc.play.filters.frontend.CookieCryptoFilter$class;
import uk.gov.hmrc.play.frontend.filters.SessionCookieCryptoFilter$;

public class SessionCookieCryptoFilter implements CookieCryptoFilter {
    private String cookieName = SessionCookieCryptoFilter$.MODULE$.cookieName();

    @Override
    public String cookieName() {
        return cookieName;
    }

    @Override
    public Function1<String, String> decrypter() {
        return SessionCookieCryptoFilter$.MODULE$.decrypter();
    }

    @Override
    public Function1<String, String> encrypter() {
        return SessionCookieCryptoFilter$.MODULE$.encrypter();
    }

    @Override
    public EssentialAction apply(EssentialAction next) {
        return Filter$class.apply(this, next);
    }

    @Override
    public Future<Result> apply(Function1<RequestHeader, Future<Result>> next, RequestHeader rh) {
        return CookieCryptoFilter$class.apply(this, next, rh);
    }

    public void uk$gov$hmrc$play$filters$frontend$CookieCryptoFilter$_setter_$cookieName_$eq(String cookieName) {
        this.cookieName = cookieName;
    }
}
