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
import uk.gov.hmrc.ssttp.models.CalculatorInput;
import uk.gov.hmrc.ssttp.models.EligibilityDebtTypeData;
import uk.gov.hmrc.ssttp.models.EligibilityExistingTTPData;
import play.data.Form;
import views.html.eligibility.*;

public class EligibilityController extends FrontendController {

    public static F.Promise<Result>  start() {
        return F.Promise.promise(() -> redirect(routes.EligibilityController.stepOne()));
    }

    public static F.Promise<Result> stepOne() {
        Form<EligibilityDebtTypeData> form = Form.form(EligibilityDebtTypeData.class);
        return F.Promise.promise(() -> ok(step_one.render(form)));
    }

    public static F.Promise<Result> stepOneSubmit() {
        Form<EligibilityDebtTypeData> form = Form.form(EligibilityDebtTypeData.class).bindFromRequest();
        if (form.hasErrors()) {
            return F.Promise.promise(() -> ok(step_one.render(form)));
        }else {
            return F.Promise.promise(() -> redirect(routes.EligibilityController.stepTwo()));
        }
    }

    public static F.Promise<Result> stepTwo() {
        Form<EligibilityExistingTTPData> form = Form.form(EligibilityExistingTTPData.class);
        return F.Promise.promise(() -> ok(step_two.render(form)));
    }


    public static F.Promise<Result> stepTwoSubmit() {
        Form<EligibilityExistingTTPData> form = Form.form(EligibilityExistingTTPData.class).bindFromRequest();
        if (form.hasErrors()) {
            return F.Promise.promise(() -> ok(step_two.render(form)));
        } else {
            return F.Promise.promise(() -> redirect(routes.CalculatorController.form()));
        }
    }

}
