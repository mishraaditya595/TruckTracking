package xyz.theadityamishra.trucktracking.model.AdminDB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

@Database(entities = [IssueModel::class], version = 1, exportSchema = true)
abstract class IssueDB: RoomDatabase() {

    abstract fun issueDao(): IssueDao

    companion object {
        @Volatile
        var issueDatabase: IssueDB? = null

        @InternalCoroutinesApi
        fun getDatabase(context: Context): IssueDB {
            val tempInstance = issueDatabase
            if (tempInstance != null)
                return tempInstance

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IssueDB::class.java,
                    "issue")
                    .build()

                issueDatabase = instance
                return instance
            }
        }
    }
}