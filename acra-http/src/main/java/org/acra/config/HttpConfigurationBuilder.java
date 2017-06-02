/*
 * Copyright (c) 2017
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

package org.acra.config;

import android.app.Application;
import android.support.annotation.NonNull;

import org.acra.annotation.NoPropagation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author F43nd1r
 * @since 01.06.2017
 */
@org.acra.annotation.ConfigurationBuilder(configurationName = "HttpSenderConfiguration", markerInterfaces = PluginConfiguration.class)
public class HttpConfigurationBuilder extends BaseHttpConfigurationBuilder<HttpConfigurationBuilder> implements PluginConfigurationBuilder {

    private final Map<String, String> httpHeaders;

    public HttpConfigurationBuilder(@NonNull Application app) {
        super(app);
        httpHeaders = new HashMap<>();
    }

    @NoPropagation
    @Override
    public HttpSenderConfiguration build() {
        return new HttpSenderConfiguration(this);
    }

    /**
     * Set custom HTTP headers to be sent by the provided
     * This should be used also by third party senders.
     *
     * @param headers A map associating HTTP header names to their values.
     * @return this instance
     */
    @NonNull
    public HttpConfigurationBuilder setHttpHeaders(@NonNull Map<String, String> headers) {
        this.httpHeaders.clear();
        this.httpHeaders.putAll(headers);
        return this;
    }

    @NonNull
    Map<String, String> httpHeaders() {
        return httpHeaders;
    }
}
