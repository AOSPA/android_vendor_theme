/**
 * Copyright (c) 2015, The CyanogenMod Project
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

package cm.theme.providers;

/**
 * CMSettings contains CM specific preferences in System, Secure, and Global.
 */
public final class CMSettings {

    public static final class Secure {

        /**
         * A '|' delimited list of theme components to apply from the default theme on first boot.
         * Components can be one or more of the "mods_XXXXXXX" found in
         * {@link ThemesContract$ThemesColumns}.  Leaving this field blank assumes all components
         * will be applied.
         *
         * ex: mods_icons|mods_overlays|mods_homescreen
         *
         * @hide
         */
        public static final String DEFAULT_THEME_COMPONENTS = "default_theme_components";

        /**
         * Default theme to use.  If empty, use holo.
         * @hide
         */
        public static final String DEFAULT_THEME_PACKAGE = "default_theme_package";

        /**
         * This will be set to the system's current theme API version when ThemeService starts.
         * It is useful for when an upgrade from one version of CM to another occurs.
         * For example, after a user upgrades from CM11 to CM12, the value of this field
         * might be 19. ThemeService would then change the value to 21. This is useful
         * when an API change breaks a theme. Themeservice can identify old themes and
         * unapply them from the system.
         * @hide
         */
        public static final String THEME_PREV_BOOT_API_LEVEL = "theme_prev_boot_api_level";

    }

}
