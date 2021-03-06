/*
 * Copyright (C) 2012 The Mahdi Rom project
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

package com.android.settings.mahdi;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceScreen;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.view.IWindowManager;

import com.android.settings.R;
import com.android.settings.SettingsPreferenceFragment;
import com.android.settings.Utils;

public class CustomizationSettings extends SettingsPreferenceFragment {

    private static final String TAG = "CustomizationSettings";

    private static final String KEY_HARDWARE_KEYS = "hardware_keys";    

    private PreferenceScreen mHardwareKeys;   

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.customization_settings);

        final ContentResolver resolver = getActivity().getContentResolver();
        final PreferenceScreen prefScreen = getPreferenceScreen();
        final Resources res = getResources();

        // Only show the hardware keys config on a device that does not have a navbar
        mHardwareKeys = (PreferenceScreen) findPreference(KEY_HARDWARE_KEYS);
        if (mHardwareKeys != null) {
            if (!res.getBoolean(R.bool.config_has_hardware_buttons)) {
                getPreferenceScreen().removePreference(mHardwareKeys);
            }        
        }
    }
}
