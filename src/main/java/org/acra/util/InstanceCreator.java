/*
 *  Copyright 2017
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
package org.acra.util;

import org.acra.ACRA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.acra.ACRA.LOG_TAG;

/**
 * @author F43nd1r
 * @since 09.03.2017
 */
public final class InstanceCreator {
    private InstanceCreator(){
    }

    public static <T> T create(Class<? extends T> clazz, T fallback) {
        try {
            return clazz.newInstance();
        } catch (InstantiationException e) {
            ACRA.log.e(LOG_TAG, "Failed to create instance of class " + clazz.getName(), e);
        } catch (IllegalAccessException e) {
            ACRA.log.e(LOG_TAG, "Failed to create instance of class " + clazz.getName(), e);
        }
        return fallback;
    }

    public static <T> List<T> create(Collection<Class<? extends T>> classes) {
        final List<T> result = new ArrayList<T>();
        for (Class<? extends T> clazz : classes) {
            T instance = create(clazz, null);
            if (instance != null) {
                result.add(instance);
            }
        }
        return result;
    }
}
