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

import play.data.Form;
import play.libs.F;
import play.mvc.Result;
import uk.gov.hmrc.play.java.frontend.controller.FrontendController;
import uk.gov.hmrc.ssttp.models.CalculatorInput;
import uk.gov.hmrc.ssttp.models.CalculatorResults;
import views.html.calculator.data_form;
import views.html.calculator.results;

public class CalculatorController extends FrontendController {

    public static F.Promise<Result> form() {
        Form<CalculatorInput> form = Form.form(CalculatorInput.class).bindFromRequest();
        return F.Promise.promise(() -> ok(data_form.render(form, "")));
    }

    public static Result submit() {
        Form<CalculatorInput> form = Form.form(CalculatorInput.class).bindFromRequest();
        return redirect(routes.CalculatorController.results());
    }

    public static F.Promise<Result> results() {
        Form<CalculatorInput> form = Form.form(CalculatorInput.class).bindFromRequest();
        CalculatorResults calc_results = new CalculatorResults();
        return F.Promise.promise(() -> ok(results.render(calc_results)));
    }
}
