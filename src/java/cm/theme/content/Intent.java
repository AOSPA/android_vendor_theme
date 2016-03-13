/*
 * Copyright (C) 2015 The CyanogenMod Project
 * This code has been modified.  Portions copyright (C) 2010, T-Mobile USA, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cm.theme.content;

import android.Manifest;

/**
 * CyanogenMod specific intent definition class.
 */
public class Intent {

    /**
     * Broadcast Action: Indicate that an unrecoverable error happened during app launch.
     * Could indicate that curently applied theme is malicious.
     * @hide
     */
    public static final String ACTION_APP_FAILURE = "cyanogenmod.intent.action.APP_FAILURE";

    /**
     * Used to indicate that a theme package has been installed or un-installed.
     */
    public static final String CATEGORY_THEME_PACKAGE_INSTALLED_STATE_CHANGE =
            "cyanogenmod.intent.category.THEME_PACKAGE_INSTALL_STATE_CHANGE";

    /**
     * Action sent from the provider when a theme has been fully installed.  Fully installed
     * means that the apk was installed by PackageManager and the theme resources were
     * processed and cached by {@link org.cyanogenmod.platform.internal.ThemeManagerService}
     * Requires the {@link  cyanogenmod.platform.Manifest.permission#READ_THEMES} permission to
     * receive this broadcast.
     */
    public static final String ACTION_THEME_INSTALLED =
            "cyanogenmod.intent.action.THEME_INSTALLED";

    /**
     * Action sent from the provider when a theme has been updated.
     * Requires the {@link cyanogenmod.platform.Manifest.permission#READ_THEMES} permission to
     * receive this broadcast.
     */
    public static final String ACTION_THEME_UPDATED =
            "cyanogenmod.intent.action.THEME_UPDATED";

    /**
     * Action sent from the provider when a theme has been removed.
     * Requires the {@link  cyanogenmod.platform.Manifest.permission#READ_THEMES} permission to
     * receive this broadcast.
     */
    public static final String ACTION_THEME_REMOVED =
            "cyanogenmod.intent.action.THEME_REMOVED";

    /**
     * Uri scheme used to broadcast the theme's package name when broadcasting
     * {@link Intent#ACTION_THEME_INSTALLED} or
     * {@link Intent#ACTION_THEME_REMOVED}
     */
public static final String URI_SCHEME_PACKAGE = "package";

}
