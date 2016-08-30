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

/**
  * Created by Mark Paxton on 02/08/16.
  * DTO For step one of the SSTTP Eligibility wizard
  */
public class EligibilityData {
    public boolean selfAssessmentDebt = false;
    public boolean otherTaxDebt = false;

    @Constraints.Required(message = "ssttp.eligibility.form.existingTTP.required")
    public boolean existingTTP;

    public String validate() {
        return (otherTaxDebt || selfAssessmentDebt) ? null : "ssttp.eligibility.form.debt_type.required";
    }

    public EligibilityData() {
    }

    public EligibilityData(boolean _selfAssessmentDebt, boolean _otherTaxDebt, boolean _existingTTP) {
        selfAssessmentDebt = _selfAssessmentDebt;
        otherTaxDebt = _otherTaxDebt;
        existingTTP = _existingTTP;
    }

    public boolean isSelfAssessmentDebt() {
        return selfAssessmentDebt;
    }

    public void setSelfAssessmentDebt(boolean selfAssessmentDebt) {
        this.selfAssessmentDebt = selfAssessmentDebt;
    }

    public boolean isOtherTaxDebt() {
        return otherTaxDebt;
    }

    public void setOtherTaxDebt(boolean otherTaxDebt) {
        this.otherTaxDebt = otherTaxDebt;
    }

    public boolean isExistingTTP() {
        return existingTTP;
    }

    public void setExistingTTP(boolean existingTTP) {
        this.existingTTP = existingTTP;
    }
}
