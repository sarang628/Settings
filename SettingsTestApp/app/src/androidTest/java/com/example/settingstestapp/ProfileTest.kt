package com.example.settingstestapp

import com.example.torang_core.data.dao.LoggedInUserDao
import com.example.torang_core.data.model.LoggedInUserData
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test


@HiltAndroidTest
class ProfileTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun hildTest(userDao: LoggedInUserDao) {
        runBlocking {
            userDao.insert(LoggedInUserData(
                userId = 1
            ))
        }
    }
}