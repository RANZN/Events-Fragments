package com.ranzan.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

public interface CommunicationListener {
    void launchFragment(Bundle bundle, Fragment fragment);
}
