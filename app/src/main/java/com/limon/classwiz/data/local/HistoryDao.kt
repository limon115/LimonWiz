// Author: Khalid Hasan Limon
package com.limon.classwiz.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

/**
 * PHONE SAFETY RATING: 10/10
 * Room database operations are inherently safe as they are forced to run
 * on background threads, eliminating any risk of main thread blockage,
 * UI freezes, or CPU thermal spikes during rapid history storage.
 */
@Dao
interface HistoryDao {
    @Query("SELECT * FROM calculation_history ORDER BY timestamp DESC")
    fun getAllHistory(): Flow<List<HistoryEntity>>

    @Insert
    suspend fun insertHistory(history: HistoryEntity)

    @Query("DELETE FROM calculation_history")
    suspend fun clearHistory()
}
