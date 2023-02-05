package com.ucne.proj_1erparcial_ap2.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // TODO: Inyectar la base de datos 
/*    @Singleton
    @Provides
    fun providesDatabase(@ApplicationContext context: Context): RoomExpampleDb {
        return Room.databaseBuilder(
            context,
            RoomExpampleDb::class.java,
            "RoomExample.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }*/

    // TODO: Inyectar el DAO 
/*    @Singleton
    @Provides
    fun providesOcupacionDao(db: RoomExpampleDb) = db.ocupacionDao*/
}