/*
 * Copyright (c) 2020
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
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
plugins {
    `java-platform`
}

dependencies {
    val autoServiceVersion: String by project
    val androidxAnnotationVersion: String by project
    val androidxCoreVersion: String by project
    constraints {
        api("com.google.auto.service:auto-service:$autoServiceVersion")
        runtime("com.google.auto.service:auto-service:$autoServiceVersion")
        api("com.google.auto.service:auto-service-annotations:$autoServiceVersion")
        runtime("com.google.auto.service:auto-service-annotations:$autoServiceVersion")
        api("androidx.annotation:annotation:$androidxAnnotationVersion")
        runtime("androidx.core:core:$androidxCoreVersion")
    }
}
