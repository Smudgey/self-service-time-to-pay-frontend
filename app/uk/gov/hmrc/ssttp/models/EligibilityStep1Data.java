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

/**
  * Created by Mark Paxton on 02/08/16.
  * DTO For step one of the SSTTP Eligibility wizard
  */
public class EligibilityStep1Data {
    private boolean _selfAssessmentDebt = false;
    private boolean _otherTaxDebt = false;
    private boolean _existingTTP = false;

  public EligibilityStep1Data() {

  }


  public EligibilityStep1Data(boolean selfAssessmentDebt, boolean otherTaxDebt, boolean existingTTP) {
    SetSelfAssessmentDebt(selfAssessmentDebt);
    SetOtherTaxDebt(otherTaxDebt);
    SetExistingTTP(existingTTP);
  }


    public boolean HasSelfAssessmentDebt() {
        return _selfAssessmentDebt;
    }

    public void SetSelfAssessmentDebt(boolean _selfAssessmentDebt) {
        this._selfAssessmentDebt = _selfAssessmentDebt;
    }

    public boolean HasOtherTaxDebt() {
        return _otherTaxDebt;
    }

    public void SetOtherTaxDebt(boolean _otherTaxDebt) {
        this._otherTaxDebt = _otherTaxDebt;
    }

    public boolean HasExistingTTP() {
        return _existingTTP;
    }

    public void SetExistingTTP(boolean _existingTTP) {
        this._existingTTP = _existingTTP;
    }
}
