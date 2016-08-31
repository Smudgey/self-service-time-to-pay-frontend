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
  * Data for Existing TTP question in the SSTTP Eligibility wizard
  */
public class EligibilityExistingTTPData {
    public Boolean existingTTP = null;

    public Map<String,List<ValidationError>> validate() {
        Map<String, List<ValidationError>> errors = new HashMap<>();
        List<ValidationError> fieldList = null;
        if(existingTTP == null) {
            fieldList = errors.getOrDefault("existingTTP", new ArrayList<ValidationError>());
            fieldList.add(new ValidationError("ssttp.eligibility.form.existing_ttp.required", "ssttp.eligibility.form.existing_ttp.required"));
            errors.put("existingTTP", fieldList);
        }
        return errors;

    }

    public EligibilityExistingTTPData() {
    }

    public EligibilityExistingTTPData(Boolean _existingTTP) {
        existingTTP = _existingTTP;
    }
}
