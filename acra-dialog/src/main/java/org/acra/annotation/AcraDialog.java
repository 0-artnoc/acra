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

package org.acra.annotation;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;

import org.acra.ACRAConstants;
import org.acra.dialog.BaseCrashReportDialog;
import org.acra.dialog.CrashReportDialog;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author F43nd1r
 * @since 01.06.2017
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Configuration
public @interface AcraDialog {

    /**
     * @return Class for the CrashReportDialog used when prompting the user for crash details.
     * If not provided, defaults to CrashReportDialog.class
     */
    @Instantiatable @AnyNonDefault @NonNull Class<? extends BaseCrashReportDialog> reportDialogClass() default CrashReportDialog.class;

    /**
     * @return Resource id for the label of positive button in the crash dialog.
     * If not provided, defaults to 'OK'.
     */
    @StringRes int resPositiveButtonText() default android.R.string.ok;

    /**
     * @return Resource id for the label of negative button in the crash dialog.
     * If not provided, defaults to 'cancel'.
     */
    @StringRes int resNegativeButtonText() default android.R.string.cancel;

    /**
     * @return Resource id for the user comment input label in the crash dialog.
     * If not provided, disables the input field.
     */
    @StringRes int resCommentPrompt() default ACRAConstants.DEFAULT_RES_VALUE;

    /**
     * @return Resource id for the user email address input label in the crash
     * dialog. If not provided, disables the input field.
     */
    @StringRes int resEmailPrompt() default ACRAConstants.DEFAULT_RES_VALUE;

    /**
     * @return Resource id for the icon in the crash dialog. Default value is
     * the system alert icon.
     */
    @DrawableRes int resIcon() default android.R.drawable.ic_dialog_alert;

    /**
     * @return Resource id for the text in the crash dialog.
     */
    @AnyNonDefault @StringRes int resText() default ACRAConstants.DEFAULT_RES_VALUE;

    /**
     * @return Resource id for the title in the crash dialog.
     */
    @StringRes int resTitle() default ACRAConstants.DEFAULT_RES_VALUE;

    /**
     * @return resource id for the crash dialog theme
     */
    @StyleRes int resTheme() default ACRAConstants.DEFAULT_RES_VALUE;
}
