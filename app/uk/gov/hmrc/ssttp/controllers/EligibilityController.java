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
import uk.gov.hmrc.ssttp.models.EligibilityData;
import play.data.Form;
import views.html.eligibility.*;

public class EligibilityController extends FrontendController {

    public static F.Promise<Result>  start() {
        return F.Promise.promise(() -> redirect(routes.EligibilityController.stepOne()));
    }

    public static F.Promise<Result> stepOne() {
        Form<EligibilityData> form = Form.form(EligibilityData.class).bindFromRequest();
        return F.Promise.promise(() -> ok(step_one.render(form)));
    }

    public static F.Promise<Result> stepOneSubmit() {
        Form<EligibilityData> form = Form.form(EligibilityData.class).bindFromRequest();
        System.out.println(form.data().toString());
        System.out.println("Form has errors? " + form.hasErrors());
        if (form.hasErrors()) {
            form.errors().forEach((field, error) -> {
                System.out.println("Form errors: " + field + ": " + error);
            });
            return F.Promise.promise(() -> ok(step_one.render(form)));
        }else {
            return F.Promise.promise(() -> redirect(routes.EligibilityController.stepTwo()));
        }
    }

    public static F.Promise<Result> stepTwo() {
        Form<EligibilityData> form = Form.form(EligibilityData.class).bindFromRequest();
        return F.Promise.promise(() -> ok(step_two.render(form, "")));
    }

    public static F.Promise<Result>  stepTwoSubmit() {
        Form<CalculatorInput> form = Form.form(CalculatorInput.class).bindFromRequest();
        return F.Promise.promise(() -> redirect(routes.CalculatorController.form()));
    }
}
