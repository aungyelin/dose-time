package dev.yelinaung.dosetime.core.database.util

import androidx.room.TypeConverter
import java.util.UUID

class UUIDConverter {

    @TypeConverter
    fun fromUUID(uuid: UUID): String {
        return uuid.toString()
    }
    @TypeConverter
    fun toUUID(uuidString: String): UUID {
        return UUID.fromString(uuidString)
    }

}