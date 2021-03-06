/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appplatform.v2020_07_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.appplatform.v2020_07_01.implementation.ResourceSkuInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.appplatform.v2020_07_01.implementation.AppPlatformManager;
import java.util.List;

/**
 * Type representing ResourceSku.
 */
public interface ResourceSku extends HasInner<ResourceSkuInner>, HasManager<AppPlatformManager> {
    /**
     * @return the capacity value.
     */
    SkuCapacity capacity();

    /**
     * @return the locationInfo value.
     */
    List<ResourceSkuLocationInfo> locationInfo();

    /**
     * @return the locations value.
     */
    List<String> locations();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the resourceType value.
     */
    String resourceType();

    /**
     * @return the restrictions value.
     */
    List<ResourceSkuRestrictions> restrictions();

    /**
     * @return the tier value.
     */
    String tier();

}
