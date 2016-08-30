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

public class EligibilityDebtTypeDataTest {

    @Test
    public void GivenEligibilityDebtTypeData_WhenCreated_ThenItIsCreated() {
        EligibilityDebtTypeData data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityDebtTypeData();
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);
    }

    @Test
    public void GivenEligibilityDebtTypeData_WhenCreatedWithTrueValues_ThenItIsCreatedWithTrueValues() {
        EligibilityDebtTypeData data = null;
        Exception thrownEx = null;
        try {
            data = new EligibilityDebtTypeData(true, true);
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);

        assertTrue(data.selfAssessmentDebt);
        assertTrue(data.otherTaxDebt);
    }

    @Test
    public void GivenEligibilityDebtTypeData_WhenSelfAssessmentDebtSet_ThenValueIsCorrect() {
        EligibilityDebtTypeData data = new EligibilityDebtTypeData();

        data.selfAssessmentDebt = true;
        assertTrue(data.selfAssessmentDebt);
        data.selfAssessmentDebt = false;
        assertFalse(data.selfAssessmentDebt);
    }

    @Test
    public void GivenEligibilityDebtTypeData_WhenOtherTaxDebtSet_ThenValueIsCorrect() {
        EligibilityDebtTypeData data = new EligibilityDebtTypeData();

        data.otherTaxDebt = true;
        assertTrue(data.otherTaxDebt);
        data.otherTaxDebt = false;
        assertFalse(data.otherTaxDebt);
    }

}
