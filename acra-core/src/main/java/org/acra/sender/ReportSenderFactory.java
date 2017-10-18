package org.acra.sender;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;

import org.acra.config.CoreConfiguration;

/**
 * Factory for creating and configuring a {@link ReportSender} instance.
 * Implementations must have a no argument constructor.
 *
 * Each configured ReportSenderFactory is created within the {@link SenderService}
 * and is used to construct and configure a single {@link ReportSender}.
 *
 * Created by William on 4-JAN-2016.
 */
@Keep
public interface ReportSenderFactory {

    /**
     * @param context   Application context.
     * @param config    Configuration to use when sending reports.
     * @return Fully configured instance of the relevant ReportSender.
     */
    @NonNull
    ReportSender create(@NonNull Context context, @NonNull CoreConfiguration config);

    boolean enabled(@NonNull CoreConfiguration config);
}
