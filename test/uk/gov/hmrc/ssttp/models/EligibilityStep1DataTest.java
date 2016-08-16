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

import org.junit.Test;
import static org.junit.Assert.*;

public class EligibilityStep1DataTest {

    @Test
    public void GivenEligibilityStepOneData_WhenCreated_ThenItIsCreated() {
        EligibilityStep1Data data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityStep1Data();
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);
    }

    @Test
    public void GivenEligibilityStepOneData_WhenCreatedWithTrueValues_ThenItIsCreatedWithTrueValues() {
        EligibilityStep1Data data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityStep1Data(true, true, true);
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);

        assertTrue(data.HasSelfAssessmentDebt());
        assertTrue(data.HasOtherTaxDebt());
        assertTrue(data.HasExistingTTP());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenSelfAssessmentDebtSet_ThenValueIsCorrect() {
        EligibilityStep1Data data = new EligibilityStep1Data();

        data.SetSelfAssessmentDebt(true);
        assertTrue(data.HasSelfAssessmentDebt());
        data.SetSelfAssessmentDebt(false);
        assertFalse(data.HasSelfAssessmentDebt());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenOtherTaxDebtSet_ThenValueIsCorrect() {
        EligibilityStep1Data data = new EligibilityStep1Data();

        data.SetOtherTaxDebt(true);
        assertTrue(data.HasOtherTaxDebt());
        data.SetOtherTaxDebt(false);
        assertFalse(data.HasOtherTaxDebt());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenExistingTTPSet_ThenValueIsCorrect() {
        EligibilityStep1Data data = new EligibilityStep1Data();

        data.SetExistingTTP(true);
        assertTrue(data.HasExistingTTP());
        data.SetExistingTTP(false);
        assertFalse(data.HasExistingTTP());
    }
}
