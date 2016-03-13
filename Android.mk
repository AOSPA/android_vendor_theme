# Copyright (C) 2015 The CyanogenMod Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
LOCAL_PATH := $(call my-dir)

cm_theme_platform_res := APPS/cm.theme.platform-res_intermediates/src

include $(CLEAR_VARS)

cm_theme_src := src/java/cm
library_src := cm/lib/main/java

LOCAL_MODULE := cm.theme.platform
LOCAL_MODULE_TAGS := optional

LOCAL_JAVA_LIBRARIES := \
    services

LOCAL_SRC_FILES := \
    $(call all-java-files-under, $(cm_theme_src)) \
    $(call all-java-files-under, $(library_src)) \
    $(call all-Iaidl-files-under, $(cm_theme_src))

cmthemeplat_LOCAL_INTERMEDIATE_SOURCES := \
    $(cm_theme_platform_res)/cm/theme/platform/R.java \
    $(cm_theme_platform_res)/cm/theme/platform/Manifest.java \
    $(cm_theme_platform_res)/cm/theme/platform/internal/R.java

LOCAL_INTERMEDIATE_SOURCES := \
    $(cmthemeplat_LOCAL_INTERMEDIATE_SOURCES)

# Include aidl files from cyanogenmod.app namespace as well as internal src aidl files
LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/src/java

include $(BUILD_JAVA_LIBRARY)
cm_theme_module := $(LOCAL_INSTALLED_MODULE)

include $(CLEAR_VARS)

LOCAL_MODULE:= cm.theme.platform.internal
LOCAL_MODULE_TAGS := optional
LOCAL_REQUIRED_MODULES := services

LOCAL_SRC_FILES := \
    $(call all-java-files-under, $(cm_theme_src)) \
    $(call all-Iaidl-files-under, $(cm_theme_src))

LOCAL_AIDL_INCLUDES := $(LOCAL_PATH)/src/java

cm_theme_LOCAL_INTERMEDIATE_SOURCES := \
    $(cm_theme_platform_res)/cm/theme/platform/R.java \
    $(cm_theme_platform_res)/cm/theme/platform/Manifest.java \
    $(cm_theme_platform_res)/cm/theme/platform/internal/R.java \
    $(cm_theme_platform_res)/cm/theme/platform/internal/Manifest.java

LOCAL_INTERMEDIATE_SOURCES := \
    $(cm_theme_LOCAL_INTERMEDIATE_SOURCES)

$(full_target): $(cm_theme_built) $(gen)
include $(BUILD_STATIC_JAVA_LIBRARY)

# Make sure that R.java and Manifest.java are built before we build
# the source for this library.
cm_theme_res_R_stamp := \
	$(call intermediates-dir-for,APPS,cm.theme.platform-res,,COMMON)/src/R.stamp
$(full_classes_compiled_jar): $(cm_theme_res_R_stamp)
$(built_dex_intermediate): $(cm_theme_res_R_stamp)

$(cm_theme_module): | $(dir $(cm_theme_module))cm.theme.platform-res.apk

cm_theme_built := $(call java-lib-deps,cm.theme.platform)

$(full_target): $(cm_theme_built) $(gen)

include $(call first-makefiles-under,$(LOCAL_PATH))
