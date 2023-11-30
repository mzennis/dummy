package id.mzennis.toktik.common.di

import dagger.Module
import dagger.Provides
import id.mzennis.toktik.common.UserSession
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideUserSession(): UserSession {
        return UserSession()
    }
}