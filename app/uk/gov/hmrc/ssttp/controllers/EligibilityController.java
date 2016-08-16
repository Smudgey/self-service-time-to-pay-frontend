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

package uk.gov.hmrc.ssttp.controllers;

import play.libs.F;
import play.mvc.Result;
import uk.gov.hmrc.play.java.frontend.controller.FrontendController;
import uk.gov.hmrc.ssttp.models.EligibilityStep1Data;
import uk.gov.hmrc.ssttp.models.EligibilityStep2Data;
import play.data.Form;
import views.html.eligibility.step_one;
import views.html.eligibility.step_two;

public class EligibilityController extends FrontendController {

    public static F.Promise<Result> stepOne() {
        Form<EligibilityStep1Data> form = Form.form(EligibilityStep1Data.class).bindFromRequest();
        return F.Promise.promise(() -> ok(step_one.render(form, "")));
    }

    public static Result stepOneSubmit() {
        Form<EligibilityStep1Data> form = Form.form(EligibilityStep1Data.class).bindFromRequest();
        return redirect(routes.EligibilityController.stepTwo());
    }

    public static F.Promise<Result> stepTwo() {
        Form<EligibilityStep2Data> form = Form.form(EligibilityStep2Data.class).bindFromRequest();
        return F.Promise.promise(() -> ok(step_two.render(form, "")));
    }

    public static Result stepTwoSubmit() {
        Form<EligibilityStep2Data> form = Form.form(EligibilityStep2Data.class).bindFromRequest();
        return redirect(routes.EligibilityController.stepTwo());
    }
}
