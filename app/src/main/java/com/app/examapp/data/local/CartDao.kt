package com.app.examapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.examapp.data.model.Cart
import com.app.examapp.data.model.Category

@Dao
interface CartDao {
    @Query("SELECT * FROM carts")
    suspend fun getAll(): List<Cart>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(cart: Cart): Long

    @Query("DELETE FROM carts WHERE id = :id")
    suspend fun removeById(id: Long)

}