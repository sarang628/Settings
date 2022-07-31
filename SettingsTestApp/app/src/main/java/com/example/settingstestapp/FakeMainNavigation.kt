package com.example.settingstestapp

import android.content.Context
import androidx.fragment.app.FragmentManager
import com.example.torang_core.navigation.MainNavigation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject


class FakeMainNavigation @Inject constructor() : MainNavigation {
    override fun goMain(fragmentManager: FragmentManager?) {

    }

    override fun goMain(context: Context) {

    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class FakeMainNavigationProvider {
    @Binds
    abstract fun provideMainNavigation(faceMainNavigation: FakeMainNavigation): MainNavigation
}