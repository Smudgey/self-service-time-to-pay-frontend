package uk.gov.hmrc.ssttp.config;

import uk.gov.hmrc.play.java.connectors.AuditConnector;

public class FrontendWiring {
    private AuditConnector frontendAuditConnector;

    public uk.gov.hmrc.play.audit.http.connector.AuditConnector frontendAuditConnector() {
        if(frontendAuditConnector == null) {
            frontendAuditConnector = new AuditConnector();
        }

        return frontendAuditConnector;
    }
}
