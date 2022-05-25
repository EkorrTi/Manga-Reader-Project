package com.example.mangareaderproject.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mangareaderproject.data.MangaEntity

@Dao
interface MangaDao {
    @Query("SELECT * FROM manga")
    fun getAll(): List<MangaEntity>

    @Query("SELECT * FROM manga WHERE id = :id")
    fun getById(id: String): MangaEntity?

    @Insert
    fun save(mangaEntity: MangaEntity)

    @Query("DELETE FROM manga WHERE id = :id")
    fun delete(id: String)
}