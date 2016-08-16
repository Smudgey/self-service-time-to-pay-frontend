import de.heikoseeberger.sbtheader.license.Apache2_0
import uk.gov.hmrc.HeaderSettings
import play.core.PlayVersion

name := "self-service-time-to-pay-frontend"
autoScalaLibrary := false

testFrameworks := Seq(TestFrameworks.JUnit)

// [START] Temporary solution until release of new version of sbt-auto-build with junit fix
headers += { "java" -> Apache2_0(HeaderSettings.copyrightYear, HeaderSettings.copyrightOwner) }

testOptions in Test := Seq()
testOptions in Test += Tests.Argument(TestFrameworks.Specs2, "sequential", "true", "junitxml", "console")
testOptions in Test += Tests.Argument(TestFrameworks.JUnit, "--ignore-runners=org.specs2.runner.JUnitRunner", "-q", "-v", "-a")
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-o", "-u", "target/test-reports", "-h", "target/test-reports/html-report")
// [END] Temporary solution until release of new version of sbt-auto-build with junit fix

inConfig(IntegrationTest)(Defaults.itSettings)

val plugins = PlayJava && SbtAutoBuildPlugin && SbtGitVersioning && SbtDistributablesPlugin

SbtDistributablesPlugin.publishingSettings

val compileDependencies = Seq(
  javaWs,
  "uk.gov.hmrc" %% "frontend-bootstrap" % "6.5.0",
  "uk.gov.hmrc" %% "play-partials" % "4.2.0",
  "uk.gov.hmrc" %% "play-config" % "2.0.1",
  "uk.gov.hmrc" %% "play-json-logger" % "2.1.1",
  "uk.gov.hmrc" %% "govuk-template" % "4.0.0",
  "uk.gov.hmrc" %% "play-health" % "1.1.0",
  "uk.gov.hmrc" %% "play-ui" % "4.14.0",
  "uk.gov.hmrc" %% "play-whitelist-filter" % "1.1.0",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.3.0"
)

val testDependencies = Seq(
  "uk.gov.hmrc" %% "hmrctest" % "1.7.0",
  "org.pegdown" % "pegdown" % "1.6.0",
  "org.jsoup" % "jsoup" % "1.8.1",
  "com.typesafe.play" %% "play-test" % PlayVersion.current,
  "com.github.tomakehurst" % "wiremock" % "1.58"
).map(d => d % Test)

libraryDependencies ++= compileDependencies
libraryDependencies ++= testDependencies

lazy val `self-service-time-to-pay-frontend` = project in file(".") enablePlugins plugins configs IntegrationTest