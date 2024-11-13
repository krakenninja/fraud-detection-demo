package com.ververica.field.dynamicrules.constants;

import lombok.NoArgsConstructor;

/**
 * Application constants
 * @since 1.2
 * @author Christopher CKW
 */
@NoArgsConstructor
public final class Application
{
    /**
     * Spring/Maven profile for {@code local-deployment}
     * @since 1.2
     * @see com.ververica.field.dynamicrules.impl.RulesEvaluatorLocal
     * @see pom.xml
     */
    public static final String PROFILE_LOCAL_DEPLOYMENT = "local-deployment";
    
    /**
     * Spring/Maven profile for {@code confluentcloud-deployment}
     * @since 1.2
     * @see com.ververica.field.dynamicrules.impl.RulesEvaluatorConfluentCloud
     * @see pom.xml
     */
    public static final String PROFILE_CONFLUENT_CLOUD_DEPLOYMENT = "confluentcloud-deployment";
}
