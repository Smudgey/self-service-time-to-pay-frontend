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

/**
 * Created by Mark Paxton on 11/08/16.
 * DTO For step two of the SSTTP Eligibility wizard
 */
public class CalculatorInput {
    private BigDecimal _totalOwed;
    private LocalDate _dueDate;
    private BigDecimal _totalCanPay;

    public CalculatorInput() {

    }

    public CalculatorInput(BigDecimal _totalOwed, LocalDate _dueDate, BigDecimal _totalCanPay) {
        this._totalOwed = _totalOwed;
        this._dueDate = _dueDate;
        this._totalCanPay = _totalCanPay;
    }

    public BigDecimal GetTotalOwed() {
        return _totalOwed;
    }

    public void SetTotalOwed(BigDecimal _totalOwed) {
        this._totalOwed = _totalOwed;
    }

    public LocalDate GetDueDate() {
        return _dueDate;
    }

    public void SetDueDate(LocalDate _dueDate) {
        this._dueDate = _dueDate;
    }

    public BigDecimal GetTotalCanPay() {
        return _totalCanPay;
    }

    public void SetTotalCanPay(BigDecimal _totalCanPay) {
        this._totalCanPay = _totalCanPay;
    }
}
