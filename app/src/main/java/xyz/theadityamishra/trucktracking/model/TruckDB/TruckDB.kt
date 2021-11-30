package xyz.theadityamishra.trucktracking.model.TruckDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [TruckModel::class], version = 1, exportSchema = true)
abstract class TruckDB: RoomDatabase() {

    abstract fun truckDao(): TruckDao

    companion object {
        @Volatile
        var truckDatabase: TruckDB? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): TruckDB {
            val tempInstance = truckDatabase
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TruckDB::class.java,
                    "truck")
                    .build()

                truckDatabase = instance
                return instance
            }
        }
    }
}