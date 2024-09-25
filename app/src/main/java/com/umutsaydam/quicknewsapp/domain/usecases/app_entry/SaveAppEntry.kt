package com.umutsaydam.quicknewsapp.domain.usecases.app_entry

import com.umutsaydam.quicknewsapp.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}