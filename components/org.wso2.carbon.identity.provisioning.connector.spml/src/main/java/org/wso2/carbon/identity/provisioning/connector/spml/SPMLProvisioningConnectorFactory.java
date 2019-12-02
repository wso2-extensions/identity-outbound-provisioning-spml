/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.provisioning.connector.spml;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.identity.application.common.model.Property;
import org.wso2.carbon.identity.provisioning.AbstractOutboundProvisioningConnector;
import org.wso2.carbon.identity.provisioning.AbstractProvisioningConnectorFactory;
import org.wso2.carbon.identity.provisioning.IdentityProvisioningException;

import java.util.ArrayList;
import java.util.List;

public class SPMLProvisioningConnectorFactory extends AbstractProvisioningConnectorFactory {

    private static final Log log = LogFactory.getLog(SPMLProvisioningConnectorFactory.class);
    private static final String SPML = "spml";

    @Override
    protected AbstractOutboundProvisioningConnector buildConnector(
            Property[] provisioningProperties) throws IdentityProvisioningException {

        SPMLProvisioningConnector spmlConnector = new SPMLProvisioningConnector();
        spmlConnector.init(provisioningProperties);

        if (log.isDebugEnabled()) {
            log.debug("Provisioning connector created of type " + getConnectorType());
        }

        return spmlConnector;
    }

    @Override
    public String getConnectorType() {
        return SPML;
    }

    /**
     * Get Configuration Properties.
     */
    @Override
    public List<Property> getConfigurationProperties() {

        List<Property> configProperties = new ArrayList<>();
        Property username = new Property();
        username.setName("spml-username");
        username.setDisplayName("Username");
        username.setRequired(false);
        username.setType("string");
        username.setDisplayOrder(1);
        configProperties.add(username);

        Property password = new Property();
        password.setName("spml-password");
        password.setDisplayName("Password");
        password.setRequired(false);
        password.setType("string");
        password.setDisplayOrder(2);
        configProperties.add(password);

        Property spmlEp = new Property();
        spmlEp.setName("spml-ep");
        spmlEp.setDisplayName("SPML Endpoint");
        spmlEp.setRequired(true);
        spmlEp.setType("string");
        spmlEp.setDisplayOrder(3);
        configProperties.add(spmlEp);

        Property spmlOc = new Property();
        spmlOc.setName("spml-oc");
        spmlOc.setDisplayName("SPML ObjectClass");
        spmlOc.setRequired(true);
        spmlOc.setType("string");
        spmlOc.setDisplayOrder(4);
        configProperties.add(spmlOc);

        return configProperties;
    }
}
