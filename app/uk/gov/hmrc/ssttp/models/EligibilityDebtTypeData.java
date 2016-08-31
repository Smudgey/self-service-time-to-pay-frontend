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

package uk.gov.hmrc.ssttp.models;

import play.data.validation.Constraints;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
  * Created by Mark Paxton on 02/08/16.
  * Data for Debt Type Question in the SSTTP Eligibility wizard
  */
public class EligibilityDebtTypeData {
    public boolean selfAssessmentDebt = false;
    public boolean otherTaxDebt = false;

    public Map<String,List<ValidationError>> validate() {
        Map<String, List<ValidationError>> errors = new HashMap<>();
        List<ValidationError> fieldList = null;
        if (!(otherTaxDebt || selfAssessmentDebt)) {
            fieldList = errors.getOrDefault("debt_type", new ArrayList<ValidationError>());
            fieldList.add(new ValidationError("ssttp.eligibility.form.debt_type.required", "ssttp.eligibility.form.debt_type.required"));
            errors.put("debt_type", fieldList);
        }
        return errors;
    }

    public EligibilityDebtTypeData() {
    }

    public EligibilityDebtTypeData(boolean _selfAssessmentDebt, boolean _otherTaxDebt) {
        selfAssessmentDebt = _selfAssessmentDebt;
        otherTaxDebt = _otherTaxDebt;
    }
}
