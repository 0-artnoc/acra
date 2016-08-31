/*
 *  Copyright 2016
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.acra.collector;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.builder.ReportBuilder;
import org.acra.util.PackageManagerWrapper;
import org.acra.util.ReportUtils;

import java.util.Set;

/**
 * Created on 12.08.2016.
 *
 * @author F43nd1r
 */
class DeviceIdCollector extends Collector {
    private final Context context;
    private final PackageManagerWrapper pm;
    private final SharedPreferences prefs;

    DeviceIdCollector(Context context, PackageManagerWrapper pm, SharedPreferences prefs) {
        super(ReportField.DEVICE_ID);
        this.context = context;
        this.pm = pm;
        this.prefs = prefs;
    }

    @Override
    boolean shouldCollect(Set<ReportField> crashReportFields, ReportField collect, ReportBuilder reportBuilder) {
        return super.shouldCollect(crashReportFields, collect, reportBuilder) && prefs.getBoolean(ACRA.PREF_ENABLE_DEVICE_ID, true)
                && pm.hasPermission(Manifest.permission.READ_PHONE_STATE);
    }

    @NonNull
    @Override
    String collect(ReportField reportField, ReportBuilder reportBuilder) {
        String result = ReportUtils.getDeviceId(context);
        return result != null ? result : "N/A";
    }
}
