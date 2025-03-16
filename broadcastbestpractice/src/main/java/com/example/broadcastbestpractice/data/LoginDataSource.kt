package com.example.broadcastbestpractice.data

import com.example.broadcastbestpractice.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            if(!username.equals("13209832943@163.com",true)){
                return  Result.Error(IOException("Eddress Error"))
            }else if(!password.equals("521109xsq",false)){
                return  Result.Error(IOException("Password Error"))
            }
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}