package com.gloria.note

import android.app.AsyncNotedAppOp
import android.content.Context
import android.provider.ContactsContract

@Database(entities = [Note::class], version = 1)

abstract class  Notedatabase: RoomDatabase(){
    abstract fun noteDao():AsyncNotedAppOp


    companion object{
        private var database: Notedatabase? = null
        fun getInstance(context: Context): Notedatabase{
            return if (database)
        }

    }
}