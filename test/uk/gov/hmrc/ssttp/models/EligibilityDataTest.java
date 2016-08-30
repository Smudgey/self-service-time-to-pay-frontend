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

public class EligibilityDataTest {

    @Test
    public void GivenEligibilityStepOneData_WhenCreated_ThenItIsCreated() {
        EligibilityData data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityData();
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);
    }

    @Test
    public void GivenEligibilityStepOneData_WhenCreatedWithTrueValues_ThenItIsCreatedWithTrueValues() {
        EligibilityData data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityData(true, true, true);
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);

        assertTrue(data.isSelfAssessmentDebt());
        assertTrue(data.isOtherTaxDebt());
        assertTrue(data.isExistingTTP());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenSelfAssessmentDebtSet_ThenValueIsCorrect() {
        EligibilityData data = new EligibilityData();

        data.setSelfAssessmentDebt(true);
        assertTrue(data.isSelfAssessmentDebt());
        data.setSelfAssessmentDebt(false);
        assertFalse(data.isSelfAssessmentDebt());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenOtherTaxDebtSet_ThenValueIsCorrect() {
        EligibilityData data = new EligibilityData();

        data.setOtherTaxDebt(true);
        assertTrue(data.isOtherTaxDebt());
        data.setOtherTaxDebt(false);
        assertFalse(data.isOtherTaxDebt());
    }

    @Test
    public void GivenEligibilityStepOneData_WhenExistingTTPSet_ThenValueIsCorrect() {
        EligibilityData data = new EligibilityData();

        data.setExistingTTP(true);
        assertTrue(data.isExistingTTP());
        data.setExistingTTP(false);
        assertFalse(data.isExistingTTP());
    }
}
