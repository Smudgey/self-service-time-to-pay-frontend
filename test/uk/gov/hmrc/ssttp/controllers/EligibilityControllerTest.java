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

import org.junit.Before;
import org.junit.Test;
import play.i18n.Messages;
import play.libs.F;
import play.mvc.Http;
import play.mvc.Result;
import play.test.FakeRequest;
import play.twirl.api.Content;
import uk.gov.hmrc.ssttp.config.FrontendGlobal;

import java.util.Collections;
import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static play.test.Helpers.*;

public class EligibilityControllerTest {

    @Before
    public void setUp() {
        Map<String, String> flashData = Collections.emptyMap();
        Map<String, Object> argData = Collections.emptyMap();
        Long id = 2L;
        play.api.mvc.RequestHeader header = new FakeRequest("GET", "/").getWrappedRequest();
        Http.Request request = mock(Http.Request.class);
        Http.Context ctx = new Http.Context(id, header, request, flashData, flashData, argData);
        Http.Context.current.set(ctx);

        when(request.body()).thenReturn(new Http.RequestBody());
    }

    @Test
    public void GivenEligibilityController_WhenPageOneRendered_ThenTitleIsDispalyed() {
        running(fakeApplication(new FrontendGlobal()), () -> {
            //Content html = views.html.eligibility.step_one.render();
            //assertThat(html.contentType(), is("text/html"));
            //assertThat(contentAsString(html), containsString(Messages.get("ssttp.landing.title")));
        });
    }

    @Test
    public void GivenEligibilityController_WhenPageOneRendered_ThenIntroTextIsDispalyed() {
        running(fakeApplication(new FrontendGlobal()), () -> {
            Result r = EligibilityController.stepOne().get(3000);
            StringBuffer b = new StringBuffer();
            b.append(r.toScala().body());
            System.out.println(b.toString());


            //.map(result -> {
//                //play.api.mvc.Result r = result.toScala();
//
//                //String html = r.toString();
//                //assertThat(html.contentType(), is("text/html"));
//                //assertThat(contentAsString(html), containsString(Messages.get("ssttp.landing.intro")));
//            });
        });
    }
}
