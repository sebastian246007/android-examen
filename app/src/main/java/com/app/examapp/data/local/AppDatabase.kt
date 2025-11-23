package com.app.examapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.app.examapp.data.model.User
import com.app.examapp.data.local.UserDao
import com.app.examapp.data.model.Cart
import com.app.examapp.data.model.Category
import com.app.examapp.data.model.Product

@Database(
    entities = [User::class, Category::class, Product::class, Cart::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun login(): UserDao
    abstract fun categories(): CategoryDao
    abstract fun carts(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "test_checkout.db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}