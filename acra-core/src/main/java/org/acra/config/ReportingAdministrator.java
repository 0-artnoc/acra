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

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;

import org.acra.builder.ReportBuilder;
import org.acra.data.CrashReportData;

/**
 * @author F43nd1r
 * @since 26.10.2017
 */
@Keep
public interface ReportingAdministrator {
    boolean shouldStartCollecting(@NonNull Context context, @NonNull CoreConfiguration config, @NonNull ReportBuilder reportBuilder);

    boolean shouldSendReport(@NonNull Context context, @NonNull CoreConfiguration config, @NonNull CrashReportData crashReportData);

    void notifyReportDropped(@NonNull Context context, @NonNull CoreConfiguration config);

    boolean enabled(@NonNull CoreConfiguration config);
}
