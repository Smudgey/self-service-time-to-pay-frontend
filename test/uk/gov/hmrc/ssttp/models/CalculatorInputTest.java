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

import org.joda.time.LocalDate;
import java.math.BigDecimal;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorInputTest {

    @Test
    public void GivenEligibilityStepTwoData_WhenCreated_ThenItIsCreated() {
        CalculatorInput data = null;
        Exception thrownEx = null;
        try {
            data = new CalculatorInput();
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);
    }

    @Test
    public void GivenEligibilityStepTwoData_WhenCreatedWithValues_ThenItIsCreatedWithValues() {
        CalculatorInput data = null;
        Exception thrownEx = null;
        try {
            data = new CalculatorInput(new BigDecimal(1000), new LocalDate(2016, 1, 30), new BigDecimal(100));
        } catch (Exception e) {
            thrownEx = e;
        }
        assertNull(thrownEx);
        assertNotNull(data);

        assertEquals(new BigDecimal(1000), data.GetTotalOwed());
        assertEquals(new LocalDate(2016, 1, 30), data.GetDueDate());
        assertEquals(new BigDecimal(100), data.GetTotalCanPay());
    }

    @Test
    public void GivenEligibilityStepTwoData_WhenTotalOwedSet_ThenValueIsCorrect() {
        CalculatorInput data = new CalculatorInput();

        data.SetTotalOwed(new BigDecimal(9999.99));
        assertEquals(new BigDecimal(9999.99), data.GetTotalOwed());
        data.SetTotalOwed(new BigDecimal(99.00));
        assertEquals(new BigDecimal(99.00), data.GetTotalOwed());
    }

    @Test
    public void GivenEligibilityStepTwoData_WhenDueDateSet_ThenValueIsCorrect() {
        CalculatorInput data = new CalculatorInput();

        data.SetDueDate(new LocalDate(2017, 6, 30));
        assertEquals(new LocalDate(2017, 6, 30), data.GetDueDate());
        data.SetDueDate(new LocalDate(2015, 1, 29));
        assertEquals(new LocalDate(2015, 1, 29), data.GetDueDate());
    }

    @Test
    public void GivenEligibilityStepTwoData_WhenTotalCanPaySet_ThenValueIsCorrect() {
        CalculatorInput data = new CalculatorInput();

        data.SetTotalCanPay(new BigDecimal(9999.13));
        assertEquals(new BigDecimal(9999.13), data.GetTotalCanPay());
        data.SetTotalCanPay(new BigDecimal(99.01));
        assertEquals(new BigDecimal(99.01), data.GetTotalCanPay());

    }
}

