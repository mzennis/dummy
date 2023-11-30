package id.mzennis.toktik.di

import dagger.Module
import dagger.Provides
import id.mzennis.toktik.data.UserSession
import javax.inject.Singleton

@Module
object ApplicationModule {

    @Singleton
    @Provides
    fun provideUserSession(): UserSession {
        return UserSession()
    }
}