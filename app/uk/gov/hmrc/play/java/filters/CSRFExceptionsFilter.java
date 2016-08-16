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

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import play.api.mvc.*;
import scala.Function1;
import scala.compat.java8.JFunction0;
import scala.concurrent.Future;
import uk.gov.hmrc.play.filters.frontend.CSRFExceptionsFilter$;

public class CSRFExceptionsFilter implements Filter {
    public CSRFExceptionsFilter() {
        super();
    }

    @Override
    public Future<Result> apply(Function1<RequestHeader, Future<Result>> f, RequestHeader rh) {
        JFunction0<DateTime> fn = () -> DateTime.now().withZone(DateTimeZone.UTC);
        return f.apply(CSRFExceptionsFilter$.MODULE$.filteredHeaders(rh, fn));
    }

    @Override
    public EssentialAction apply(EssentialAction next) {
        return Filter$class.apply(this, next);
    }
}
