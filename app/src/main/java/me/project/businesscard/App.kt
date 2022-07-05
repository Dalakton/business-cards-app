package me.project.businesscard

import android.app.Application
import me.project.businesscard.data.AppDataBase
import me.project.businesscard.data.BusinessCardRepository

class App: Application() {

    val database by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}
